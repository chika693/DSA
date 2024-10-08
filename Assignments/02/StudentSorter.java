import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

class Student implements Comparable<Student>{
    private String first, last;
    private int id;
    private double grade;
    private Student(String first, String last, int id, double grade) {
        this.first = first;
        this.last = last;
        if (id < 0) {
            System.out.println("Invalid student id.");
            throw new IllegalArgumentException();
        } else {
            this.id = id;
        }
        if (grade < 0.0) {
            System.out.println("Invalid student grade.");
            throw new IllegalArgumentException();
        } else {
            this.grade = grade;
        }
    }

    public static Student create(String first, String last, int id, double grade) {
        return new Student(first, last, id, grade);
    }

    public String getFirst() { return first; }

    public String getLast() { return last; }

    public int getId() { return id; }

    public double getGrade() { return grade; }

    @Override 
    public String toString() { return getFirst() + ", " + getLast() + " " + getId() + " " + getGrade(); }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Student) {
            Student other = (Student) o;
            return this.first.equals(other.first) && this.last.equals(other.last) && this.id == other.id && this.grade == other.grade;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, last, id, grade);
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.id, other.id);
    }

}

public class StudentSorter { 
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        try {

            Scanner fileSc = new Scanner(new File("students.txt"));
            while (fileSc.hasNext()) {
                String first = fileSc.next();
                String last = fileSc.next();
                int id = fileSc.nextInt();
                double grade = fileSc.nextDouble();
                
                studentList.add(Student.create(first, last, id, grade));
            }
            fileSc.close();
        } 
        catch (FileNotFoundException ex) {
            System.out.println("File: students.txt not found.");
        }


        Scanner input = new Scanner(System.in);
        char option; 

        do {
            System.out.println("Choices:");
            System.out.println("F - sort by first name");
            System.out.println("L - sort by last name");
            System.out.println("I - sort by id");
            System.out.println("G - sort by grade");
            System.out.println("Q - quit");

            option = input.next().charAt(0);

            switch(option) {
                case 'F':
                case 'f': {
                    Comparator<Student> byFirstComparator = new Comparator<>() {
                        @Override
                        public int compare(Student s1, Student s2) {
                            return s1.getFirst().compareTo(s2.getFirst());
                        }
                    };
                    Collections.sort(studentList, byFirstComparator);
                    System.out.println("students sorted by first name:");
                    display(studentList);
                    System.out.println();
                    break;
                } 

                case 'L':
                case 'l': {
                    Comparator<Student> byLastComparator = new Comparator<>() {
                        @Override
                        public int compare(Student s1, Student s2) {
                            return s1.getLast().compareTo(s2.getLast());
                        }
                    };
                    Collections.sort(studentList, byLastComparator);
                    System.out.println("students sorted by last name:");
                    display(studentList);
                    System.out.println();
                    break;
                }

                case 'I':
                case 'i': {
                    Comparator<Student> byIdComparator = new Comparator<>() {
                        @Override
                        public int compare(Student s1, Student s2) {
                            return Integer.compare(s1.getId(), s2.getId());
                        }
                    };
                    Collections.sort(studentList, byIdComparator);
                    System.out.println("students sorted by id:");
                    display(studentList);
                    System.out.println();
                    break;
                }

                case 'G':
                case 'g': {
                    Comparator<Student> byGradeComparator = new Comparator<>() {
                        @Override
                        public int compare(Student s1, Student s2) {
                            return Double.compare(s1.getGrade(), s2.getGrade()); 
                        }
                    };
                    Collections.sort(studentList, byGradeComparator);
                    System.out.println("students sorted by grade:");
                    display(studentList);
                    System.out.println();
                    break;
                }

                case 'Q':
                case 'q':
                    break;

                default:
                    System.out.println("Invalid Option.");
            }

        } while (option != 'Q' && option != 'q');

        input.close();

    }

    public static void display(List<Student> list) {
        for (Student s : list) {
            System.out.printf("%-9s%-9s%-9d%-9.1f\n", s.getFirst(), s.getLast(), s.getId(), s.getGrade());
        }
    }

}
