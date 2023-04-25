package org.example;

public class LoadCommand implements Command {
    private final Catalog catalog;
    private final String filePath;

    public LoadCommand(Catalog catalog, String filePath) {
        this.catalog = catalog;
        this.filePath = filePath;
    }

    @Override
    public void execute() {
        catalog.load(filePath);
    }
}
