package com.ust.project;

import java.util.Scanner;

public class MainApp {

    static Employee employee;
    static Training technicalTraining;
    static Training softSkillTraining;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

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
                    technicalTraining =
                            new Training(201, "Java Full Stack", "Trainer A");
                    technicalTraining.enrollEmployee(employee);
                    break;

                case 3:
                    softSkillTraining =
                            new Training(301, "Communication Skills", "Trainer B");
                    softSkillTraining.enrollEmployee(employee);
                    break;

                case 4:
                    System.out.println("\nEvaluating Trainings:");

                    if (technicalTraining != null) {
                        technicalTraining.completeTraining();
                        CertificateGenerator.generateCertificate(employee, technicalTraining);
                    }

                    if (softSkillTraining != null) {
                        softSkillTraining.completeTraining();
                        CertificateGenerator.generateCertificate(employee, softSkillTraining);
                    }
                    break;

                case 5:
                    if (technicalTraining != null) {
                        System.out.println("Certification: " +
                                technicalTraining.getTrainingName());
                        System.out.println("Status: " +
                                technicalTraining.getStatus());
                    }
                    break;

                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
