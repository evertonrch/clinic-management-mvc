package br.com.sys.clinicmanagement.dto;

import br.com.sys.clinicmanagement.model.Patient;

import java.time.LocalDate;

public class PatientRequestDto {

    private String firstName;
    private String middleName;
    private String lastName;

    private String email;

    public PatientRequestDto(String firstName, String middleName, String lastName, String email) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Patient toPatient() {
        Patient patient = new Patient();
        patient.setFirstName(firstName);
        patient.setMiddleName(middleName);
        patient.setLastName(lastName);
        patient.setEmail(email);
        return patient;
    }

    @Override
    public String toString() {
        return "PatientRequestDto{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
