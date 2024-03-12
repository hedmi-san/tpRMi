package clientrmi;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.rmi.*;
import serverrmi.Interface;
import javax.swing.*;
public class ClientRMI {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setTitle("Calculator");
        f.setSize(400, 400);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextField textFieldOne = new JTextField();
        textFieldOne.setBounds(150, 20, 100, 35);
        JLabel l1 = new JLabel("First number -a- :");
        l1.setBounds(0, 20, 140, 30);
        JTextField textFieldTwo = new JTextField();
        textFieldTwo.setBounds(150, 70, 100, 35);
        JLabel l2 = new JLabel("Second number -b- :");
        l2.setBounds(0, 70, 140, 30);
        JButton sum = new JButton("sum");
        sum.setBounds(300, 20, 70, 30);
        JButton sub = new JButton("sub");
        sub.setBounds(300, 60, 70, 30);
        JButton mul = new JButton("mul");
        mul.setBounds(300, 100, 70, 30);
        JButton div = new JButton("div");
        div.setBounds(300, 140, 70, 30);
        f.add(textFieldOne);
        f.add(l1);
        f.add(textFieldTwo);
        f.add(l2);
        f.add(sum);
        f.add(sub);
        f.add(mul);
        f.add(div);
        f.setLayout(null);
        f.setVisible(true);
        sum.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a=0,b=0;
                String valueOne = textFieldOne.getText();
                String valueTwo = textFieldTwo.getText();
                a = Integer.parseInt(valueOne);                 
                b = Integer.parseInt(valueTwo);
                try{  
                Interface stub=(Interface)Naming.lookup("rmi://Localhost:5000/calculator"); 
                int x = stub.add(a,b);
                JOptionPane.showMessageDialog(null, "The result is : " + x);
                }catch( MalformedURLException | NotBoundException | RemoteException ee){}
                }
        });
        sub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a=0,b=0;
                String valueOne = textFieldOne.getText();
                String valueTwo = textFieldTwo.getText();
                a = Integer.parseInt(valueOne);                 
                b = Integer.parseInt(valueTwo);
                try{  
                Interface stub=(Interface)Naming.lookup("rmi://Localhost:5000/calculator"); 
                int x = stub.substract(a,b);
                JOptionPane.showMessageDialog(null, "The result is : " + x);
                }catch( MalformedURLException | NotBoundException | RemoteException ee){}
                }
        });
        mul.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a=0,b=0;
                String valueOne = textFieldOne.getText();
                String valueTwo = textFieldTwo.getText();
                a = Integer.parseInt(valueOne);                 
                b = Integer.parseInt(valueTwo);
                try{  
                Interface stub=(Interface)Naming.lookup("rmi://Localhost:5000/calculator"); 
                int x = stub.multiply(a,b);
                JOptionPane.showMessageDialog(null, "The result is : " + x);
                }catch( MalformedURLException | NotBoundException | RemoteException ee){}
                }
        });
        div.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a=0,b=0;
                String valueOne = textFieldOne.getText();
                String valueTwo = textFieldTwo.getText();
                a = Integer.parseInt(valueOne);                 
                b = Integer.parseInt(valueTwo);
                try{  
                Interface stub=(Interface)Naming.lookup("rmi://Localhost:5000/calculator"); 
                int x = stub.divide(a,b);
                JOptionPane.showMessageDialog(null, "The result is : " + x);
                }catch( MalformedURLException | NotBoundException | RemoteException ee){}
                }
        });
    }
}
