Feature: Enviar una valoracion

        Scenario: Enviar una valoracion con comentarios
             Given estoy en página de inicio
             When Cierro el banner de bienvenida
             And Abro el menu desplegable de la izquierda
             And voy a la seccion customer feedback
             And relleno el formulacion con la informacion
             And le doy al botón de enviar
             Then aparece un pequeño banner en la parte inferior

         Scenario: Enviar una valoracion erronea sin todos los campos llenos
             Given estoy en página de inicio
             When Cierro el banner de bienvenida
             And Abro el menu desplegable de la izquierda
             And voy a la seccion customer feedback
             And le doy al botón de enviar
             Then no puedo pulsar el boton porque no esta activo