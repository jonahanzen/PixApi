package br.com.pix;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pix")
public class ApiController {
	
	
	private CriarCobranca cobranca = new CriarCobranca();
	private ListarCobrancas cobrancas = new ListarCobrancas();
	
	@GetMapping
	public String todasCobrancas() {
		return cobrancas.consultaGeral().toString();
	}
	
	@PostMapping("/{nome}/{cpf}/{valor}")
	public String criarCobranca(
			@PathVariable String nome,
			@PathVariable String cpf,
			@PathVariable String valor) {
		return cobranca.criarCobrancaDados(nome, cpf, valor).toString();
		
	}
	
	
	
}
