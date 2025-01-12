@Language
Feature: Cambiar el idioma

		Scenario: Cambiar el idioma a catalán
		 Given estoy en página de inicio
		 When Cierro el banner de bienvenida
		 And cambio el idioma a catalan desde el icono de arriba a la derecha
		 Then el título de la página es Tots els productes