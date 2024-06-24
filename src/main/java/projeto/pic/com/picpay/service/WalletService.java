package projeto.pic.com.picpay.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import projeto.pic.com.picpay.controller.dto.CreareWalletDto;
import projeto.pic.com.picpay.entity.Wallet;
import projeto.pic.com.picpay.exception.WalletDataAlreadyExistsException;
import projeto.pic.com.picpay.repository.WalletRepository;

@Service
public class WalletService {

    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletTypeRepository){
        this.walletRepository  = walletTypeRepository;
    }

    public Wallet createWallet(CreareWalletDto creareWalletDto) {

      Optional<Wallet> walletDataBase =  walletRepository.findByCpfCnpjOrEmail(creareWalletDto.cpfCnpj(), creareWalletDto.email());   

      if (walletDataBase.isPresent()){
        throw new WalletDataAlreadyExistsException("CpfCnpj Or Email Already Exists");
      }
       return walletRepository.save( creareWalletDto.toWallet());
    }

}
