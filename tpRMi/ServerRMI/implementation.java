package serverrmi;
import java.rmi.*;
import java.rmi.server.*;

public class implementation extends UnicastRemoteObject implements Interface{
    public implementation()throws RemoteException{
    super();
    }
    public int add(int x,int y){
        return x+y;
    }
    public int substract(int x , int y){
        return x-y;
    }
    public int multiply(int x , int y){
        return x*y;
    }
    public int divide(int x , int y){
        if(y == 0)
            return 0;
        return x/y;  
    }
    public double[] secondDegreeQuadraticEquation(int a, int b, int c) {
    double x = Math.pow(b, 2) - 4 * a * c;
    double[] result = new double[2];
    if (x > 0) {
        result[0] = (-b + Math.sqrt(x)) / (2 * a);
        result[1] = (-b - Math.sqrt(x)) / (2 * a);
    } else if (x == 0) {
        result[0] = -b / (2 * a);
        result[1] = result[0];
    } else {
        result[0] = Double.NaN;
        result[1] = Double.NaN;
    }
    return result;
}
    public int pgcd(int a,int b){
        int result = 1;
        for (int i = 2; i <= a; i++) 
            if((a%i==0)&&(b%i==0))
                result=i;
        return result;
    }
    public int ppcm(int a,int b){
    int result = pgcd(a, b);
    result = (a * b) / result;
    return result;
    }

}
