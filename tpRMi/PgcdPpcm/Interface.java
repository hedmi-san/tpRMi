package serverrmi;
import java.rmi.*;
public interface Interface extends Remote {
    public int pgcd(int x,int y)throws RemoteException;
    public int ppcm(int x,int y)throws RemoteException;
}
