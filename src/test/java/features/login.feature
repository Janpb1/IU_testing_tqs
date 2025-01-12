Feature: Funcionalidad de inicio de sesión en Juice Shop

	Scenario: Inicio de sesión con credenciales válidas
	  Given Estoy en la página de inicio de sesión
	  When Cierro el banner de bienvenida
	  And Introduzco un correo electrónico y contraseña válidos
	  And Hago clic en el botón de inicio de sesión
	  Then Debería ser redirigido a la página principal
	
	Scenario: Inicio de sesión con credenciales inválidas
	  Given Estoy en la página de inicio de sesión
	  When Cierro el banner de bienvenida
	  And Introduzco un correo electrónico o contraseña inválidos
	  And Hago clic en el botón de inicio de sesión
	  Then Debería ver un mensaje de error