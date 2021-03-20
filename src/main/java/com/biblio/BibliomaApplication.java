package com.biblio;

import java.text.SimpleDateFormat;
import java.util.Arrays;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.biblio.biblio.domain.Categoria;
import com.biblio.biblio.domain.Cidade;
import com.biblio.biblio.domain.Cliente;
import com.biblio.biblio.domain.Endereco;
import com.biblio.biblio.domain.Estado;
import com.biblio.biblio.domain.Livros;
import com.biblio.biblio.domain.Pagamento;
import com.biblio.biblio.domain.PagamentoComBoleto;
import com.biblio.biblio.domain.PagamentoComCartao;
import com.biblio.biblio.domain.Pedido;
import com.biblio.biblio.domain.enums.EstadoPagamento;
import com.biblio.biblio.domain.enums.TipoCliente;
import com.biblio.biblio.repositories.CategoriaRepository;
import com.biblio.biblio.repositories.CidadeRepository;
import com.biblio.biblio.repositories.ClienteRepository;
import com.biblio.biblio.repositories.EnderecoRepository;
import com.biblio.biblio.repositories.EstadoRepository;
import com.biblio.biblio.repositories.LivroRepository;
import com.biblio.biblio.repositories.PagamentoRepository;
import com.biblio.biblio.repositories.PedidoRepository;

@SpringBootApplication
public class BibliomaApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(BibliomaApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Romance");
		Categoria cat2 = new Categoria(null, "Policial");
		Categoria cat3 = new Categoria(null, "Suspense e Mistério");
		Categoria cat4 = new Categoria(null, "Ficção Científica");
		
		Livros li1 = new Livros(null, "O Peão", "Steven James","Rocco","testestets",4,40.00);
		Livros li2 = new Livros(null, "A Torre", "Steven James","Rocco","testestets",5,30.00);
		Livros li3 = new Livros(null, "O Cavalo", "Steven James","Rocco","testestets",4,60.00);
		
		cat1.getLivros().addAll(Arrays.asList(li1));
		cat2.getLivros().addAll(Arrays.asList(li1,li2));
		cat3.getLivros().addAll(Arrays.asList(li3));
		
		li1.getCategorias().addAll(Arrays.asList(cat1,cat2));
		li2.getCategorias().addAll(Arrays.asList(cat2));
		li3.getCategorias().addAll(Arrays.asList(cat3));
		
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2,cat3,cat4));
		livroRepository.saveAll(Arrays.asList(li1,li2,li3));
		
		Estado est1 = new Estado(null, "São Paulo");
		Estado est2 = new Estado(null,"Minas Gerais");
		
		Cidade cid1 = new Cidade(null,"Campinas",est1);
		Cidade cid2 = new Cidade(null,"Uberlandia",est2);
		Cidade cid3 = new Cidade(null, "Bauru",est1);
		
		est1.getCidades().addAll(Arrays.asList(cid1,cid3));
		est2.getCidades().addAll(Arrays.asList(cid2));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));

		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1, cid1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, cid2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.PAGO, ped1, 6);
		ped1.setPagamento(pagto1);

		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedido().addAll(Arrays.asList(ped1, ped2));

		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		
	}
	
} 