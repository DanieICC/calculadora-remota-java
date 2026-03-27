// Preguntas de Reflexión

// 7. ¿Por qué todos los métodos de la interfaz deben lanzar RemoteException?
    // Porque los métodos se ejecutan a través de una red, y pueden ocurrir errores como 
    // fallas de conexión, como tener un servidor caído, 'RemoteException' permite
    // manejar esos errores obligatoriamente.

// 8. ¿Qué pasaría si ejecutas el cliente antes que el servidor?
    // El cliente no podrá conectarse y lanzará un error, porque el servidor 
    // aún no está disponible ni registrado en el RMI.

// 9. ¿En cuál de los 4 archivos ocurre realmente el cálculo de la suma?
    // En 'CalculadoraImpl.java', ya que ahí está la implementación de las 
    // operaciones matemáticas.

// 10. ¿Para qué sirve el Registry en RMI?
    // Sirve como un directorio donde el servidor registra los objetos remotos con 
    // un nombre, y el cliente los busca usando ese nombre para obtener una referencia.

// 11. ¿Qué modificarías en el cliente si el servidor estuviera en otra computadora?
    // Se debe cambiar la dirección (host) en el método 'lookup()' para usar la IP o nombre 
    // de la computadora donde está el servidor, en lugar de 'localhost'.
