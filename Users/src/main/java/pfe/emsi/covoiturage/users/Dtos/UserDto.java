package pfe.emsi.covoiturage.users.Dtos;

import lombok.Data;
import pfe.emsi.covoiturage.users.Dao.Gender;

@Data
public class UserDto {
    private String password;
    private String nom;
    private String email;
    private String prenom;
    private String telephone;
    private Gender sexe;
    private int age;
    private String cin;
}
