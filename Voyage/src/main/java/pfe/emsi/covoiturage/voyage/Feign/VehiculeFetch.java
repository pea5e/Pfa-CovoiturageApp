package pfe.emsi.covoiturage.voyage.Feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import pfe.emsi.covoiturage.voyage.Entity.Vehicule;

@FeignClient(name="Users",url="http://localhost:8098")
public interface VehiculeFetch {

    @GetMapping("/Vehicule/get")
    Vehicule getVehicule();
}
