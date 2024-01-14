package dao;

import model.Document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArchiveImpl implements Archive {

    List<Document> documentList;

    public ArchiveImpl(List<Document> documentList) {
        this.documentList = documentList;
    }

    @Override
    public boolean addDocument(Document document) {
        if (documentList == null || documentList.contains(document)) {
            return false;
        }
        return documentList.add(document);
    }

    @Override
    public void updateDocument(int documentId) {
        for (Document d: documentList){
            if (d.getId() == documentId){
                d.setTitle(d.getTitle());
                d.setAnnotation(d.getAnnotation());
            } else {
                System.out.println("Document not found");
            }
        }
    }

    @Override
    public Document getDocumentById(int documentId) {
        for (Document d : documentList) {
            if (d.getId() == documentId) {
                return d;
            }
        }
        return null;
    }

    @Override
    public List<Document> getDocumentByPerson(String person) {
        return documentList.stream()
                .filter(document -> document.getPersonName().equals(person))
                .collect(Collectors.toList());
    }

    @Override
    public List<Document> getAllDocuments() {
        return documentList;
    }

    @Override
    public boolean searchDocumentsByWord(String keyword) {
        List<Document> res = new ArrayList<>();
        for (Document d: documentList){
            if (d.getTitle().equals(keyword) || d.getAnnotation().equals(keyword)){
                return res.add(d);
            }
        }
        return false;
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
