<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>
<%@page import="br.edu.unicid.bean.Usuario" %>

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
    <title>Consulta Usuario</title>
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
        </nav>
      </div><!-- Fim da barra menu -->
    </header>

    <div class="parallax" style="height: auto;">          
      <br><br> 
      <div class="container" id="nav-container" style="height: auto;">   
        <br><br>  
        <div class="row">
          <div class="col-sm-2">
          </div>
          <div class="col-sm-8">
            <div class="card" style="height: auto;">          
              <div class="card-body">
                <h5 class="card-title">Consultar Usuario</h5>
                <br>
                <jsp:useBean id="usuario" scope="session" class="br.edu.unicid.bean.Usuario" />
                  <form action="ServletUsuario?cmd=atualizar" method="post">                  
                    <div class="form-group">
                      <label>Co?digo:</label>
                      <input type="text" class="form-control" name="codUsuario" size="60" maxlength="60"
                      value="<%=usuario.getCodUsuario()%>" readonly="readonly"><br>
                      <label>Nome:</label>
                      <input type="text" class="form-control" name="nomeUsuario" size="60" maxlength="60"
                      value="<%=usuario.getNomeUsuario()%>" readonly="readonly"><br>                                          
                      <label>E-mail:</label>
                      <input type="text" class="form-control" name="emailUsuario" size="60"
                      maxlength="60" value="<%=usuario.getEmailUsuario()%>"
                      readonly="readonly">
                      <br>
                      <label>Senha:</label>
                      <input type="text" class="form-control" name="senhaUsuario" size="60" maxlength="60"
                      value="<%=usuario.getSenhaUsuario()%>" readonly="readonly"><br>                      
                    </div>                                                              
                    <a href="index.jsp" class="btn btn-outline-dark">Pagina Inicial</a>
                  </form> 
              </div>
            </div>
          </div>
          <br>
        </div>     
      </div><br><br><br>
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