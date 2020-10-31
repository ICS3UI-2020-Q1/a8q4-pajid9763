import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;
  JLabel nLabel;
  JLabel facLabel;

  JTextField nInput;
  JTextField facInput;

  JButton calcButton;


  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);

    // initialize the main JPanel 
    mainPanel = new JPanel(); 
    // turn on manual layouts 
    mainPanel.setLayout(null);
    // add the panel to the JFrame 
    frame.add(mainPanel);


    // create the labels
    nLabel = new JLabel("n");
    facLabel = new JLabel("factorial(n)");

    // set the location and size of the labels 
    nLabel.setBounds(30, 30, 30, 20);
    facLabel.setBounds(150, 30, 80, 20);

    // add the labels to the main panel 
    mainPanel.add(nLabel);
    mainPanel.add(facLabel);


    // initialize the JTextFields 
    nInput = new JTextField();
    facInput = new JTextField();

    // disable the factorial text field so the user cannot type in it 
    facInput.setEnabled(false);

    // set the location and size of the JTextFields
    nInput.setBounds(60, 30, 80, 20);
    facInput.setBounds(235, 30, 150, 20);

    // add the text fields to the main panel 
    mainPanel.add(nInput);
    mainPanel.add(facInput);


    // initialize the button
    calcButton = new JButton("CALC");

    // add an actionListener 
    calcButton.addActionListener(this);

    // give the button an action command 
    calcButton.setActionCommand("calc");

    // set the location and size of the button 
    calcButton.setBounds(390, 30, 70, 20);

    // add button to the mainPanel 
    mainPanel.add(calcButton);
 
  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

    // create a total variable to keep track of the total
    int total = 1;
    // get text from the number the user inputted
    String nInputText = nInput.getText();
    // convert that text into a double
    double nInputNum = Double.parseDouble(nInputText);

    // calculate the sum of the factorial
    for (int i = 1; i <= nInputNum; i++){
      total = total * i;
      
    }
      // convert the double to a String so it can be displayed on screen
      String totalFinal = String.valueOf(total);
      facInput.setText(totalFinal);
  }

    

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
