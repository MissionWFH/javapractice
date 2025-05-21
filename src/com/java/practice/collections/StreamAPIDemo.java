package com.java.practice.collections;

import java.util.*;
import java.util.stream.Collectors;

public class StreamAPIDemo {

    public static void main(String[] args) {

        List<Employee> employees = Employee.fetchEmployeeData();
        streamAPIQuestionsAboutEmployee(employees);
        System.out.println("\n======================================================================================\n");
        List<Student> students = Student.fetchStudentData();
        streamAPIQuestionsAboutStudent(students);
    }

    private static void streamAPIQuestionsAboutEmployee(List<Employee> employees) {
        // 1. Group the Employees by city.
        Map<String, List<Employee>> empByCity = employees.stream()
                .collect(Collectors.groupingBy(Employee::city));
        System.out.println("\nEmployees grouped by city :: ");
        empByCity.forEach((empCity, emp) -> System.out.println(empCity + " -> " + emp));
        System.out.println("--------------------------------------------------------------------------------------");

        // 2. Group the Employees by age.
        Map<Integer, List<Employee>> empByAge = employees.stream()
                .collect(Collectors.groupingBy(Employee::age));
        System.out.println("Employees grouped by age :: ");
        empByAge.forEach((empAge, emp) -> System.out.println(empAge + " -> " + emp));
        System.out.println("--------------------------------------------------------------------------------------");

        // 3. Find the count of male and female employees present in the organization.
        Map<String, Long> noOfMaleAndFemaleEmployees = employees.stream()
                .collect(Collectors.groupingBy(Employee::gender, Collectors.counting()));
        System.out.println("Count of male and female employees present in the organization:: \n" + noOfMaleAndFemaleEmployees);
        System.out.println("--------------------------------------------------------------------------------------");

        // 4. Print the names of all departments in the organization.
        System.out.println("Names of all departments in the organization :: ");
        employees.stream().map(Employee::deptName).distinct().forEach(System.out::println);
        System.out.println("--------------------------------------------------------------------------------------");

        // 5. Print employee details whose age is greater than 28.
        System.out.println("Employee details whose age is greater than 28 :: ");
        employees.stream().filter(e -> e.age() > 28).toList().forEach(System.out::println);
        System.out.println("--------------------------------------------------------------------------------------");

        // 6. Find maximum age of employee.
        OptionalInt max = employees.stream().mapToInt(Employee::age).max();
        if (max.isPresent())
            System.out.println("Maximum age of Employee :: " + max.getAsInt());
        System.out.println("--------------------------------------------------------------------------------------");

        // 7. Print Average age of Male and Female Employees.
        Map<String, Double> avgAge = employees.stream()
                .collect(Collectors.groupingBy(Employee::gender, Collectors.averagingInt(Employee::age)));
        System.out.println("Average age of Male and Female Employees :: " + avgAge);
        System.out.println("--------------------------------------------------------------------------------------");

        // 8. Print the number of employees in each department.
        System.out.println("No of employees in each department :: ");
        employees.stream()
                .collect(Collectors.groupingBy(Employee::deptName, Collectors.counting()))
                .forEach((key, value) -> System.out.println(key + " : " + value));
        System.out.println("--------------------------------------------------------------------------------------");

        // 9. Find the senior employee by age.
        Employee seniorEmpByAge = employees.stream()
                .max(Comparator.comparingInt(Employee::age))
                .orElse(null);
        System.out.println("Senior employee by age details :: \n" + seniorEmpByAge);
        System.out.println("--------------------------------------------------------------------------------------");

        // 10. Find the senior employee by joining in the organization.
        Employee seniorEmpByJoining = employees.stream()
                .min(Comparator.comparingInt(Employee::yearOfJoining))
                .orElse(null);
        System.out.println("Senior employee by joining :: \n" + seniorEmpByJoining);
        System.out.println("--------------------------------------------------------------------------------------");

        // 11.Find the senior employee in each department
        System.out.println("Senior Employee per Department :: ");
        employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::deptName, Collectors.minBy(Comparator.comparing(Employee::yearOfJoining))))
                .forEach((dept, empOpt) ->
                        empOpt.ifPresent(emp -> System.out.println(dept + " -> " + emp.name() + " (DOJ: " + emp.yearOfJoining() + ")")));
        System.out.println("--------------------------------------------------------------------------------------");

        // 12. Find the junior employee by joining in the organisation
        System.out.println("Junior Employee By Joining per Department :: ");
        employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::deptName, Collectors.maxBy(Comparator.comparing(Employee::yearOfJoining))))
                .forEach((dept, empOpt) ->
                        empOpt.ifPresent(emp -> System.out.println(dept + " -> " + emp.name() + " (DOJ: " + emp.yearOfJoining() + ")")));
        System.out.println("--------------------------------------------------------------------------------------");

        // 13. Find the youngest female employee.
        Employee youngestFemaleEmployee = employees.stream()
                .filter(e -> "F".equals(e.gender()))
                .min(Comparator.comparingInt(Employee::age))
                .orElse(null);
        System.out.println("Youngest Female employee details :: \n" + youngestFemaleEmployee);
        System.out.println("--------------------------------------------------------------------------------------");

        // 14. Find employees whose age is greater than 30 and less than 30.
        System.out.println("Employees whose age is greater than 30 and less than 30 :: ");
        Map<Boolean, List<Employee>> partitionEmployeesByAge =
                employees.stream()
                        .collect(Collectors.partitioningBy(e -> e.age() > 30));

        List<Employee> employeesGreaterThan30 = partitionEmployeesByAge.get(Boolean.TRUE);
        List<Employee> employeesLessThan30 = partitionEmployeesByAge.get(Boolean.FALSE);

        System.out.println("Employees greater than 30 years ::\n" + employeesGreaterThan30);
        System.out.println("Employees less than 30 years ::\n" + employeesLessThan30);
        System.out.println("--------------------------------------------------------------------------------------");

        // 15. Find the department name which has the highest number of employees.
        String maxNoOfEmployeesInDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::deptName, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey).orElse(null);
        System.out.println("Max no of employees present in Dept :: " + maxNoOfEmployeesInDept);
        System.out.println("--------------------------------------------------------------------------------------");

        // 16. Find if there are any employees from HR Department.
        Employee emp = employees.stream()
                .filter(e -> "HR".equalsIgnoreCase(e.deptName()))
                .findAny()
                .orElse(null);
        System.out.println("Found employees from HR department ::\n" + emp);
        System.out.println("--------------------------------------------------------------------------------------");

        // 17. Find the department names that these employees work for, where the number of employees in the department is over 3.
        System.out.println("Department names where the number of employees in the department is over 3 :: ");
        employees.stream()
                .collect(Collectors.groupingBy(Employee::deptName, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 3)
                .forEach(System.out::println);
        System.out.println("--------------------------------------------------------------------------------------");

        // 18 . Find distinct department names that employees work for.
        System.out.println("Distinct department names that employees work for :: ");
        employees.stream()
                .map(Employee::deptName)
                .distinct()
                .forEach(System.out::println);
        System.out.println("--------------------------------------------------------------------------------------");

        // 19. Find all employees who live in ‘Blore’ city, sort them by their name and print the names of employees.
        employees.stream()
                .filter(e -> "Blore".equals(e.city()))
                .sorted(Comparator.comparing(Employee::name))
                .forEach(e -> System.out.println("Employees staying in Blore :: " + e.name()));
        System.out.println("--------------------------------------------------------------------------------------");

        // 20. No of employees in the organisation.
        System.out.println("No of employees in the organisation :: " + (long) employees.size());
        System.out.println("--------------------------------------------------------------------------------------");

        // 21. Find the department which has the highest number of employees.
        Optional<Map.Entry<String, Long>> deptNameWithHighestEmp = employees.stream()
                .collect(Collectors.groupingBy(Employee::deptName, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue());
        deptNameWithHighestEmp.ifPresent(stringLongEntry ->
                System.out.println("Department which has the highest number of employees :: " + stringLongEntry));
        System.out.println("--------------------------------------------------------------------------------------");

        // 22. Sorting a Stream by name and age fields.
        System.out.println("Sorting based on name and age :: ");
        Comparator<Employee> comparator1 = Comparator.comparing(Employee::name);
        Comparator<Employee> comparator2 = Comparator.comparingInt(Employee::age);
        employees.stream().sorted(comparator1.thenComparing(comparator2)).forEach(System.out::println);
        System.out.println("--------------------------------------------------------------------------------------");

        // 23. Print average and total salary of the organization.
        DoubleSummaryStatistics empSalary = employees.stream()
                .collect(Collectors.summarizingDouble(Employee::salary));
        System.out.println("Average Salary in the organisation :: " + empSalary.getAverage());
        System.out.println("Total Salary in the organisation :: " + empSalary.getSum());
        System.out.println("Maximum Salary in the organisation :: " + empSalary.getMax());
        System.out.println("Minimum Salary in the organisation :: " + empSalary.getMin());
        System.out.println("--------------------------------------------------------------------------------------");

        // 24. Print Average salary of each department.
        System.out.println("Print Average salary of each department :: ");
        employees.stream()
                .collect(Collectors.groupingBy(Employee::deptName, Collectors.averagingDouble(Employee::salary)))
                .forEach((key, value) -> System.out.println(key + " : " + value));
        System.out.println("--------------------------------------------------------------------------------------");

        // 25. Print Average salary by gender in each department .
        System.out.println("Average Salary by Gender in Department :: ");
        Map<String, Map<String, Double>> avgSalaryByGenderPerDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::deptName, Collectors.groupingBy(
                                Employee::gender, Collectors.averagingDouble(Employee::salary)
                        )
                ));
        avgSalaryByGenderPerDept.forEach((dept, genderAvg) ->
                genderAvg.forEach((gender, avg) ->
                        System.out.println(dept + " -> " + gender + ": ₹" + avg)
                )
        );
        System.out.println("--------------------------------------------------------------------------------------");

        // 26. To get a list of employees from each department whose salary is greater than the average salary of their department ***
//        employees.stream()
//                .filter(e -> e.salary() > averageMap.get(e.deptName()))
//                .collect(Collectors.groupingBy(Employee::deptName))
//                .forEach((dept, empListAboveAvg) -> {
//                    System.out.println("Employees in Department who salary greater than average salary: " + dept);
//                    empListAboveAvg.forEach(e -> System.out.println("  " + e.name() + " – >" + e.salary()));
//                });
//        System.out.println("--------------------------------------------------------------------------------------");

        // 27. Find Highest salary in the organisation.
        Optional<Employee> empHighest = employees.stream()
                .max(Comparator.comparingDouble(Employee::salary));

        empHighest.ifPresent(e -> System.out.println("Highest Salary in the organisation :: " + e.salary()));
        System.out.println("--------------------------------------------------------------------------------------");

        // 28. Find the Second-Highest salary in the organisation.
        Optional<Employee> secondHighestEmpSal = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::salary).reversed())
                .skip(1)
                .findFirst();
        secondHighestEmpSal.ifPresent(e -> System.out.println("Second-Highest Salary in the organisation :: " + e.salary()));
        System.out.println("--------------------------------------------------------------------------------------");

        // 29. Nth Highest salary.
        int n = 7;
        Optional<Employee> nTHHighestEmpSal = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::salary).reversed())
                .skip(n - 1)
                .findFirst();
        nTHHighestEmpSal.ifPresent(e -> System.out.println(n + "th highest salary in the organisation :: " + e.salary()));
        System.out.println("--------------------------------------------------------------------------------------");

        // 30. Print the top 3 highest salary earned employees
        System.out.println("Top 3 earner highest salary employees ::");
        employees.stream()
                .sorted(Comparator.comparingDouble(Employee::salary).reversed())
                .limit(3)
                .forEach(e -> System.out.println("Top earner -> " + e.name() + " : ₹" + e.salary()));
        System.out.println("--------------------------------------------------------------------------------------");

        // 31. Find highest paid salary in the organisation based on gender.
        Map<String, Optional<Employee>> highestPaidMFEmployee = employees.stream()
                .collect(Collectors.groupingBy(Employee::gender, Collectors.maxBy(Comparator.comparingLong(Employee::salary))));
        System.out.println("Highest paid male and female employee in the organisation :: ");
        highestPaidMFEmployee.forEach((empGender, highestPaidEmp) -> System.out.println(empGender + " -> " + highestPaidEmp.get()));
        System.out.println("--------------------------------------------------------------------------------------");

        // 32. Find lowest paid salary in the organisation based on the gender.
        Map<String, Optional<Employee>> lowestPaidMFEmployee = employees.stream()
                .collect(Collectors.groupingBy(Employee::gender, Collectors.minBy(Comparator.comparingDouble(Employee::salary))));
        System.out.println("Lowest paid male and female employee in the organisation :: ");
        lowestPaidMFEmployee.forEach((empGender, lowestPaidEmp) -> System.out.println(empGender + " -> " + lowestPaidEmp.get()));
        System.out.println("--------------------------------------------------------------------------------------");

        // 33. Find lowest paid salary in the organisation
        employees.stream()
                .min(Comparator.comparingDouble(Employee::salary))
                .ifPresent(e -> System.out.println("Lowest paid employee in the organisation :: " + e.name() + " -> " + e.salary()));
        System.out.println("--------------------------------------------------------------------------------------");

        // 34. Sort the employees salary in the organisation in ascending order
        System.out.println("Sorting the organisation's employee salary in ascending order :: ");
        employees.stream()
                .sorted(Comparator.comparingLong(Employee::salary))
                .toList()
                .forEach(System.out::println);
        System.out.println("--------------------------------------------------------------------------------------");

        // 35. Sort the employees salary in the organisation in descending order.
        System.out.println("Sorting the organisation's employee salary in descending order :: ");
        employees.stream()
                .sorted(Comparator.comparingLong(Employee::salary).reversed())
                .toList()
                .forEach(System.out::println);
        System.out.println("--------------------------------------------------------------------------------------");

        // 36. Highest salary based on department.
        System.out.println("Highest salary dept wise :: ");
        employees.stream()
                .collect(Collectors.groupingBy(Employee::deptName, Collectors.maxBy(Comparator.comparing(Employee::salary))))
                .forEach((deptName, optEmp) ->
                        optEmp.ifPresent(highestSalEmp ->
                                System.out.println(deptName + " -> " + highestSalEmp.name() + " : " + highestSalEmp.salary())));
        System.out.println("--------------------------------------------------------------------------------------");

        // 37. Lowest paid based on department
        System.out.println("lowest paid dept wise :: ");
        employees.stream()
                .collect(Collectors.groupingBy(Employee::deptName, Collectors.minBy(Comparator.comparing(Employee::salary))))
                .forEach((dept, OptEmp) ->
                        OptEmp.ifPresent(lowestSalEmp ->
                                System.out.println(dept + " -> " + lowestSalEmp.name() + " : " + lowestSalEmp.salary())
                        ));
        System.out.println("--------------------------------------------------------------------------------------");

        // 38. Print lowest paid employee in the organisation
        employees.stream()
                .min(Comparator.comparingDouble(Employee::salary))
                .ifPresent(e -> System.out.println("Lowest paid employee :: " + e.name()));
        System.out.println("--------------------------------------------------------------------------------------");

        // 39. List of employee’s second-highest salary based on department
        System.out.println("Second-Highest salary dept wise :: ");
        employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::deptName, Collectors.collectingAndThen(
                                Collectors.toList(), list ->
                                        list.stream()
                                                .sorted(Comparator.comparingDouble(Employee::salary).reversed())
                                                .skip(1)
                                                .findFirst()
                        )
                ))
                .forEach((dept, OptEmp) ->
                        OptEmp.ifPresent(secondHighestSal ->
                                System.out.println(dept + " -> " + secondHighestSal.name() + " : " + secondHighestSal.salary())
                        ));
        System.out.println("--------------------------------------------------------------------------------------");

        // 40. Sort the employees salary in each department in ascending order
        System.out.println("Sorting the employee salary department wise in ascending order :: ");
        Map<String, List<Employee>> sortedEmployeeAsc = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::deptName, Collectors.collectingAndThen(
                                Collectors.toList(), list ->
                                        list.stream()
                                                .sorted(Comparator.comparingDouble(Employee::salary))
                                                .toList()
                        )
                ));

        sortedEmployeeAsc.forEach((dept, sortedEmpBySal) -> System.out.println(dept + " -> " + sortedEmpBySal));
        System.out.println("--------------------------------------------------------------------------------------");

        // 41. Sort the employees salary in each department in descending order
        System.out.println("Sorting the department wise employee salary in descending order ");
        Map<String, List<Employee>> sortedEmployeeDesc = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::deptName, Collectors.collectingAndThen(
                                Collectors.toList(), list ->
                                        list.stream()
                                                .sorted(Comparator.comparingDouble(Employee::salary).reversed())
                                                .toList())));

        sortedEmployeeDesc.forEach((dept, sortedEmpBySal) -> System.out.println(dept + " -> " + sortedEmpBySal));
        System.out.println("--------------------------------------------------------------------------------------");

        // 42. Print the no of Male and Female in each department
        System.out.println("No of Male and Female in the department :: ");
        Map<String, Map<String, Long>> genderMapByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::deptName, Collectors.groupingBy(
                                Employee::gender, Collectors.counting()
                        )
                ));
        genderMapByDept.forEach((dept, genderCnt) -> System.out.println(dept + " -> " + genderCnt));
        System.out.println("--------------------------------------------------------------------------------------");

        // 43. Find list of employees whose age is less than 30 in Department HR
        employees.stream()
                .filter(e -> e.age() < 30 && "HR".equalsIgnoreCase(e.deptName()))
                .map(Employee::name)
                .forEach(name -> System.out.println("Young in Dev: " + name));
        System.out.println("--------------------------------------------------------------------------------------");

        // 44. Find the employees whose name start with J.
        employees.stream()
                .map(Employee::name)
                .filter(name -> name.toLowerCase().startsWith("j"))
                .forEach(name -> System.out.println("Name starts with J: " + name));
        System.out.println("--------------------------------------------------------------------------------------");

        // 45. Find the employees in each department that have a salary above a certain threshold.
        System.out.println("Employees in each department that have a salary above a certain threshold :: ");
        Map<String, Set<Employee>> wellPaidEmployeesByDepartment = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::deptName, Collectors.filtering(e -> e.salary() > 140, Collectors.toSet())));
        wellPaidEmployeesByDepartment.forEach((dept, wellPaidEmployees) -> System.out.println(dept + " -> " + wellPaidEmployees));
        System.out.println("--------------------------------------------------------------------------------------");
    }

    private static void streamAPIQuestionsAboutStudent(List<Student> students) {
        System.out.println("::::: Sort based on Age of students ::::: ");
        //  Collections.sort(students, new AgeComparator()); // sorting based on age of students
        students.stream().sorted(Comparator.comparingInt(Student::age)).forEach(System.out::println);

        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("::::: Sort based on Name of students ::::: ");
        // Collections.sort(students, new NameComparator()); // sorting based on name of students
        students.stream().sorted(Comparator.comparing(Student::name)).forEach(System.out::println);

        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("::::: Filter the students that age is > 15 ::::: ");
        students.stream().sorted(Comparator.comparingInt(Student::age)).filter(age -> age.age() > 15)
                .forEach(System.out::println);

        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("::::: Get the min age of student ::::: ");
        students.stream().min(Comparator.comparingInt(Student::age)).ifPresent(System.out::println);

        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("::::: Get the max age of student ::::: ");
        students.stream().max(Comparator.comparingInt(Student::age)).ifPresent(System.out::println);

        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("::::: Sort based on Age of students using Comparable ::::: ");
        Collections.sort(students); // sorting based on age of students
        students.forEach(System.out::println);

        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("::::: Student details unique by student name ::::: ");
        Map<String, List<Student>> collect = students.stream()
                .collect(Collectors.groupingBy(Student::name));
        collect.forEach((key, value) -> System.out.println(key + " " + value));
    }
}