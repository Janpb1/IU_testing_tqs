@Github
Feature: Visitar el github

	Scenario: Visitar el github
		Given estoy en página de inicio
		When Cierro el banner de bienvenida
		And Abro el menu desplegable de la izquierda
	  And Clico en el icono del github
		Then Estoy en la página de github
	
	