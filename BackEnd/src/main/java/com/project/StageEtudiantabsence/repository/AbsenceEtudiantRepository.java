package com.project.StageEtudiantabsence.repository;


import com.project.StageEtudiantabsence.model.AbsenceEtudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AbsenceEtudiantRepository  extends JpaRepository<AbsenceEtudiant,Long> {
    @Query("SELECT A FROM AbsenceEtudiant  A WHERE  A.idetudiant=:idUSer")
    List<AbsenceEtudiant> getAbsenceEtudiant(String idUSer);
}
