package com.biblio;

import java.util.Arrays;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.biblio.biblio.domain.Categoria;
import com.biblio.biblio.domain.Livros;
import com.biblio.biblio.repositories.CategoriaRepository;
import com.biblio.biblio.repositories.LivroRepository;

@SpringBootApplication
public class BibliomaApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LivroRepository livroRepository;

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
		
	}
} 