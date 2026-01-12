package com.ust.project;

public class Training {

    public enum Status {
        NOT_STARTED,
        IN_PROGRESS,
        COMPLETED
    }

    private int trainingId;
    private String trainingName;
    private String trainerName;
    private Employee employee;
    private Status status;

    public Training(int trainingId, String trainingName, String trainerName) {
        this.trainingId = trainingId;
        this.trainingName = trainingName;
        this.trainerName = trainerName;
        this.status = Status.NOT_STARTED;
    }

    public void enrollEmployee(Employee employee) {
        this.employee = employee;
        this.status = Status.IN_PROGRESS;
        System.out.println("Employee " + employee.getEmpName() +
                " enrolled in " + trainingName);
    }

    public void completeTraining() {
        this.status = Status.COMPLETED;
    }

    public Status getStatus() {
        return status;
    }

    public String getTrainingName() {
        return trainingName;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void evaluate() {
        System.out.println("General training evaluation");
    }
}
