package com.project.StageEtudiantabsence.repository;

import com.project.StageEtudiantabsence.model.Classe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
@Repository
public interface ClasseRepository extends JpaRepository <Classe, Long> {

}
