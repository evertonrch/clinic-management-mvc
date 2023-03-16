package br.com.sys.clinicmanagement.dao;

import br.com.sys.clinicmanagement.model.Medic;

import java.util.List;

public interface MedicDao {

    List<Medic> getMedics();
    void saveMedic(Medic medic);

    List<String> medicsByName();

    Medic findByName(String medic);

    Medic findById(long parseLong);

    void delete(Medic medic);
}
