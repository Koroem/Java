package org.example;

import java.util.ArrayList;
import java.util.List;

public class Student implements Comparable<Student> {
    private String name;
    private List <Project> preferences;

    public Student(String name) {
        this.name = name;
        this.preferences=new ArrayList<>();
    }
    public void addPreference(Project project) {
        preferences.add(project);
    }

    public String getName() {

        return name;
    }

    public List<Project> getPreferences() {
        return preferences;
    }

    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return "Student: "  + name;
    }
}
