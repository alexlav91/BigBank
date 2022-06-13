package ru.al.bigbank.service;

import ru.al.bigbank.model.entity.Client;

import java.util.List;

public interface ClientService {
    List<Client> getAllClients();
    void saveClient(Client client);
    Client getClientById(long id);
    void deleteClientById(long id);

}
