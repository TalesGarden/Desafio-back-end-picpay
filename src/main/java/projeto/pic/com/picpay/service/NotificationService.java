package projeto.pic.com.picpay.service;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import projeto.pic.com.picpay.entity.Transfer;
import projeto.pic.com.picpay.client.NotificationClient;

@Service
public class NotificationService {

    private static final Logger logger =  org.slf4j.LoggerFactory.getLogger(NotificationService.class);

    private final NotificationClient notificationClient;

    public NotificationService (NotificationClient notificationClient){
        this.notificationClient = notificationClient;
    }

    public void sendNotification(Transfer transfer){

        try {
            logger.info("Sending Notification");
            var responseNotification = notificationClient.sendNotification(transfer);

            if(responseNotification.getStatusCode().isError()){
                logger.error("Error while sending notification, status code is not ok");
            }
        }
        catch(Exception e){
            logger.error("Error while sending notification", e);
        }
    }
    
}
