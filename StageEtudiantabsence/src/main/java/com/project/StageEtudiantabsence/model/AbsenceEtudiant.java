package com.project.StageEtudiantabsence.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class AbsenceEtudiant {

    @Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
    private String idetudiant;
    @ManyToOne
    @JsonIgnore
    private Classe classe;

    private Timestamp Seance;
    private Date SeanceDate;
    private int Semestre;

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    private String Observation;
    @Lob
    private  byte[] file;
    private String fileName;

    @Enumerated(EnumType.STRING)
    private Presence presence;
    @Enumerated(EnumType.STRING)
    private Module module;

    public void setModule(com.project.StageEtudiantabsence.model.Module module) {
        this.module = module;
    }

    public Module getModule() {
        return module;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdetudiant() {
        return idetudiant;
    }

    public void setIdetudiant(String idetudiant) {
        this.idetudiant = idetudiant;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }


    public Timestamp getSeance() {
        return Seance;
    }

    public void setSeance(Timestamp seance) {
        Seance = seance;
    }

    public Date getSeanceDate() {
        return SeanceDate;
    }

    public void setSeanceDate(Date seanceDate) {
        SeanceDate = seanceDate;
    }

    public int getSemestre() {
        return Semestre;
    }

    public void setSemestre(int semestre) {
        Semestre = semestre;
    }

    public String getObservation() {
        return Observation;
    }

    public void setObservation(String observation) {
        Observation = observation;
    }

    public Presence getPresence() {
        return presence;
    }

    public void setPresence(Presence presence) {
        this.presence = presence;
    }

    public AbsenceEtudiant() {

    }

    public AbsenceEtudiant(Long id, String idetudiant, Classe classe,  Timestamp seance, Date seanceDate, int semestre, String observation, Presence presence, Module module) {
        this.id = id;
        this.idetudiant = idetudiant;
        this.classe = classe;

        Seance = seance;
        SeanceDate = seanceDate;
        Semestre = semestre;
        Observation = observation;
        this.presence = presence;
        this.module=module;

    }
}
