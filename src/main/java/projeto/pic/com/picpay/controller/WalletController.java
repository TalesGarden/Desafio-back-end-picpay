package projeto.pic.com.picpay.controller;

import org.springframework.web.bind.annotation.RestController;

import projeto.pic.com.picpay.controller.dto.CreareWalletDto;
import projeto.pic.com.picpay.entity.Wallet;
import projeto.pic.com.picpay.service.WalletService;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class WalletController {

    private WalletService walletService;

    public WalletController(WalletService walletService){
        this.walletService = walletService;
    }

    @PostMapping("wallets")
    public ResponseEntity<Wallet> postMethodName(@RequestBody CreareWalletDto creareWalletDto) {
    
        var walletEntity = walletService.createWallet(creareWalletDto);
        return new ResponseEntity<Wallet>(walletEntity, HttpStatus.CREATED);
    }
    
    
}
