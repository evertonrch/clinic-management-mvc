package br.com.sys.clinicmanagement.dao;

import br.com.sys.clinicmanagement.model.Consultation;

import java.util.List;

public interface ConsultationDao {

    void saveConsultation(Consultation consultation);

    List<Consultation> getConsultations();

    void delete(Consultation consultation);

    Consultation findById(Long id);
}
