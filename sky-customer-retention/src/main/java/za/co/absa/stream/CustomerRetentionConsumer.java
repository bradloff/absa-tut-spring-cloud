package za.co.absa.stream;


import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.SubscribableChannel;

@EnableBinding(CustomerRetentionConsumer.Channels.class)
public class CustomerRetentionConsumer {

    @StreamListener(Channels.CANCELLATION_REQUEST)
    public void cancellation(String message) {
        System.out.println(">>>"+message);
    }

    interface Channels {
        String CANCELLATION_REQUEST = "cancellationRequest";

        @Input(CANCELLATION_REQUEST)
        SubscribableChannel cancellationRequestChannel();
    }
}

