import db.EmployeeDB;
import models.Employee;
import view.View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class HRManager {

    private static final String LINE = "--------------------------------------";

    private static final String[] NAVIGATION_OPTIONS = new String[]{"Exit", "Add Employee", "Edit Employee", "List Employees", "Delete Employee"};

    final static Scanner scanner = new Scanner(System.in);
    private static Scanner reader = new Scanner(System.in);

    private static View view = new View();



    public static void main(String[] args) {
        while (true) {
            printMenu();
        }
    }

    private static void printMenu() {
        System.out.println(LINE);
        System.out.println("-------------" + " HR Manager " + "-------------");
        System.out.println(LINE);
        for(int i = 1; i <= NAVIGATION_OPTIONS.length; i++) {
            System.out.println(i + ". " + NAVIGATION_OPTIONS[i-1]);
        }
        System.out.println();
        System.out.println("Please select a option between 1 and " + NAVIGATION_OPTIONS.length + ":");

        selectMenu();

    }

    private static void selectMenu() {
        //TODO: add error handling

        try {
            int selectedMenuId = scanner.nextInt();
            showMenu(selectedMenuId);
            //  Block of code to try
        }
        catch(Exception e) {
            //  Block of code to handle errors
            System.out.println("Error: " + e);
        }


    }

    private static void showMenu(int selectedMenuId) throws ParseException {

        EmployeeDB employeeDB;


        switch (selectedMenuId) {
            case 1:
                System.exit(0);
                break;
            case 2:
                // Einlesen eines Emloyees

                System.out.println("Prename:");
                Scanner scanner = new Scanner(System.in);
                String prename = scanner.next();

                System.out.println("Surname:");
                scanner = new Scanner(System.in);
                String surname = scanner.next();

                System.out.println("Job:");
                scanner = new Scanner(System.in);
                String job = scanner.next();

                System.out.println("Date: (Format:[1980-12-12])");
                scanner = new Scanner(System.in);
                String date = scanner.next();

                System.out.print("Salary: ");
                double salary = reader.nextDouble();

                System.out.println("Employement Date:");
                scanner = new Scanner(System.in);
                long employementdate = Long.parseLong(scanner.next());
                employementdate = Date.parse(String.valueOf(employementdate));

                Employee employee = new Employee(prename, surname, job, date, salary, employementdate);

                view.showAddEmployee();
                break;
            case 3:

                System.out.println("Prename:");
                scanner = new Scanner(System.in);
                String prenameedit = scanner.next();

                System.out.println("Surname:");
                scanner = new Scanner(System.in);
                String surnameedit = scanner.next();

                System.out.println("Job:");
                scanner = new Scanner(System.in);
                String jobedit = scanner.next();

                System.out.println("Date: (Format:[1980-12-12])");
                scanner = new Scanner(System.in);
                String dateedit = scanner.next();
                Date date2 = new SimpleDateFormat("dd.MM.yyyy").parse(String.valueOf(dateedit));

                System.out.print("Salary: ");
                double salaryedit = reader.nextDouble();

                System.out.println("Employement Date:");
                scanner = new Scanner(System.in);
                long employementdateedit = Long.parseLong(scanner.next());
                Date date1 = new SimpleDateFormat("dd.MM.yyyy").parse(String.valueOf(employementdateedit));

                employee = new Employee(prenameedit, surnameedit, jobedit, date2, salaryedit, date1);

                view.showEditEmployee();
                break;
            case 4:
                employeeDB = new EmployeeDB();
                employeeDB.getEmployees();
                view.showListEmployees();
                break;
            case 5:
                System.out.println("Employee ID:");
                scanner = new Scanner(System.in);
                String idDelete = scanner.next();

                employeeDB = new EmployeeDB();
                employeeDB.deleteEmployee(idDelete);

                view.showDeleteEmployee();
                break;
            default:
                System.out.println("You selected a invalid option. please select again.");
                selectMenu();
        }

    }

}
