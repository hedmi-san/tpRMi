package serverrmi;
import java.rmi.*;

public interface Interface extends Remote{
    public double[] secondDegreeQuadraticEquation(int x,int y,int z)throws RemoteException;
}
