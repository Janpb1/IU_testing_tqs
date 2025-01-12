@Address
Feature: Añadir dirección a la cuenta

		Scenario: Añadir dirección válida a la cuenta
		 	Given Estoy en la página de inicio de sesión
		  When Cierro el banner de bienvenida
		  And Introduzco un correo electrónico y contraseña válidos
		  And Hago clic en el botón de inicio de sesión
		  Then Debería ser redirigido a la página principal
		  When Clicas al botón de cuenta
		  And Clicas a la opción de Orders y Payment
		  And Clicas a la opción de mis direcciones
		  And Clicas al botón de nueva dirección
		  And Rellenas los datos de tu nueva dirección
		  And Clicas Submit
		  Then Redirige a la página de direcciones guardadas