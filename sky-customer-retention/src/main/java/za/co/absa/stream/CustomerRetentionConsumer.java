package za.co.absa.stream;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

@EnableBinding(CustomerRetentionConsumer.Channels.class)
public class CustomerRetentionConsumer {



    @StreamListener(Channels.CANCELLATION_REQUEST)
    public void cancellation(String message) {
        System.out.println(">>>"+message);
    }

    interface Channels {
        //String CANCELLATION_REPLY = "cancellationReply";
        String CANCELLATION_REQUEST = "cancellationRequest";

        @Input(CANCELLATION_REQUEST)
        SubscribableChannel cancellationRequestChannel();

        //@Output(CANCELLATION_REPLY)
        //MessageChannel cancellationReplyChannel();
    }
}

