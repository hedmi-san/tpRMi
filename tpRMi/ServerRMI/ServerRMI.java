package serverrmi;
import java.rmi.*;
import java.rmi.registry.*;

public class ServerRMI {

    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(5000);
            Interface calculatore = new implementation();
            Interface pgcd_ppcm = new implementation();
            Interface equation = new implementation();
            Naming.rebind("rmi://localhost:5000/calculator", calculatore);
            Naming.rebind("rmi://localhost:5000/pgcd_ppcm", pgcd_ppcm);
            Naming.rebind("rmi://localhost:5000/equation", equation);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
