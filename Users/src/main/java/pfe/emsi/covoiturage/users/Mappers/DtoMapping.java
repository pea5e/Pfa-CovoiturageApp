package pfe.emsi.covoiturage.users.Mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pfe.emsi.covoiturage.users.Dao.Driver;
import pfe.emsi.covoiturage.users.Dao.Passenger;
import pfe.emsi.covoiturage.users.Dtos.PasswordDto;
import pfe.emsi.covoiturage.users.Dtos.UserDto;

@Component
public class DtoMapping {
    @Autowired
    private static PasswordEncoder passwordEncoder;

    public static Passenger DtotoPassenger(UserDto userDto, PasswordDto passwordDto) {
        return new Passenger(userDto.getNom(),passwordEncoder.encode(passwordDto.getPasswordActuel()),
                userDto.getEmail(), userDto.getPrenom(), userDto.getTelephone(),userDto.getSexe(),
                userDto.getAge(),userDto.getNombre_voya(),userDto.getBanned());
    }

    public static Driver DtotoDriver(UserDto userDto, PasswordDto passwordDto) {
        return new Driver(userDto.getN_permis(), userDto.getCin(),userDto.getNom(),passwordEncoder.encode(passwordDto.getPasswordActuel()),
                userDto.getEmail(), userDto.getPrenom(), userDto.getTelephone(),userDto.getSexe(),
                userDto.getAge(),userDto.getNombre_voya(),userDto.getBanned());
    }
}
