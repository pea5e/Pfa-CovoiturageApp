package pfe.emsi.covoiturage.voyage.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;



public class User {
    private Long id;
    private String nom;
    private String password;
    private String email;
    private String prenom;
    private String telephone;
    private Gender sexe;
    private int age;
    private String cin;
    private int nombre_voya;
    private Boolean banned = false;

    public User() {
    }

    public User(String nom, String encode, String email, String prenom, String telephone, Gender sexe, int age, int nombre_voya, Boolean banned) {
        this.nom = nom;
        this.password = encode;
        this.email = email;
        this.prenom = prenom;
        this.telephone = telephone;
        this.sexe = sexe;
        this.age = age;
        this.nombre_voya = nombre_voya;
        this.banned = banned;

    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public Gender getSexe() {
        return sexe;
    }

    public int getAge() {
        return age;
    }

    public String getCin() {
        return cin;
    }

    public int getNombre_voya() {
        return nombre_voya;
    }

    public Boolean getBanned() {
        return banned;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setSexe(Gender sexe) {
        this.sexe = sexe;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public void setNombre_voya(int nombre_voya) {
        this.nombre_voya = nombre_voya;
    }

    public void setBanned(Boolean banned) {
        this.banned = banned;
    }

    @Override
    public String toString() {
        return "User{" +
                "nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", prenom='" + prenom + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}