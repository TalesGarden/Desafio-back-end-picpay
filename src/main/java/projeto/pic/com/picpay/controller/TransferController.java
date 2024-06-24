package projeto.pic.com.picpay.controller;

import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import projeto.pic.com.picpay.controller.dto.TransferDto;
import projeto.pic.com.picpay.entity.Transfer;
import projeto.pic.com.picpay.service.TransferService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class TransferController {
    private final TransferService transferService;

    public TransferController(TransferService transferService){
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public ResponseEntity<Transfer> postMethodName(@RequestBody @Valid TransferDto transferDto) {
        
        return ResponseEntity.ok(transferService.transfer(transferDto));
    }
    


}
