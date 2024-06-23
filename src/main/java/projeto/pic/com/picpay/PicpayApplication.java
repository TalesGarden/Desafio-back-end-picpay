package projeto.pic.com.picpay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableAutoConfiguration
@EnableFeignClients
public class PicpayApplication {

	public static void main(String[] args) {
		SpringApplication.run(PicpayApplication.class, args);
	}

}
