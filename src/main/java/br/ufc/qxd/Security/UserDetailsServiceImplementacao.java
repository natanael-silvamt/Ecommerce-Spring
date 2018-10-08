package br.ufc.qxd.Security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.ufc.qxd.Model.Client;
import br.ufc.qxd.Repository.ClientRepository;

@Repository
@Transactional
public class UserDetailsServiceImplementacao implements UserDetailsService {
	@Autowired
	private ClientRepository clientRepository;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Client client = this.clientRepository.findByLogin(login);
		if(client == null)
			throw new UsernameNotFoundException("Login não encontrado !!!");
		return new User(client.getUsername(), client.getPassword(), true, true, true, true, client.getAuthorities());
	}

}
