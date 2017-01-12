package za.co.absa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SkyReportingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SkyReportingServiceApplication.class, args);
    }
}

@EnableBinding(ReportingServiceProducer.Channels.class)
class ReportingServiceProducer {

    @InboundChannelAdapter(value = Channels.REQ_REPORT, poller = @Poller(fixedDelay = "10000"))
    public String requestReportMessageSource(){
        return "request:report";
    }

    @StreamListener(Channels.RETRIEVE_REPORT)
    public void report(String message) {
        System.out.println(">>>"+message);
        new File("");
    }

    interface Channels {
        String REQ_REPORT = "requestReport";
        String RETRIEVE_REPORT = "retrieveReport";

        @Output(REQ_REPORT)
        MessageChannel requestReportChannel();

        @Input(RETRIEVE_REPORT)
        SubscribableChannel retrieveReportChannel();
    }
}