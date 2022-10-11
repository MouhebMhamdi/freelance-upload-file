package com.project.StageEtudiantabsence.controller;

import com.project.StageEtudiantabsence.model.AbsenceEtudiant;
import com.project.StageEtudiantabsence.model.Classe;
import com.project.StageEtudiantabsence.model.Etudiant;
import com.project.StageEtudiantabsence.services.ClasseServiceImpl;
import com.project.StageEtudiantabsence.services.EtudiantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/etudiant")
public class EtudiantController  {

    @Autowired
    EtudiantServiceImpl etudiantService;


    @GetMapping("/retrieve-all-etudiant")
    @ResponseBody
    public List<Etudiant> getAlletudiant() {
        List<Etudiant> list = etudiantService.RetreiveAllEtudiant();
        return list;
    }
    @DeleteMapping("/removeetudiant/{etudiant-id}")
    @ResponseBody
    public void removeetudiant(@PathVariable("etudiant-id") Long id) {
        etudiantService.Deleteetudiant(id);
    }

    @PostMapping("/Add-etudiant")
    @ResponseBody
    public Etudiant addetudiant(@RequestBody Etudiant etudiant ){

        return etudiantService.Addetudiant(etudiant);
    }
    @PutMapping(value="/modifyetudiant/{etudiant-id}")
    public Etudiant modify(@PathVariable (name="etudiant-id") Long id, @RequestBody Etudiant etudiant){

        return etudiantService.updateEtudiant(etudiant, id);
    }

}
