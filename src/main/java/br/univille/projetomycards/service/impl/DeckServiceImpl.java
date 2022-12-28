package br.univille.projetomycards.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projetomycards.entity.Deck;
import br.univille.projetomycards.repository.DeckRepository;
import br.univille.projetomycards.service.DeckService;

@Service
public class DeckServiceImpl implements DeckService{
    @Autowired
    private DeckRepository repositorio;

    @Override
    public List<Deck> getAll() {
        return repositorio.findAll();
    }

    @Override
    public Deck save(Deck deck) {
        return repositorio.save(deck);
    }

    @Override
    public Deck findById(long id) {
        var resultado = repositorio.findById(id);
        if(resultado.isPresent()){
            return resultado.get();
        }
        return new Deck();
    }

    @Override
    public void delete(long id) {
        repositorio.deleteById(id);
    }
    
}
