package com.parreira.prjCadFornecedor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parreira.prjCadFornecedor.entities.Fornecedor;
import com.parreira.prjCadFornecedor.service.FornecedorService;

@RestController
@RequestMapping("/Fornecedor")
public class FornecedorController {
	private final FornecedorService fornecedorService;

	@Autowired
	public FornecedorController(FornecedorService fornecedorService) {
		this.fornecedorService = fornecedorService;
	}

	@PostMapping
	public Fornecedor criarProdutos(@RequestBody Fornecedor fornecedor) {
		return fornecedorService.salvarFornecedor(fornecedor);
	}

	@GetMapping("/{id}")
	public Fornecedor buscarFornecedorPorId(@PathVariable Long id) {
		return fornecedorService.getFornecedorById(id);
	}

	@GetMapping
	public List<Fornecedor> listarTodosFornecedor() {
		return fornecedorService.getAllFornecedor();
	}

	@DeleteMapping("/{id}")
	public void deleFornecedor(@PathVariable Long id) {
		fornecedorService.deletarFornecedor(id);

		@PutMapping("/{id}")
	public ResponseEntity<Fornecedor> atualizaFornecedor(@PathVariable Long id, @RequestBody Fornecedor fornecedor){
		Fornecedor atualizado = fornecedorService.updateFornecedor(id, fornecedor);
		if(atualizado != null) {
			return ResponseEntity.ok(atualizado);
		}else {
			return ResponseEntity.notFound().build();		}
	}

}
