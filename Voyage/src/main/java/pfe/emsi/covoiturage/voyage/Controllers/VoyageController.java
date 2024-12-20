package pfe.emsi.covoiturage.voyage.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pfe.emsi.covoiturage.voyage.Entity.Vehicule;
import pfe.emsi.covoiturage.voyage.Feign.VehiculeFetch;
import pfe.emsi.covoiturage.voyage.Service.VoyageService;

@RestController
public class VoyageController {

    private  final VehiculeFetch vehiculeFetch;
    private final VoyageService voyageService;

    public VoyageController(VehiculeFetch vehiculeFetch, VoyageService voyageService) {
        this.vehiculeFetch = vehiculeFetch;
        this.voyageService = voyageService;
    }

    @PostMapping("/add")
    public void saveVoyage(VoyageDTO voyage)
    {
        voyageService.saveVoyage(voyage);
    }

    @GetMapping("/get")
    public void getVoyages()
    {
        voyageService.getVoyages();
    }

    @GetMapping("/getVehicule")
    public Vehicule getVehicule()
    {
        Vehicule vec = vehiculeFetch.getVehicule();
        System.out.println(vec.getPlate());
        return vehiculeFetch.getVehicule();
    }
}