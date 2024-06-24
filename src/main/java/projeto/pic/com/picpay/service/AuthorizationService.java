package projeto.pic.com.picpay.service;

import org.springframework.stereotype.Service;

import projeto.pic.com.picpay.client.AuthorizationClient;
import projeto.pic.com.picpay.controller.dto.TransferDto;
import projeto.pic.com.picpay.exception.PicPayException;;


@Service
public class AuthorizationService {
    private final AuthorizationClient authorizationClient;

    public AuthorizationService(AuthorizationClient authorizationClient){
        this.authorizationClient = authorizationClient;
    }

    public boolean isAuthorized(TransferDto transferDto){

        var resp  = authorizationClient.isAuthorized();

        if (resp.getStatusCode().isError()){
            throw new PicPayException();
        }
        return resp.getBody().authorized();

    }

}
