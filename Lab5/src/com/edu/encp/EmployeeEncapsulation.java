package com.edu.encp;

import java.util.Scanner;

class Employee {
    // Instance variables
    int eid;
    String ename;
    float esalary;
    int age;

    void inputEmployee() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the name: ");
        ename = sc.nextLine();

        System.out.println("Enter Employee id: ");
        eid = sc.nextInt();
    }

    void displayEmpData() {
        System.out.println("The name of the employee is: " + ename);
        System.out.println("Employee id is: " + eid);
    }
}

public class EmployeeEncapsulation {
    public static void main(String[] args) {
        System.out.println("Main method");

        Employee dataobject = new Employee();
        dataobject.inputEmployee(); // Input employee data
        dataobject.displayEmpData(); // Display employee data
    }
}
