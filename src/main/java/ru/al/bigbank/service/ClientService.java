package ru.al.bigbank.service;

import ru.al.bigbank.model.dto.ClientDTO;
import ru.al.bigbank.model.entity.Client;
import ru.al.bigbank.model.entity.Payment;

import java.util.List;

public interface ClientService {
    List<Client> getAllClients();

    void saveClient(ClientDTO client);

    Client getClientById(long id);

    void deleteClientById(long id);

    List<Payment> showTransactionByClient(long id);

}
