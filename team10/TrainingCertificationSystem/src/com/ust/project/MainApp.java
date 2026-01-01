package com.ust.project;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Employee employee = null;
        Training techTraining = new TechnicalTraining(1, "Java Full Stack", "Mr. Kumar");
        Training softTraining = new SoftSkillTraining(2, "Communication Skills", "Ms. Anitha");

        while (true) {

            System.out.println("\n===== TRAINING & CERTIFICATION SYSTEM =====");
            System.out.println("1. Create Employee");
            System.out.println("2. Enroll in Technical Training");
            System.out.println("3. Enroll in Soft Skill Training");
            System.out.println("4. Evaluate Trainings");
            System.out.println("5. Check Certification Status");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Employee Name: ");
                    String name = sc.nextLine();

                    employee = new Employee(id, name);
                    System.out.println("Employee created successfully.");
                    break;

                case 2:
                    if (employee == null) {
                        System.out.println("Create employee first.");
                    } else {
                        techTraining.enrollEmployee(employee);
                    }
                    break;

                case 3:
                    if (employee == null) {
                        System.out.println("Create employee first.");
                    } else {
                        softTraining.enrollEmployee(employee);
                    }
                    break;

                case 4:
                    System.out.println("\nEvaluating Trainings:");
                    techTraining.evaluate();
                    softTraining.evaluate();
                    break;

                case 5:
                    Certification cert =
                            new Certification("Java Full Stack Certification", true);
                    cert.showStatus();
                    break;

                case 6:
                    System.out.println("Exiting application...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
