package com.petshopping.services.validators;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.petshopping.domain.Pessoa;
import com.petshopping.repositores.PesooaRepositores;

public class PessoaInsertValidator implements ConstraintValidator<PessoaInsert,Pessoa> {

	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private PesooaRepositores repo;
	
	@Override
	public boolean isValid(Pessoa value, ConstraintValidatorContext context) {
		if(request == null) {
			return true;
		}
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Long id = null;
		if(map.get("id") != null) {
			id = Long.parseLong(map.get("id"));
		}
		
		Pessoa aux = repo.findByEmail(value.getEmail());
		if(aux != null) {
			if(id == null || !id.equals(aux.getId_pessoa())) {				
				context.disableDefaultConstraintViolation();
				context
				.buildConstraintViolationWithTemplate("Já existe um usuário com o e-mail informado")
				.addPropertyNode("email")
				.addConstraintViolation();
				return false;
			}
		}
		return true;
	}



}
