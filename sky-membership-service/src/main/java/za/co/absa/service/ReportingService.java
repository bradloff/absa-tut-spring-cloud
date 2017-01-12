package za.co.absa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.annotation.Transformer;
import za.co.absa.model.Customer;

import java.util.Collection;

/**
 * Created by barry on 2017/01/12.
 */
@EnableBinding
public class ReportingService {


    @Autowired
    MembershipService memberService;

    @Transformer(inputChannel = "reportRequest", outputChannel = "reportResponse")
    public Collection<Customer> processReportingRequest(String timeData) {
        System.out.println("Reporting, getting all the customers");
        return memberService.getAllCustomers();


    }

}
