package fr.bikach.solid.s.refactored.hr.documents;

/*
Common interface used in application when there is
a need for document exports
 */
public interface ExportableDocument {
    byte[] toPdf();
    String toJson();
    String toTxt();
}
