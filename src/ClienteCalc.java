import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

// CLIENTE 
// Se conecta al servidor, obtiene la calculadora remota
// y permite al usuario operar con un menú interactivo.

public class ClienteCalc {
    public static void main(String[] args) {
        try {
            // PASO 1: Conectarse al Registry del servidor.
            // "localhost" = Misma máquina. Cambiar por IP real si está en otra máquina.
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // PASO 2: Obtener el objeto remoto por su nombre clave.
            // lookup() retorna un Stub (proxy) que intercepta cada llamada
            // y la envía por red al servidor real.
            CalculadoraInterface calc = (CalculadoraInterface) registry.lookup( ("Calculadora"));

            Scanner scanner = new Scanner(System.in);
            int opcion = -1;

            System.out.println("===========================");
            System.out.println(" Calculadora RMI");
            System.out.println("===========================");

            // Bucle principal: El menú se repite hasta que el usuario elija "Salir"


            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
