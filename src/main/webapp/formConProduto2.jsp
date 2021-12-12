<%@ page contentType="text/html"%>
<%@ page pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="br.edu.unicid.bean.Produto" %>
<%@ page import="br.edu.unicid.bean.Categoria" %>
<%@ page import="br.edu.unicid.dao.ProdutoDao" %>
<%@ page import="br.edu.unicid.dao.CategoriaDao" %>

<!DOCTYPE html>

<html>

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
    <title>Consulta Produto</title>
  </head>

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
          <div class="collapse navbar-collapse justify-content-end" id="navbar-links"> 
	           <button class="btn btn-light" type="submit">
	               <i class="bi-cart-fill me-1"></i>
	               Carrinho
	               <span class="badge bg-white text-dark ms-1 rounded-pill">0</span>
	           </button>  
           </div>            
        </nav>
      </div><!-- Fim da barra menu -->
    </header>
    
        <br>            
    <!-- Conteudo -->
    <!-- Div principal -->
    
    <div class="parallax" style="height: auto;">
    		  <div class="wrapper">
		    <br>
    
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
               
      <br>
      <div class="container" id="nav-container" style="height: auto;">   
        <br><br><br>  
        <div class="row">
          <div class="col-sm-2">
          </div>
          <div class="col-sm-8">
            <div class="card" style="height: auto;">            
              <div class="card-body">
                <h5 class="card-title"><b>Black Fraude TechToy</b></h5>
                <br>
                <jsp:useBean id="produto" scope="session" class="br.edu.unicid.bean.Produto" />
                <form>                      
                  <div class="form-group">
                    <label><b><%=produto.getNomeProduto()%></b></label><br><br>
                    <label><%=produto.getDescProduto()%></label><br><br>
                    <input type="image" name="fotoProduto" style="height: 150px;"
                    src= "<%=produto.getFotoProduto()%>" readonly="readonly" ><br><br>                    	
                    <label><b>R$:</label><label><%=produto.getPrecoProduto()%></b></label><br>
                    <label>Em até 12 vezes no Cartão TechToy</label><br>                 
                  </div>                                                          
                  <a class="btn btn-outline-dark">Adicionar ao Carrinho</a>
                </form> 
              </div>
            </div>
          </div>
          <br>
        </div>      
      </div><br><br><br>
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