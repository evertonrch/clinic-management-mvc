package br.com.sys.clinicmanagement.dao;

import br.com.sys.clinicmanagement.model.Medic;

import java.util.List;

public interface MedicDao {

    List<Medic> medics();
    void saveMedic(Medic medic);
}
