package br.com.sys.clinicmanagement.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_specialization")
public class Specialization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @OneToOne(mappedBy = "specialization")
    private Medic medic;


    public Specialization() {
    }

    public Specialization(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public Medic getMedic() {
        return medic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Specialization that = (Specialization) o;
        return Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description);
    }
}
