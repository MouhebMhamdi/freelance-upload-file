package com.project.StageEtudiantabsence.services;

import com.project.StageEtudiantabsence.model.Classe;
import com.project.StageEtudiantabsence.model.Etudiant;

import java.util.List;

public interface EtudiantService {

    List<Etudiant> RetreiveAllEtudiant();
    Etudiant Addetudiant (Etudiant etudiant);
    public void Deleteetudiant(Long id);

    Etudiant updateEtudiant( Etudiant etudiant, Long id);

}
