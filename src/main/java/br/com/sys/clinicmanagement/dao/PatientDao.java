package br.com.sys.clinicmanagement.dao;

import br.com.sys.clinicmanagement.model.Patient;

import java.util.List;

public interface PatientDao {

    void savePatient(Patient patient);

    Patient findByName(String name);

    List<Patient> getPatients();
}
