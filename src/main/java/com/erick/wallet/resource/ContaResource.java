package com.erick.wallet.resource;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.erick.wallet.domain.Conta;
import com.erick.wallet.domain.PagamentoDeBoleto;
import com.erick.wallet.domain.Transacao;
import com.erick.wallet.domain.Usuario;
import com.erick.wallet.dto.UsuarioSaldoDTO;
import com.erick.wallet.services.ContaService;
import com.erick.wallet.services.PagamentoDeBoletoService;
import com.erick.wallet.services.TransacaoService;
import com.erick.wallet.services.UsuarioService;

@RestController
@RequestMapping("/conta")
public class ContaResource {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private TransacaoService transacaoService;
	
	@Autowired
	private ContaService contaService;
	
	@Autowired
	private PagamentoDeBoletoService boletoService;
	
	@GetMapping("/meusdados/{id}")
	public ResponseEntity<Usuario> dadosUsuario(@PathVariable Integer id){
		return ResponseEntity.ok().body(usuarioService.buscarUsuario(id));
	}
	
	@GetMapping("/saldo/{id}")
	public ResponseEntity<UsuarioSaldoDTO> saldoUsuario(@PathVariable Integer id){
		UsuarioSaldoDTO obj = new UsuarioSaldoDTO(usuarioService.buscarUsuario(id));
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping("/extrato/{id}")
	public ResponseEntity<Conta> extratoUsuario(@PathVariable Integer id){
		Conta obj = contaService.buscarContaPorUsuario(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping("/transferencia")
	public ResponseEntity<Void> transferenciaUsuario(@RequestBody Transacao transacao){
		Transacao obj = transacaoService.salvarTransacao(transacao);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PostMapping("/pagamento")
	public ResponseEntity<Void> pagamentoBoleto(@RequestBody PagamentoDeBoleto boleto){
		PagamentoDeBoleto obj = boletoService.salvarPagamentoDeBoleto(boleto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
}
