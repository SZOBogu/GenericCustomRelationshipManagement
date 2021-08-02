package controllers;

import entities.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

        return "saveCustomerForm";
    }

    @PostMapping("/addCustomer")
    public String addCustomer(@ModelAttribute("customer") CustomerEntity customer){

        customerService.addCustomer(customer);

        return "redirect:/customer/list";
    }

    @GetMapping("/updateCustomerForm/{id}")
    public String updateCustomer(@PathVariable int id, Model model){

        CustomerEntity customer = customerService.getCustomer(id);
        model.addAttribute("customer", customer);
        return "saveCustomerForm";
    }

    @RequestMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable int id){
        this.customerService.deleteCustomer(id);
        return "redirect:/customer/list";
    }
}
