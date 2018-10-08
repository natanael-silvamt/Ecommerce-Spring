package br.ufc.qxd.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufc.qxd.Model.Client;


public interface ClientRepository extends JpaRepository<Client, Long>{
	Client findByLogin(String login);
}
