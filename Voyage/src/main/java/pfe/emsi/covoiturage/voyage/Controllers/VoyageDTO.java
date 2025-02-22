package pfe.emsi.covoiturage.voyage.Controllers;

import java.time.LocalDateTime;

public record VoyageDTO(double destinationX, double destinationY, double emplacementX, double emplacementY, String labelDestination, String labelEmplacement, float Tarif,
                        int Duree, int Distance,LocalDateTime time) {
}