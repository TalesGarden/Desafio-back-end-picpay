package projeto.pic.com.picpay.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import projeto.pic.com.picpay.controller.dto.TransferDto;
import projeto.pic.com.picpay.entity.Transfer;
import projeto.pic.com.picpay.entity.Wallet;
import projeto.pic.com.picpay.exception.InsufficientBalanceException;
import projeto.pic.com.picpay.exception.TransferNotAllowedForWalletTypeException;
import projeto.pic.com.picpay.exception.TransferNotAuthorizedException;
import projeto.pic.com.picpay.exception.WalletNotFoundException;
import projeto.pic.com.picpay.repository.TransferRepository;
import projeto.pic.com.picpay.repository.WalletRepository;

@Service
public class TransferService {

    private final NotificationService notificationService;
    private final AuthorizationService authorizationService;
    private final TransferRepository transferRepository;
    private final WalletRepository walletRepository;

    public TransferService(TransferRepository transferRepository,
            NotificationService notificationService,
            AuthorizationService authorizationService,
            WalletRepository walletRepository) {

        this.authorizationService = authorizationService;
        this.notificationService = notificationService;
        this.transferRepository = transferRepository;
        this.walletRepository = walletRepository;
    }

    @Transactional
    public Transfer transfer(TransferDto transferDto) {

        var sender = walletRepository.findById(transferDto.payee())
                .orElseThrow(() -> new WalletNotFoundException(transferDto.payer()));

        var receiver = walletRepository.findById(transferDto.payee())
                .orElseThrow(() -> new WalletNotFoundException(transferDto.payee()));

        validateTransfer(transferDto, sender);
        sender.debit(transferDto.value());
        receiver.credit(transferDto.value());

        var transfer = new Transfer(sender, receiver, transferDto.value());

        walletRepository.save(sender);
        walletRepository.save(receiver);
        var transferResult = transferRepository.save(transfer);
        
        //cria nova tread para envio da notificação
        CompletableFuture.runAsync(() -> notificationService.sendNotification(transferResult));
        return transferResult;

    }

    private void validateTransfer(TransferDto transferDto, Wallet sender) {

        if (!sender.isTransferAllowedForWalletType()) {
            throw new TransferNotAllowedForWalletTypeException();
        }

        if (!sender.isBalanceEqualsOrGreatherThan(transferDto.value())) {
            throw new InsufficientBalanceException();
        }

        if (!authorizationService.isAuthorized(transferDto)) {
            throw new TransferNotAuthorizedException();
        }
    }

}
