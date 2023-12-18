package com.FinalProject.FExam.Service;

import com.FinalProject.FExam.Repository.ClientRepository;
import com.FinalProject.FExam.Model.Client;
import org.springframework.stereotype.Service;


@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client saveClient(Client client){

        Client savedClient = clientRepository.save(client);


        return savedClient;


    }
}
