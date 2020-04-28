package com.petshopping.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.petshopping.domain.Pessoa;
import com.petshopping.repositores.PesooaRepositores;
import com.petshopping.security.UserSecurity;
@Service
public class UserSecurityService implements UserDetailsService  {

	@Autowired
	private PesooaRepositores repo;
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		 
		Pessoa pessoa = repo.findByEmail(email);
		if(pessoa == null) {
			throw new UsernameNotFoundException(email);
		}
		return new UserSecurity(pessoa.getId_pessoa(), pessoa.getEmail(),pessoa.getSenha(),pessoa.getPerfis());
	 
	}

}
