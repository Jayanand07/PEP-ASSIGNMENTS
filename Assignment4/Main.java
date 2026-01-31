package Assignment.Assignment4;

import java.util.*;
import java.util.stream.*;

class Employee {
    int id;
    String name;
    String dept;
    int salary;
    List<String> skills;

    Employee(int id, String name, String dept, int salary, List<String> skills) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        this.skills = skills;
    }

    @Override
    public String toString() {
        return name + " | " + dept + " | " + salary;
    }
}

public class Main {
    public static void main(String[] args) {

        List<Employee> employees = List.of(
                new Employee(1, "Aman", "IT", 70000, List.of("Java", "Spring")),
                new Employee(2, "Ravi", "HR", 40000, List.of("Recruitment")),
                new Employee(3, "Neha", "IT", 90000, List.of("Java", "Docker")),
                new Employee(4, "Pooja", "Finance", 60000, List.of("Excel", "Accounts")),
                new Employee(5, "Aman", "IT", 70000, List.of("Java", "Spring")));

        System.out.println("=".repeat(60));
        System.out.println("   ASSIGNMENT 4: JAVA STREAMS & LAMBDA EXPRESSIONS");
        System.out.println("=".repeat(60));

        System.out.println("\n--- Task 1: Filter (salary > 60,000) ---");
        List<Employee> task1 = employees.stream()
                .filter(e -> e.salary > 60000)
                .toList();
        System.out.println(task1);

        System.out.println("\n--- Task 2: Map (extract names) ---");
        List<String> task2 = employees.stream()
                .map(e -> e.name)
                .toList();
        System.out.println(task2);

        System.out.println("\n--- Task 3: Distinct (unique names) ---");
        Set<String> task3 = employees.stream()
                .map(e -> e.name)
                .collect(Collectors.toSet());
        System.out.println(task3);

        System.out.println("\n--- Task 4: Sorting (salary descending) ---");
        List<Employee> task4 = employees.stream()
                .sorted((e1, e2) -> Integer.compare(e2.salary, e1.salary))
                .toList();
        System.out.println(task4);

        System.out.println("\n--- Task 5: Skip + Limit (2nd & 3rd highest paid) ---");
        List<Employee> task5 = employees.stream()
                .sorted((e1, e2) -> Integer.compare(e2.salary, e1.salary))
                .skip(1)
                .limit(2)
                .toList();
        System.out.println(task5);

        System.out.println("\n--- Task 6: flatMap (unique skills) ---");
        Set<String> task6 = employees.stream()
                .flatMap(e -> e.skills.stream())
                .collect(Collectors.toSet());
        System.out.println(task6);

        System.out.println("\n--- Task 7: Reduce (total salary) ---");
        int task7 = employees.stream()
                .map(e -> e.salary)
                .reduce(0, Integer::sum);
        System.out.println("Total Salary: " + task7);

        System.out.println("\n--- Task 8: Average Salary (map + reduce + count) ---");
        int totalSalary = employees.stream()
                .map(e -> e.salary)
                .reduce(0, Integer::sum);
        long count = employees.stream().count();
        double task8 = (double) totalSalary / count;
        System.out.println("Average Salary: " + task8);

        System.out.println("\n--- Task 9: groupingBy (group by department) ---");
        Map<String, List<Employee>> task9 = employees.stream()
                .collect(Collectors.groupingBy(e -> e.dept));
        task9.forEach((dept, empList) -> System.out.println(dept + " => " + empList));

        System.out.println("\n--- Task 10: groupingBy + Collector (highest paid per dept) ---");
        Map<String, Employee> task10 = employees.stream()
                .collect(Collectors.groupingBy(
                        e -> e.dept,
                        Collectors.collectingAndThen(
                                Collectors.maxBy((e1, e2) -> Integer.compare(e1.salary, e2.salary)),
                                opt -> opt.orElse(null))));
        task10.forEach((dept, emp) -> System.out.println(dept + " => " + emp));

        System.out.println("\n--- Task 11: Top Skilled High Earners (single pipeline) ---");
        List<String> task11 = employees.stream()
                .filter(e -> e.dept.equals("IT"))
                .filter(e -> e.salary > 60000)
                .flatMap(e -> e.skills.stream())
                .distinct()
                .sorted()
                .limit(3)
                .toList();
        System.out.println("Top 3 Skills: " + task11);

        System.out.println("\n--- Task 12: Department Salary Report (Complex) ---");
        Map<String, Map<String, Double>> task12 = employees.stream()
                .collect(Collectors.groupingBy(
                        e -> e.dept,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                empList -> {
                                    double total = empList.stream()
                                            .map(e -> e.salary)
                                            .reduce(0, Integer::sum);
                                    double empCount = empList.stream().count();
                                    double average = total / empCount;

                                    Map<String, Double> stats = new LinkedHashMap<>();
                                    stats.put("total", total);
                                    stats.put("average", Math.round(average * 100.0) / 100.0);
                                    stats.put("count", empCount);
                                    return stats;
                                })));
        task12.forEach((dept, stats) -> System.out.println(dept + " = " + stats));
    }
}
