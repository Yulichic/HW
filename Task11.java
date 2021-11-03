package com.company;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class Main {

    public class Student {
        private String name;
        private int course;

        public Student(String name, int course) {
            this.name = name;
            this.course = course;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getCourse() {
            return course;
        }

        public void setCourse(int course) {
            this.course = course;
        }

        public boolean compareCourse(Student other) {
            if ((this.name == other.name) && (this.course == other.course)) {
                return true;
            }
            return false;
        }

        public void output() {
            System.out.println("Student " + this.name + " in course " + this.course);
        }

        @Override
        public String toString() {
            return "Student " + this.name + " in course " + this.course;
        }

        public void printStudents(List<Student> students, Integer course) {
            for (int i = 0; i < students.size(); ++i) {
                if (students.get(i).getCourse() == course) {
                    students.get(i).output();
                }
            }
        }
        public int compareByName(Student other) {
            String str1 = this.getName();
            String str2 = other.getName();
            return str1.compareTo(str2);
        }

        public int compareByCourse(Student other) {
            int price1 = this.getCourse();
            int price2 = other.getCourse();

            if (price1 > price2) {
                return 1;
            } else if (price1 < price2) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    class sortedByName implements Comparator<Student> {
        public int compare(Student obj1, Student obj2) {
            return obj1.compareByName(obj2);
        }
    }

    class sortedByCourse implements Comparator<Student> {
        public int compare(Student obj1, Student obj2) {
            return  obj1.compareByCourse(obj2);
        }
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        String[] name = new String[]{"Tom", "Bob", "Lili", "Fred", "Maria"};
        int[] course = new int[]{1, 2, 2, 5, 4};

        Student s;
        for (int i = 0; i < 5; ++i) {
            s = new Student(name[i], course[i]);
            students.add(s);
        }

        System.out.println();
        for (Object person : students) {
            System.out.println(person);
        }

        students.sort(new sortedByName());
        System.out.println("\n~~~ Сортування по імені");

        for (Student product : students)
            System.out.println(product.toString());

        students.sort(new sortedByCourse());
        System.out.println("\n~~~ Сортування по курсах");

        for (Student product : students)
            System.out.println(product.toString());
    }
}
