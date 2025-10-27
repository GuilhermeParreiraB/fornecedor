package com.parreira.prjCadFornecedor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parreira.prjCadFornecedor.entities.Fornecedor;
import com.parreira.prjCadFornecedor.repository.FornecedorRepository;

@Service
public class FornecedorService {
	private final FornecedorRepository fornecedorRepository;
	@Autowired
	public FornecedorService (FornecedorRepository fornecedorRepository) {
		this.fornecedorRepository =  fornecedorRepository;
	}
	
	public Fornecedor salvarFornecedor(Fornecedor Fornecedor) {
		return fornecedorRepository.save(Fornecedor);
	}
	
	public Fornecedor getFornecedorById(Long id) {
		return fornecedorRepository.findById(id).orElse(null);
	}
	
	public List<Fornecedor> getAllFornecedor(){
		return fornecedorRepository.findAll();
	}
	
	public void deletarFornecedor(Long id) {
		fornecedorRepository.deleteById(id);

		public Fornecedor updateFornecedor(Long id, Fornecedor fornecedorAtualizado) {
		Optional<Fornecedor> fornecedorOptional = fornecedorRepository.findById(id);
		if(fornecedorOptional.isPresent()) {
			Fornecedor fornecedor = fornecedorOptional.get();
			fornecedor.setCnpj(fornecedorAtualizado.getCnpj());
			fornecedor.setEmail(fornecedorAtualizado.getEmail());
			fornecedor.setEndereco(fornecedorAtualizado.getEndereco());
			fornecedor.setFone(fornecedorAtualizado.getFone());
			fornecedor.setInscricaoEstadual(fornecedorAtualizado.getInscricaoEstadual());
			fornecedor.setNomeFantasia(fornecedorAtualizado.getNomeFantasia());
			fornecedor.setRazaoSocial(fornecedorAtualizado.getRazaoSocial());
			return fornecedorRepository.save(fornecedor);
			
		}else {
			return null;
		}
	}
	
}


