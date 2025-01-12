Feature: Funcionalidad de registro
  
	Scenario: Registro correcto
		Given estoy en la página de registro
		When Cierro el banner de bienvenida
		And introduzco un email, contraseña dos veces y la respuesta de seguridad
		And hago clic en el boton de registro
		Then Debería ser redirigido a la página de login
		
	Scenario: Registro incorrecto
		Given estoy en la página de registro
		When Cierro el banner de bienvenida
		And introduzco un email, contraseña dos veces y me olvido de la pregunta de seguridad
		Then el botón de registro está deshabilitado