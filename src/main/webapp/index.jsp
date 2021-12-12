<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="br.edu.unicid.bean.Produto" %>
<%@ page import="br.edu.unicid.bean.Categoria" %>
<%@ page import="br.edu.unicid.dao.ProdutoDao" %>
<%@ page import="br.edu.unicid.dao.CategoriaDao" %>

<!DOCTYPE html>

<html lang="pt-br">

  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Fontes -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Ubuntu&display=swap" rel="stylesheet">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <!-- CSS -->
    <link rel="stylesheet" type="text/css" href="./css/css.css">
    <title>TechToy | Brinquedos</title>
  </head>   <!-- id = # / class = . -->

  <body>

    <header>
      <!-- Barra Menu -->
      <div class="container" id="nav-container">
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
        <a class="navbar-brand" href="index.jsp"><img id="logo" src="./imgs/logo_novo.png" alt="TechToy" style="width:40px"><b> | TechToy</b></a>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-links" 
          aria-controls="navbar-links" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse justify-content-end" id="navbar-links" >
            <div class="navbar-nav">
              <a href="login.jsp" class="nav-item nav-link" id="about-menu" style="color: azure;">Area Administrativa</a>
            </div>
          </div>                 
        </nav>
      </div><!-- Fim da barra menu -->
    </header>

    <br>            
    <!-- Conteudo -->
    <!-- Div principal -->
    <div class="parallax" style="height: auto;">
		  <div class="wrapper" style="height: auto; width:250px;">
		    
        <!-- Sidebar  -->
        <nav id="sidebar">
		      <br>
          <div class="sidebar-header">
			      <br>
            <h3>Categoria de Produtos</h3>
          </div>
            <ul class="list-unstyled components">
            <li><a href = "index.jsp">	Todas as categorias</a></li>
              <li>							
              <%
				CategoriaDao dao = new CategoriaDao();
				List <Categoria> lista = new ArrayList<Categoria>();
				lista = (ArrayList)dao.todosCategorias();
				//List <Categoria> lista = new ArrayList<Categoria>();
				//lista = (ArrayList)request.getAttribute("categoriasList");
				for(Categoria a: lista){%>
					<a href=<%="ServletProduto?cmd=filtrar&codCategoria=".concat(String.valueOf(a.getCodCategoria()))%>>&nbsp&nbsp&nbsp<%=a.getNomeCategoria()%></a>		
					<%
					}
				%>
              </li>
            </ul>         
        </nav>

        <!-- Page Content  -->
        <br>

        <div>
    
    <br><br>
    
			<div class="container" style="height: auto; width:auto;">
			
			<br>
			
			<div class="row" style="height: auto; width:1050px;">
			
				    <%
					ProdutoDao daop = new ProdutoDao();
					List <Produto> listap = new ArrayList<Produto>();
					listap = (ArrayList)daop.todosProdutos();
					for(Produto a: listap){%>
			
				<div class="col-md-4">
				
					<div class="card" style="height: auto; width:300px; border-radius: 20px;">					  
					    <div class="card-body"><br>
					    <img src= "<%=a.getFotoProduto()%>" style="height:150px; width:150px;"><br><br>
					      <h6 class="card-title"><b><%=a.getNomeProduto()%></b></h6>
					      <h7 class="card-title"><%=a.getDescProduto()%></h7><br><br>
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
  								<path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
							</svg>
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
  								<path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
							</svg>
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
  								<path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
							</svg>
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
  								<path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
							</svg>
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
  								<path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
							</svg><br><br>
					      <h7 class="card-title"><b>R$&nbsp<%=a.getPrecoProduto()%></b></h7><br><br>
					      <a href=<%="ServletProduto?cmd=descricao&idProduto=".concat(String.valueOf(a.getIdProduto()))%> type="submit" class="btn btn-outline-dark">Veja mais</a>
					    </div>
					  </div> 
					  <br>
				
				</div>
				
					<%
					}
					%> 
				
			</div>
			
			</div>
               
      </div>

     </div>
      
      </div>
			   		     
    <!-- Footer -->   
    <footer id="row-footer" class="navbar-dark bg-dark">
      <div class="container">
        <br>
        <div class="row">
          <div class="col-md-12 col-sm-12 col-xs-12">
            <p class="copyright-text">Copyright &copy; 2021 Todos os direitos reservados a TechToy | Site com fins educativos</p>
          </div>
        </div>
      </div>
    </footer> <!-- Fim do footer -->
    <!-- Scripts -->           
    <!-- JavaScript Opcional do Bootstrap-->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="/js/js.js"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

  </body>

</html>