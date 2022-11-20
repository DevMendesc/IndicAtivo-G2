package br.com.empiricus.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.empiricus.model.UserLoginPF;
import br.com.empiricus.repository.UserPFRepository;


@Service
public class UserPFService {

	@Autowired
	private UserPFRepository repository;
	
	
	@Autowired
    EmailService emailService;
	
	public interface UserrPFService {
	UserLoginPF saveUserPF(UserLoginPF userLoginPF);//METODO  POST
	List<UserLoginPF> getAllUserPF(); //METODO GET ALL (PESQUISA TODA TABELO)
	UserLoginPF getUserPFById(long id); //METODO GET POR ID
	UserLoginPF updateUserPF(UserLoginPF userLoginPF, long id); //METODO PUT
	void deleteUserPF(long id); //METODO DELETE
	}

	public UserLoginPF CadastrarUserPF(UserLoginPF userLoginPF) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String senhaEncoder = encoder.encode(userLoginPF.getSenha());
		userLoginPF.setSenha(senhaEncoder);
		emailService.enviarEmail(userLoginPF.getEmail(), "Confirmação de cadastro", "O seu cadastro no IndicAtivos Foi realizado com sucesso!");
		return repository.save(userLoginPF);
	}

}