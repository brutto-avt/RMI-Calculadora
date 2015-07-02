
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import sun.rmi.registry.RegistryImpl;

public class Calculadora extends UnicastRemoteObject implements CalculadoraInterface {
    private static RegistryImpl imp;
    
    public Calculadora() throws RemoteException {
        imp = new RegistryImpl(1099);
    }

    @Override
    public long somar(long a, long b) throws RemoteException {
        return a + b;
    }

    @Override
    public long subtrair(long a, long b) throws RemoteException {
        return a - b;
    }

    @Override
    public long multiplicar(long a, long b) throws RemoteException {
        return a * b;
    }

    @Override
    public long dividir(long a, long b) throws RemoteException {
        return b > 0 ? a / b : 0;
    }
    
    public static void main(String[] args) {
        try {
            Calculadora c = new Calculadora();
            Naming.rebind("calculadora", c);
            System.out.println("Servidor registrado");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
}
