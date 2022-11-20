package br.com.empiricus.seguranca;

import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.empiricus.model.UserLoginPF;
import br.com.empiricus.model.UserLoginPJ;
import br.com.empiricus.repository.UserPFRepository;
import br.com.empiricus.repository.UserPJRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserPFRepository userPFRepository;

	@Autowired
	private UserPJRepository userPJRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		if (username.length() ==  11) {
			Optional<UserLoginPF>clientePF = userPFRepository.findByCpf(username);
			
			return new org.springframework.security.core.userdetails.User(clientePF.get().getCpf(), clientePF.get().getSenha(), Collections.EMPTY_LIST);
			
		}
		else if (username.length() == 14) {
			Optional<UserLoginPJ> clientePJ = userPJRepository.findByCnpj(username);
			
			return new org.springframework.security.core.userdetails.User(clientePJ.get().getCnpj(), clientePJ.get().getSenha(), Collections.EMPTY_LIST);
		}

		return null;
	}


}