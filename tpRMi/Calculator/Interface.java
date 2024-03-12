package serverrmi;

import java.rmi.*;
 

public interface Interface extends Remote{
    public int add(int x,int y)throws RemoteException;
    public int substract(int x,int y)throws RemoteException;
    public int multiply(int x,int y)throws RemoteException;
    public int divide(int x,int y)throws RemoteException;
}
