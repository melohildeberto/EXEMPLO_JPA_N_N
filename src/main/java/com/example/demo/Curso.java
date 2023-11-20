package com.example.demo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long cursoId;
	@Column(name = "nome", columnDefinition = "VARCHAR(40)", nullable = false)
	public String nome;
	@Column(name = "valor", columnDefinition = "decimal", nullable = false)
	public float valor;
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "cursos")
	List<Aluno> alunos;
}
