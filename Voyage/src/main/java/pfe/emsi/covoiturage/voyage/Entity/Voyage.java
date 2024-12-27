package pfe.emsi.covoiturage.voyage.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
//@NoArgsConstructor
//@AllArgsConstructor
@Setter
@Getter
public class Voyage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @AttributeOverrides({
            @AttributeOverride(name="Label",column=@Column(name="destinationLabel")),
            @AttributeOverride(name="x",column=@Column(name="destinationX")),
            @AttributeOverride(name="y",column=@Column(name="destinationY"))
    })
    @Embedded
    private Coordinates Destination;
    @AttributeOverrides({
            @AttributeOverride(name="Label",column=@Column(name="emplacementLabel")),
            @AttributeOverride(name="x",column=@Column(name="emplacementX")),
            @AttributeOverride(name="y",column=@Column(name="emplacementY"))
    })
    @Embedded
    private Coordinates Emplacement;
    private float Tarif;
    private int Duree;
    private int Distance;
    private int review;
    @Transient
    private User driver;
    private Long UserId;
//    private LocalDateTime time;

    public Voyage(Long id, Coordinates destination, Coordinates emplacement, float tarif, int duree, int distance, int review, Long UserId) {
        this.id = id;
        Destination = destination;
        Emplacement = emplacement;
        Tarif = tarif;
        Duree = duree;
        Distance = distance;
        this.review = review;
        this.UserId = UserId;
//        this.time = time;
    }

    public Voyage() {
    }

    public Long getId() {
        return id;
    }

    public Coordinates getDestination() {
        return Destination;
    }

    public Coordinates getEmplacement() {
        return Emplacement;
    }

    public float getTarif() {
        return Tarif;
    }

    public int getDuree() {
        return Duree;
    }

    public int getDistance() {
        return Distance;
    }

    public int getReview() {
        return review;
    }

    public User getDriver() {
        return driver;
    }

    public Long getUserId() {
        return UserId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDestination(Coordinates destination) {
        Destination = destination;
    }

    public void setEmplacement(Coordinates emplacement) {
        Emplacement = emplacement;
    }

    public void setTarif(float tarif) {
        Tarif = tarif;
    }

    public void setDuree(int duree) {
        Duree = duree;
    }

    public void setDistance(int distance) {
        Distance = distance;
    }

    public void setReview(int review) {
        this.review = review;
    }

    public void setDriver(User driver) {
        this.driver = driver;
    }

    public void setUserId(Long userId) {
        UserId = userId;
    }
}