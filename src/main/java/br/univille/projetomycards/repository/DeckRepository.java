package br.univille.projetomycards.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.projetomycards.entity.Deck;

@Repository
public interface DeckRepository 
        extends JpaRepository<Deck,Long>{
    
}
