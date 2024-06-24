package projeto.pic.com.picpay.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import projeto.pic.com.picpay.controller.dto.AutorizationResponse;

@FeignClient(
    name = "AuthorizationClient",
    url = "${client.authorization.service.url}"
)
public interface AuthorizationClient {
    @GetMapping 
    ResponseEntity<AutorizationResponse> isAuthorized();
}
