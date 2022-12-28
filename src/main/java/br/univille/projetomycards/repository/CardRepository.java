package br.univille.projetomycards.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.univille.projetomycards.entity.Card;
import br.univille.projetomycards.entity.Deck;

@Repository
public interface CardRepository 
    extends JpaRepository<Card,Long>{
    /*select * from cliente where nome like '%zinho%' */
    List<Card> findByNomeIgnoreCaseContaining(@Param("nome") String nome);
    List<Card> findByDeckResidencia(Deck deck);
}
