package pfe.emsi.covoiturage.users.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pfe.emsi.covoiturage.users.Dao.User;
import pfe.emsi.covoiturage.users.Repositories.UserRepos;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService tokenService;
    private final UserService userService;

    @Autowired
    public AuthService(
            AuthenticationManager authenticationManager,
            JwtService tokenService,
            UserService userService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
        this.userService = userService;
    }

    public String authenticate(String username, String password) {
        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(username, password));

        return tokenService.generateToken(authentication);
    }

    public User authenticatedUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userService.getUserByEmail(username);
    }

}