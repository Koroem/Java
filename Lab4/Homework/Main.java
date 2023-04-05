package org.example;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;


public class Main {
    public static void main(String[] args) {

        Faker faker = new Faker();
        Random random = new Random();

        List<Student> students = new ArrayList<>();
        List<Project> projects = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Student randomStudent = new Student(faker.name().fullName());
            Project randomProject = new Project(faker.app().name());

            students.add(randomStudent);
            projects.add(randomProject);
        }
        for (Student student : students) {
            List<Project> randomPreferences = new ArrayList<>(projects);
            Collections.shuffle(randomPreferences);

            int randomNumberOfPreferences = random.nextInt(projects.size()) + 1;

            for (int i = 0; i < randomNumberOfPreferences; i++) {
                student.addPreference(randomPreferences.get(i));
            }
        }

        double avgPreferences = students.stream().mapToInt(s -> s.getPreferences().size()).average().orElse(0);
        System.out.println("Average preferences: " + avgPreferences);

        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.println("Student " + i + " preferences count: " + student.getPreferences().stream().count());
        }

        System.out.println("\nStudents with fewer preferences than the average:\n");
        students.stream()
                .filter(s -> s.getPreferences().size() < avgPreferences)
                .forEach(System.out::println);

        /*
        System.out.println("\nProjects:\n");
        projects.forEach(System.out::println);
         */

        Map<Student, Project> matching = (Map<Student, Project>) findMaximumCardinalityMatching(students, projects);
        System.out.println("Maximum cardinality matching:");
        matching.forEach((student, project) -> System.out.println(student + " - " + project));
    }
    public static Map<Student, Project> findMaximumCardinalityMatching(List<Student> students, List<Project> projects) {
        Map<Student, Project> matching = new HashMap<>();

        for (Student student : students) {
            Project preferredProject = null;
            for (Project project : student.getPreferences()) {
                if (!isProjectAssigned(matching, project)) {
                    preferredProject = project;
                    break;
                }
            }

            if (preferredProject != null) {
                matching.put(student, preferredProject);
            }
        }

        return matching;
    }

    private static boolean isProjectAssigned(Map<Student, Project> matching, Project project) {
        return matching.containsValue(project);
    }
}