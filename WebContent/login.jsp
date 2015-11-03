<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
  <%@include file="head.jsp" %>  
</head>
<body>
    <s:fielderror />
	<section id="login">
    <div class="container">
    	<div class="row">
    	    <div class="col-xs-12">
        	    <div class="form-wrap">
                <h1>Ya tengo cuenta InfoP@@l</h1>
                    <form role="form" action="login" method="post" id="login-form">
                        <div class="form-group">
                            <label for="email" class="sr-only">Email</label>
                        	 <s:textfield id="email" name="email" placeholder="tallerjava@ejemplo.com" cssClass="form-control"/>
                        </div>
                        <div class="form-group">
                            <label for="key" class="sr-only">Password</label>
                        	<s:textfield type="password" id="clave" name="clave" cssClass="form-control"/>
                        	
                        </div>
                        <div class="checkbox">
                            <span class="character-checkbox" onclick="showPassword()"></span>
                            <span class="label">Mostrar contraseña</span>
                        </div>
						<s:submit value="Ingresar" cssClass="btn btn-primary btn-lg btn-block"></s:submit>
                        <h1>¿Sos nuevo?</h1>
                        <a href="registracion.jsp" id="btn-login" class="btn btn-primary btn-lg btn-block">Registrate</a>
                    </form>
                    <hr>
        	    </div>
    		</div> 
    	</div> 
    </div> 
</section>

</body>
</html>