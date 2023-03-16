package br.com.sys.clinicmanagement.dao.impl;

import br.com.sys.clinicmanagement.dao.PatientDao;
import br.com.sys.clinicmanagement.model.Patient;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class PatientDaoImpl implements PatientDao {

    private final EntityManager entityManager;

    public PatientDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Transactional
    @Override
    public void savePatient(Patient patient) {
        entityManager.persist(patient);
    }

    @Override
    public Patient findByName(String name) {
        return entityManager.createQuery("SELECT p FROM Patient p WHERE p.firstName = :name", Patient.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    @Override
    public List<Patient> getPatients() {
        return entityManager.createQuery("SELECT p FROM Patient p", Patient.class)
                .getResultList();
    }


}
