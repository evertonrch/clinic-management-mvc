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

    @OneToOne
    private Specialization specialization;

    public Medic(String firstName, String crm) {
        this.firstName = firstName;
        this.crm = crm;
    }

    public Medic(){
    }

    public Medic(MedicRequestDto medicReq) {
        this.firstName = medicReq.getFirstName();
        this.address = medicReq.getAddress();
        this.crm = medicReq.getCrm();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getCrm() {
        return crm;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    @Override
    public String toString() {
        return "Medic{" +
                "firstName='" + firstName + '\'' +
                ", crm='" + crm + '\'' +
                '}';
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
