package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("Input n: ");
        int n = inputNumber();

        int n2 = n * n;
        System.out.println("n^2 = " + n2);

        boolean includedNumber3 = false;
        while ((n2 != 0) && (!includedNumber3)) {
            if (n2 % 10 == 3) {
                includedNumber3 = true;
            }
            n2 = n2 / 10;
        }

        if (includedNumber3) {
            System.out.println("a) 3 included");
        } else {
            System.out.println("a) 3 not included");
        }

        int revers = 0, temp, copy = n;
        do {
            temp = copy % 10;
            revers = (revers * 10) + temp;
            copy = copy / 10;
        } while (copy > 0);
        System.out.println("b) " + revers);

        int begin, middle = 0, position = 1;
        copy = n;
        begin = copy % 10;
        copy = copy / 10;
        while (copy > 9) {
            begin *= 10;
            middle += (copy % 10) * position;
            position *= 10;
            copy /= 10;
        }
        copy = (begin * 10) + (middle * 10) + copy;
        System.out.println("c) " + copy);

        int result, first_1 = 10;
        copy = n;
        while (copy != 0) {
            copy /= 10;
            first_1 *= 10;
        }
        result = first_1 + n * 10 + 1;
        System.out.println("d) " + result);
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

    static int inputNumber() {
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

}
