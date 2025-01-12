@ExitSession
Feature: Cerrar sesión

	Scenario:
		Given Estoy en la página de inicio de sesión
	  When Cierro el banner de bienvenida
	  And Introduzco un correo electrónico y contraseña válidos
	  And Hago clic en el botón de inicio de sesión
	  Then Debería ser redirigido a la página principal
	  When Clicas al botón de cuenta
	  And Clicas al botón de cerrar sesión
	  Then Debería ser redirigido a la página principal
	  When Clicas al botón de cuenta
	  Then Aparece el botón de loguear
	  
	  
	  