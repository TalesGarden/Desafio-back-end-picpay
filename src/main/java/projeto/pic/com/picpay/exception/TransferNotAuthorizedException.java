package projeto.pic.com.picpay.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class TransferNotAuthorizedException extends PicPayException {

    @Override
    public ProblemDetail toProblemDetail(){
        var pd = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        pd.setTitle("Transfer is not authorized");
        pd.setDetail("Authorization service not authorized this transfer");

        return pd;
    }

}
