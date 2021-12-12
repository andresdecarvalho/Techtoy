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
    <title>TechToy | Administrativo</title>
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
        </nav>
      </div><!-- Fim da barra menu -->
    </header>

    <br>            
    <!-- Conteudo -->
    <!-- Div principal -->
    <div class="parallax">	
        <br>
		<div class="wrapper">
		    <br>
            <!-- Sidebar  -->
            <nav id="sidebar">
                <br>
                <div class="sidebar-header">
                    <br>
                    <h3>Area Administrativa</h3>
                </div>
                <ul class="list-unstyled components">
                    <li>
                        <a href="#homeSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Categoria</a>
                        <ul class="collapse list-unstyled" id="homeSubmenu">
                            <li>
                                <a href="incluirCategoria.jsp">Incluir Categoria</a>
                            </li>
                            <li>
                                <a href="consultarCategoria.jsp">Consultar Categoria</a>
                            </li>
                            <li>
                                <a href="ServletCategoria?cmd=listar">Listar Categoria</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#pageSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Produto</a>
                        <ul class="collapse list-unstyled" id="pageSubmenu">
                            <li>
                                <a href="incluirProduto.jsp">Incluir Produto</a>
                            </li>
                            <li>
                                <a href="consultarProduto.jsp">Consultar Produto</a>
                            </li>
                            <li>
                                <a href="ServletProduto?cmd=listar">Listar Produto</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#pageSubmenu2" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Usuario</a>
                        <ul class="collapse list-unstyled" id="pageSubmenu2">
                            <li>
                                <a href="incluirUsuario.jsp">Incluir Usuario</a>
                            </li>
                            <li>
                                <a href="consultarUsuario.jsp">Consultar Usuario</a>
                            </li>
                            <li>
                                <a href="ServletUsuario?cmd=listar">Listar Usuario</a>
                            </li>
                        </ul>
                    </li>
                </ul>
                <br><br><br><br><br><br><br>
            </nav>
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