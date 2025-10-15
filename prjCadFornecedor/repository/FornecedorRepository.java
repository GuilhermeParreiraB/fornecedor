package com.parreira.prjCadFornecedor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parreira.prjCadFornecedor.entities.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long>{

}