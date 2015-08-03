
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JTextField;

//This is a simple calculator applet that
//you can embed on your HTML doctype project

/**
 * @author tofu.
 * 
 * @version 1.0b
 */
public class CalcuApplet extends JApplet implements ActionListener 
{
   
    private JTextField displayText = new JTextField(30);
    private JButton[] button = new JButton[16];
    
    private String[] keys = {"7", "8", "9", "/",
                             "4", "5", "6", "*",
                             "1", "2", "3", "-",
                             "0", "C", "=", "+"};

    private String numStr1 = "";
    private String numStr2 = "";
    

    private char op;
    private boolean firstInput = true;

    public CalcuApplet()
    {

        
        
        Container pane = getContentPane();

        pane.setLayout(null);

        displayText.setSize(200, 30);
        displayText.setLocation(10, 10);
        pane.add(displayText);

        int x, y;
        x = 10;
        y = 40;
        
    
    


    for (int ind = 0; ind < 16; ind++)
    {
        button[ind] = new JButton(keys[ind]);
        button[ind].addActionListener(this);
        button[ind].setSize(50, 30);
        button[ind].setLocation(x, y);
        pane.add(button[ind]);
        x = x + 50;

    if ((ind + 1) % 4 == 0)
    {
        x = 10;
        y = y + 30;
}
}

    }
        
public void actionPerformed(ActionEvent e)
{
    String resultStr;

    String str
        = String.valueOf(e.getActionCommand());

    char ch = str.charAt(0);

    switch (ch)
    {
    
case '0':
case '1':
case '2':
case '3':
case '4':
case '5':
case '6':
case '7':
case '8':
case '9':

if (firstInput)
{
    numStr1 = numStr1 + ch;
    displayText.setText(numStr1);
}
    
else
{

    numStr2 = numStr2 + ch;
    displayText.setText(numStr2);
}

break;

case '+':
case '-':
case '*':
case '/':

    op = ch;
    firstInput = false;
    break;

case '=':

    resultStr = evaluate();
    displayText.setText(resultStr);
    numStr1 = resultStr;
    numStr2 = "";
    firstInput = false;
    break;

case 'C':

    displayText.setText("");
    numStr1 = "";
    numStr2 = "";
    firstInput = true;
    
}
}

private String evaluate()
{

    final char beep = '\u0007';

    try
    { 
 
    int num1 = Integer.parseInt(numStr1);
    int num2 = Integer.parseInt(numStr2);
    int result = 0;

    switch (op)
    {

case '+':
    result = num1 + num2;
    break;

case '-':
    result = num1 - num2;
    break;

case '*':
    result = num1 * num2;
    break;

case '/':
    result = num1 / num2;
    break;
}

return String.valueOf(result);
}

catch (ArithmeticException e)
{
    System.out.print(beep);
    return "E R R O R: " + e.getMessage();
}

catch (NumberFormatException e)
{
    System.out.print(beep);

    if (numStr1.equals(""))
        return "E R R O R: Invalid First Number";
    else
        return "E R R O R: Invalid Second Number";
}

catch ( Exception e)
{
    System.out.print(beep);
    return "E R R O R";
}
}

 public void init()
 {

     CalcuApplet calcu = new CalcuApplet();
       
}
}
 