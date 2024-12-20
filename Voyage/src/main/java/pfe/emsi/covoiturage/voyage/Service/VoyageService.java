package pfe.emsi.covoiturage.voyage.Service;


import org.springframework.stereotype.Service;
import pfe.emsi.covoiturage.voyage.Controllers.VoyageDTO;
import pfe.emsi.covoiturage.voyage.Entity.Voyage;
import pfe.emsi.covoiturage.voyage.Repository.VoyageRepo;

import java.util.List;

@Service
public class VoyageService {
    private final VoyageRepo voyageRepo;

    public VoyageService(VoyageRepo voyageRepo) {
        this.voyageRepo = voyageRepo;
    }

    public Voyage saveVoyage(VoyageDTO voyageDTO){
        return voyageRepo.save(DTOMapping.DTOtoObject(voyageDTO));
    }

    public List<Voyage> getVoyages(){
        return voyageRepo.findAll();
    }
}