package br.com.sys.clinicmanagement.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "tb_consultation")
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime scheduling;
    @Column(precision = 10, scale = 2)
    private BigDecimal price;
    @OneToOne
    private Patient patient;
    @OneToOne
    private Medic medic;

    public Consultation() {}

    public Consultation(LocalDateTime scheduling, BigDecimal price) {
        this.scheduling = scheduling;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consultation that = (Consultation) o;
        return Objects.equals(id, that.id) && Objects.equals(scheduling, that.scheduling) && Objects.equals(price, that.price) && Objects.equals(patient, that.patient) && Objects.equals(medic, that.medic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, scheduling, price, patient, medic);
    }

    public BigDecimal getPrice() {
        return price;
    }

    public LocalDateTime getScheduling() {
        return scheduling;
    }

    public Patient getPatient() {
        return patient;
    }

    public Medic getMedic() {
        return medic;
    }

    public Long getId() {
        return id;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setMedic(Medic medic) {
        this.medic = medic;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setScheduling(LocalDateTime scheduling) {
        this.scheduling = scheduling;
    }

    @Override
    public String toString() {
        return "Consultation{" +
                "id=" + id +
                ", scheduling=" + scheduling +
                ", price=" + price +
                ", patient=" + patient +
                ", medic=" + medic +
                '}';
    }
}
