package com.project.StageEtudiantabsence.services;

import com.project.StageEtudiantabsence.model.Classe;

import java.util.List;

public interface ClasseService {
    List<Classe> RetreiveAllClasse ();
    Classe Addclasse (Classe classe);
    public void Deleteclasse(Long id);

    Classe updateClasse( Classe classe, Long id);
}
