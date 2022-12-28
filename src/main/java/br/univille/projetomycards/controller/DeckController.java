package br.univille.projetomycards.controller;

import java.util.HashMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.projetomycards.entity.Deck;
import br.univille.projetomycards.service.CardService;
import br.univille.projetomycards.service.DeckService;

@Controller
@RequestMapping("/decks")
public class DeckController {
    @Autowired
    private DeckService service;


    @Autowired
    private CardService cardService;

    @GetMapping
    public ModelAndView index(){
        var listaDecks = service.getAll();
        return new ModelAndView("deck/index","listaDecks",listaDecks);
    }
    @GetMapping("/novo")
    public ModelAndView novo(){
        var novaDeck = new Deck();
        var listaCards = cardService.getAll();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("listaCards",listaCards);
        dados.put("deck",novaDeck);
        return new ModelAndView("deck/form", dados);
    }
    @PostMapping(params = "form")
    public ModelAndView save(@Valid Deck deck,  BindingResult bindingResult){        
        if(bindingResult.hasErrors()){
            var listaCards = cardService.getAll();
            HashMap<String,Object> dados = new HashMap<>();
            dados.put("deck",deck);
            dados.put("listaCards",listaCards);
            return new ModelAndView("deck/form",dados);
        }

        service.save(deck);
        return new ModelAndView("redirect:/decks");
    }
    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id){
        var umaDeck = service.findById(id);

        var listaCards = cardService.getAll();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("deck",umaDeck);
        dados.put("listaCards",listaCards);

        return new ModelAndView("deck/form",dados);
    }


    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id){

        service.delete(id);

        return new ModelAndView("redirect:/decks");
    }


}
