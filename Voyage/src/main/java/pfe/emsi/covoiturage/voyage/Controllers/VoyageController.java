package pfe.emsi.covoiturage.voyage.Controllers;


import jakarta.ws.rs.core.HttpHeaders;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.ContextValue;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.server.WebGraphQlInterceptor;
import org.springframework.graphql.server.WebGraphQlRequest;
import org.springframework.graphql.server.WebGraphQlResponse;
import org.springframework.web.bind.annotation.*;
import pfe.emsi.covoiturage.voyage.Entity.User;
import pfe.emsi.covoiturage.voyage.Entity.Vehicule;
import pfe.emsi.covoiturage.voyage.Entity.Voyage;
import pfe.emsi.covoiturage.voyage.Feign.UserFetch;
import pfe.emsi.covoiturage.voyage.Service.VoyageService;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;



@RestController
public class VoyageController {

    private  final UserFetch userFetch;
    private final VoyageService voyageService;

    public VoyageController(UserFetch userFetch, VoyageService voyageService) {
        this.userFetch = userFetch;
        this.voyageService = voyageService;
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

}