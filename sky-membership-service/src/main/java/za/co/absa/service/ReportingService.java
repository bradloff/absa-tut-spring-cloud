package za.co.absa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.annotation.Transformer;
import org.springframework.messaging.MessageChannel;
import za.co.absa.model.Customer;

import java.util.Collection;

/**
 * Created by barry on 2017/01/12.
 */
@EnableBinding(ReportingService.Queues.class)
public class ReportingService {


    @Autowired
    MembershipService memberService;

    @Transformer(inputChannel = Queues.INPUT, outputChannel = Queues.OUTPUT)
    public String processReportingRequest(String timeData) {
        System.out.println("Reporting, getting all the customers");
        StringBuffer data = new StringBuffer();

        for(Customer customer: memberService.getAllCustomers()){
            data.append("\n"); //hack to display nicely on the reporting service... ;)
            data.append(customer.toString());
        }
        if(data.toString().length()==0){
            data.append("No customer data available");
        }
        return data.toString();


    }

    interface Queues{
        String INPUT  = "reportRequest";
        String OUTPUT = "reportResponse";

        @Input(INPUT)
        MessageChannel reportRequest();

        @Output(OUTPUT)
        MessageChannel reportResponse();
    }

}
