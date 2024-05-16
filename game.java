import javax.swing.*;
import javax.swing.JScrollPane;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;


public class Game {
   static String correctAnswer;
   static int scoreCounter = 0;
   
   static String rEquation() {
      int x;
      int y;
      
      x = (int) (Math.random()*100);
      y = (int) (Math.random()*100);
      
      String result = "";
      result = x +  " + " + y;
      correctAnswer =String.valueOf(x + y);
      
      return result;
   }
   
   public static void main(String[] args){
   
      Scanner scanner = new Scanner(System.in);
       JFrame frame = new JFrame("command Prompt");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(400,200);
       frame.setLocationRelativeTo(null);
       
       JPanel panel = new JPanel();
       JLabel label = new JLabel("Enter command");
       JTextField textField = new JTextField(20);
       JTextArea textArea = new JTextArea(5,20);
       JScrollPane scrollPane = JScrollPane(textArea);
       
       panel.add(label);
       panel.add(textField);
       panel.add(scrollPane);
       
       textField.addActionListener(new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e) {
             String command = textField.getText();
             textArea.append(command + "\n");
             textField.setText("");
          }
       });
       
       frame.add(panel);
       frame.setVisible(true);
    
   
      
      System.out.println("Welcome to Math Game, press 's' to start and 'x' to exit");
      String input;
      boolean dontBreakLoop = false;
      boolean awaitingSolution = false;
      while(true){
       input = scanner.next();
      switch(input){
         case "s":
            if(awaitingSolution){
               System.out.println("Answer the question first");
               
            } else{
            System.out.println("solve: " + rEquation());
            awaitingSolution = true;
            break; }
            break;
             
         default:
            if(input.equals(correctAnswer)){
               System.out.println("correct");
             scoreCounter++;
             System.out.println("solve: " + rEquation()); }
             else {
            System.out.println("incorrect! " + correctAnswer);
            }
            break;
         
         case "exit":
            System.exit(0);

      }}
      
}}
