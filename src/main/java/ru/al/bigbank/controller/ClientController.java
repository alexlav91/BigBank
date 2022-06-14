package ru.al.bigbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.al.bigbank.model.dto.ClientDTO;
import ru.al.bigbank.model.dto.PaymentDTO;
import ru.al.bigbank.model.entity.Client;
import ru.al.bigbank.model.entity.Payment;
import ru.al.bigbank.service.ClientService;
import ru.al.bigbank.service.ClientServiceImp;
import ru.al.bigbank.service.PaymentService;

@Controller
public class ClientController {

    private ClientServiceImp clientService;

    private PaymentService paymentService;
    @Autowired
    public ClientController(ClientServiceImp clientService, PaymentService paymentService) {
        this.clientService = clientService;
        this.paymentService = paymentService;
    }

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
    public String saveClient(@ModelAttribute("client") ClientDTO client){
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
        PaymentDTO payment = new PaymentDTO();
        model.addAttribute("payment", payment);
        return "new_payment";
    }
    @PostMapping("/savePayment")
    public String savePayment(@ModelAttribute("payment") PaymentDTO payment){
        paymentService.savePayment(payment);
        return "redirect:/";
    }
    @GetMapping("/showTransaction/{id}")
    public String showTransaction(@PathVariable(value = "id") long id, Model model){
    model.addAttribute("listOfPayment", clientService.showTransactionByClient(id));
        return "transaction_list";
    }

}
