package com.project.StageEtudiantabsence.controller;

import com.project.StageEtudiantabsence.model.AbsenceEtudiant;
import com.project.StageEtudiantabsence.model.Files;
import com.project.StageEtudiantabsence.services.AbsenceEtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@CrossOrigin(origins = "*")
@RestController

@RequestMapping("/absenceEtudiant")
public class AbsenceEtudiantController {
    @Autowired
    private AbsenceEtudiantService absenceEtudiantService;
    @PostMapping("/add")
    public String add(@RequestBody AbsenceEtudiant absenceEtudiant){
        absenceEtudiantService.saveAbsenceEtudiant(absenceEtudiant);
        return "new student is added";
    }
    @RequestMapping(value = "/file",method=RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Files addImage(@RequestPart("file") MultipartFile image)throws IOException {
        return absenceEtudiantService.addFile(image);
    }
    @GetMapping("/getAll")
    public List<AbsenceEtudiant> getAllAbsenceEtudiants(){
        return absenceEtudiantService.getAllAbsenceEtudiants();
    }
}
