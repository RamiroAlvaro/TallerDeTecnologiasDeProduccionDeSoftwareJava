$(document).ready(function() {
	ocultarDiario();
	ocultarPeriodico();
	ocultarPuntual();
		
});

function ocultarDiario() {
	$("#altaRecorrido_").hide();
	$("#hp1").hide();
	$("#hr1").hide();
	$("#altaRecorrido_viajeDiario_horaDeRegreso").hide();
	$("#altaRecorrido_viajeDiario_horaDePartida").hide();
	
}

function ocultarPeriodico() {
	$("#hp2").hide();
	$("#hr2").hide();
	$("#altaRecorrido_viajePeriodico_horaDePartida").hide();
	$("#altaRecorrido_viajePeriodico_horaDeRegreso").hide();
	$(".checkboxLabel").hide();
	$("input[name='viajePeriodico.dias']").hide();
}

function ocultarPuntual() {
	$("#hp3").hide();	
	$("#hr3").hide();
	$("#fe").hide();
	$("#altaRecorrido_viajePuntual_fecha").hide();
	$("#altaRecorrido_viajePuntual_horaDePartida").hide();
	$("#altaRecorrido_viajePuntual_horaDeRegreso").hide();
}

function mostrarDiario() {
	$("#altaRecorrido_").show();
	$("#hp1").show();
	$("#hr1").show();
	$("#altaRecorrido_viajeDiario_horaDeRegreso").show();
	$("#altaRecorrido_viajeDiario_horaDePartida").show();
}

function mostrarPeriodico() {
	$("#hp2").show();
	$("#hr2").show();
	$("#altaRecorrido_viajePeriodico_horaDePartida").show();
	$("#altaRecorrido_viajePeriodico_horaDeRegreso").show();
	$(".checkboxLabel").show();
	$("input[name='viajePeriodico.dias']").show();
}

function mostrarPuntual() {
	$("#hp3").show();	
	$("#hr3").show();
	$("#altaRecorrido_viajePuntual_fecha").show();
	$("#altaRecorrido_viajePuntual_horaDePartida").show();
	$("#altaRecorrido_viajePuntual_horaDeRegreso").show();
	$("#fe").show();
}

function mostrar(opcion) {
	
	if (opcion == 'Viaje_diario') {
		mostrarDiario();
		ocultarPeriodico();
		ocultarPuntual();
	}
	else {
		if (opcion == 'Viaje_periodico') {
			mostrarPeriodico();
			ocultarDiario();
			ocultarPuntual();
		}
		else if (opcion == 'Viaje_puntual'){
			mostrarPuntual();
			ocultarDiario();
			ocultarPeriodico();
		}
	}

}

