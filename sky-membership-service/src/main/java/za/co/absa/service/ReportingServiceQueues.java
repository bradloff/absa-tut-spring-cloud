package za.co.absa.service;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 *
 * @author abpl245
 */
public interface ReportingServiceQueues {

    String INPUT = "reportRequest";
    String OUTPUT = "reportResponse";

    @Input(INPUT)
    MessageChannel reportRequest();

    @Output(OUTPUT)
    MessageChannel reportResponse();
}
