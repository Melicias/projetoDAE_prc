package com.example.prc.dtos;

import com.example.prc.entities.TipoDadosBiometricos;
import com.example.prc.entities.Utente;
import io.smallrye.common.constraint.NotNull;

import javax.persistence.*;
import java.util.Date;

public class UtenteDadosBiometricosDTO {
    private int id;
    private TipoDadosBiometricosDTO tipoDadosBiometricos;
    private UtenteDTO utente;
    private Date data_observacao;
    private String valor;

    @Temporal(TemporalType.TIMESTAMP)
    private Date deleted_at;
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;

    public UtenteDadosBiometricosDTO() {
    }

    public UtenteDadosBiometricosDTO(TipoDadosBiometricosDTO tipoDadosBiometricos, Date data_observacao, String valor) {
        this.tipoDadosBiometricos = tipoDadosBiometricos;
        this.data_observacao = data_observacao;
        this.valor = valor;
        this.created_at = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoDadosBiometricosDTO getTipoDadosBiometricos() {
        return tipoDadosBiometricos;
    }

    public void setTipoDadosBiometricos(TipoDadosBiometricosDTO tipoDadosBiometricos) {
        this.tipoDadosBiometricos = tipoDadosBiometricos;
    }

    public Date getData_observacao() {
        return data_observacao;
    }

    public void setData_observacao(Date data_observacao) {
        this.data_observacao = data_observacao;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Date getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(Date deleted_at) {
        this.deleted_at = deleted_at;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public UtenteDTO getUtente() {
        return utente;
    }

    public void setUtente(UtenteDTO utente) {
        this.utente = utente;
    }
}
