package com.sistema.gerenciamento.log;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class LogAtividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String evento;
    private LocalDateTime dataHora;
    private String usuarioResponsavel;

    public LogAtividade() {
    }

    public LogAtividade(String evento, String usuarioResponsavel) {
        this.evento = evento;
        this.usuarioResponsavel = usuarioResponsavel;
        this.dataHora = LocalDateTime.now();
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getEvento() {
        return evento;
    }
    public void setEvento(String evento) {
        this.setEvento(evento);
    }
    public LocalDateTime getDataHora() {
        return dataHora;
    }
    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
    public String getUsuarioResponsavel() {
        return usuarioResponsavel;
    }
    public void setUsuarioResponsavel(String usuarioResponsavel) {
        this.usuarioResponsavel = usuarioResponsavel;
    }
}