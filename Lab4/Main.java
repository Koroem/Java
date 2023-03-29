package org.example;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        var students = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Student("S" + i) )
                .toArray(Student[]::new);
        var projects = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Project("S" + i) )
                .toArray(Project[]::new);

        // Put all the students in a LinkedList and sort them by their names
        List<Student> sortedStudents = IntStream.range(0, students.length)
                .mapToObj(i -> students[i])
                .sorted()
                .collect(Collectors.toCollection(LinkedList::new));

        // Print sorted students
        System.out.println("Sorted students:");
        sortedStudents.forEach(System.out::println);

        // Put all the projects in a TreeSet and sort them by their names
        TreeSet<Project> sortedProjects = IntStream.range(0, projects.length)
                .mapToObj(i -> projects[i])
                .collect(Collectors.toCollection(TreeSet::new));

        // Print sorted projects
        System.out.println("Sorted projects:");
        sortedProjects.forEach(System.out::println);
    }
}