package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class EuclidesTableGenerator extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 550;
	private static final int HEIGHT = 300;
	
	private JTextField number1, number2;
	private JTextArea area;
	private JLabel lnumber1, lnumber2;
	private JButton calculateTable;
	
	public EuclidesTableGenerator()
	{
		/*
		 * Crear botones textfields y demas
		 */
		lnumber1 = new JLabel("Enter number 1: ", SwingConstants.RIGHT);
		lnumber2 = new JLabel("Enter number 2: ", SwingConstants.RIGHT);
		number1 = new JTextField(5);
		number2 = new JTextField(5);
		area = new JTextArea(5,40);
		calculateTable = new JButton("Calculate");
		
		calculateTable.addActionListener(new CalculateButton());
		
		setTitle("Euclides");
		Container pane = this.getContentPane();
		FlowLayout layout = new FlowLayout();
		pane.setLayout(layout);
		
		
		pane.add(lnumber1);
		pane.add(number1);
		pane.add(lnumber2);
		pane.add(number2);
		pane.add(area);
		pane.add(calculateTable);
		
		setSize(WIDTH, HEIGHT);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	/*
	 * Clase de la accion que hace el boton
	 */
	private class CalculateButton implements ActionListener {  
		public void actionPerformed (ActionEvent e) { 
			
			String finaltext = "";
			try {
				
				// Cojo los numeros que se han introducido
				Integer num1 = Integer.parseInt(number1.getText());
				Integer num2 = Integer.parseInt(number2.getText());
				
				// Rellenar vectores de los datos iniciales de la tabla
				Vector<Integer> v1 = new Vector<Integer>();
				v1.add(1);
				v1.add(0);
				Vector<Integer> v2 = new Vector<Integer>();
				v2.add(0);
				v2.add(1);
				Vector<Integer> vQ = new Vector<Integer>();
				Vector<Integer> vD = new Vector<Integer>();
				vD.add(num1);
				vD.add(num2);
				Vector<Integer> vR = new Vector<Integer>();
				 
				vQ.add(vD.elementAt(0) / vD.elementAt(1));
				vR.add(vD.elementAt(0) % vD.elementAt(1));
				int i = 0;
				
				// Se hace el bucle hasta que el ultimo resto es 0
				while( vR.lastElement() != 0 ){
				  
					v1.add(vQ.elementAt(i)*v1.elementAt(i+1) + v1.elementAt(i));
					v2.add(vQ.elementAt(i)*v2.elementAt(i+1)+ v2.elementAt(i));
					  
					vD.add(vR.elementAt(i));
					vQ.add(vD.elementAt(i+1) / vD.elementAt(i+2));
					vR.add(vD.elementAt(i+1) % vD.elementAt(i+2));
					
					i++;
				}
				finaltext += "Table: \r\n\r\n";
				finaltext += v1.toString() + "\r\n";
				finaltext += v2.toString() + "\r\n";
				finaltext += vQ.toString() + "\r\n";
				finaltext += vD.toString() + "\r\n";
				finaltext += vR.toString() + "\r\n\r\n";
				 
				finaltext += "The gcd between " + num1 + " and " + num2 + " is " + vD.lastElement().toString() + ".\r\n";
				  
				finaltext += "The Bezout crap is: " + (int)Math.pow(-1, (double)i) +" * "+ vD.lastElement().toString() + " = " 
					  		+ "-"+v2.lastElement().toString() + "*" + num2 + " + " + v1.lastElement().toString() + "*" + num1;
			  
				
			} catch (NumberFormatException ne) {
				if (number1.getText().equals("Kappa") || number2.getText().equals("Kappa")) {
					
					finaltext += 	"░░░░▄▀▀▀▀▀█▀▄▄▄▄░░░░\r\n" +
									"░░▄▀▒▓▒▓▓▒▓▒▒▓▒▓▓▓▓░ \r\n" +
									"▄▀▒▒▓▒▓▒▒▓▒█▒█▓▒▒██░ \r\n" +
									"█▓▒▓▒▓▒██▓░░░░░░███░ \r\n" +
									"█▓▓███▒▓▒░█░█▀▀▒▒██░ \r\n" +
									"████▓▒░░░░▀▀█▀█░▒▒█░ \r\n" +
									"████▓▒░░░░▀▀▀░▀░▒▒█░\r\n" +
									"████░░░▄▄▄██░░███▄▓░ \r\n" +
									"░▀▄█░░░▀███▓░▓███▓▒░ \r\n" +
									"▀▄░░░░░░░░░░░░▀▓▒▒█░ \r\n" +
									"░▀░▀░░░▒░░▓▀▄▄▄▓▒▓█░ \r\n" +
									"░░▀░░░░░▓▓░░░▓█▓▓▓█░ \r\n" +
									"░░░▀▄▄▒▒░░▀▀███▀▒█▀░ \r\n" +
									"░░░░░▀██▒▒░░░░▓██░░░ \r\n" +
									"░░░░░░░░▀▀█▄▄▄▄▀░░░░\r\n";
					
					lnumber1.setText("Kappa");
					lnumber2.setText("Kappa");
					calculateTable.setText("Kappa");
					
				} else {
					finaltext += "Write fucking numbers retard.";
				}
				
			}
			
			area.setText(finaltext);
		}
	} 
	public static void main(String [] args){
		@SuppressWarnings("unused")
		EuclidesTableGenerator etg = new EuclidesTableGenerator();
	}

}
