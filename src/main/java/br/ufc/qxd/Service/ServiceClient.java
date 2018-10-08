package br.ufc.qxd.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.ufc.qxd.Model.Client;
import br.ufc.qxd.Repository.ClientRepository;


@Service
public class ServiceClient {
	@Autowired
	private ClientRepository clientRepository;
	
	public void AddCliente(Client client) {
		client.setPassword(new BCryptPasswordEncoder().encode(client.getPassword()));
		this.clientRepository.save(client);
	}
	
	public List<Client> getCustomers(){
		return this.clientRepository.findAll();
	}
	
	public void remove_client(Long id) {
		this.clientRepository.deleteById(id);
	}
	
	public Client getById(Long id) {
		return this.clientRepository.getOne(id);
	}
}
