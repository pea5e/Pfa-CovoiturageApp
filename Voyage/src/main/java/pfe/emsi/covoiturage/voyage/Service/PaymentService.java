package pfe.emsi.covoiturage.voyage.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pfe.emsi.covoiturage.voyage.Controllers.PaymentDTO;
import pfe.emsi.covoiturage.voyage.Entity.Payment;
import pfe.emsi.covoiturage.voyage.Entity.User;
import pfe.emsi.covoiturage.voyage.Entity.Voyage;
import pfe.emsi.covoiturage.voyage.Feign.UserFetch;
import pfe.emsi.covoiturage.voyage.Repository.PaymentRepo;
import pfe.emsi.covoiturage.voyage.Repository.VoyageRepo;

@Service
public class PaymentService {
    @Autowired
    private UserFetch userFetch;

    @Autowired
    private  PaymentRepo paymentRepo;

    @Autowired
    private  VoyageRepo voyageRepo;

    @Autowired
    private  NotificationService notificationService;

    public Payment savePayment(PaymentDTO paymentDTO, User user){
//        return paymentRepo.save(new Payment());
        Voyage voyage = voyageRepo.findById(paymentDTO.VoyageID()).get();
        String body = "Payment pour le voyage de " + voyage.getEmplacement() + " vers " + voyage.getDestination();

        notificationService.sendNotification(user.getEmail(), "Payment", body);

        return paymentRepo.save(new Payment(paymentDTO.Nom(),paymentDTO.Card(),paymentDTO.Expiry(), paymentDTO.Security(),voyage,user.getId(),null));
    }

}
