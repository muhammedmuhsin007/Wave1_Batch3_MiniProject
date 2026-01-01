package com.ust.project;

public class Certification {

    private String certificationName;
    private boolean completed;

    public Certification(String certificationName, boolean completed) {
        this.certificationName = certificationName;
        this.completed = completed;
    }

    public void showStatus() {
        System.out.println("Certification: " + certificationName);
        if (completed) {
            System.out.println("Status: Completed");
        } else {
            System.out.println("Status: Pending");
        }
    }
}
