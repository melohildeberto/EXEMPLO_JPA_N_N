package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExemploJpaNNApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExemploJpaNNApplication.class, args);
	}


	@Bean
	public CommandLineRunner inserindoAlunoCurso(AlunoRepositorio alunoRepositorio, CursoRepositorio cursoRepositorio) {
		return (args) -> {

			for (int i = 1; i < 11; i++) {
				Aluno aluno = new Aluno();
				aluno.nome = "Melo" + i;
				aluno.cpf = "" + i;
				aluno.rg = "" + i;
				aluno = alunoRepositorio.save(aluno);
				System.out.println(aluno.alunoId);
			}
			for (int i = 1; i < 11; i++) {
				Curso curso = new Curso();
				curso.nome = "Curso " + i;
				curso.valor = (i * 10);
				curso = cursoRepositorio.save(curso);
				System.out.println(curso.cursoId + " " + curso.nome);
			}
		};
	}
//	@Primary
	@Bean
	public CommandLineRunner inserindoCursosDoAluno(AlunoRepositorio alunoRepositorio, CursoRepositorio cursoRepositorio) {
		return (args) -> {
			List<Curso> cursos = cursoRepositorio.findAll();
			Optional<Aluno> aluno = alunoRepositorio.findById(2l);
			if (aluno.isPresent()) {
				aluno.get().cursos = cursos;
				alunoRepositorio.save(aluno.get());
			}
		};
	}

	@Bean
	public CommandLineRunner buscandoAluno(AlunoRepositorio alunoRepositorio, CursoRepositorio cursoRepositorio) {
		return (args) -> {
			
			Optional<Aluno> a = alunoRepositorio.findById(1l);
			if (a.isPresent()) {
				for (Curso obj : a.get().cursos) {
					System.out.println(obj.cursoId + " " + obj.nome);
				}
			}
		};
	}
	
//	@Bean
	public CommandLineRunner buscandoCurso(AlunoRepositorio alunoRepositorio, CursoRepositorio cursoRepositorio) {
		return (args) -> {
			Optional<Curso> a = cursoRepositorio.findById(1l);
			if (a.isPresent()) {
				for (Aluno obj : a.get().alunos) {
					System.out.println(obj.alunoId + " " + obj.nome);
				}

			}
		};
	}
	
	
}
