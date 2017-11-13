package br.com.jp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author JP on 10/10/17.
 */
@Entity
public class Pojo extends BaseEntity {

    @NotNull
    private String nome;

    private String sobrenome;

    @Column(name = "data_nascimento")
    private Date dataNascimento;

    @NotNull
    @Column(name = "numero_rg")
    private Integer numeroRg;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Integer getNumeroRg() {
        return numeroRg;
    }

    public void setNumeroRg(Integer numeroRg) {
        this.numeroRg = numeroRg;
    }
}
