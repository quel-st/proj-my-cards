package br.univille.projetomycards.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projetomycards.entity.Card;
import br.univille.projetomycards.entity.Deck;
import br.univille.projetomycards.repository.CardRepository;
import br.univille.projetomycards.service.CardService;

@Service
public class CardServiceImpl 
    implements CardService{

    @Autowired
    private CardRepository repositorio;

    @Override
    public List<Card> getAll() {
        return repositorio.findAll();
    }

    @Override
    public Card save(Card card) {
        return repositorio.save(card);
    }

    @Override
    public Card findById(long id) {
        var resultado = repositorio.findById(id);
        if(resultado.isPresent()){
            return resultado.get();
        }
        return new Card();
    }

    @Override
    public void delete(long id) {
        repositorio.deleteById(id);
    }

    @Override
    public List<Card> findByDeckResidencia(Deck deck) {
        return repositorio.findByDeckResidencia(deck);
    }
    

   
}
