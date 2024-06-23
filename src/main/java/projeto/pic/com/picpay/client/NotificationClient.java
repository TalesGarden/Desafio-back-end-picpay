package projeto.pic.com.picpay.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import projeto.pic.com.picpay.entity.Transfer;

@FeignClient(
    url = "$(https://run.mocky.io/v3/18959b51-0cc4-4508-9178-c0cd931e6ea2)"
)
public interface NotificationClient {

    @PostMapping
    ResponseEntity<Void> sendNotification(@RequestBody Transfer transfer);
}
