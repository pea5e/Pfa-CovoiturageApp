package pfe.emsi.covoiturage.users.Controllers;

import com.netflix.discovery.converters.Auto;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import pfe.emsi.covoiturage.users.Dao.User;
import pfe.emsi.covoiturage.users.Dtos.UserDto;
import pfe.emsi.covoiturage.users.Services.AuthService;
import pfe.emsi.covoiturage.users.Services.UserService;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;



    @MutationMapping
    public ResponseEntity<String> createUser(@Argument UserDto userDto) {
        try
        {
            return ResponseEntity.ok(userService.createUser(userDto).toString());

        }catch (Exception e)
        {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
//    @MutationMapping
//    public ResponseEntity<User> createUser(@Argument UserDto userDto, @Argument PasswordDto passwordDto) {
//        try
//        {
//            return ResponseEntity.ok(userService.createUser(userDto,passwordDto));
//
//        }catch (Exception e)
//        {
//            return ResponseEntity.badRequest().body(null);
//        }
//
//    }
//
//    @MutationMapping
//    public ResponseEntity<Passenger> createPassenger(@Argument UserDto userDto, @Argument PasswordDto passwordDto) {
//        try{
//            return ResponseEntity.ok(userService.createPassenger(userDto,passwordDto));
//        }
//        catch (Exception e)
//        {
//            return ResponseEntity.badRequest().body(null);
//        }
//    }
//
//    @MutationMapping
//    public ResponseEntity<Driver> createDriver(@Argument UserDto userDto, @Argument PasswordDto passwordDto) {
//        try{
//            return ResponseEntity.ok(userService.createDriver(userDto,passwordDto));
//        }
//        catch (Exception e)
//        {
//            return ResponseEntity.badRequest().body(null);
//        }
//    }
//
//    @QueryMapping
//    public ResponseEntity<List<User>> getAllUsers() {
//        return ResponseEntity.ok(userService.getAllUsers());
//    }
//
    @GetMapping("getById/{id}")
    public User getUser(@PathVariable("id") Long userId) {
        try
        {
            return userService.getUser(userId);
        }catch (Exception e)
        {
            return null;
        }

    }

    @GetMapping("get")
    public User getAuthenticated(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        System.out.println(token);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth instanceof AnonymousAuthenticationToken);
        System.out.println(auth.isAuthenticated());
        try
        {
            return userService.getUserByEmail(auth.getName());
        }catch (Exception e)
        {
            return null;
        }

    }

    @QueryMapping
    public String Authenticate(@Argument String email,@Argument String password) {
        try
        {
            return authService.authenticate(email,password);
        }catch (Exception e)
        {
            return null;
        }

    }

    @QueryMapping
    public User getUserByEmail(@Argument String email) {
        try
        {
            return userService.getUserByEmail(email);
        }catch (Exception e)
        {
            return null;
        }

    }
//
//    @QueryMapping
//    public ResponseEntity<List<Driver>> getAllDrivers() {
//        return ResponseEntity.ok(userService.getAllDrivers());
//    }
//
//    @QueryMapping
//    public ResponseEntity<List<Passenger>> getAllPassengers() {
//        return ResponseEntity.ok(userService.getAllPassengers());
//    }
//
//    @MutationMapping
//    public ResponseEntity<Boolean> updatePwd(@Argument Long userId, @Argument PasswordDto passwordDto) {
//        try
//        {
//            return ResponseEntity.ok(userService.changePassword(userId,passwordDto));
//        }catch (Exception e)
//        {
//            return ResponseEntity.badRequest().body(false);
//        }
//
//    }
//
//    @MutationMapping
//    public ResponseEntity<Boolean> updateDriver(@Argument Long userId,@Argument UserDto userDto) {
//        try{
//            userService.updateDriver(userId,userDto);
//            return ResponseEntity.ok(true);
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body(null);
//        }
//    }
//
//    @MutationMapping
//    public ResponseEntity<Boolean> updatePassenger(@Argument Long userId,@Argument UserDto userDto) {
//        try{
//            userService.updatePassenger(userId,userDto);
//            return ResponseEntity.ok(true);
//        }catch (Exception e)
//        {
//            return ResponseEntity.badRequest().body(null);
//        }
//    }
//
//    @MutationMapping
//    public ResponseEntity<Vehicule> AttribuerVehicule(@Argument Long userId, @Argument VehiculeDto vehiculeDto) {
//        try
//        {
//            return ResponseEntity.ok(userService.AttribuerVehicule(userId,vehiculeDto));
//        }
//        catch (Exception e)
//        {
//            return ResponseEntity.badRequest().body(null);
//        }
//
//    }
}
