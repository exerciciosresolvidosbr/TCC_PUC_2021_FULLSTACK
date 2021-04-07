package br.com.condagil.service.oauth;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.condagil.models.builder.oauth.UsuarioDTOBuilder;
import br.com.condagil.models.dto.oauth.UsuarioDTO;
import br.com.condagil.repository.query.UsuarioQueryRepository;

@Service
public class UsuarioQueryService {

	@Autowired
	private UsuarioQueryRepository usuarioQueryRepository;
	
	public List<UsuarioDTO> recuperarUsuarios(){
		List<UsuarioDTO> listaReceitasDto = UsuarioDTOBuilder
				.converterListaEntityEmUsuarioDTO(usuarioQueryRepository.recuperarUsuarios());
		return listaReceitasDto;
	}

	public UsuarioDTO recuperarUsuarioPorId(Long usuarioId) {
		return UsuarioDTOBuilder.getInstance()
				.converterEntityEmUsuarioDTO(usuarioQueryRepository.recuperarUsuarioPorId(usuarioId))
				.getUsuarioDTO();
	}
	
	public UsuarioDTO recuperarPorEmail(String email){
		return UsuarioDTOBuilder.getInstance()
				.converterEntityEmUsuarioDTO(usuarioQueryRepository.recuperarPorEmail(email))
				.getUsuarioDTO();
	}

}