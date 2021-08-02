package controllers;

import daos.CustomerDAO;
import entities.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
}
