package com.project.StageEtudiantabsence.repository;

import com.project.StageEtudiantabsence.model.Files;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilesRepository extends JpaRepository<Files, Integer> {
}