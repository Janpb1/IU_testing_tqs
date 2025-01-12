@Language
Feature: Cambiar el idioma

		Scenario: Cambiar el idioma a catalán
		 Given estoy en página de inicio
		 When Cierro el banner de bienvenida
		 And cambio el idioma a "catalan" desde el icono 3 de arriba a la derecha
		 Then el título de la página es "Tots els productes"
		 
		Scenario: Cambiar el idioma a español
		 Given estoy en página de inicio
		 When Cierro el banner de bienvenida
		 And cambio el idioma a "español" desde el icono 9 de arriba a la derecha
		 Then el título de la página es "Todos los Productos"
		 
		Scenario: Cambiar el idioma a alemán
		 Given estoy en página de inicio
		 When Cierro el banner de bienvenida
		 And cambio el idioma a "alemán" desde el icono 6 de arriba a la derecha
		 Then el título de la página es "Alle Produkte"
		 
		 
		 
		 