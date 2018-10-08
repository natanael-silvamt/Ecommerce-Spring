package br.ufc.qxd.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.ufc.qxd.Model.Client;
import br.ufc.qxd.Service.ServiceClient;

@Controller
@RequestMapping("/cliente")
public class ControllerClient {
	@Autowired
	private ServiceClient serviceClient;
	
	@RequestMapping("/cadastro")
	public ModelAndView customer_registration() {
		ModelAndView mv = new ModelAndView("cadastro_cliente");
		mv.addObject("cliente", new Client());
		return mv;
	}
	
	@PostMapping("/salvarCliente")
	public ModelAndView save_customer(Client client) {
		this.serviceClient.AddCliente(client);
		ModelAndView mv = new ModelAndView("redirect:/");
		return mv;
	}
	
	@GetMapping("/listarClientes")
	public ModelAndView list_customers() {
		List<Client> clients = this.serviceClient.getCustomers();
		ModelAndView mv = new ModelAndView("#");
		mv.addObject("allClientes", clients);
		return mv;
	}
	
	@RequestMapping("{id}")
	public ModelAndView upgrade_client(@PathVariable Long id) {
		Client client = this.serviceClient.getById(id);
		ModelAndView mv = new ModelAndView("");
		mv.addObject("cliente", client);
		return mv;
	}
	
	@RequestMapping("/excluir/{id}")
	public ModelAndView delete_client(@PathVariable Long id) {
		this.serviceClient.remove_client(id);
		ModelAndView mv = new ModelAndView("redirect:#");
		return mv;
	}
	
	@RequestMapping("/logar")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
