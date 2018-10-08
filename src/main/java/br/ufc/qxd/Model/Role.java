package br.ufc.qxd.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements GrantedAuthority{
	private static final long serialVersionUID = 1L;

	@Id
	private String role;
	
	@ManyToMany(mappedBy = "roles")
	private List<Client> customers;
	
	@Override
	public String getAuthority() {
		return this.role;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Client> getClients() {
		return customers;
	}

	public void setClients(List<Client> clients) {
		this.customers = clients;
	}
}
