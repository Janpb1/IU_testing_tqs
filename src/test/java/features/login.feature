Feature: Login en The Internet

  Scenario: Login exitoso
    Given que el usuario está en la página de login
    When introduce un usuario válido "tomsmith" y contraseña válida "SuperSecretPassword!"
    Then debería ver un mensaje de éxito "You logged into a secure area!"

  Scenario: Login fallido
    Given que el usuario está en la página de login
    When introduce un usuario inválido "usuario123" y contraseña inválida "password123"
    Then debería ver un mensaje de error "Your username is invalid!"