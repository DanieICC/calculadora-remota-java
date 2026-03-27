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
            while (opcion != 5) {
                System.out.println("\n--- MENÚ ---");
                System.out.println("1. Suma");
                System.out.println("2. Resta");
                System.out.println("3. Multiplicación");
                System.out.println("4. División");
                System.out.println("5. Salir");
                System.out.print("Elige una opción: ");

                // Validar que el input sea un número entero
                if (scanner.hasNextInt()) {
                    opcion = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer
                } else {
                    System.out.println(" [!] Opción inválida. Ingresa un número del 1 al 5.");
                    scanner.nextLine();
                    continue;
                } 

                // Las opciones del 1 al 4 necesita dos números que se leen aquí.
                if (opcion >= 1 && opcion <= 4) {
                    double a = 0, b = 0;

                    System.out.println(" Número A: ");
                    // Leer y validar el primer número
                    if (scanner.hasNextDouble()) {
                        a = scanner.nextDouble();
                    } else {
                        System.out.println(" [!] Número inválido.");
                        scanner.nextLine();
                        continue;
                    }

                    System.out.println(" Número B: ");
                    // Leer y validar el segundo número
                    if (scanner.hasNextDouble()) {
                        b = scanner.nextDouble();
                        scanner.nextLine(); // Limpiar buffer
                    } else {
                        System.out.println(" [!] Número inválido.");
                        scanner.nextLine();
                        continue;
                    }

                    // Ejecutar la operación elegida
                    // Cada llamada viaja por red al servidor, que calcula y devuelve el resultado
                    switch (opcion) {
                        case 1:
                            System.out.println("  Resultado: " + a + " + " + b + " = " + calc.sumar(a, b));
                            break;
                        case 2:
                            System.out.println("  Resultado: " + a + " - " + b + " = " + calc.restar(a, b));
                            break;
                        case 3:
                            System.out.println("  Resultado: " + a + " * " + b + " = " + calc.multiplicar(a, b));
                            break;
                        case 4:
                            try {
                                System.out.println("  Resultado: " + a + " / " + b + " = " + calc.dividir(a, b));
                            } catch (Exception e) {
                                System.out.println(" [!] " + e.getMessage());
                            }
                            break;
                    } 
                    
                } else if (opcion == 5) {
                    System.out.println("Cerrando Calculadora... Hasta luego.");
                } else {
                    System.out.println(" [!] Opción no válida. Elige un número entre 1 y 5.");
                }
            }

            scanner.close();

        } catch (Exception e) {
            System.err.println("Error en el cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
