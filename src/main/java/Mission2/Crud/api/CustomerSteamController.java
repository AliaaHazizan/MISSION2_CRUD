package Mission2.Crud.api;

import Mission2.Crud.model.Customer;
import Mission2.Crud.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/customers")


public class CustomerSteamController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public void addCustomer( @RequestBody Customer customer){

        customerService.addCustomer(customer);

    }

    @GetMapping
    public List<Customer> getCustomers() {
         return customerService.getCustomers();
    }

    @GetMapping(value = "/{customerId}")
    public Customer getCustomer(@PathVariable("customerId") int customerId){

        return customerService.getCustomer(customerId);

    }

    @PutMapping(value = "/{customerId}")
    public void updateCustomer(@RequestBody Customer customer, @PathVariable ("customerId") Integer customerId){

        customerService.updateCustomer(customerId, customer);

    }

    @DeleteMapping(value = "/{customerId}")
    public void deleteCustomer(@PathVariable ("customerId") int customerId){
        customerService.deleteCustomer(customerId);

    }
}
