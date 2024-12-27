package pfe.emsi.covoiturage.users.Services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pfe.emsi.covoiturage.users.Dao.CustomUserDetails;
import pfe.emsi.covoiturage.users.Dao.User;
import pfe.emsi.covoiturage.users.Repositories.UserRepos;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepos userRepos ;
    private Environment env;

    @Autowired
    public CustomUserDetailsService(UserRepos userRepos, Environment env) {
        this.userRepos = userRepos;
        this.env = env;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("\n\n\n*************************************** Server Authentication ***************************************\n\n\n");
        Optional<User> user = userRepos.findByEmail(username);
        return user.map(value -> new CustomUserDetails(value.getEmail(), value.getPassword(), !value.getBanned())).orElse(null);
    }
}
