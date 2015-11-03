<nav class="navbar navbar-default" role="navigation">
  <s:action name="prepareNuevoRecorrido"/>
  <div class="container">  
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-slide-dropdown">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="index.jsp">InfoP@@l</a>
    </div>
    <div class="collapse navbar-collapse" id="bs-slide-dropdown">
        <ul class="nav navbar-nav">
            <li><a href="inicio.jsp">Inicio</a></li>
        	<li class="dropdown">
			  <a href="#" class="dropdown-toggle" data-toggle="dropdown">Menu <span class="caret"></span></a>				
			  <ul class="dropdown-menu" role="menu">         
                <s:if test="%{#session.tipo == false}">	
	                <li><a href="prepareNuevoRecorrido">Nuevo Recorrido</a></li>
	                <li><a href="listarRecorridos">Recorridos Disponibles</a></li>
	                <li><a href="listarPropuestas">Propuestas</a></li>
	                <li><a href="listarRespuestas">Respuesta a propuestas</a></li>
	                <li><a href="denuncia.jsp">Denunciar usuario</a></li> 
                 </s:if>
                 <s:else>
                <li class="divider"></li>
                <li><a href="#"></a></li>
               
	                <li><a href="nuevoEvento.jsp">Nuevo Evento Academico</a></li>
	                <li><a href="listarEventos">Eventos academicos</a></li> 
                </s:else>
              </ul>                
            </li>
        </ul>        
        <ul class="nav navbar-nav navbar-right">
            <li><a href="#"></a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown"><s:property value="#session['usuario']"/><span class="caret"></span></a>
              <ul class="dropdown-menu" role="menu">
                <li><a href="#">Ver perfil</a></li>
                <li><a href="#">Opciones</a></li>
                <li><a href="logout">Salir</a></li>                
              </ul>
            </li>
        </ul>
    </div>
  </div>
</nav>