package org.example;

public class SaveCommand implements Command {
    private final Catalog catalog;
    private final String filePath;

    public SaveCommand(Catalog catalog, String filePath) {
        this.catalog = catalog;
        this.filePath = filePath;
    }

    @Override
    public void execute() {
        catalog.save(filePath);
    }
}
