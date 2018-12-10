import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.*;
import javax.swing.*;

public class ResidentUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResidentUI frame = new ResidentUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection = null;
	/**
	 * Create the frame.
	 */
	public ResidentUI() {
		connection = sqlConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnreapply = new JButton("Application Form");
		btnreapply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Application reapply = new Application(); 
					reapply.setVisible(true);
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "Couldn't load application form.");
				}
			}
		});
		btnreapply.setBounds(34, 38, 185, 23);
		contentPane.add(btnreapply);
		
		JButton btncomplaint = new JButton("Complaint");
		btncomplaint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Complaint complaint = new Complaint(); 
					complaint.setVisible(true);
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "Couldn't load complaint page.");
				}
			}
		});
		btncomplaint.setBounds(34, 91, 185, 23);
		contentPane.add(btncomplaint);
		
		JButton btnNewButton = new JButton("Update Information");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Application reapply = new Application(); 
					reapply.setVisible(true);
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "An error occured..");
				}
			}
		});
		btnNewButton.setBounds(34, 151, 185, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View Applicatin Status");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					JOptionPane.showMessageDialog(null, "Application status: Pending.");
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "Reapply to view application status.");
				}
			}
		});
		btnNewButton_1.setBounds(34, 205, 185, 23);
		contentPane.add(btnNewButton_1);
	}

}
