package pfe.emsi.covoiturage.users.Dao;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor@Setter@Getter
public class Passenger extends User{


    public Passenger(String nom, String encode, String email, String prenom, String telephone, Gender sexe, int age, int nombreVoya, Boolean banned) {
        super(nom, encode, email, prenom, telephone, sexe,age,nombreVoya,banned);
    }
}
