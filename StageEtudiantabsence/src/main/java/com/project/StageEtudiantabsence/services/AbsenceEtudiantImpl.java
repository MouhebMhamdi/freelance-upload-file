package com.project.StageEtudiantabsence.services;

import com.project.StageEtudiantabsence.model.AbsenceEtudiant;
import com.project.StageEtudiantabsence.model.Files;
import com.project.StageEtudiantabsence.repository.AbsenceEtudiantRepository;
import com.project.StageEtudiantabsence.repository.FilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class AbsenceEtudiantImpl implements AbsenceEtudiantService {
    @Autowired
    private AbsenceEtudiantRepository absenceEtudiantRepository;

    @Autowired
    private FilesRepository filesRepository;
    @Override
    public AbsenceEtudiant saveAbsenceEtudiant(AbsenceEtudiant absenceEtudiant) {
        return absenceEtudiantRepository.save(absenceEtudiant);
    }

    @Override
    public List<AbsenceEtudiant> getAllAbsenceEtudiants() {
        return absenceEtudiantRepository.findAll();
    }

    @Override
    public Files addFile(MultipartFile file) throws IOException {
        Files files=new Files();
        files.setFile(file.getBytes());
        files.setFileName(file.getOriginalFilename());
        files.setFileType(file.getContentType());
        return filesRepository.save(files);
    }
}
