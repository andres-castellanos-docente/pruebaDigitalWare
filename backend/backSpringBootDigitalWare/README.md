# back DigitalWare Andres Castellanos

Se debe instalar postgresql

Se debe crear la base de datos "pruebadw"
Se debe crear el  usuario de base de datos
"usrprueba" clave "12345678"


se debe iniciar el servidor para que jpa cree las tablas(validar parametros de conexion en archivo application.properties de springboot)


detener servidor y ejecutar el script para crear el usuario restfull


se debe crear un usuario en la tabla usuariosrest

usuario 'admin'
clave '12345678'
encriptada  '$2a$10$1dCKuQoQqbBNCK.Rb8XQSemwqdHdVAcCTb1kUQLg2key/4VX./TvS'


INSERT INTO public.usuariosrest ( activo, email, password, username) VALUES ( true, NULL, '$2a$10$1dCKuQoQqbBNCK.Rb8XQSemwqdHdVAcCTb1kUQLg2key/4VX./TvS', 'admin');
