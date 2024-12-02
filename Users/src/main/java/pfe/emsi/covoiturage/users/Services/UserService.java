package pfe.emsi.covoiturage.users.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import pfe.emsi.covoiturage.users.Dao.Driver;
import pfe.emsi.covoiturage.users.Dao.Passenger;
import pfe.emsi.covoiturage.users.Dtos.PasswordDto;
import pfe.emsi.covoiturage.users.Dtos.UserDto;
import pfe.emsi.covoiturage.users.Mappers.DtoMapping;
import pfe.emsi.covoiturage.users.Repositories.AdminRepos;
import pfe.emsi.covoiturage.users.Repositories.DriverRepos;
import pfe.emsi.covoiturage.users.Repositories.PassengerRepos;

@Service
public class UserService {
    @Autowired
    private DriverRepos driverRepos;
    @Autowired
    private PassengerRepos passengerRepos;
    @Autowired
    private AdminRepos adminRepos;

    public Passenger createPassenger(UserDto userDetails, PasswordDto passwordDto) {
        return passengerRepos.save(DtoMapping.DtotoPassenger(userDetails,passwordDto));
    }

    public Driver createDriver(UserDto userDetails, PasswordDto passwordDto) {
        return driverRepos.save(DtoMapping.DtotoDriver(userDetails,passwordDto));
    }
}
