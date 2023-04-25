package org.example;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class ViewCommand implements Command {
    private Document document;

    public ViewCommand(Document document) {
        this.document = document;
    }

    @Override
    public void execute() {
        String location = document.getLocation();
        try {
            if (location.startsWith("http") || location.startsWith("https")) {
                Desktop.getDesktop().browse(new URI(location));
            } else {
                Desktop.getDesktop().open(new File(location));
            }
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}

