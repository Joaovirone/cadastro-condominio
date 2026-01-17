package com.cadastroCondominio.cadastro_condominio.domain.model.morador;

import java.util.UUID;

import org.hibernate.validator.constraints.br.CPF;

import com.cadastroCondominio.cadastro_condominio.domain.model.unidade.Unidade;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "moradores")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Morador {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 300)
    private String nome;

    @Column(nullable = true, unique = true, length = 15)
    private String rg; 

    @Embedded
    @AttributeOverride(name = "numero", column = @Column(name = "cpf", unique = true, nullable = false))
    private Cpf cpf;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unidade_id")
    private Unidade unidade;

    public void mudarPara(Unidade novaUnidade ){

       this.unidade = novaUnidade;
    }
}
