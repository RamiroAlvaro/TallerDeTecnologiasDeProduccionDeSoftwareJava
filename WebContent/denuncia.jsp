<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<%@include file="head.jsp"%>

<title>InfoP@@l</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
	<%@include file="menu.jsp"%>
	<s:fielderror />
	<div class="container">
		<legend class="header">Denunciar usuario</legend>
		<div class="row">
			<div class="col-sm-4 col-md-4">
				<div class="panel panel-default">
					<div class="panel-body">
						<s:form action="denunciar" method="post">
							<s:textarea name="texto"
								placeholder="Escriba aquí el nombre del usuario al que desea denunciar y el motivo de la denuncia"
								cols="30" rows="5" />
							<s:submit value="Enviar denuncia" />
						</s:form>
					</div>
				</div>
			</div>
		</div>

		
	</div>
</body>
</html>