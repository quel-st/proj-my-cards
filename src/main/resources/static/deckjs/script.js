function save(){
    var nome=prompt("Digite o nome do Deck:");

    if (nome!=null)
    {
        $.ajax({
            url: "/decks/",
            method: "POST",
            success: function(nome){
               console.log(nome);
            }
        });
    }

}

(function(){
    $("#tabdecks").on("click",".js-delete", function(){
        let botaoClicado  = $(this);
        $("#btnsim").attr("data-id",botaoClicado.attr("data-id"));
        $("#modaldeck").modal("show");
    });

    $("#btnsim").on("click",function(){
        let botaoSim = $(this);
        let id = botaoSim.attr("data-id");
        $.ajax({
            url: "/decks/delete/" + id,
            method: "GET",
            success: function(){
                window.location.href="/decks";
            }
        });
    });


})();