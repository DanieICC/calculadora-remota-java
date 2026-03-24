import java.rmi.Remote;
import java.rmi.RemoteException;

// "extends Remote" le dice a Java que esta interfaz
// puede ser usada desde otra máquina por medio de la red.
public interface CalculadoraInterface extends Remote {

    // Cada método lanza RemoteException en caso de que
    // la llamada falle durante su viaje por la red.

    double sumar(double a, double b) throws RemoteException;

    double restar(double a, double b) throws RemoteException;

    double multiplicar (double a, double b) throws RemoteException;

    double dividir(double a, double b) throws RemoteException; // Dividir evalua si "b != 0" en la implementación.
}
