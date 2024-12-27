package pfe.emsi.covoiturage.voyage.Config;

import org.springframework.graphql.server.WebGraphQlInterceptor;
import org.springframework.graphql.server.WebGraphQlRequest;
import org.springframework.graphql.server.WebGraphQlResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Collections;

@Component
class RequestHeaderInterceptor implements WebGraphQlInterceptor {

    @Override
    public Mono<WebGraphQlResponse> intercept(WebGraphQlRequest request, Chain chain) {
        String value = request.getHeaders().getFirst("Authorization");
        System.out.println(value);
        request.configureExecutionInput((executionInput, builder) ->
                builder.graphQLContext(Collections.singletonMap("token", value)).build());
        return chain.next(request);
    }
}