package dao;

import model.Document;

import java.time.LocalDate;
import java.util.List;

public interface Archive {
    public boolean addDocument(Document document);

    public void updateDocument(int documentId);

    public Document getDocumentById(int documentId);

    public List<Document> getDocumentByPerson(String person);
    public List<Document> getAllDocuments();

    public boolean searchDocumentsByWord(String keyword);

    public List<Document> getDocumentForPeriod(LocalDate startDate, LocalDate endDate);

    public boolean deleteDocument(int documentId);

}
