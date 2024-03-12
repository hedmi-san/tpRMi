package serverrmi;
import java.rmi.*;
 

public interface Interface extends Remote{
    public int add(int x,int y)throws RemoteException;
    public int substract(int x,int y)throws RemoteException;
    public int multiply(int x,int y)throws RemoteException;
    public int divide(int x,int y)throws RemoteException;
    public double[] secondDegreeQuadraticEquation(int x,int y,int z)throws RemoteException;
    public int pgcd(int x,int y)throws RemoteException;
    public int ppcm(int x,int y)throws RemoteException;
}
