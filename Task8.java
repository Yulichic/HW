package com.company;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public interface CalculatePay {
        float calculatePay();
    }

    public class Employee implements CalculatePay {
        private String name;
        private String employeeId;

        public Employee() {
        }

        public Employee(String name, String employeeId) {
            this.name = name;
            this.employeeId = employeeId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmployeeId() {
            return employeeId;
        }

        public void setEmployeeId(String employeeId) {
            this.employeeId = employeeId;
        }

        @Override
        public float calculatePay() {
            return 0;
        }

        public void output() {
            System.out.println("Name: " + this.name + " ID: " + this.employeeId);
            System.out.println("Average Monthly wage:  " + this.calculatePay());
        }
    }

    public class ContractEmployee extends Employee implements CalculatePay {
        private String federalTaxIdmember;
        private int hourlyRate;
        private int numberOfHoursWorked;

        public ContractEmployee() {
        }

        public ContractEmployee(String name, String federalTaxIdmember, int hourlyRate, int numberOfHoursWorked) {
            super(name, federalTaxIdmember);
            this.federalTaxIdmember = federalTaxIdmember;
            this.hourlyRate = hourlyRate;
            this.numberOfHoursWorked = numberOfHoursWorked;
        }

        public int getHourlyRate() {
            return hourlyRate;
        }

        public void setHourlyRate(int hourly_rate) {
            this.hourlyRate = hourlyRate;
        }

        public int getNumberOfHoursWorked() {
            return numberOfHoursWorked;
        }

        public void setNumberOfHoursWorked(int numberOfHoursWorked) {
            this.numberOfHoursWorked = numberOfHoursWorked;
        }

        public String getFederalTaxIdmember() {
            return federalTaxIdmember;
        }

        public void setFederalTaxIdmember(String federalTaxIdmember) {
            this.federalTaxIdmember = federalTaxIdmember;
        }

        @Override
        public float calculatePay() {
            return hourlyRate * numberOfHoursWorked;
        }

    }

    public class SalariedEmployee extends Employee implements CalculatePay {
        private String socialSecurityNumber;
        private float fixedMonthlyPayment;

        public SalariedEmployee() {
        }

        public SalariedEmployee(String name, String socialSecurityNumber, float fixedMonthlyPayment) {
            super(name, socialSecurityNumber);
            this.socialSecurityNumber = socialSecurityNumber;
            this.fixedMonthlyPayment = fixedMonthlyPayment;
        }

        public String getSocialSecurityNumber() {
            return socialSecurityNumber;
        }

        public void setSocialSecurityNumber(String socialSecurityNumber) {
            this.socialSecurityNumber = socialSecurityNumber;
        }

        public float getFixedMonthlyPayment() {
            return fixedMonthlyPayment;
        }

        public void setFixedMonthlyPayment(float fixedMonthlyPayment) {
            this.fixedMonthlyPayment = fixedMonthlyPayment;
        }

        @Override
        public float calculatePay() {
            return fixedMonthlyPayment;
        }

    public static void main(String[] args) {
        Employee[] employees = new Employee[5];

        try (BufferedReader br = new BufferedReader(new FileReader("employee.txt"))) {
            String s;
            int i = -1;

            while ((s = br.readLine()) != null) {
                String[] words = s.split(" ");
                SalariedEmployee sEm = new SalariedEmployee();
                ContractEmployee cEmt = new ContractEmployee();

                if (words.length == 3) {
                    ++i;
                    float temp = Float.parseFloat(words[2]);
                    employees[i] = new SalariedEmployee(words[0], words[1], temp);
                }

                if (words.length == 4) {
                    ++i;
                    int temp = Integer.parseInt(words[2]);
                    int temp2 = Integer.parseInt(words[2]);
                    employees[i] = new ContractEmployee(words[0], words[1], temp, temp2);
                }
            }
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }

        QuickSort(employees, 0, employees.length - 1);

        for (Employee em : employees) {
            em.output();
        }

    }

    static int Partition(Employee arr[], int start, int end) {
        float x = arr[end].calculatePay();
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (arr[j].calculatePay() <= x) {
                i++;
                Employee temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        Employee temp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = temp;
        return i + 1;
    }

    static void QuickSort(Employee employees[], int left, int right) {
        int s;
        if (left < right) {
            s = Partition(employees, left, right);
            QuickSort(employees, left, s - 1);
            QuickSort(employees, s + 1, right);
        }
    }
}
