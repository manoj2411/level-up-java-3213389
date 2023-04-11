package com.linkedin.javacodechallenges;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class App {
    public static List<String> findStudentsWithIncompleteVolunteerEvents(
            List<String> students,
            Map<String, List<String>> attendeesMapping) {

        Map<String, Long> attendence = attendeesMapping
            .values().stream()
            .flatMap(Collection::stream)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        
        List<String> result = new ArrayList<>();        
        for(String student : students) {
            if(attendence.getOrDefault(student, 0l) < 2) {
                result.add(student);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> students = List.of("Sally", "Polly", "Molly",
                "Tony", "Harry");

        Map<String, List<String>> attendeesMapping = Map.of("Farmer's Market", List.of("Sally", "Polly"),
                "Car Wash Fundraiser", List.of("Molly", "Tony", "Polly"),
                "Cooking Workshop", List.of("Sally", "Molly", "Polly"),
                "Midnight Breakfast", List.of("Polly", "Molly"));

        System.out.println(findStudentsWithIncompleteVolunteerEvents(
                students, attendeesMapping));
    }

}
