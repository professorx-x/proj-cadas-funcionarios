function achando_funcionario()
{
	var nome = document.getElementById('nome').value;
	
	if(nome != "")
	{
		$.post
	    (
	        "atualizando_cadastro_nome",
	        {nome: nome},
	        function(resposta)
	        {
	            //alert(resposta);
	            if(resposta != "")
	            {
					var array_string = resposta.split("-");
		            
		            var id = array_string[0];
		            var nome2 = array_string[1];
		            var cargo2 = array_string[2];
		            var dataNascimento = array_string[3];
		            var sexo = array_string[4];
		            var dataCadastro = array_string[5];
		            
		            var marcado = document.getElementsByName('sexo');
		           	
		           	
		            for(var i = 0; i < marcado.length; i++)
		            {
		            	if(marcado[i].value == sexo)
		            	{
		            		marcado[i].checked = true;
		            	}
		            }
		            
		            document.getElementById('id').value = id;
		            document.getElementById('nome1').value = nome2;
		            document.getElementById('nome2').value = nome2;
		            document.getElementById('cargo2').value = cargo2;
		            document.getElementById('dataNascimento').value = dataNascimento;
		            document.getElementById('dataCadastro').value = dataCadastro;
		      	}
		    	else
		    	{
		    		alert("O nome não foi encontrado");
		    		
		    		document.getElementById('id').value = "";
		    		document.getElementById('nome1').value = "";
		    		document.getElementById('nome2').value = "";
		            document.getElementById('cargo2').value = "";
		            document.getElementById('dataNascimento').value = "";
		            document.getElementById('dataCadastro').value = "";
		            
		            var marcado = document.getElementsByName('sexo');
		            
		            for(var i = 0; i < marcado.length; i++)
		            {
		            	marcado[i].checked = false;
		            }
		    	}        
	        }
	    );
	}
	else
	{
		alert("Espaço do nome não pode ficar em branco");
	}
}

function acha_id()
{
	var acha_id = document.getElementById('acha_id').value;
	
	$.post
    (
        "atualizando_cadastro_id",
        {id: acha_id},
        function(resposta)
        {
            //alert(resposta);
	            if(resposta != "")
	            {
					var array_string = resposta.split("-");
		            
		            var id = array_string[0];
		            var nome2 = array_string[1];
		            var cargo2 = array_string[2];
		            var dataNascimento = array_string[3];
		            var sexo = array_string[4];
		            var dataCadastro = array_string[5];
		            
		            var marcado = document.getElementsByName('sexo');
		           	
		           	
		            for(var i = 0; i < marcado.length; i++)
		            {
		            	if(marcado[i].value == sexo)
		            	{
		            		marcado[i].checked = true;
		            	}
		            }
		            
		            document.getElementById('id').value = id;
		            document.getElementById('nome1').value = nome2;
		            document.getElementById('nome2').value = nome2;
		            document.getElementById('cargo2').value = cargo2;
		            document.getElementById('dataNascimento').value = dataNascimento;
		            document.getElementById('dataCadastro').value = dataCadastro;
		      	}
		    	else
		    	{
		    		alert("O ID não foi encontrado");
		    		
		    		document.getElementById('id').value = "";
		    		document.getElementById('nome1').value = "";
		    		document.getElementById('nome2').value = "";
		            document.getElementById('cargo2').value = "";
		            document.getElementById('dataNascimento').value = "";
		            document.getElementById('dataCadastro').value = "";
		            
		            var marcado = document.getElementsByName('sexo');
		            
		            for(var i = 0; i < marcado.length; i++)
		            {
		            	marcado[i].checked = false;
		            }
		    	}
        }
    );
}