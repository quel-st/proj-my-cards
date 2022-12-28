package br.univille.projetomycards.controller;

import java.util.HashMap;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import br.univille.projetomycards.service.CardService;
import br.univille.projetomycards.service.DeckService;

@Controller
@RequestMapping("/lista")
public class ListaController {
    
    @Autowired
    private CardService cardservice;

    @Autowired
    private DeckService deckService;

    @GetMapping
    public ModelAndView index() {
        var listacards = cardservice.getAll();
        var listadecks = deckService.getAll();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("card",listacards);
        dados.put("deck",listadecks);
        return new ModelAndView("lista/index", dados);
    }
    @GetMapping("/puxar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id){
        var umDeck = deckService.findById(id);
        var cartas = cardservice.findByDeckResidencia(umDeck);
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("deck",umDeck);
        dados.put("cartas",cartas);
        return new ModelAndView("lista/index",dados);
    }

   
    
    
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id){

        cardservice.delete(id);

        return new ModelAndView("redirect:/lista");
    }
}
