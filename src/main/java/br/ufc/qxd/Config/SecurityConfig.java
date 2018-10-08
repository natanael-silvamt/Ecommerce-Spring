package br.ufc.qxd.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.ufc.qxd.Security.UserDetailsServiceImplementacao;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private UserDetailsServiceImplementacao userDetailsImplementacao;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable().authorizeRequests()
		
		.antMatchers("/").permitAll()
		.antMatchers("/cliente/cadastro").permitAll()
		.antMatchers("/produto/listarProdutos").permitAll()
		.antMatchers("/produto/cadastro").hasRole("ADMIN")
		.antMatchers("/produto/salvarProduto").hasRole("ADMIN")
		.antMatchers("/carrinho/addProduto").hasRole("USER")
		.antMatchers("/carrinho/historicoCompras").hasRole("USER")
		.antMatchers("/carrinho/visualizar").permitAll()
		.antMatchers("/cliente/salvarCliente").permitAll()
		.anyRequest().authenticated() 
		
		.and()
		.formLogin()
		.loginPage("/cliente/logar")
		.permitAll() 
		
		.and()
		.logout()
		.logoutSuccessUrl("/cliente/logar?logout")
		.permitAll();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsImplementacao).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "ImagensProdutos/**", "/resources/**"); 
	}

}
