package com.inaciojr9.escola.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public Aluno salvar(@RequestBody Aluno aluno) {
		return JDBCInsert.insert(aluno.getNome());
	}
	
	@DeleteMapping("/alunos/{id}")
	public ResponseEntity<Object> excluir(@PathVariable(value="id") long id) {
		JDBCDelete.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/alunos/{id}")
	public ResponseEntity<Object> atualizar(@RequestBody Aluno aluno, @PathVariable(value="id") long id) {
		if(id != aluno.getId()) {
			System.out.println(">>>>>>>>> ID: "+id);
			System.out.println(">>>>>>>>> ALuno GetID: "+aluno.getId());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		JDBCUpdate.update(aluno.getId(), aluno.getNome());
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
