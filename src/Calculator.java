import com.sun.source.tree.PackageTree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    JButton jbt;
    String[] jbtName = {"x^2","C","Del","+","7","8","9","/","4","5","6","*","1","2","3","-","Exit","0",".","="};
    JTextArea display = new JTextArea();
    private double a = 0;
    private double b = 0;
    private int caseNumber = 0;
    private double kq = 0;

    public JButton myButton(String name) {
        jbt = new JButton(name);
        jbt.setForeground(Color.RED);
        jbt.setBackground(Color.WHITE);
        jbt.addActionListener(this);
        return jbt;
    }

    public Calculator() {
        super("Calculator");
        setLayout(new BorderLayout());
        display.setRows(4);
        display.setBackground(Color.GRAY);
        add(display,BorderLayout.NORTH);
        add(createJbtArea(),BorderLayout.CENTER);
        setSize(240,330);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public JPanel createJbtArea() {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(5,4));
        for (int i=0; i<jbtName.length; i++) {
           p.add(myButton(jbtName[i]));
        }
        p.setBackground(Color.WHITE);
        return p;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if (actionEvent.getActionCommand().equals("1")) display.append("1");
        if (actionEvent.getActionCommand().equals("2")) display.append("2");
        if (actionEvent.getActionCommand().equals("3")) display.append("3");
        if (actionEvent.getActionCommand().equals("4")) display.append("4");
        if (actionEvent.getActionCommand().equals("5")) display.append("5");
        if (actionEvent.getActionCommand().equals("6")) display.append("6");
        if (actionEvent.getActionCommand().equals("7")) display.append("7");
        if (actionEvent.getActionCommand().equals("8")) display.append("8");
        if (actionEvent.getActionCommand().equals("9")) display.append("9");
        if (actionEvent.getActionCommand().equals("0")) display.append("0");
        if (actionEvent.getActionCommand().equals(".")) display.append(".");

        if (actionEvent.getActionCommand().equals("+")) {
            a = Double.parseDouble(display.getText());
            caseNumber = 1;
            display.setText("");
        }
        if (actionEvent.getActionCommand().equals("-")) {
            a = Double.parseDouble(display.getText());
            caseNumber = 2;
            display.setText("");
        }
        if (actionEvent.getActionCommand().equals("*")) {
            a = Double.parseDouble(display.getText());
            caseNumber = 3;
            display.setText("");
        }
        if (actionEvent.getActionCommand().equals("/")) {
            a = Double.parseDouble(display.getText());
            caseNumber = 4;
            display.setText("");
        }
        if (actionEvent.getActionCommand().equals("x^2")) {
            caseNumber = 5;
            display.setText(display.getText()+"^2");
        }
        if (actionEvent.getActionCommand().equals("=")) {
            switch (caseNumber) {
                case 1:
                    b = Double.parseDouble(display.getText());
                    kq = a + b;
                    break;
                case 2:
                    b = Double.parseDouble(display.getText());
                    kq = a - b;
                    break;
                case 3:
                    b = Double.parseDouble(display.getText());
                    kq = a * b;
                    break;
                case 4:
                    b = Double.parseDouble(display.getText());
                    kq = a / b;
                    break;
                case 5:
                    String s=display.getText();
                    String m="";
                    for (int i=0; i<s.length()-2;i++) {
                        m = m+s.charAt(i);
                    }
                    b = Double.parseDouble(m);
                    kq = b*b;
                    break;
                default: kq = 0;
            }
            display.setText(""+kq);
        }

        if (actionEvent.getActionCommand().equals("Exit")) System.exit(0);

        if (actionEvent.getActionCommand().equals("C")) display.setText("");

        if (actionEvent.getActionCommand().equals("Del")) {
            String s = display.getText();
            display.setText("");
            for (int i=0; i<s.length()-1; i++) {
                display.setText(display.getText()+s.charAt(i));
            }
        }

    }
}
