package pfe.emsi.covoiturage.voyage.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Payment {

    String nom;
    String card;
    String expiry;
    String security;

    @OneToOne
    Voyage voyage;


    Long userID;

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


}
