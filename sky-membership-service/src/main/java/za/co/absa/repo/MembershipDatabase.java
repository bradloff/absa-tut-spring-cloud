package za.co.absa.repo;

import org.springframework.stereotype.Service;
import za.co.absa.model.Customer;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * Created by barry on 2017/01/12.
 */
@Service
public class MembershipDatabase {

    static HashMap<Integer, Customer> db = new HashMap();

    public boolean add(Customer customer){
        System.out.printf("Adding the customer id [%d]\n", customer.getId());

        db.put(customer.getId(), customer);
        return (getById(customer.getId()) != null?true:false);
    }

    public boolean delete(Customer customer){

        if(db.get(customer.getId() )!= null){
            return (db.remove(customer.getId()) != null?true:false);
        }else{
            System.out.println("No customer found");
            return false;
        }
    }

    public Customer getById(Integer id){
        return db.get(id);
    }

    public Collection<Customer> findAll(){
        return db.values();
    }
}
