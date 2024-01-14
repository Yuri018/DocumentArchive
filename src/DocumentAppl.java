import dao.Archive;
import dao.ArchiveImpl;
import model.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DocumentAppl {
    private static final String FILE_NAME = "src/document.csv";

    public static void main(String[] args) {

        List<Document> documents = new ArrayList<>();

        Archive archive = new ArchiveImpl(documents);

        Scanner scanner = new Scanner(System.in);

    }
}
