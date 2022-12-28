package br.univille.projetomycards.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Deck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 1000,unique = true)
    private String nome;


    @OneToMany(cascade = { CascadeType.REFRESH, CascadeType.MERGE })
    private List<Card> listaCards = new ArrayList<>();
    


    public String toString(){
        return getNome();
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Card> getListaCards() {
        return listaCards;
    }

    public void setListaCards(List<Card> listaCards) {
        this.listaCards = listaCards;
    }

   

    
}
