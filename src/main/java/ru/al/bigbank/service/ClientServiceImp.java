package ru.al.bigbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.al.bigbank.model.dto.ClientDTO;
import ru.al.bigbank.model.entity.Client;
import ru.al.bigbank.model.entity.Payment;
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
    public void saveClient(ClientDTO client) {
      Client client1 = new Client();
      client1.setId(client.getId());
      client1.setClientName(client.getClientName());
      client1.setBalance(client.getBalance());
      client1.setPhoneNumb(client.getPhoneNumb());
      this.clientRepository.save(client1);
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

    @Override
    public List<Payment> showTransactionByClient(long id) {
        Client client = clientRepository.findById(id).orElseThrow();
        return client.getPayments();

    }
}
