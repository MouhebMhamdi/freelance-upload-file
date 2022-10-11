package com.project.StageEtudiantabsence.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Etudiant {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String idetudiant;
    private String nom;
    private String prenom;
    private String nomClass;
    @ManyToOne
    @JsonIgnore
    private Classe classe;

    public Etudiant() {

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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public Etudiant(Long id, String idetudiant, String nom, String prenom, Classe classe) {
        this.id = id;
        this.idetudiant = idetudiant;
        this.nom = nom;
        this.prenom = prenom;
        this.classe = classe;
    }
}
