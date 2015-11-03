<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <%@include file="head.jsp" %>  
    
    </head>
    <body>  
<%--     	<s:property value="#session.perfil"/> --%>
<%-- 		<h2>Bienvenido/a, <s:property value="#session['nombre']"/> <s:property value="#session['apellido']"/></h2>        --%>
        <%@include file="menu.jsp" %> 
       <s:fielderror />
<div class="container">
    <h3>Administracion de eventos academicos</h3>
    <hr>
    <p><a href="nuevoEvento.jsp">Nuevo evento academico</a></p>
    <div class="row">
        <div class="panel panel-primary filterable">
            <div class="panel-heading">
                <h3 class="panel-title">Eventos</h3>
                <div class="pull-right">

                </div>
            </div>
	            <table class="table">
	                <thead>
	                    <tr class="filters">
	                        <th><input type="text" class="form-control" placeholder="Id" disabled></th>
	                        <th><input type="text" class="form-control" placeholder="Nombre" disabled></th>
	                        <th><input type="text" class="form-control" placeholder="Direccion" disabled></th>
	                        <th><input type="text" class="form-control" placeholder="Localidad" disabled></th>
							<th><input type="text" class="form-control" placeholder="Fecha" disabled></th>
							<th><input type="text" class="form-control" placeholder="Descripcion" disabled></th>
							<th><input type="text" class="form-control" placeholder="Estado" disabled></th>
							
	                    </tr>
	                </thead>
	                <tbody>
	               	<s:iterator value="listadoEventos">
	                    <tr>    
	                    	<td><s:property value="id" /></td>       
	                    	<td><s:property value="nombre" /></td>  
	                    	<td><s:property value="direccion" /></td>  
	                    	<td><s:property value="localidad" /></td>
	                    	<td><s:property value="fecha" /></td>
	                    	<td><s:property value="descripcion" /></td>
	                    	<td><s:property value="estado" /></td>     
	                                                
	                    </tr>                    
	                </s:iterator>
	                </tbody>
	                
	            </table>

        </div>
    </div>
</div>
</body>
</html>