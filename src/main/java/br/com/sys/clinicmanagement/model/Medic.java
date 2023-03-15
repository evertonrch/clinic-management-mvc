package br.com.sys.clinicmanagement.model;

import br.com.sys.clinicmanagement.dto.MedicRequestDto;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_medic")
public class Medic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String crm;
    @Lob
    private String address;

    private String specialty;

    public Medic(String firstName, String crm, String specialty) {
        this.firstName = firstName;
        this.crm = crm;
        this.specialty = specialty;
    }

    public Medic(){
    }

    public Medic(MedicRequestDto medicReq) {
        this.firstName = medicReq.getFirstName();
        this.address = medicReq.getAddress();
        this.crm = medicReq.getCrm();
        this.specialty = medicReq.getSpecialty();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getCrm() {
        return crm;
    }

    public String getSpecialty() {
        return specialty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medic medic = (Medic) o;
        return Objects.equals(firstName, medic.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName);
    }
}
