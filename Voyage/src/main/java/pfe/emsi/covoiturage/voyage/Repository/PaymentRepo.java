package pfe.emsi.covoiturage.voyage.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfe.emsi.covoiturage.voyage.Entity.Payment;
import pfe.emsi.covoiturage.voyage.Entity.Voyage;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Long> {
}