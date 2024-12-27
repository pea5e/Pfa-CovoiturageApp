package pfe.emsi.covoiturage.voyage.Feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import pfe.emsi.covoiturage.voyage.Entity.User;
import pfe.emsi.covoiturage.voyage.Entity.Vehicule;

@FeignClient(name="Users",url="http://localhost:8095")
public interface UserFetch {

    @GetMapping("/User/getById/{id}")
    User getUserById(@PathVariable("id") Long userId);

    @GetMapping("/User/get")
    User getAuthenticated(@RequestHeader(value = "Authorization", required = true) String Token);
}
