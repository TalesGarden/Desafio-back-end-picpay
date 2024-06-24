package projeto.pic.com.picpay.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projeto.pic.com.picpay.entity.Transfer;

@Repository
public interface TransferRepository extends JpaRepository<Transfer ,UUID>{

}
