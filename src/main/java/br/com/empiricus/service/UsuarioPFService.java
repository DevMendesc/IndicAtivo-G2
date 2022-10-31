package br.com.empiricus.service;



import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.empiricus.model.ClientePF;
import br.com.empiricus.model.UserLoginPF;
import br.com.empiricus.repository.UsuarioPFRepository;




@Service
public class UsuarioPFService {

	@Autowired
	private UsuarioPFRepository repository;

	public ClientePF CadastrarUsuarioPF(ClientePF clientePF) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String senhaEncoder = encoder.encode(clientePF.getSenha());
		clientePF.setSenha(senhaEncoder);
		return repository.save(clientePF);
	}

	public Optional<UserLoginPF> Logar(Optional<UserLoginPF> user) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<ClientePF> cpf = repository.findByCpf(user.get().getCpf());
		
		if (cpf.isPresent()) {
			
			if (encoder.matches(user.get().getSenha(), cpf.get().getSenha())) {
				
				String auth = user.get().getCpf() + ":" + user.get().getSenha();
				
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				
				String authHeader = "Basic " + new String(encodedAuth);
				
				user.get().setToken(authHeader);
				user.get().setNome(cpf.get().getNome());

				return user;
			}
		}
		return null;
	}
}