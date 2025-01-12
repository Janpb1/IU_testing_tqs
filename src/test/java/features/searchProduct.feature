Feature: Buscar en el buscador

Scenario: Buscar la palabra teclado y que se encuentren resultados
  Given estoy en página de inicio
  When Cierro el banner de bienvenida
  When el usuario pulsa el banner de busqueda
  And introduce la palabra juice
  Then aparecen los resultados

Scenario: Buscar la palabra teclado y que se encuentren resultados
  Given estoy en página de inicio
  When Cierro el banner de bienvenida
  When el usuario pulsa el banner de busqueda
  And introduce la palabra teclado
  Then no aparecen resultados