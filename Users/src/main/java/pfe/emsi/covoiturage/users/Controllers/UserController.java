package pfe.emsi.covoiturage.users.Controllers;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pfe.emsi.covoiturage.users.Dao.Driver;
import pfe.emsi.covoiturage.users.Dao.Passenger;
import pfe.emsi.covoiturage.users.Dao.User;
import pfe.emsi.covoiturage.users.Dao.Vehicule;
import pfe.emsi.covoiturage.users.Dtos.PasswordDto;
import pfe.emsi.covoiturage.users.Dtos.UserDto;
import pfe.emsi.covoiturage.users.Dtos.VehiculeDto;
import pfe.emsi.covoiturage.users.Services.UserService;

import java.util.List;

@RestController("/User")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("get")
    public String get()
    {
        return "heelloooooooooooo world!";
    }

    /*
    @MutationMapping
    public ResponseEntity<User> createUser(@Argument UserDto userDto, @Argument PasswordDto passwordDto) {
        try
        {
            return ResponseEntity.ok(userService.createUser(userDto,passwordDto));

        }catch (Exception e)
        {
            return ResponseEntity.badRequest().body(null);
        }

    }

    @MutationMapping
    public ResponseEntity<Passenger> createPassenger(@Argument UserDto userDto, @Argument PasswordDto passwordDto) {
        try{
            return ResponseEntity.ok(userService.createPassenger(userDto,passwordDto));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @MutationMapping
    public ResponseEntity<Driver> createDriver(@Argument UserDto userDto, @Argument PasswordDto passwordDto) {
        try{
            return ResponseEntity.ok(userService.createDriver(userDto,passwordDto));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @QueryMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @QueryMapping
    public ResponseEntity<User> getUser(@Argument Long userId) {
        try
        {
            return ResponseEntity.ok(userService.getUser(userId));
        }catch (Exception e)
        {
            return ResponseEntity.badRequest().body(null);
        }

    }

    @QueryMapping
    public ResponseEntity<List<Driver>> getAllDrivers() {
        return ResponseEntity.ok(userService.getAllDrivers());
    }

    @QueryMapping
    public ResponseEntity<List<Passenger>> getAllPassengers() {
        return ResponseEntity.ok(userService.getAllPassengers());
    }

    @MutationMapping
    public ResponseEntity<Boolean> updatePwd(@Argument Long userId, @Argument PasswordDto passwordDto) {
        try
        {
            return ResponseEntity.ok(userService.changePassword(userId,passwordDto));
        }catch (Exception e)
        {
            return ResponseEntity.badRequest().body(false);
        }

    }

    @MutationMapping
    public ResponseEntity<Boolean> updateDriver(@Argument Long userId,@Argument UserDto userDto) {
        try{
            userService.updateDriver(userId,userDto);
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @MutationMapping
    public ResponseEntity<Boolean> updatePassenger(@Argument Long userId,@Argument UserDto userDto) {
        try{
            userService.updatePassenger(userId,userDto);
            return ResponseEntity.ok(true);
        }catch (Exception e)
        {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @MutationMapping
    public ResponseEntity<Vehicule> AttribuerVehicule(@Argument Long userId, @Argument VehiculeDto vehiculeDto) {
        try
        {
            return ResponseEntity.ok(userService.AttribuerVehicule(userId,vehiculeDto));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().body(null);
        }

    }
    */
}
