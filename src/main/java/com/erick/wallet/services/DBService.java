package com.erick.wallet.services;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erick.wallet.domain.Banco;
import com.erick.wallet.domain.Cartao;
import com.erick.wallet.domain.Conta;
import com.erick.wallet.domain.Endereco;
import com.erick.wallet.domain.Transacao;
import com.erick.wallet.domain.Usuario;
import com.erick.wallet.domain.util.Data;
import com.erick.wallet.repositories.BancoRepository;
import com.erick.wallet.repositories.CartaoRepository;
import com.erick.wallet.repositories.ContaRepository;
import com.erick.wallet.repositories.EnderecoRepository;
import com.erick.wallet.repositories.TransacaoRepository;
import com.erick.wallet.repositories.UsuarioRepository;

@Service
public class DBService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private BancoRepository bancoRepository;
	
	@Autowired
	private CartaoRepository cartaoRepository;
	
	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private TransacaoRepository transacaoRepository;
	
	public void instanciacaoBancoDeDados(){
		
		Endereco end1 = new Endereco(null, "Av. abc", "123");
		Endereco end2 = new Endereco(null, "Av. cba", "321");
		Endereco end3 = new Endereco(null, "Av. aaa", "111");
		
		enderecoRepository.saveAll(Arrays.asList(end1, end2, end3));
		
		Banco b1 = new Banco(null, "ITAU");
		b1.setEndereco(end1);
		Banco b2 = new Banco(null, "NUBANK");
		b2.setEndereco(end2);
		
		bancoRepository.saveAll(Arrays.asList(b1, b2));

		Transacao tran1 = new Transacao(null, 23.00, new Date(), "AR-13322", "AR-113344", "transferencia");
		Transacao tran2 = new Transacao(null, 156.00, new Date(), "AR-13322", "AR-113344", "transferencia");
		Transacao tran3 = new Transacao(null, 2222.00, new Date(), "AR-13322", "AR-113344", "transferencia");
		
		Cartao c1 = new Cartao(null, "123456789", Data.paraData("19-05-2022 09:21"), "C", Data.paraData("21-04-2018"));
		Cartao c2 = new Cartao(null, "987654321", Data.paraData("19-05-2022 09:21"), "D", Data.paraData("21-04-2018"));
		
		Conta co1 = new Conta(null, "123456", new Date(), 0.0, false);
		Conta co2 = new Conta(null, "654321", new Date(), 233.0, true);
		
		co2.setTransacoes(Arrays.asList(tran1, tran2, tran3));
		tran1.setConta(co2);
		tran2.setConta(co2);
		tran3.setConta(co2);
		
		Usuario usuario = new Usuario(null, "Erick Luz", "43768646840", "erickluz", "123456", "C");
		usuario.setBanco(b1);
		b1.setUsuario(Arrays.asList(usuario));
		usuario.setCartao(Arrays.asList(c1, c2));
		c1.setUsuario(usuario);
		usuario.setConta(Arrays.asList(co1, co2));
		co1.setUsuario(usuario);
		co2.setUsuario(usuario);
		usuario.setEndereco(Arrays.asList(end3));
		
		contaRepository.saveAll(Arrays.asList(co1, co2));
		transacaoRepository.saveAll(Arrays.asList(tran1, tran2, tran3));
		bancoRepository.saveAll(Arrays.asList(b1, b2));
		cartaoRepository.saveAll(Arrays.asList(c1, c2));
		usuarioRepository.save(usuario);
		
	}
}