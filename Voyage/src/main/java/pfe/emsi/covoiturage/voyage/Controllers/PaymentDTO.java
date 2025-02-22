package pfe.emsi.covoiturage.voyage.Controllers;

import java.time.LocalDateTime;

public record PaymentDTO(String Nom,String Card,String Expiry,String Security,Long VoyageID) {
}