package dao;

import model.Document;

import java.time.LocalDate;
import java.util.List;

public interface Archive {
    public boolean addDocument(Document document);

    public void updateDocument(Document updateDoc);

    public Document getDocumentById(int documentId);
    public List<Document> getAllDocuments();

    public List<Document> searchDocuments(String keyword);

    public List<Document> getDocumentForPeriod(LocalDate startDate, LocalDate endDate);

    public void deleteDocument(int documentId);

}
