package tests;

import dao.Archive;
import dao.ArchiveImpl;
import model.Document;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArchiveTest {

    List<Document> documents = new ArrayList<>();

    Archive testArchive = new ArchiveImpl(documents);

    @BeforeEach
    void setUp() {
        //создаем список документов
        documents = List.of(
                new Document(1, "document_1", "annotation_1", "Ivan",LocalDate.of(2023, 02, 1)),
                new Document(2, "document_2", "annotation_2", "Petr", LocalDate.of(2023, 03, 5)),
                new Document(3, "document_3", "annotation_3", "Juri", LocalDate.of(2023, 04, 10))
        );
        //добавляем документы в архив
        for (Document d : documents) {
            testArchive.addDocument(d);
        }
    }

    @Test
    void addDocument() {
        Document d = new Document(4, "document_4", "annotation_4", "Max", LocalDate.of(2023, 05, 15));
        assertTrue(testArchive.addDocument(d));
        assertFalse(testArchive.addDocument(d));
    }

    @Test
    void updateDocument() {
        int documentIdToUpdate = 1;//берем ID документа
        String updateTitle = "document_1Update";
        String updateAnnotation = "annotation_1Update";
        LocalDate updateLocalDate = LocalDate.of(2023, 05, 20);

        for (Document d : documents) {
            if (d.getId() == documentIdToUpdate) {
                d.setTitle(updateTitle);
                d.setAnnotation(updateAnnotation);
                d.setArchiveDate(updateLocalDate);
                testArchive.updateDocument(documentIdToUpdate);
                break;//выходим из цикла, чтобы не проверять все документы
            }
        }
        Document updateDocument = documents.get(0);
        assertEquals(documentIdToUpdate, updateDocument.getId());
        assertEquals(updateTitle, updateDocument.getTitle());
        assertEquals(updateAnnotation, updateDocument.getAnnotation());
        assertEquals(updateLocalDate, updateDocument.getArchiveDate());
    }

    @Test
    void getDocumentById() {
        int documentById = 3;
        Document foundDocument = null;
        for (Document d : documents) {
            if (d.getId() == documentById) {
                foundDocument = d;
                break;
            }
        }
        assertEquals(documentById, foundDocument.getId());
        assertNotNull(foundDocument);
    }

    @Test
    void getAllDocuments() {
        assertEquals(3, documents.size());
    }

    @Test
    void searchDocumentsByWord() {
        String keyword = "document_2";
        List<Document> res = new ArrayList<>();
        for (Document d : documents) {
            if (d.getTitle().equals(keyword) || d.getAnnotation().equals(keyword)) {
                res.add(d);
            }
        }
        assertEquals(documents.get(1), res.get(0));
    }

    @Test
    void getDocumentForPeriod() {
        LocalDate from = LocalDate.of(2023, 1, 1);
        LocalDate to = LocalDate.of(2023, 4, 1);
        List<Document> documentsForPeriod = new ArrayList<>();
        for (Document d : documents) {
            if (d.getArchiveDate().isAfter(from) && d.getArchiveDate().isBefore(to)) {
                documentsForPeriod.add(d);
            }
        }
        assertEquals(2, documentsForPeriod.size());
    }

    @Test
    void deleteDocument() {
        int deleteDocumentByID = 3;
        boolean res = testArchive.deleteDocument(deleteDocumentByID);
        assertTrue(res);
    }
}
