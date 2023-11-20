package com.example.demo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Aluno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long alunoId;
	@Column(name = "nome", columnDefinition = "VARCHAR(60)", nullable = false)
	public String nome;
	@Column(name = "cpf", columnDefinition = "VARCHAR(11)", unique = true, nullable = false)
	public String cpf;
	@Column(name = "rg", columnDefinition = "VARCHAR(10)", nullable = false)
	public String rg;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "curso_aluno", joinColumns = @JoinColumn(name = "alunoId"), inverseJoinColumns = @JoinColumn(name = "cursoId"))
	List<Curso> cursos;
}
