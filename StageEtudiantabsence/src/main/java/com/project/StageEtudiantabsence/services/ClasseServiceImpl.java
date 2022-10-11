package com.project.StageEtudiantabsence.services;

import com.project.StageEtudiantabsence.model.Classe;
import com.project.StageEtudiantabsence.repository.ClasseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClasseServiceImpl implements ClasseService {
    @Autowired
    ClasseRepository classeRepository;
    @Override
    public List<Classe> RetreiveAllClasse() {
        return classeRepository.findAll();
    }

    @Override
    public Classe Addclasse(Classe classe) {
        return classeRepository.save(classe);
    }

    @Override
    public void Deleteclasse(Long id) {
classeRepository.deleteById(id);
    }



    @Override
    public Classe updateClasse(Classe classe, Long id) {
        classe.setId(id);
        return classeRepository.save(classe);
    }
}
