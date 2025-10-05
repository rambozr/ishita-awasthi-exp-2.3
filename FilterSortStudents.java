import java.util.*;
import java.util.stream.*;

class Student {
    private String name;
    private double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() { return name; }
    public double getMarks() { return marks; }

    @Override
    public String toString() {
        return name + " (" + marks + "%)";
    }
}

 class FilterSortStudents {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Alice", 82),
            new Student("Bob", 68),
            new Student("Charlie", 90),
            new Student("David", 74),
            new Student("Eve", 78)
        );

        System.out.println("Students scoring above 75%, sorted by marks:");
        students.stream()
                .filter(s -> s.getMarks() > 75)
                .sorted(Comparator.comparingDouble(Student::getMarks))
                .map(Student::getName)
                .forEach(System.out::println);
    }
}
