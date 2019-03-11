import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;


public class View extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	Model model;
	Control control;
	PopUp popUp;
	private JFrame frame;
	JPanel JPField = new JPanel();
	JButton fields[][] = 	{
			{new JButton("0"), new JButton("0"), new JButton("0")},
			{new JButton("0"), new JButton("0"), new JButton("0")},
			{new JButton("0"), new JButton("0"), new JButton("0")}

		};
	JTextPane infoRight = new JTextPane();
	JTextPane infoCenter = new JTextPane();
	JTextPane infoLeft = new JTextPane();
	/**
	 * Constructor of the class View
	 * Create the application.
	 */
	public View(Model model, Control control) {
		this.model = model;
		this.control = control;
		generatePopUp();
		frame = new JFrame();
		frame.setBounds(100, 100, 540, 645);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		infoRight.setContentType("text/html");
		infoLeft.setContentType("text/html");
		infoCenter.setContentType("text/html");
		infoRight.setEditable(false);
		infoLeft.setEditable(false);
		infoCenter.setEditable(false);
		
		frame.getContentPane().add(infoRight);
		frame.getContentPane().add(infoCenter);
		frame.getContentPane().add(infoLeft);
		frame.setResizable(false);
		
		
		JPField.setLayout(new GridLayout(3,3));
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				fields[i][j].setText(i + "; " + j);
				final int ii = i;
				final int jj = j;
				fields[i][j].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						control.setField(ii, jj);
						
					}
				});
				frame.add(fields[i][j]);
			}
		}
		update();
		frame.setLayout(new GridLayout(4,1));
		
		
		frame.setVisible(false);
	}
	/**
	 * todo
	 */
	public void setVisible(boolean bool) {
		frame.setVisible(bool);
	}
	/**
	 * Function that generates the PopUp
	 */
	public void generatePopUp() {
		popUp = new PopUp(model, control, this);
	}
	/**
	 * Function that shows the score
	 */
	public void showScore() {
		if(model.isCurrentPlayer1()) {
			infoCenter.setText("<html><font size = 15>Aktueller Spieler: " + "X" + "</font></html>");
		}else {
			infoCenter.setText("<html><font size = 15>Aktueller Spieler: " + "O" + "</font></html>");
		}
		infoRight.setText("<html><font size = 15>Gewinne Spieler X: " + model.getWinsX() + "</font></html>");
		
		infoLeft.setText("<html><font size = 15>Gewinne Spieler O: " + model.getWinsO() + "</font></html>");
	}
	
	/**
	 * Function that updates the gamefield
	 */
	public void update() {
		showScore();
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				String text = "";
				if(model.getFeld(i,j) == 0) {
					
				}else if(model.getFeld(i,j) == 1) {
					text = "X";
				}else if(model.getFeld(i,j) == 2) {
					text = "O";
				}else {
					text = "";
				}
				fields[i][j].setText("<html><font size=\"50\">" + text +"</font></html>");
			}
		}
		
		
	}
	/**
	 * Function that shows the PopUp
	 */
	public void showPopUp() {
		if(control.calculate() == 11)popUp.setText("Spieler <b>O</b> hat <b>verloren</b>");
		else if(control.calculate() == 12)popUp.setText("Spieler <b>X</b> hat <b>verloren</b>");
		else popUp.setText("Keiner konnte Gewinnen.");
		popUp.setVisible(true);
		setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Function that sets the editability of the buttons
	 * @param bool boolean if editable
	 */
	public void setButtonEditable(boolean bool) {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				fields[i][j].setEnabled(bool);
			}
		}
	}
}
