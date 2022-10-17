import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener{
    JButton[] numberButtons = new JButton[10];
    /*
     * numberButtons[0] = 0
     * numberButtons[1] = 1
     * numberButtons[2] = 2
     * numberButtons[3] = 3
     * numberButtons[4] = 4
     * numberButtons[5] = 5
     * numberButtons[6] = 6
     * numberButtons[7] = 7
     * numberButtons[8] = 8
     * numberButtons[9] = 9
     */
    JButton[] operatorButtons = new JButton[5];
    /*
     * operatorButtons[0] = +
     * operatorButtons[1] = -
     * operatorButtons[2] = *
     * operatorButtons[3] = =
     * operatorButtons[4] = /
     */
    JPanel panel = new JPanel();
    JPanel numberPanel = new JPanel();
    JTextField textField = new JTextField();
    char operator;
    double num1=0,num2=0,result=0;
    public Calculator(){
        setTitle("Calculator");
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(50, 50, 400, 600);
        textField.setEditable(false);
        panel.setLayout(new BorderLayout(10,10));
        numberPanel.setLayout(new GridLayout(5,3,5,20));
        panel.add(textField,BorderLayout.NORTH);
        panel.add(numberPanel,BorderLayout.CENTER);
        add(panel);
        for(int i = 0;i<numberButtons.length;i++){
            numberButtons[i] = new JButton(Integer.toString(i));
            numberButtons[i].addActionListener(this);
            if(i==0) continue;
            numberPanel.add(numberButtons[i]);
        }
        operatorButtons[0] = new JButton("+");
        operatorButtons[1] = new JButton("-");
        operatorButtons[2] = new JButton("*");
        operatorButtons[3] = new JButton("=");
        operatorButtons[4] = new JButton("/");
        for(int i = 0;i<operatorButtons.length;i++){
            operatorButtons[i].addActionListener(this);
            if(i==0){
                numberPanel.add(operatorButtons[0]);
                numberPanel.add(numberButtons[0]);
                continue;
            }
            numberPanel.add(operatorButtons[i]);
        }
        
    }
    public static void main(String[] args) {
        new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<10;i++) {
			if(e.getSource() == numberButtons[i]) {
				textField.setText(textField.getText().concat(String.valueOf(i)));
			}
		}

        if(e.getSource()==operatorButtons[0]) {
			num1 = Double.parseDouble(textField.getText());
			operator ='+';
			textField.setText("");
		}
		if(e.getSource()==operatorButtons[1]) {
			num1 = Double.parseDouble(textField.getText());
			operator ='-';
			textField.setText("");
		}
		if(e.getSource()==operatorButtons[2]) {
			num1 = Double.parseDouble(textField.getText());
			operator ='*';
			textField.setText("");
		}
		if(e.getSource()==operatorButtons[4]) {
			num1 = Double.parseDouble(textField.getText());
			operator ='/';
			textField.setText("");
		}
		if(e.getSource()==operatorButtons[3]) {
			num2=Double.parseDouble(textField.getText());
			
			switch(operator) {
			case'+':
				result=num1+num2;
				break;
			case'-':
				result=num1-num2;
				break;
			case'*':
				result=num1*num2;
				break;
			case'/':
				result=num1/num2;
				break;
			}
			textField.setText(String.valueOf(result));
			num1=result;
		}
    }  
    
}