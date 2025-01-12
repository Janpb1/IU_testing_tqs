@SupportChat
Feature: Chat de soporte mediante IA

	Scenario:
	Given Estoy en la página de inicio de sesión
	  When Cierro el banner de bienvenida
	  And Introduzco un correo electrónico y contraseña válidos
	  And Hago clic en el botón de inicio de sesión
	  Then Debería ser redirigido a la página principal
	  When Abro el menu desplegable de la izquierda
	  And Clico en el icono de chat de soporte
		And Estoy en la página de soporte
		And Escribo hola
		Then Recibo un mensaje del bot
		
		
		