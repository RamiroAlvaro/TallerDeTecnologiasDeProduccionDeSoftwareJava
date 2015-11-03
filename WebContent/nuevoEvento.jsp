<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <%@include file="head.jsp" %>  
    </head>
    <body>  
    	
<%--     	<s:property value="#session.usrLogin"/> --%>
<%--         <s:property value="#session['tipo']"/> --%>
<%-- 		<h2>Bienvenido/a, <s:property value="#session['nombre']"/> <s:property value="#session['apellido']"/></h2>       --%>
        <%@include file="menu.jsp" %> 
        <s:fielderror /> 
          <div class="row">
    <div class="col-md-4 col-md-offset-4">
      <form class="form-horizontal" action="altaEvento" method="post">
        <fieldset>

          <!-- Form Name -->
          <legend>Nuevo Evento Académico</legend>

          <!-- Text input-->
          <div class="form-group">
            <label class="col-sm-2 control-label" for="textinput">Nombre:</label>
            <div class="col-sm-10">
              <s:textfield id="nombre" name="nombre" placeholder="nombre" cssClass="form-control"/>
            </div>
          </div>

          <!-- Text input-->
          <div class="form-group">
            <label class="col-sm-2 control-label" for="textinput">Localidad:</label>
            <div class="col-sm-10">
 				<s:textfield id="localidad" name="localidad" placeholder="localidad" cssClass="form-control"/>            </div>
          </div>

          <!-- Text input-->
          <div class="form-group">
            <label class="col-sm-2 control-label" for="textinput">Dirección:</label>
            <div class="col-sm-10">
             <s:textfield id="textinput" name="direccion" placeholder="7 numero 1180" cssClass="form-control" />
            </div>
          </div>

          <!-- Text input-->
          <div class="form-group">
	            <label class="col-sm-2 control-label" for="textinput">Fecha:</label>
	            <div class="col-sm-4">
	              <s:textfield id="textinput" name="fecha" format="dd/MM/yyyy" cssClass="form-control" />
	            </div>
          </div> 
			<div class="form-group">
	            <label class="col-sm-2 control-label" for="textinput">Descripción</label>
	            <div class="col-sm-4">
	               <s:textarea id="textarea" name="descripcion"  placeholder="descripcion" cssClass="form-control"/>
	            </div>
          </div>          
          
          <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
              <div class="pull-right">
                <s:submit value="Enviar" cssClass="btn btn-primary"></s:submit>
              </div>
            </div>
          </div>

        </fieldset>
      </form>
    </div>
    </div>
    </body>
</html>