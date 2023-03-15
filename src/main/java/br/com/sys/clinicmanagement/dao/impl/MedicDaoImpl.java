package br.com.sys.clinicmanagement.dao.impl;

import br.com.sys.clinicmanagement.dao.MedicDao;
import br.com.sys.clinicmanagement.model.Medic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class MedicDaoImpl implements MedicDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Medic> medics() {
        return entityManager.createQuery("SELECT m FROM Medic AS m", Medic.class)
                .getResultList();
    }

    @Override
    @Transactional
    public void saveMedic(Medic medic) {
        entityManager.persist(medic);
    }

    @Override
    @Transactional
    public List<String> medicsByName() {
        return entityManager.createQuery("SELECT m.firstName FROM Medic m", String.class)
                .getResultList();
    }

    @Override
    public Medic findByName(String medic) {
        return entityManager.createQuery("SELECT m FROM Medic m WHERE m.firstName = :medicName", Medic.class)
                .setParameter("medicName", medic)
                .getSingleResult();
    }


}
