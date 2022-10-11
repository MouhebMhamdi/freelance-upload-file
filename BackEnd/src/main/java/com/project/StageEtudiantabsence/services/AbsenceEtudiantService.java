package com.project.StageEtudiantabsence.services;

import com.project.StageEtudiantabsence.model.AbsenceEtudiant;
import com.project.StageEtudiantabsence.model.Files;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface AbsenceEtudiantService {
    public AbsenceEtudiant saveAbsenceEtudiant(AbsenceEtudiant absenceEtudiant);
    public List<AbsenceEtudiant> getAllAbsenceEtudiants();

    public Files addFile(MultipartFile file) throws IOException;
            ;

}
