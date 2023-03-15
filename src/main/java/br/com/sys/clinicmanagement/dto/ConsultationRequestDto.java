package br.com.sys.clinicmanagement.dto;

import br.com.sys.clinicmanagement.model.Consultation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class ConsultationRequestDto {

    private String consultationDate;
    private String consultationTime;
    private String medic;
    private String patient;
    private String value;

    public ConsultationRequestDto(String consultationDate, String consultationTime, String medic, String patient, String value) {
        this.consultationDate = consultationDate;
        this.consultationTime = consultationTime;
        this.medic = medic;
        this.patient = patient;
        this.value = value;
    }

    public String getConsultationDate() {
        return consultationDate;
    }

    public String getConsultationTime() {
        return consultationTime;
    }

    public String getMedic() {
        return medic;
    }

    public String getPatient() {
        return patient;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "ConsultationRequestDto{" +
                "consultationDate=" + consultationDate +
                ", consultationTime=" + consultationTime +
                ", medic='" + medic + '\'' +
                ", patient='" + patient + '\'' +
                ", value=" + value +
                '}';
    }

    public Consultation toConsultation() {
        Consultation consultation = new Consultation();
        consultation.setConsultationDate(LocalDate.parse(consultationDate));
        consultation.setConsultationTime(LocalTime.parse(consultationTime));
        consultation.setPrice(new BigDecimal(value));
        return consultation;
    }
}
