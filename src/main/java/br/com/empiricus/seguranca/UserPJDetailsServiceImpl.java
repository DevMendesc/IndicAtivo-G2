package br.com.empiricus.seguranca;

import java.util.Optional;

import br.com.empiricus.model.ClientePJ;
import br.com.empiricus.repository.UsuarioPJRepository;
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
public class UserPJDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UsuarioPJRepository usuarioPJRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<ClientePJ> clientePJ = usuarioPJRepository.findByCnpj(username);
		
		if(clientePJ.isPresent())
					return new UserPJDetailsImpl(clientePJ.get());
				else 
					throw new ResponseStatusException(HttpStatus.FORBIDDEN);

	}

}
