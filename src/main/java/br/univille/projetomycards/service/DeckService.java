package br.univille.projetomycards.service;

import java.util.List;

import br.univille.projetomycards.entity.Deck;

public interface DeckService {
    List<Deck> getAll();
    Deck save(Deck deck);
    Deck findById(long id);
    void delete(long id);
}
