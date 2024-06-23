package projeto.pic.com.picpay.config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import projeto.pic.com.picpay.entity.WalletType;
import projeto.pic.com.picpay.repository.WalletTypeRepository;

@Configuration
public class DataLoader implements CommandLineRunner{

    private final WalletTypeRepository walletTypeRepository;

    public DataLoader(WalletTypeRepository walletTypeRepository){
        this.walletTypeRepository = walletTypeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Arrays.stream(WalletType.Enum.values())
                .forEach(walletType -> walletTypeRepository.save(walletType.get())); 
    }
    
}
