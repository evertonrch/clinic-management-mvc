package br.com.sys.clinicmanagement.model;

public class Medic {

    private String firstName;
    private String crm;

    public Medic(String firstName, String crm) {
        this.firstName = firstName;
        this.crm = crm;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getCrm() {
        return crm;
    }

    @Override
    public String toString() {
        return "Medic{" +
                "firstName='" + firstName + '\'' +
                ", crm='" + crm + '\'' +
                '}';
    }
}
