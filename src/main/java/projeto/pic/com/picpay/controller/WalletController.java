package projeto.pic.com.picpay.controller;

import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import projeto.pic.com.picpay.controller.dto.CreareWalletDto;
import projeto.pic.com.picpay.entity.Wallet;
import projeto.pic.com.picpay.service.WalletService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class WalletController {

    private WalletService walletService;

    public WalletController(WalletService walletService){
        this.walletService = walletService;
    }

    @PostMapping("wallets")
    public ResponseEntity<Wallet> postMethodName(@RequestBody @Valid CreareWalletDto creareWalletDto) {
    
        var walletEntity = walletService.createWallet(creareWalletDto);
        return new ResponseEntity<Wallet>(walletEntity, HttpStatus.CREATED);
    }
    
    
}
