package za.co.absa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;
import za.co.absa.model.Customer;
import za.co.absa.repo.MembershipDatabase;

import java.math.BigDecimal;
import java.util.Collection;

/**
 * Created by barry on 2017/01/12.
 */
@Service
@EnableBinding(Source.class)
public class MembershipService {

    @Value("${retention.threshold}")
    private int thresholdProp;


    @Autowired
    @Qualifier("output")
    MessageChannel output;

    @Autowired
    MembershipDatabase memberDB;

    public boolean enrolCustomer(Customer customer){
        return memberDB.add(customer);
    }

    public boolean cancelSubscription(Integer customerId){


        BigDecimal threshold = new BigDecimal(thresholdProp);

        Customer customer = memberDB.getById(customerId);
        if( threshold.compareTo(customer.getSubscriptionAmount()) == -1) {
            customer.setFlaggedForDeletion(true);
            memberDB.add(customer);
            GenericMessage<Customer> msg = new GenericMessage(customer.toString());
            System.out.printf("Yo this guys is spending a lot of money!!! Sending customer data to the retention office [%s]", customer.toString());

            output.send(msg);

            return false;
        }else{

            return memberDB.delete(memberDB.getById(customerId));
        }
    }


    public Collection<Customer> getAllCustomers(){
        System.out.println("Getting all the customer details(findall)");
        return memberDB.findAll();

    }
}
