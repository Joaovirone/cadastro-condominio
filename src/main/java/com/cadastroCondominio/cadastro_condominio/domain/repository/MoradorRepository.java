package com.cadastroCondominio.cadastro_condominio.domain.repository;

import java.util.Optional;
import java.util.UUID;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cadastroCondominio.cadastro_condominio.domain.model.morador.Cpf;
import com.cadastroCondominio.cadastro_condominio.domain.model.morador.Morador;
import java.util.List;
;
public interface MoradorRepository extends JpaRepository<Morador, UUID>{

    Optional <Morador> findByRg(String rg);

    Optional <Morador> findByNome(String nome);
    boolean existsByCpf_Numero(String numeroCpf);
    
}
