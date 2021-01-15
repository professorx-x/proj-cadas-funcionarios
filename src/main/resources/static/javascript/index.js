function alerta(cargo)
{
	$.post
    (
        "pesquisa_cargo",
        {resposta: cargo},
        function(total_post)
        {
            $("#conteudo").html(total_post);
        }
    );
}

function acha_id()
{
	var acha_id = document.getElementById('acha_id').value;
	
	$.post
    (
        "pesquisa_id",
        {resposta: acha_id},
        function(total_post)
        {
            //alert(total_post);
            $("#conteudo2").html(total_post);
        }
    );
}