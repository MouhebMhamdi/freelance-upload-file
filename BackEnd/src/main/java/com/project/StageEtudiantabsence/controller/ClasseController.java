package com.project.StageEtudiantabsence.controller;

import com.project.StageEtudiantabsence.model.AbsenceEtudiant;
import com.project.StageEtudiantabsence.model.Classe;
import com.project.StageEtudiantabsence.services.ClasseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/classe")
public class ClasseController {
    @Autowired
    ClasseServiceImpl classeService;



    @GetMapping("/retrieve-all-classe")
    @ResponseBody
    public List<Classe> getAllclasse() {
        List<Classe> list = classeService.RetreiveAllClasse();
        return list;
    }
    @DeleteMapping("/removeclasse/{classe-id}")
    @ResponseBody
    public void removeclasse(@PathVariable("classe-id") Long id) {
        classeService.Deleteclasse(id);
    }

    @PostMapping("/Add-classe")
    @ResponseBody
    public Classe addClasse(@RequestBody Classe classe ){

        return classeService.Addclasse(classe);
    }
    @PutMapping(value="/modifyclasse/{classe-id}")
    public Classe modify(@PathVariable (name="classe-id") Long id, @RequestBody Classe classe){

        return classeService.updateClasse(classe, id);
    }


}
