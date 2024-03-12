
package clientrmippcmpgcd;
import java.awt.event.*;
import java.net.MalformedURLException;
import javax.swing.*;
import java.rmi.*;
import serverrmi.Interface;
public class ClientRMIPPCMPGCD {

    public static void main(String[] args) {
         JFrame f = new JFrame();
        f.setTitle("PGCD and PPCM calculator");
        f.setSize(400, 400);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField textFieldOne = new JTextField();
        textFieldOne.setBounds(150, 20, 100, 35);

        JTextField textFieldTwo = new JTextField();
        textFieldTwo.setBounds(150, 70, 100, 35);

        JButton btnOne = new JButton("PGCD");
        btnOne.setBounds(150, 120, 95, 30);

        JButton btnTwo = new JButton("PPCM");
        btnTwo.setBounds(150, 160, 95, 30);
        JLabel l1 = new JLabel("First number : ",JLabel.CENTER);
        l1.setBounds(0, 20, 95, 30);
        JLabel l2 = new JLabel("Second number : ",JLabel.CENTER);
        l2.setBounds(0, 70, 100, 30);
        f.add(textFieldOne);
        f.add(l1);
        f.add(textFieldTwo);
        f.add(l2);
        f.add(btnOne);
        f.add(btnTwo);
        f.setLayout(null);
        f.setVisible(true);
        btnOne.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String valueOne = textFieldOne.getText();
                String valueTwo = textFieldTwo.getText();
                int a =Integer.parseInt(valueOne);
                int b = Integer.parseInt(valueTwo);
                try{  
                Interface stub =(Interface)Naming.lookup("rmi://Localhost:5000/pgcd_ppcm"); 
                int x = stub.pgcd(a,b);
                JOptionPane.showMessageDialog(null, "The result is : " + x);
                }catch( MalformedURLException | NotBoundException | RemoteException ee){} 
            }
        });
        btnTwo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String valueOne = textFieldOne.getText();
                String valueTwo = textFieldTwo.getText();
                int a =Integer.parseInt(valueOne);
                int b = Integer.parseInt(valueTwo);
                try{  
                Interface stub =(Interface)Naming.lookup("rmi://Localhost:5000/pgcd_ppcm"); 
                int x = stub.ppcm(a,b);
                JOptionPane.showMessageDialog(null, "The result is : " + x);
                }catch( MalformedURLException | NotBoundException | RemoteException ee){} 
            }
        });
    }
    
}
