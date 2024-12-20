package pfe.emsi.covoiturage.voyage.Entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@AllArgsConstructor
@Getter
@Setter
//@NoArgsConstructor
@Embeddable
public class Coordinates {
    @Basic
    private double x;
    @Basic
    private double y;
    @Basic
    private String Label;

    public Coordinates(double x, double y, String label) {
        this.x = x;
        this.y = y;
        Label = label;
    }

    public Coordinates() {
    }
}