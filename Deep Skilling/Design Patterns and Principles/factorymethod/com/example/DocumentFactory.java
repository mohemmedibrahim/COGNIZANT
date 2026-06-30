package com.example;

public abstract class DocumentFactory {
    // The Factory Method
    public abstract Document createDocument();

    // An optional helper method demonstrating internal usage
    public void convertAndOpen() {
        Document doc = createDocument();
        doc.open();
    }
}