import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;

public class PopUp extends JFrame implements ActionListener{
	/**
	 * Constructor of the class PopUp
	 */
	private static final long serialVersionUID = 1L;
	
	
	private JFrame frame = new JFrame();
	private JTextPane text = new JTextPane();
	private JPanel jpJbtn = new JPanel();
	private JButton jbtn0 = new JButton("<html><font size = 25>0 Spieler</font></html>");
	private JButton jbtn1 = new JButton("<html><font size = 25>1 Spieler</font></html>");
	private JButton jbtn2 = new JButton("<html><font size = 25>2 Spieler</font></html>");
	
	/**
	 * Constructor of the class PopUp
	 * @param model
	 * @param control
	 * @param view
	 */
	public PopUp(Model model, Control control, View view) {
		frame.setLayout(new GridLayout(2,1));
		jbtn0.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				view.setVisible(true);
				control.setPlayerNo(0);
				control.restart();
				setVisible(false);
			}
		});	
		jbtn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				view.setVisible(true);
				control.setPlayerNo(1);
				control.restart();
				setVisible(false);
			}
		});
		jbtn2 .addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				view.setVisible(true);
				control.setPlayerNo(2);
				control.restart();
				setVisible(false);
			}
		});
		jpJbtn.setLayout(new GridLayout(1,3));
		jpJbtn.add(jbtn0);
		jpJbtn.add(jbtn1);
		jpJbtn.add(jbtn2);
		setText("TicTacToe: NEUES SPIEL");
		text.setContentType("text/html");
		text.setEditable(false);
		frame.setBounds(100, 100, 540, 645);
		frame.getContentPane().add(text);
		frame.getContentPane().add(jpJbtn);
		frame.setVisible(true);
		frame.setResizable(false);
	}
	/**
	 * Function that sets the visibility
	 * @param bool boolean if visible
	 */
	public void setVisible(boolean bool) {
		frame.setVisible(bool);
	}
	/**
	 * Function that sets a textfield 
	 * @param text shows a textfield
	 */
	public void setText(String text) {
		this.text.setText("<html><font size = 25><center>" + text + "</center></font></html>");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
