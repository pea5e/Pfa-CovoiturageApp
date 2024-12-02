package pfe.emsi.covoiturage.users.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pfe.emsi.covoiturage.users.Dao.Passenger;

public interface PassengerRepos extends JpaRepository<Passenger, Long> {
}
