package dao;

import model.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ArchiveImpl implements Archive {

    List<Document> documentList;

    public ArchiveImpl(List<Document> documentList) {
        this.documentList = documentList;
    }

    @Override
    public boolean addDocument(Document document) {
        if (documentList == null || documentList.contains(document)){
            return false;
        }
        return documentList.add(document);
    }

    @Override
    public void updateDocument(int documentId) {

    }

    @Override
    public Document getDocumentById(int documentId) {
        for (Document d: documentList){
            if (d.getId() == documentId){
                return d;
            }
        }
        return null;
    }

    @Override
    public List<Document> getAllDocuments() {
        return documentList;
    }

    @Override
    public List<Document> searchDocuments(String keyword) {
        return null;
    }

    @Override
    public List<Document> getDocumentForPeriod(LocalDate from, LocalDate to) {
        return documentList.stream()
                .filter(document -> !document.getArchiveDate().isBefore(from) && !document.getArchiveDate().isAfter(to))
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteDocument(int documentId) {
        return documentList.removeIf(document -> document.getId() == documentId);
    }
}
