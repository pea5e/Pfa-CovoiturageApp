package pfe.emsi.covoiturage.users.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pfe.emsi.covoiturage.users.Dao.Admin;

public interface AdminRepos extends JpaRepository<Admin, Long> {
}
