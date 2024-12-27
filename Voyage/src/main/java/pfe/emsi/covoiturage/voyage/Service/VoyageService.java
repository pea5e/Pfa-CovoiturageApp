package pfe.emsi.covoiturage.voyage.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfe.emsi.covoiturage.voyage.Controllers.VoyageDTO;
import pfe.emsi.covoiturage.voyage.Entity.Voyage;
import pfe.emsi.covoiturage.voyage.Feign.UserFetch;
import pfe.emsi.covoiturage.voyage.Repository.VoyageRepo;

import java.util.List;

@Service
public class VoyageService {

    @Autowired
    private UserFetch userFetch;
    private final VoyageRepo voyageRepo;

    public VoyageService(VoyageRepo voyageRepo) {
        this.voyageRepo = voyageRepo;
    }

    public Voyage saveVoyage(VoyageDTO voyageDTO, Long id){
        return voyageRepo.save(DTOMapping.DTOtoObject(voyageDTO,id));
    }

    public List<Voyage> getVoyages(){
        List<Voyage> voyages = voyageRepo.findAll();
//        for(int i=0;i<voyages.size();i++)
        voyages.forEach(voyage -> voyage.setDriver(userFetch.getUserById(voyage.getUserId())));

        System.out.println(voyages.get(0).getDestination().getX());
        return voyages;
    }
}