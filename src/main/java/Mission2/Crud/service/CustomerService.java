package Mission2.Crud.service;

import Mission2.Crud.model.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class CustomerService {

    private int customerIdCount = 1;
    private List<Customer> customerList = new CopyOnWriteArrayList<>();

     public void addCustomer (Customer customer){
         customerList.add(customer);
     }
     public List<Customer> getCustomers(){
         return customerList;
     }
     public Customer getCustomer(int customerId){
         return customerList
                 .stream()
                 .filter(c -> c.getCustomerId() == customerId)
                 .findFirst()
                 .get();



     }
     public void updateCustomer(int customerId, Customer customer){
         customerList
                 .stream()
                 .forEach(c -> {
                     if (c.getCustomerId() == customerId){
                         c.setCustomerFirstName(customer.getCustomerFirstName());
                         c.setCustomerLastName(customer.getCustomerLastName());
                         c.setCustomerEmail(customer.getCustomerEmail());
                     }
                 });
          customerList
                 .stream()
                 .filter(c -> c.getCustomerId() == customerId)
                 .findFirst()
                 .get();

     }

     public void deleteCustomer (int customerId){
         customerList
                 .removeIf(c -> c.getCustomerId() == (customerId));


     }
}
