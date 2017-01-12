package za.co.absa.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 *
 * @author abpl245
 */
@EnableBinding(Sink.class)
public class SkyClientsConsumer {
    private static final Logger LOG = LoggerFactory.getLogger(SkyClientsConsumer.class);
    
    @StreamListener(Sink.INPUT)
    public void generateReport(final String report) {
        LOG.info("{}", report);
    }
}
