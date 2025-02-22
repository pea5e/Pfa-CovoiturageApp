package pfe.emsi.covoiturage.voyage.Service;

import pfe.emsi.covoiturage.voyage.Controllers.VoyageDTO;
import pfe.emsi.covoiturage.voyage.Entity.Coordinates;
import pfe.emsi.covoiturage.voyage.Entity.Voyage;

public class DTOMapping {
    public static Voyage DTOtoObject(VoyageDTO voyageDTO,Long userid)
    {
        return new Voyage(null,new Coordinates(voyageDTO.destinationX(), voyageDTO.destinationY(), voyageDTO.labelDestination()),new Coordinates(voyageDTO.emplacementX(), voyageDTO.emplacementY(), voyageDTO.labelEmplacement()), voyageDTO.Tarif(), voyageDTO.Duree(), voyageDTO.Distance(), 0,userid,voyageDTO.time());
    }

}
