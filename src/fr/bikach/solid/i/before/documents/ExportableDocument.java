package fr.bikach.solid.i.before.documents;

/*
Common interface used in application when there is
a need for document exports
 */
public interface ExportableDocument {
    byte[] toPdf();
    String toJson();
    String toTxt();
}
