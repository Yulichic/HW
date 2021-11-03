package com.company;
import java.time.Year;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static class Person {
        private String name;
        private int birthYear;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getBirthYear() {
            return birthYear;
        }

        public void setBirthYear(int birthYear) {
            if (birthYear > Year.now().getValue() || birthYear <= 0) {
                System.out.println("Incorrect year of birth.");
                this.birthYear = 0;
            } else {
                this.birthYear = birthYear;
            }
        }

        public Person() {
        }

        public Person(String name, int birthYear) {
            this.name = name;
            if (birthYear > Year.now().getValue() || birthYear <= 0) {
                System.out.println("Incorrect year of birth.");
                this.birthYear = 0;
            } else {
                this.birthYear = birthYear;
            }
        }

        public int calculateAge() {
            if (this.birthYear != 0) {
                return Year.now().getValue() - this.birthYear;
            } else {
                System.out.println("Your year of birth is 0, please enter it.");
                return -1;
            }
        }

        public void input() {
            Scanner in = new Scanner(System.in);
            System.out.print("Input name ");
            this.name = inputString();

            System.out.print("Input year of birth ");
            int birthYear = inputIntegerNumber();
            while (birthYear > Year.now().getValue() || birthYear <= 0) {
                System.out.println("Incorrect year of birth.");
                birthYear = inputIntegerNumber();
            }
            this.birthYear = birthYear;
        }

        public void output() {
            System.out.println("Name is " + this.name);
            System.out.println("Year of birth is " + this.birthYear);
        }

        public void changeName(String name) {
            this.name = name;
        }

        static int checkNumber(int number) {
            Scanner temp = new Scanner(System.in);
            while (number <= 0) {
                while (true) {
                    try {
                        System.out.println("Value must be positive!");
                        System.out.print("Input positive value: ");
                        number = Integer.parseInt(temp.nextLine().trim());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Input error! Please enter a number.");
                    }
                }
            }
            return number;
        }

        static int inputIntegerNumber() {
            Scanner temp = new Scanner(System.in);
            int number;
            while (true) {
                try {
                    number = Integer.parseInt(temp.nextLine().trim());
                    number = checkNumber(number);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Input error! Please enter a number.");
                }
            }
            return number;
        }

        static String inputString(){
            Scanner temp = new Scanner(System.in);
            String str = temp.nextLine();

            String pattern = "([\\s|a-zA-Z])+";
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(str);

            while(!m.matches()){
                System.out.print("Input error! Please enter only the letters of the English alphabet. ");
                str = temp.nextLine();
                m = p.matcher(str);
            }
            return str;
        }

    }

    public static void main(String[] args) {
        Person pers1 = new Person();
        pers1.output();

        Person pers2 = new Person("Zac", 1979);
        pers2.output();
        System.out.println("Age " + pers2.calculateAge());

        Person pers3 = new Person();
        pers3.setName("Karen");
        pers3.setBirthYear(1945);
        pers3.output();

        Person pers4 = new Person();
        pers4.input();
        System.out.println("Name " + pers4.getName());
        System.out.println("Year " + pers4.getBirthYear());

        Person pers5 = new Person("Sue", 1998);
        pers5.changeName("Harre");
        pers5.output();
    }


}
