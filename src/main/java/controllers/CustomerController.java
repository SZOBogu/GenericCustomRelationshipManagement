package controllers;

import daos.CustomerDAO;
import entities.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import services.CustomerService;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;


    @GetMapping("/list")
    public String getCustomerList(Model model){
        List<CustomerEntity> customers = this.customerService.getCustomers();

        model.addAttribute("customers", customers);

        return "listCustomers";
    }

    @GetMapping("/addCustomerForm")
    public String getAddCustomerForm(Model model){
        CustomerEntity customer = new CustomerEntity();

        model.addAttribute("customer", customer);

        return "addCustomerForm";
    }

    @PostMapping("/addCustomer")
    public String addCustomer(@ModelAttribute("customer") CustomerEntity customer){

        customerService.addCustomer(customer);

        return "redirect:/customer/list";
    }
}
