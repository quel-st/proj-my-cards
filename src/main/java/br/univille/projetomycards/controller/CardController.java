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

import br.univille.projetomycards.entity.Card;
import br.univille.projetomycards.service.DeckService;
import br.univille.projetomycards.service.CardService;

@Controller
@RequestMapping("/cards")
public class CardController {
    
    @Autowired
    private CardService service;

    @Autowired
    private DeckService deckService;

    @GetMapping
    public ModelAndView index(){
        var listaCards = service.getAll();
        return new ModelAndView("card/index","listaCards",listaCards);
    }
    @GetMapping("/novo")
    public ModelAndView novo(){
        var card = new Card();
        var listadecks = deckService.getAll();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("card",card);
        dados.put("listadecks",listadecks);
        return new ModelAndView("card/form", dados);
    }
    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id){
        var umCard = service.findById(id);
        var listadecks = deckService.getAll();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("card",umCard);
        dados.put("listadecks",listadecks);
        return new ModelAndView("card/form",dados);
    }
    @PostMapping(params = "form")
    public ModelAndView save(@Valid Card card,
                            BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            var listadecks = deckService.getAll();
            HashMap<String,Object> dados = new HashMap<>();
            dados.put("card",card);
            dados.put("listadecks",listadecks);
            return new ModelAndView("card/form",dados);
        }
        service.save(card);

        return new ModelAndView("redirect:/cards");
    }
    
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id){

        service.delete(id);

        return new ModelAndView("redirect:/cards");
    }


}
