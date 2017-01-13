package za.co.absa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.co.absa.model.Customer;
import za.co.absa.service.MembershipService;

import java.util.Collection;
import java.util.List;

/**
 * Created by barry on 2017/01/12.
 */

@RestController
@RequestMapping(value="v1")
public class MembershipController {

    @Autowired
    private MembershipService memServ;

    @PostMapping(value = "/enrol")
    public Integer enrolCustomer(@ModelAttribute Customer customer){
        return memServ.enrolCustomer(customer);
    }

    @DeleteMapping(value = "/cancel/{id}")
    public boolean enrolCustomer(@PathVariable("id") Integer customerId){
        System.out.printf("Got the id [%d] to cancel\n", customerId);
        return memServ.cancelSubscription(customerId);
    }

    @GetMapping
    public Collection<Customer> getAllCustomers(){
        return memServ.getAllCustomers();
    }
}
