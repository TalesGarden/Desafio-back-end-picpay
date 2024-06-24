package projeto.pic.com.picpay.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;


public class WalletNotFoundException extends PicPayException {

    private Long walletId;

    public WalletNotFoundException(Long walletId){
        this.walletId = walletId;
    }

    @Override
    public ProblemDetail toProblemDetail(){
        
        var pd = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        pd.setTitle("Wallet Not Found");
        pd.setDetail("There is no wallet with id " + walletId + ".");

        return pd;
    }

}
