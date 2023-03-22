package main.modelo;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class Empresa {

    private Long id;
    private String nome;

    private Date dataAbertura = new Date();

    public Empresa(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }
}
