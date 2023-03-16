package br.com.sys.clinicmanagement.dto;

import br.com.sys.clinicmanagement.model.Patient;

import java.time.LocalDate;

public class PatientRequestDto {

    private String firstName;
    private String middleName;
    private String lastName;

    private String birthDate;

    public PatientRequestDto(String firstName, String middleName, String lastName, String birthDate) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthDate = birthDate;
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

    public String getBirthDate() {
        return birthDate;
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

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Patient toPatient() {
        Patient patient = new Patient();
        patient.setFirstName(firstName);
        patient.setMiddleName(middleName);
        patient.setLastName(lastName);
        patient.setBirthDate(LocalDate.parse(birthDate));
        return patient;
    }

    @Override
    public String toString() {
        return "PatientRequestDto{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                '}';
    }
}
