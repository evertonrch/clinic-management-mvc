package br.com.sys.clinicmanagement.dto;

public class MedicRequestDto {

    private String firstName;
    private String address;
    private String crm;

    public MedicRequestDto(String firstName, String address, String crm) {
        this.firstName = firstName;
        this.address = address;
        this.crm = crm;
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

    @Override
    public String toString() {
        return "MedicRequestDto{" +
                "firstName='" + firstName + '\'' +
                ", address='" + address + '\'' +
                ", crm='" + crm + '\'' +
                '}';
    }
}
