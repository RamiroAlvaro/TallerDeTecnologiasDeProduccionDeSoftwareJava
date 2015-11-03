<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
<head>
        <%@include file="head.jsp" %>  

</head>
<body>
	<s:fielderror />
    	     

	<form class="form-horizontal" action="registracion" method="post">
            <fieldset>

                <!-- Registro de usuario -->
                <legend><h1>Registro de usuario</h1></legend>

                <!-- Nombre-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="textinput">Nombre</label>  
                    <div class="col-md-4">
                        <s:textfield id="textinput" name="nombre" placeholder="Juan" cssClass="form-control input-md"/>
                        
                    </div>
                </div>

                <!-- Apellido-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="textinput">Apellido</label>  
                    <div class="col-md-4">
                        <s:textfield id="textinput" name="apellido" placeholder="Gimenez" cssClass="form-control input-md"/>
                       
                         
                    </div>
                </div>

                <!-- Telefono-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="textinput">Telefono</label>  
                    <div class="col-md-4">
                         <s:textfield id="textinput" name="telefono" placeholder="0221-4717711" cssClass="form-control input-md"/>
                        
                          
                    </div>
                </div>

                <!-- E-mail-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="textinput">E-mail</label>  
                    <div class="col-md-4">
                        <s:textfield id="textinput" name="email" placeholder="tallerjava@ejemplo.com" cssClass="form-control input-md"/>
                        
                         
                    </div>
                </div>

                <!-- Clave-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="passwordinput">Clave</label>
                    <div class="col-md-4">
                        <s:textfield id="passwordinput" name="clave" type="password" placeholder="" cssClass="form-control input-md"/>

                        
                    </div>
                </div>



                <!-- Avatar --> 
                <div class="form-group">
                    <label class="col-md-4 control-label" for="filebutton">Avatar</label>
                    <div class="col-md-4">
                        <s:textfield id="filebutton" name="foto" type="file" cssClass="input-file"/>
                   
                    </div>
                </div>

                <!-- Boton doble -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="button1id"></label>
                    <div class="col-md-8">
                       <s:submit value="Enviar" cssClass="btn btn-primary"></s:submit>

                      
                    </div>
                </div>

            </fieldset>
        </form>
</body>
</html>