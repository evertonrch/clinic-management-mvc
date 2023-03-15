package br.com.sys.clinicmanagement.dto;

public class MedicRequestDto {

    private String firstName;
    private String address;
    private String crm;
    private String specialty;

    public MedicRequestDto(String firstName, String address, String crm, String specialty) {
        this.firstName = firstName;
        this.address = address;
        this.crm = crm;
        this.specialty = specialty;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getAddress() {
        return address;
    }

    public String getCrm() {
        return crm;
    }

    public String getSpecialty() {
        return specialty;
    }

    @Override
    public String toString() {
        return "MedicRequestDto{" +
                "firstName='" + firstName + '\'' +
                ", address='" + address + '\'' +
                ", crm='" + crm + '\'' +
                ", specialty='" + specialty + '\'' +
                '}';
    }
}
