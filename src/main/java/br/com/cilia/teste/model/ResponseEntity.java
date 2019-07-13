package br.com.cilia.teste.model;

import org.springframework.security.core.Transient;

import javax.persistence.Entity;


@Entity
public class ResponseEntity {

    private int codigo;
    private String mensagem;

    public ResponseEntity(int codigo, String mensagem) {
        this.codigo   = codigo;
        this.mensagem =  mensagem;
    }

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

}
