package br.com.sys.clinicmanagement.dao.impl;

import br.com.sys.clinicmanagement.dao.ConsultationDao;
import br.com.sys.clinicmanagement.model.Consultation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ConsultationDaoImpl implements ConsultationDao {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    @Override
    public void saveConsultation(Consultation consultation) {
        entityManager.persist(consultation);
    }

    @Override
    public List<Consultation> getConsultations() {
        return entityManager.createQuery("SELECT c FROM Consultation c", Consultation.class)
                .getResultList();
    }
}
