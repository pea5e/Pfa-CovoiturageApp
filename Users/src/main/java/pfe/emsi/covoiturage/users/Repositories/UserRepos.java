package pfe.emsi.covoiturage.users.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pfe.emsi.covoiturage.users.Dao.User;

import java.util.Optional;

@Repository
public interface UserRepos extends JpaRepository<User, Long> {

    @Query(value = "select u from User u where u.email=?1")
    Optional<User> findByEmail(String email);
}
