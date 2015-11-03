<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <%@include file="head.jsp" %> 
	
	
</head>
<body>
		<%@include file="menu.jsp"%>
		<s:fielderror />
		<div class="container">
    <h3>Recorridos disponibles</h3>
    <hr>
    <div class="row">
        <div class="panel panel-primary filterable">
            <div class="panel-heading">
                <h3 class="panel-title">Recorridos</h3>
                <div class="pull-right">
                   
                </div>
            </div>
            <table class="table">
                <thead>
                    <tr class="filters">
                        <th><input type="text" class="form-control" placeholder="Fecha de Publicacion" disabled></th>
                        <th><input type="text" class="form-control" placeholder="Origen" disabled></th>
                        <th><input type="text" class="form-control" placeholder="Destino" disabled></th>
                        <th><input type="text" class="form-control" placeholder="Asientos" disabled></th>
                        <th><input type="text" class="form-control" placeholder="Usuario" disabled></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                	<s:iterator value="listadoRecorridos">
                	   
	                    <tr>
	                        <td><s:property value="fechaPublicacion"/></td>
	                        <td><s:property value="origen"/></td>
	                        <td><s:property value="destino"/></td>
	                        <td><s:property value="asientos"/></td>
	                        <td><s:property value="owner.nombre"/></td>
	                        <td>
	                        	<s:url id="participarURL" action="participar">
	                        		<s:param name="recorrido_id" value="%{id}"></s:param>
 	                        		
	                        	</s:url><s:a href="%{participarURL}">Participar</s:a>
	                        	
	                        </td>                        
	                    </tr>
	                    
                    </s:iterator>               
                </tbody>
            </table>
        </div>
    </div>
    <br>    

</div>
</body>
</html>