package projeto.pic.com.picpay.controller.dto;

import projeto.pic.com.picpay.entity.Wallet;
import projeto.pic.com.picpay.entity.WalletType;

public record CreareWalletDto(String fullName,
                              String cpfCnpj,
                              String email,
                              String password,
                               WalletType.Enum walletType  ) {
    public Wallet toWallet(){
        return new Wallet(  fullName,
                            cpfCnpj,
                            email,
                            password,
                            walletType.get()
                            );
    }
} 