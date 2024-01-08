package model;

import java.time.LocalDate;
import java.util.Objects;

public class Document {
    private int id;
    private String title;
    private String annotation;
    private LocalDate archiveDate;

    public Document(int id, String title, String annotation, LocalDate archiveDate) {
        this.id = id;
        this.title = title;
        this.annotation = annotation;
        this.archiveDate = archiveDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public LocalDate getArchiveDate() {
        return archiveDate;
    }

    public void setArchiveDate(LocalDate archiveDate) {
        this.archiveDate = archiveDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return id == document.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", annotation='" + annotation + '\'' +
                ", archiveDate=" + archiveDate +
                '}';
    }
}
