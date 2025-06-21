package pfe.emsi.covoiturage.voyage.Controllers;


import jakarta.ws.rs.core.HttpHeaders;
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.graphql.server.WebGraphQlInterceptor;
import org.springframework.graphql.server.WebGraphQlRequest;
import org.springframework.graphql.server.WebGraphQlResponse;
import org.springframework.web.bind.annotation.*;
import pfe.emsi.covoiturage.voyage.Entity.User;
import pfe.emsi.covoiturage.voyage.Entity.Vehicule;
import pfe.emsi.covoiturage.voyage.Entity.Voyage;
import pfe.emsi.covoiturage.voyage.Feign.UserFetch;
import pfe.emsi.covoiturage.voyage.Service.PaymentService;
import pfe.emsi.covoiturage.voyage.Service.VoyageService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;



@RestController
public class VoyageController {

    private  final UserFetch userFetch;
    private final VoyageService voyageService;
    private final PaymentService paymentService;


    public VoyageController(UserFetch userFetch, VoyageService voyageService,PaymentService paymentService) {
        this.userFetch = userFetch;
        this.voyageService = voyageService;
        this.paymentService = paymentService;
    }

    @MutationMapping
    public String pay(@ContextValue String token,@Argument PaymentDTO payment)
    {
        User user = userFetch.getAuthenticated(token);

        return paymentService.savePayment(payment,user).toString();
    }

    @PostMapping("/add")
    public String saveVoyageRest(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, VoyageDTO voyage)
    {
        User user = userFetch.getAuthenticated(token);

        return voyageService.saveVoyage(voyage,user.getId()).toString();
    }

    @GetMapping("/getUser/{token}")
    public String getUser(@PathVariable("token") String token)
    {
        return userFetch.getAuthenticated("Bearer "+token).getNom();
    }

    @GetMapping("/get")
    public List<Voyage> getVoyagesRest()
    {
        return voyageService.getVoyages();
    }
    @MutationMapping
    public String saveVoyage(@ContextValue String token,@Argument VoyageDTO voyage)
    {
        User user = userFetch.getAuthenticated(token);
        return voyageService.saveVoyage(voyage,user.getId()).toString();
    }

    @QueryMapping
    public List<Voyage> getVoyages(@ContextValue String token)
    {
        return voyageService.getVoyages();
    }


    @SubscriptionMapping
    public Flux<String> getVoyager(@Argument int count){
        return Flux.fromStream(Stream.generate(() -> "Hello @ " + Instant.now()))
                .delayElements(Duration.ofSeconds(1))
                .take(count);
    }

}