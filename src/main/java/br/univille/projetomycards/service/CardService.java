package br.univille.projetomycards.service;

import java.util.List;

import br.univille.projetomycards.entity.Card;
import br.univille.projetomycards.entity.Deck;

public interface CardService {
    List<Card> getAll();
    Card save(Card card);
    Card findById(long id);
    void delete(long id);
    List<Card>  findByDeckResidencia(Deck deck);
}
