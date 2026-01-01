package com.ust.project;

public class Training {

    private int trainingId;
    private String trainingName;
    private String trainerName;
    private Employee employee;

    public Training(int trainingId, String trainingName, String trainerName) {
        this.trainingId = trainingId;
        this.trainingName = trainingName;
        this.trainerName = trainerName;
    }

    public void enrollEmployee(Employee employee) {
        this.employee = employee;
        System.out.println("Employee " + employee.getEmpName() +
                " enrolled in " + trainingName);
    }

    public String getTrainingName() {
        return trainingName;
    }

    public void evaluate() {
        System.out.println("General training evaluation");
    }
}
