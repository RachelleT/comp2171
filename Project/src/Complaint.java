import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Complaint extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Complaint frame = new Complaint();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection = null;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	/**
	 * Create the frame.
	 */
	public Complaint() {
		connection = sqlConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 487, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("RoomIssue");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					JOptionPane.showMessageDialog(null, "Administration is notified about Room Issue.");
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "An error occured.");
				}
			}
		});
		btnNewButton.setBounds(46, 63, 101, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("GeneralIssue");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					JOptionPane.showMessageDialog(null, "Administration is notified about General Issue.");
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "An error occured.");
				}
			}
		});
		btnNewButton_1.setBounds(262, 63, 120, 23);
		contentPane.add(btnNewButton_1);
	}
}
