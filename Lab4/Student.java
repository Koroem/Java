package org.example;
import java.util.ArrayList;
import java.util.List;

public class Student implements Comparable<Student> {
    private String name;
    private List<Project> admissibleProjects;

    public Student(String name) {
        this.name = name;
        this.admissibleProjects = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Project> getAdmissibleProjects() {
        return admissibleProjects;
    }

    public void addAdmissibleProject(Project project) {
        admissibleProjects.add(project);
    }

    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + '}';
    }
}