package projeto.pic.com.picpay.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import projeto.pic.com.picpay.entity.Wallet;
import projeto.pic.com.picpay.entity.WalletType;

public record CreareWalletDto(@NotBlank String fullName,
                              @NotBlank  String cpfCnpj,
                              @NotBlank  String email,
                              @NotBlank  String password,
                              @NotNull  WalletType.Enum walletType  ) {
    public Wallet toWallet(){
        return new Wallet(  fullName,
                            cpfCnpj,
                            email,
                            password,
                            walletType.get()
                            );
    }
} 