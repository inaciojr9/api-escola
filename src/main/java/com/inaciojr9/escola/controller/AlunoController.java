package com.inaciojr9.escola.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inaciojr9.escola.banco.JDBCDelete;
import com.inaciojr9.escola.banco.JDBCInsert;
import com.inaciojr9.escola.banco.JDBCSelect;
import com.inaciojr9.escola.banco.JDBCSelectPorId;
import com.inaciojr9.escola.banco.JDBCUpdate;
import com.inaciojr9.escola.model.Aluno;

@RestController
@RequestMapping(value="/api/v1")
public class AlunoController{
	
	@GetMapping("/alunos")
	public List<Aluno> listarTodos(){
		return JDBCSelect.getAll();
	}
	
	@GetMapping("/alunos/{id}")
	public Aluno obterPorId(@PathVariable(value="id") long id) {
		return JDBCSelectPorId.getById(id);
	}
	
	@PostMapping("/alunos")
	public void salvar(@RequestBody Aluno aluno) {
		JDBCInsert.insert(aluno.getNome());
	}
	
	@DeleteMapping("/alunos/{id}")
	public void excluir(@PathVariable(value="id") long id) {
		JDBCDelete.delete(id);
	}
	
	@PutMapping("/alunos")
	public void atualizar(@RequestBody Aluno aluno) {
		JDBCUpdate.update(aluno.getId(), aluno.getNome());
	}

}
