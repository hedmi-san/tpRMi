package clientrmiequation;

import javax.swing.*;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.rmi.*;
import serverrmi.Interface;

public class ClientRMIEquation {

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setTitle("Ma première fenêtre");
        f.setSize(400, 400);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextField textFieldOne = new JTextField();
        textFieldOne.setBounds(150, 20, 100, 35);
        JLabel l1 = new JLabel("First number -a- :");
        l1.setBounds(0, 20, 140, 30);
        JTextField textFieldTwo = new JTextField();
        textFieldTwo.setBounds(150, 70, 100, 35);
        JLabel l2 = new JLabel("Second number -b- :");
        l2.setBounds(0, 70, 140, 30);
        JTextField textFieldThree = new JTextField();
        textFieldThree.setBounds(150, 120, 100, 35);
        JLabel l3 = new JLabel("Third number -c- :");
        l3.setBounds(0, 120, 140, 30);
        JButton btn = new JButton("get solution");
        btn.setBounds(150, 160, 120, 30);
        f.add(textFieldOne);
        f.add(l1);
        f.add(textFieldTwo);
        f.add(l2);
        f.add(textFieldThree);
        f.add(l3);
        f.add(btn);
        f.setLayout(null);
        f.setVisible(true);
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a = 0, b = 0, c = 0;
                String valueOne = textFieldOne.getText();
                String valueTwo = textFieldTwo.getText();
                String valueThree = textFieldThree.getText();
                a = Integer.parseInt(valueOne);
                b = Integer.parseInt(valueTwo);
                c = Integer.parseInt(valueThree);
                try {
                    Interface stub = (Interface) Naming.lookup("rmi://Localhost:5000/equation");
                    double[] x = stub.secondDegreeQuadraticEquation(a, b, c);
                    if (Double.isNaN(x[0])) {
                        JOptionPane.showMessageDialog(null, "This equation doesn't have a real solution");
                    } else if (x[0] != x[1]) {
                        String solution1 = String.format("%.2f", x[0]);
                        String solution2 = String.format("%.2f", x[1]);
                        JOptionPane.showMessageDialog(null, "This equation accept two solutions : "+"\nThe first solution is : " + solution1 + "\nThe second solution is : " + solution2);
                    } else {
                        String solution = String.format("%.2f", x[0]);
                        JOptionPane.showMessageDialog(null, "This equation accept only one solution : "+"\nThe solution is : " + solution);
                    }
                } catch (MalformedURLException | NotBoundException | RemoteException ee) {
                }
            }
        });
    }
}
/*
a = 1, b = -3, c = 2
a = 1, b = -2, c = 1
a = 2, b = 4, c = 5
*/