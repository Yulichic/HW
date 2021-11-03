package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        //task1
        System.out.print("Input flower bad radius: ");
        Scanner in = new Scanner(System.in);

        float r = inputFloatNumber();
        double perimeter = 2 * r * Math.PI;
        double area = r * r * Math.PI;

        System.out.println("Perimeter = " + perimeter);
        System.out.println("Area = " + area);

        //task2
        System.out.println();

        System.out.print("What is your name? Answer: ");
        String name = inputString();

        System.out.print("Where are you live, " + name + "? Answer: ");
        String address = inputString();

        System.out.print("Your name is " + name);
        System.out.println(" and you live in " + address);

        //task3
        System.out.println();

        System.out.print("Roaming in the first country is ");
        float c1 = inputFloatNumber();
        System.out.print("Roaming in the second country is ");
        float c2 = inputFloatNumber();
        System.out.print("Roaming in the third country is ");
        float c3 = inputFloatNumber();

        System.out.print("Time of the first call is ");
        float t1 = inputFloatNumber();
        System.out.print("Time of the second call is ");
        float t2 = inputFloatNumber();
        System.out.print("Time of the third call is ");
        float t3 = inputFloatNumber();

        float result1 = c1 * t1;
        float result2 = c2 * t2;
        float result3 = c3 * t3;
        float resultAll = result1 + result2 + result3;

        System.out.println("The cost of the first call is " + result1);
        System.out.println("The cost of the second call is " + result2);
        System.out.println("The cost of the third call is " + result3);
        System.out.println("The cost of all calls is " + resultAll);
        in.close();
    }


    static float checkNumber(float number) {
        Scanner temp = new Scanner(System.in);
        while (number <= 0) {
            while (true) {
                try {
                    System.out.println("Value must be positive!");
                    System.out.print("Input positive value: ");
                    number = Float.parseFloat(temp.nextLine().trim().replace(",", "."));
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Input error! Please enter a number.");
                }
            }
        }
        return number;
    }

    static float inputFloatNumber() {
        Scanner temp = new Scanner(System.in);
        float number;
        while (true) {
            try {
                number = Float.parseFloat(temp.nextLine().trim().replace(",", "."));
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