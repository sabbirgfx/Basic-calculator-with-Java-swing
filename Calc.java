import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calc implements ActionListener {

    Font myFont = new Font("helvetica", Font.PLAIN, 20);

    JFrame jframe;
    JTextField tfield;
    JTextField output_text;
    JButton[] digit_button = new JButton[10];
    JButton[] op_button = new JButton[9];
    JButton add_button, sub_button, mul_button, div_button, dec_button, equ_button, del_button, clr_button, neg_button;
    JPanel panel;

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    Calc() {

        jframe = new JFrame("Calculator");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(420, 550);
        jframe.setLayout(null);

        output_text = new JTextField();
        output_text.setBounds(50, 2, 300, 20);
        output_text.setFont(new Font("helvetica", Font.PLAIN, 15));
        output_text.setEditable(false);
        output_text.setHorizontalAlignment(JTextField.LEFT);
        output_text.setBorder(null);

        tfield = new JTextField();
        tfield.setBounds(50, 25, 300, 50);
        tfield.setFont(myFont);
        tfield.setEditable(false);

        add_button = new JButton("+");
        sub_button = new JButton("-");
        mul_button = new JButton("*");
        div_button = new JButton("/");
        dec_button = new JButton(".");
        equ_button = new JButton("=");
        del_button = new JButton("Delete");
        clr_button = new JButton("Clear");
        neg_button = new JButton("-");

        op_button[0] = add_button;
        op_button[1] = sub_button;
        op_button[2] = mul_button;
        op_button[3] = div_button;
        op_button[4] = dec_button;
        op_button[5] = equ_button;
        op_button[6] = del_button;
        op_button[7] = clr_button;
        op_button[8] = neg_button;

        for (int i = 0; i < 9; i++) {
            op_button[i].addActionListener(this);
            op_button[i].setFont(myFont);
            op_button[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            digit_button[i] = new JButton(String.valueOf(i));
            digit_button[i].addActionListener(this);
            digit_button[i].setFont(myFont);
            digit_button[i].setFocusable(false);
            digit_button[i].setBackground(Color.black);
            digit_button[i].setForeground(Color.white);
        }

        for (int i = 0; i < 9; i++) {
            op_button[i].setFont(myFont);
            op_button[i].setFocusable(false);
            op_button[i].setBackground(Color.orange);
        }

        neg_button.setBounds(50, 430, 93, 50);
        del_button.setBounds(150, 430, 93, 50);
        clr_button.setBounds(250, 430, 93, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 5));

        panel.add(digit_button[1]);
        panel.add(digit_button[2]);
        panel.add(digit_button[3]);
        panel.add(add_button);
        panel.add(digit_button[4]);
        panel.add(digit_button[5]);
        panel.add(digit_button[6]);
        panel.add(sub_button);
        panel.add(digit_button[7]);
        panel.add(digit_button[8]);
        panel.add(digit_button[9]);
        panel.add(mul_button);
        panel.add(dec_button);
        panel.add(digit_button[0]);
        panel.add(equ_button);
        panel.add(div_button);

        jframe.add(panel);
        jframe.add(del_button);
        jframe.add(clr_button);
        jframe.add(neg_button);
        jframe.add(tfield);
        jframe.add(output_text);
        jframe.setVisible(true);

    }

    public static void main(String[] args) {
        Calc calc = new Calc();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == digit_button[i]) {
                tfield.setText(tfield.getText().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == add_button) {
            num1 = Double.parseDouble(tfield.getText());
            operator = '+';
            tfield.setText("");
        }

        if (e.getSource() == sub_button) {
            num1 = Double.parseDouble(tfield.getText());
            operator = '-';
            tfield.setText("");
        }

        if (e.getSource() == div_button) {
            num1 = Double.parseDouble(tfield.getText());
            operator = '/';
            tfield.setText("");
        }

        if (e.getSource() == mul_button) {
            num1 = Double.parseDouble(tfield.getText());
            operator = '*';
            tfield.setText("");
        }

        if (e.getSource() == dec_button) {
            tfield.setText(tfield.getText().concat("."));
        }

        if (e.getSource() == equ_button) {
            num2 = Double.parseDouble(tfield.getText());

            switch (operator) {
                case '+' -> {
                    result = num1 + num2;
                    output_text.setText((int)num1 + " + " + (int)num2 + " = ");
                }
                case '-' -> {
                    result = num1 - num2;
                    output_text.setText((int)num1 + " - " + (int)num2 + " = ");
                }
                case '*' -> {
                    result = num1 * num2;
                    output_text.setText((int)num1 + " * " + (int)num2 + " = ");
                }
                case '/' -> {
                    result = num1 / num2;
                    output_text.setText((int)num1 + " / " + (int)num2 + " = ");
                }
                case '%' -> {
                    result = num1 % num2;
                    output_text.setText((int)num1 + " % " + (int)num2 + " = ");
                }
            }
            tfield.setText(String.valueOf(result));
            num1 = result;
        }

        if (e.getSource() == clr_button) {
            tfield.setText("");
            output_text.setText("");
        }

        if (e.getSource() == del_button) {
            String string = tfield.getText();
            tfield.setText("");
            for(int i=0;i<string.length()-1;i++){
                tfield.setText(tfield.getText()+string.charAt(i));
            }
        }

        if (e.getSource() == neg_button) {
            double temp = Double.parseDouble(tfield.getText());
            temp*=-1;
            tfield.setText(String.valueOf(temp));
        }
    }
}