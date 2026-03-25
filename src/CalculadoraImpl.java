import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// IMPLEMENTACIÓN
// Aquí se define el *cómo* se ejecuta cada operación.
// Extiende UnicastRemoteObject para poder recibir llamadas remotas.
// Implementa CalculadoraInterface para cumplir el "contrato".
public class CalculadoraImpl extends UnicastRemoteObject implements CalculadoraInterface{
    
    // Constructor obligatorio que lanza RemoteException.
    // Llama a super() para que UnicastRemoteObject registre
    // este objeto y lo ponga a escuchar en la red.
    public CalculadoraImpl() throws RemoteException {
        super();
    }

    // Suma: La operación más simple, retorna a + b
    @Override
    public double sumar(double a, double b) throws RemoteException {
        double resultado = a + b;
        System.out.println("[Servidor] " + a + " + " + b + " = " + resultado);
        return resultado;
    }

    // Resta: Retorna a - b
    @Override
    public double restar(double a, double b) throws RemoteException {
        double resultado = a - b;
        System.out.println("[Servidor] " + a + " - " + b + " = " + resultado);
        return resultado;
    }

    // Multiplicación: Retorna a * b
    @Override
    public double multiplicar(double a, double b) throws RemoteException {
        double resultado = a * b;
        System.out.println("[Servidor] " + a + " * " + b + " = " + resultado);
        return resultado;
    }

    // División: Valida que el divisor no sea cero antes de dividir.
    // Si b == 0, lanza una excepción con mensaje descriptivo. 
    // Esta excepción viaja de vuelta al cliente por la red.
    @Override
    public double dividir(double a, double b) throws RemoteException {
        if (b == 0) {
            throw new RemoteException("Error: No se puede dividir entre 0.");
        }
        double resultado = a / b;
        System.out.println("[Servidor] " + a + " / " + b + " = " + resultado);
        return resultado;
    }
}
