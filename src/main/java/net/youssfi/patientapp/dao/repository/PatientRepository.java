package net.youssfi.patientapp.dao.repository;

import net.youssfi.patientapp.dao.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository  extends JpaRepository<Patient,Long> {
    //recherche
Page<Patient>findByNomContainsIgnoreCaseOrPrenomContainsIgnoreCase(String nom , String prenom, Pageable pageable);
}
