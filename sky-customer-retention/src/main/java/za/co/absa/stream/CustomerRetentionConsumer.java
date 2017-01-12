package za.co.absa.stream;


import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.SubscribableChannel;

@EnableBinding(CustomerRetentionConsumer.Channels.class)
public class CustomerRetentionConsumer {

   @StreamListener(Channels.CANCELATION_REQUEST)
    public void cancelation(String message) {
        System.out.println(">>>"+message);
    }

    interface Channels {
        String CANCELATION_REQUEST = "cancelationRequest";

        @Input(CANCELATION_REQUEST)
        SubscribableChannel retrieveReportChannel();
    }
}

