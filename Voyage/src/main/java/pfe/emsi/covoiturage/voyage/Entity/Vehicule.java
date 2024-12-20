package pfe.emsi.covoiturage.voyage.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;


public class Vehicule {
    private Long id;
    //    private String immatricula;
    private String plate;
    private String model;
    private Statut statut = Statut.En_Cours;
    private TypeVeh type = TypeVeh.Sedan;
    private Driver driver;

    public String getPlate()
    {
        return  this.plate;
    }
}
