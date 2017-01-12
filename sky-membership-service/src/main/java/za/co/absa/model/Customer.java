package za.co.absa.model;



import java.math.BigDecimal;
import java.util.Random;

/**
 * Created by barry on 2017/01/12.
 */
public class Customer {
    Integer id;
    String name;
    String surname;
    String emailAddress;
    BigDecimal subscriptionAmount;

    public Customer(){
        id  = new Random().nextInt();
    }

    public Integer getId(){
        if( null == id || id.equals(0)){
            id = new Random().nextInt();
        }
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public BigDecimal getSubscriptionAmount() {
        return subscriptionAmount;
    }

    public void setSubscriptionAmount(BigDecimal subscriptionAmount) {
        this.subscriptionAmount = subscriptionAmount;
    }
}
