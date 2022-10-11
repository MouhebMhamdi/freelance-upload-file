package com.project.StageEtudiantabsence.services;

import com.project.StageEtudiantabsence.model.Classe;
import com.project.StageEtudiantabsence.model.Etudiant;
import com.project.StageEtudiantabsence.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EtudiantServiceImpl implements EtudiantService{
    @Autowired
    EtudiantRepository etudiantRepository;
    @Override
    public List<Etudiant> RetreiveAllEtudiant() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant Addetudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public void Deleteetudiant(Long id) {
        etudiantRepository.deleteById(id);

    }

    @Override
    public Etudiant updateEtudiant(Etudiant etudiant, Long id) {
        etudiant.setId(id);
        return etudiantRepository.save(etudiant);
    }
}
