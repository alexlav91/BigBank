package ru.al.bigbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.al.bigbank.model.entity.Client;
import ru.al.bigbank.model.entity.Payment;
import ru.al.bigbank.service.ClientService;
import ru.al.bigbank.service.PaymentService;

@Controller
public class ClientController {
    @Autowired
    private ClientService clientService;
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listOfClients", clientService.getAllClients() );
        return "index";
    }
    @GetMapping("/showNewClientForm")
    public String showNewClientForm(Model model){
        Client client= new Client();
        model.addAttribute("client", client);
        return "new_client";
    }
    @PostMapping("/saveClient")
    public String saveClient(@ModelAttribute("client") Client client){
        clientService.saveClient(client);
        return "redirect:/";
    }
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value ="id")long id, Model model){
        Client client= clientService.getClientById(id);
        model.addAttribute("client", client);
        return "update_client";
    }
    @GetMapping("/deleteClient/{id}")
    public String deleteClient(@PathVariable(value = "id")long id){
        this.clientService.deleteClientById(id);
        return "redirect:/";
    }
    @GetMapping("/showNewPaymentForm")
    public String showNewPaymentForm(Model model){
        Payment payment = new Payment();
        model.addAttribute("payment", payment);
        return "new_payment";
    }
    @PostMapping("/savePayment")
    public String savePayment(@ModelAttribute("payment") Payment payment){
        paymentService.savePayment(payment);
        return "redirect:/";
    }

}
