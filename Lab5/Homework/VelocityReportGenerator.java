package org.example;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.Properties;

public class VelocityReportGenerator {

    public static void generateReport(List<Document> documents, String outputFile) {

        Properties properties = new Properties();
        properties.setProperty("resource.loader", "class");
        properties.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");

        VelocityEngine velocityEngine = new VelocityEngine(properties);
        velocityEngine.init();


        Template template = velocityEngine.getTemplate("templates/report.vm");


        VelocityContext context = new VelocityContext();
        context.put("documents", documents);


        StringWriter writer = new StringWriter();
        template.merge(context, writer);


        try (FileWriter fileWriter = new FileWriter(outputFile)) {
            fileWriter.write(writer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
