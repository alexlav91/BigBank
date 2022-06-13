package ru.al.bigbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.al.bigbank.model.entity.Client;
import ru.al.bigbank.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImp implements ClientService{
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public void saveClient(Client client) {
      this.clientRepository.save(client);
    }

    @Override
    public Client getClientById(long id) {
        Optional<Client> optional=clientRepository.findById(id);
        Client client=null;
        if(optional.isPresent()){
            client=optional.get();
        }else {
            throw new RuntimeException("Client not found for id: "+id);
            }
        return client;
    }

    @Override
    public void deleteClientById(long id) {
        this.clientRepository.deleteById(id);
    }
}
