package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("Input a: ");
        int a = inputNumber();

        System.out.print("Input b: ");
        int b = inputNumber();

        System.out.print("Input c: ");
        int c = inputNumber();

        System.out.print("Input x: ");
        int x = inputNumber();

        System.out.print("Input y: ");
        int y = inputNumber();


        if ((x >= a && y >= b) || (x >= b && y >= a)) {
            System.out.println("The brick will pass");
        } else if ((x >= b && y >= c) || (x > c && y > b)) {
            System.out.println("The brick will pass");

        } else if ((x >= c && y >= a) || (x >= a && y >= c)) {
            System.out.println("The brick will pass");
        } else {
            System.out.println("The brick will not pass");
        }

    }

        static int checkNumber(int number) {
            Scanner in_temp = new Scanner(System.in);
            while (number <= 0) {
                while (true) {
                    try {
                        System.out.println("Value must be positive!");
                        System.out.print("Input positive value: ");
                        number = Integer.parseInt(in_temp.nextLine().trim());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Input error! Please enter a number.");
                    }
                }
            }
            return number;
        }

        static int inputNumber() {
            Scanner in_temp = new Scanner(System.in);
            int number;
            while (true) {
                try {
                    number = Integer.parseInt(in_temp.nextLine().trim());
                    number = checkNumber(number);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Input error! Please enter a number.");
                }
            }
            return number;
        }

    }
	// write your code here


