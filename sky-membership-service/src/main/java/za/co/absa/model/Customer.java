package za.co.absa.model;



import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Random;

/**
 * Created by barry on 2017/01/12.
 */
@Data public class Customer {
    Integer id;
    String name;
    String surname;
    String emailAddress;
    BigDecimal subscriptionAmount;
    Boolean flaggedForDeletion = false;

    public Customer(){
        id  = new Random().nextInt(Integer.MAX_VALUE);
    }

    public Integer getId(){
        if( null == id || id.equals(0)){
            id = new Random().nextInt(Integer.MAX_VALUE);
        }
        return id;
    }


//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getSurname() {
//        return surname;
//    }
//
//    public void setSurname(String surname) {
//        this.surname = surname;
//    }
//
//    public String getEmailAddress() {
//        return emailAddress;
//    }
//
//    public void setEmailAddress(String emailAddress) {
//        this.emailAddress = emailAddress;
//    }
//
//    public BigDecimal getSubscriptionAmount() {
//        return subscriptionAmount;
//    }
//
//    public void setSubscriptionAmount(BigDecimal subscriptionAmount) {
//        this.subscriptionAmount = subscriptionAmount;
//    }
}
