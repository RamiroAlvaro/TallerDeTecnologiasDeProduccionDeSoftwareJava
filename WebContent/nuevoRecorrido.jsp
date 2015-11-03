<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<%@include file="head.jsp"%>


<script src="scripts/nuevoRecorrido.js"></script>

<title>InfoP@@l</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>


	<%@include file="menu.jsp"%>
	<s:fielderror />
	<div class="container">
		<s:form action="altaRecorrido" method="post">

			<div class="row setup-content" id="step-1">
				<div class="col-xs-12">
					<div>

						<div class="row">
							<div class="col-md-6">
								<div>
									<fieldset>
										<legend class="text-center header">Nuevo Recorrido</legend>
										<div class="form-group">
											<div class="col-md-10 col-md-offset-1">
												<s:textfield name="origen" placeholder="Origen"
													class="form-control" />
											</div>
										</div>
										<div class="form-group">
											<div class="col-md-10 col-md-offset-1">
												<s:textfield name="destino" placeholder="Destino"
													class="form-control" />
											</div>
										</div>
										<div class="form-group">
											<div class="col-md-10 col-md-offset-1">
												<s:textfield name="asientos"
													placeholder="Cantidad de asientos" />
											</div>
										</div>
										
										<div class="form-group" id="listadoeventos">
											<div class="col-md-10 col-md-offset-1">												
												 <%-- <s:action name="listarEventos" executeResult="false" > --%>												
												<%-- <s:select list="#attr.listadoEventos" name="evento" label="Evento asociado:" id="listaeventos"/> --%>
												<s:select list="listadoEventos" name="eventoId" label="Evento asociado:" id="listaeventos" listKey="id" listValue="nombre"/>
												<%-- </s:action> --%>
											</div>
										</div>
									</fieldset>

								</div>
							</div>
							<div class="col-md-6">
								<div>
									<div class="panel panel-default">
										<div class="text-center header"></div>
									</div>
								</div>
							</div>
						</div>
						<h1 class="text-center"></h1>
					</div>
				</div>
			</div>

			<div class="col-xs-12">
				<div>
					<h1 class="text-center"></h1>

					<div class="form-group">
						<s:radio name="tipo_recorrido"
							list="{'Viaje_diario','Viaje_periodico','Viaje_puntual'}"
							onChange="mostrar(this.value)" />
					</div>
					<div id="diario">
						<s:label value="Hora de partida:" id="hp1" />
						<s:textfield name="viajeDiario.horaDePartida" type="time" />
						<s:label value="Hora de regreso:" id="hr1" />
						<s:textfield name="viajeDiario.horaDeRegreso" type="time" />
					</div>
					<div id="periodico">
						<s:checkboxlist name="viajePeriodico.dias" label="Días:"
							list="{'lunes','martes','miercoles','jueves','viernes'}" />
						<br>
						<s:label value="Hora de partida:" id="hp2" />
						<s:textfield name="viajePeriodico.horaDePartida" type="time" />
						<s:label value="Hora de regreso:" id="hr2" />
						<s:textfield name="viajePeriodico.horaDeRegreso" type="time" />
					</div>
					<div id="puntual">
						<s:label value="Fecha:" id="fe" />
						<s:textfield name="viajePuntual.fecha" />
						<s:label value="Hora de partida:" id="hp3" />
						<s:textfield name="viajePuntual.horaDePartida" type="time"/>
						<s:label value="Hora de regreso:" id="hr3" />
						<s:textfield name="viajePuntual.horaDeRegreso" type="time" />
					</div>

					<s:submit value="Enviar" />
				</div>
			</div>

		</s:form>
	</div>
</body>
</html>