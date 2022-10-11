package com.project.StageEtudiantabsence.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Classe {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String nom;
    @OneToMany(mappedBy="classe")
    private Set<AbsenceEtudiant> absenceEtudiant;
    @OneToMany(mappedBy = "classe")
    private Set<Etudiant> etudiant;


    public Classe() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Set<AbsenceEtudiant> getAbsenceEtudiant() {
        return absenceEtudiant;
    }

    public void setAbsenceEtudiant(Set<AbsenceEtudiant> absenceEtudiant) {
        this.absenceEtudiant = absenceEtudiant;
    }

    public Set<Etudiant> getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Set<Etudiant> etudiant) {
        this.etudiant = etudiant;
    }

    public Classe(Long id, String nom, Set<AbsenceEtudiant> absenceEtudiant, Set<Etudiant> etudiant) {
        this.id = id;
        this.nom = nom;
        this.absenceEtudiant = absenceEtudiant;
        this.etudiant = etudiant;
    }

}
