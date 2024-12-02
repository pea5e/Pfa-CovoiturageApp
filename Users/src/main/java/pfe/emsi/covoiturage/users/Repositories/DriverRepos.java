package pfe.emsi.covoiturage.users.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pfe.emsi.covoiturage.users.Dao.Driver;

public interface DriverRepos extends JpaRepository<Driver, Long> {
}
