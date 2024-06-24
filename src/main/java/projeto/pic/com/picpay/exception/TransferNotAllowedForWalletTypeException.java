package projeto.pic.com.picpay.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class TransferNotAllowedForWalletTypeException extends PicPayException{


    @Override
    public ProblemDetail toProblemDetail(){
        var pd = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        pd.setTitle("TThis wallet type is not allowed for transfer");

        return pd;
    }

}
