package br.com.empiricus.seguranca;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.empiricus.model.ClientePF;
import br.com.empiricus.repository.UsuarioPFRepository;

@Service
public class UserPFDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UsuarioPFRepository usuarioPFRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<ClientePF> clientePF = usuarioPFRepository.findByCpf(username);
		
		if(clientePF.isPresent()) 
					return new UserPFDetailsImpl(clientePF.get());
				else 
					throw new ResponseStatusException(HttpStatus.FORBIDDEN);

	}

}
