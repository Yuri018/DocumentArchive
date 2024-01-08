package dao;

import model.Document;

import java.time.LocalDate;
import java.util.List;

public class ArchiveImpl implements Archive {
    @Override
    public boolean createDocument(Document document) {

        return false;
    }

    @Override
    public void updateDocument(Document updateDoc) {

    }

    @Override
    public Document getDocumentById(int documentId) {
        return null;
    }

    @Override
    public List<Document> getAllDocuments() {
        return null;
    }

    @Override
    public List<Document> searchDocuments(String keyword) {
        return null;
    }

    @Override
    public List<Document> getDocumentForPeriod(LocalDate startDate, LocalDate endDate) {
        return null;
    }

    @Override
    public void deleteDocument(int documentId) {

    }
}
