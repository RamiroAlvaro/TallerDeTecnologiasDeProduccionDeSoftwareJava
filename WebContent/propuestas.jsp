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
		<h3>Propuestas</h3>
		<hr>
		<div class="row">
			<div class="panel panel-primary filterable">
				<div class="panel-heading">
					<h3 class="panel-title">Propuestas</h3>
					<div class="pull-right">
						
					</div>
				</div>
				<table class="table">
					<thead>
						<tr class="filters">
							<th><input type="text" class="form-control" placeholder="Viajero" disabled></th>
							<th><input type="text" class="form-control" placeholder="Origen" disabled></th>
							<th><input type="text" class="form-control" placeholder="Destino" disabled></th>
							<th><input type="text" class="form-control" placeholder="Aceptar Propuesta" disabled></th>
							<th><input type="text" class="form-control" placeholder="Rechazar Propuesta" disabled></th>
<!-- 							<th></th> -->
						</tr>
					</thead>
					<tbody>
						<s:iterator value="listadoPropuestas">
							<tr>
								<td><s:property value="viajero.nombre" /></td>
								<td><s:property value="recorrido.origen" /></td>
								<td><s:property value="recorrido.destino" /></td>
								<td><s:url id="aceptarURL" action="aceptarPropuesta">
								     <s:param name="propuesta_id" value="%{id}"></s:param>
									</s:url> <s:a href="%{aceptarURL}">Aceptar propuesta</s:a>
								</td>
								<td><s:url id="rechazarURL" action="rechazarPropuesta">
								    <s:param name="propuesta_id" value="%{id}"></s:param>
									</s:url> <s:a href="%{rechazarURL}">Rechazar propuesta</s:a>
								</td>
								
	                        	
	                        	
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</div>
		</div>
		</div>
</body>
</html>