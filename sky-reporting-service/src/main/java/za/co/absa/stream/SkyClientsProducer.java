package za.co.absa.stream;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;

/**
 *
 * @author abpl245
 */
@EnableBinding(Source.class)
public class SkyClientsProducer {
    @InboundChannelAdapter(channel = Source.OUTPUT, poller = @Poller(fixedDelay = "10000"))
    public String reqSource() {
        return "{'get': 'true'}";
    }
}
