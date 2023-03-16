package br.com.sys.clinicmanagement.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "tb_consultation")
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate consultationDate;
    private LocalTime consultationTime;
    @Column(precision = 10, scale = 2)
    private BigDecimal price;
    @OneToOne
    private Patient patient;
    @OneToOne
    private Medic medic;

    public Consultation() {}

    public Consultation(LocalDate consultationDate, LocalTime consultationTime, BigDecimal price) {
        this.consultationDate = consultationDate;
        this.consultationTime = consultationTime;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consultation that = (Consultation) o;
        return Objects.equals(id, that.id) && Objects.equals(consultationDate, that.consultationDate) && Objects.equals(consultationTime, that.consultationTime) && Objects.equals(price, that.price) && Objects.equals(patient, that.patient) && Objects.equals(medic, that.medic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, consultationDate, consultationTime, price, patient, medic);
    }

    public void setMedic(Medic medic) {
        this.medic = medic;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setConsultationDate(LocalDate consultationDate) {
        this.consultationDate = consultationDate;
    }

    public void setConsultationTime(LocalTime consultationTime) {
        this.consultationTime = consultationTime;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getConsultationDate() {
        return consultationDate;
    }

    public LocalTime getConsultationTime() {
        return consultationTime;
    }

    public BigDecimal getPrice() {
        return price;
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

    @Override
    public String toString() {
        return "Consultation{" +
                "id=" + id +
                ", consultationDate=" + consultationDate +
                ", consultationTime=" + consultationTime +
                ", price=" + price +
                ", patient=" + patient +
                ", medic=" + medic +
                '}';
    }
}
