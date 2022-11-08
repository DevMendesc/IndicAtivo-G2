package br.com.empiricus.service;



import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.empiricus.model.ClientePJ;
import br.com.empiricus.model.UserLoginPJ;
import br.com.empiricus.repository.UsuarioPJRepository;




@Service
public class UsuarioPJService {

	@Autowired
	private UsuarioPJRepository repository;
	
	@Autowired
    EmailService emailService;

	public ClientePJ CadastrarUsuarioPJ(ClientePJ clientePJ) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String senhaEncoder = encoder.encode(clientePJ.getSenha());
		clientePJ.setSenha(senhaEncoder);
		emailService.enviarEmail(clientePJ.getEmail(), "Confirmação de cadastro", "O seu cadastro no IndicAtivos Foi realizado com sucesso!");
		return repository.save(clientePJ);
	}

	public Optional<UserLoginPJ> Logar(Optional<UserLoginPJ> user) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<ClientePJ> cnpj = repository.findByCnpj(user.get().getCnpj());
		
		if (cnpj.isPresent()) {
			
			if (encoder.matches(user.get().getSenha(), cnpj.get().getSenha())) {
				
				String auth = user.get().getCnpj() + ":" + user.get().getSenha();
				
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				
				String authHeader = "Basic " + new String(encodedAuth);
				
				user.get().setToken(authHeader);
				user.get().setNome(cnpj.get().getNome());

				return user;
			}
		}
		return null;
	}
}