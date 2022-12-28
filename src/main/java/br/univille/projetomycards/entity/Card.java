package br.univille.projetomycards.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 1000, nullable = false)
    private String nome;
    @Column(length = 3000)
    private String frente;
    private String verso;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE })
    private Deck deckResidencia;

    public long getId() {
        return id;
    }

    public Deck getDeckResidencia() {
        return deckResidencia;
    }

    public void setDeckResidencia(Deck deckResidencia) {
        this.deckResidencia = deckResidencia;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFrente() {
        return frente;
    }

    public void setFrente(String frente) {
        this.frente = frente;
    }

    public String getVerso() {
        return verso;
    }

    public void setVerso(String verso) {
        this.verso = verso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
