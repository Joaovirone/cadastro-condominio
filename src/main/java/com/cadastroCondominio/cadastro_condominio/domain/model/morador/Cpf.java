package com.cadastroCondominio.cadastro_condominio.domain.model.morador;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
public class Cpf {
    
    private String numero;

    
    public Cpf(String numero){
        if(!validar(numero)){
            
            throw new IllegalArgumentException("CPF inválido");
        }

        this.numero = numero;
    }

    private boolean validar (String numero){
        
        return numero != null && numero.matches("\\d{11}");
    }

    @Override
    public String toString(){
        return numero;
    }

}
