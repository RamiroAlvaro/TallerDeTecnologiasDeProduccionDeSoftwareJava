<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>

<script src="scripts/nuevoRecorrido.js"></script>

<title>InfoP@@l</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->
    <link href="frontend/css/bootstrap.css" rel="stylesheet">
    <link href="frontend/css/bootstrap-responsive.css" rel="stylesheet">
    <link href="frontend/css/style.css" rel="stylesheet"> 
  <!--Font-->
    <link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600' rel='stylesheet' type='text/css'>
    
</head>
<body>
  <!--HEADER ROW-->
  <div id="header-row">
    <div class="container">
      <div class="row">
              <!--LOGO-->
              <div class="span3"><a class="brand" href="#"><img src="frontend/img/logo.png" alt="logo"/></a></div>
              <!-- /LOGO -->

            <!-- MAIN NAVIGATION -->  
              <div class="span9">
                <div class="navbar  pull-right">
                  <div class="navbar-inner">
                    <a data-target=".navbar-responsive-collapse" data-toggle="collapse" class="btn btn-navbar"><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></a>
                    <div class="nav-collapse collapse navbar-responsive-collapse">
                    <ul class="nav">
                        	<li><a href="registracion.jsp">Registrarse</a></li>
                        	<li><a href="login.jsp">Iniciar sesión</a></li>
	                </ul>
                  </div>

                  </div>
                </div>
              </div>
            <!-- MAIN NAVIGATION -->  
      </div>
    </div>
  </div>
  <!-- /HEADER ROW -->
    <div class="container">

  <!--Carousel
  ==================================================-->

  <div id="myCarousel" class="carousel slide">
    <div class="carousel-inner">

      <div class="active item">
        <div class="container">
          <div class="row">
            
              <div class="span6">

                <div class="carousel-caption">
                      <h1>El primer servicio de carpooling de la Facultad de Informática</h1>
                      <p class="lead">Nuestro objetivo es hacer que estudiantes y profesores se puedan trasladar con facilidad y a un bajo costo.</p>
                      
                </div>

              </div>

                <div class="span6"> <img src="frontend/img/slide/carp.jpg" alt="carpooling"></div>

          </div>
        </div>
       



      </div>

      <div class="item">
       
        <div class="container">
          <div class="row">
            
              <div class="span6">

                <div class="carousel-caption">
                      <h1>Viajes a eventos y congresos</h1>
                      <p class="lead">Con InfoP@@l podrás coordinar viajes con colegas y compañeros de forma rápida y segura.</p>
                      
                </div>

              </div>

                <div class="span6"> <img src="frontend/img/slide/eventos.png" alt="eventos"></div>

          </div>
        </div>

      </div>





    </div>
       <!-- Carousel nav -->
      <a class="carousel-control left " href="#myCarousel" data-slide="prev"><i class="icon-chevron-left"></i></a>
      <a class="carousel-control right" href="#myCarousel" data-slide="next"><i class="icon-chevron-right"></i></a>
        <!-- /.Carousel nav -->

  </div>
    <!-- /Carousel -->



<!-- Feature 
  ==============================================-->


  <div class="row feature-box">
      <div class="span12 cnt-title">
       <h1>Con InfoP@@l coordinar viajes es mucho más fácil</h1>                
      </div>

      <div class="span4">
        <img src="frontend/img/1.png">
        <h2>Es seguro</h2>
        <p>
           Nos manejamos exclusivamente en el ámbito de la Facultad. 
        </p>
      </div>

      <div class="span4">
        <img src="frontend/img/2.png">
        <h2>Ahorrás plata</h2>
        <p>
            Uno de nuestros principales objetivos es que viajar te salga mucho menos.
        </p>           
      </div>

      <div class="span4">
        <img src="frontend/img/3.png">
        <h2>Menos tránsito</h2>
        <p>
            Al compartir el transporte, se reduce potencialmente el tránsito y la contaminación que conlleva. 
        </p>       
      </div>
  </div>


<!-- /.Feature -->

  <div class="hr-divider"></div>

<!-- Row View -->


    <div class="row">
        <div class="span6"><img src="frontend/img/responsive.png"></div>

        <div class="span6">
          <img class="hidden-phone" src="frontend/img/icon4.png" alt="">
          <h1>Se adapta a cualquier dispositivo</h1>
            <p>Podés usar InfoP@@l en tu laptop, en tu celular, en tu tablet... donde quieras! </p>
        </div>
    </div>

    
</div>


<!-- /.Row View -->



<!--Footer
==========================-->

<footer>
    <div class="container">
      <div class="row">
        <div class="span6">Copyright &copy 2013 InfoP@@l | Todos los Derechos Reservados  <br>
        <small>Al servicio de la Facultad de Informática de la UNLP</small>
        </div>
        <div class="span6">
            <div class="social pull-right">
                <a href="#"><img src="frontend/img/social/googleplus.png" alt=""></a>
                <a href="#"><img src="frontend/img/social/dribbble.png" alt=""></a>
                <a href="#"><img src="frontend/img/social/twitter.png" alt=""></a>
                <a href="#"><img src="frontend/img/social/dribbble.png" alt=""></a>
                <a href="#"><img src="frontend/img/social/rss.png" alt=""></a>
            </div>
        </div>
      </div>
    </div>
</footer>

<!--/.Footer-->

  </body>
</html>