@EditProfile
Feature: Edit profile
	
	Scenario: Change account name
		Given Estoy en la página de inicio de sesión
		  When Cierro el banner de bienvenida
		  And Introduzco un correo electrónico y contraseña válidos
		  And Hago clic en el botón de inicio de sesión
		  Then Debería ser redirigido a la página principal
		  When Clicas al botón de cuenta
		  And Clicas la opción donde sale tu correo
		  Then Se te redirige a la página de tu perfil
		  When Pones un nombre nuevo de usuario
		  And Clicas Set Username
		  Then Sale tu nuevo nombre al lado de la foto
		  
		  
		  