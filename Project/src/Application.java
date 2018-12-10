import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;


public class Application extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application frame = new Application();
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
	public Application() {
		connection = sqlConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Firstname");
		lblNewLabel.setBounds(54, 48, 67, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Lastname");
		lblNewLabel_1.setBounds(361, 48, 67, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ID");
		lblNewLabel_2.setBounds(54, 85, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("RoomPreference");
		lblNewLabel_3.setBounds(54, 121, 108, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("CurrentRoom ");
		lblNewLabel_4.setBounds(361, 121, 85, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Nationality");
		lblNewLabel_5.setBounds(54, 164, 67, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Permanent Address");
		lblNewLabel_6.setBounds(54, 216, 129, 23);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Telephone");
		lblNewLabel_7.setBounds(54, 259, 77, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("EmailAddress");
		lblNewLabel_8.setBounds(54, 296, 95, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Faculty");
		lblNewLabel_9.setBounds(54, 340, 46, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Major");
		lblNewLabel_10.setBounds(361, 340, 46, 14);
		contentPane.add(lblNewLabel_10);
		
		textField = new JTextField();
		textField.setBounds(160, 45, 171, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(160, 118, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(160, 161, 124, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(160, 82, 124, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(193, 213, 405, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(160, 256, 108, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(160, 293, 437, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(160, 337, 171, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(456, 45, 131, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(456, 118, 86, 20);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(456, 337, 131, 20);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String query = "INSERT into applicants (FirstName, LastName, ID, Age, RoomPreference, CurrentRoom, Nationality, PermanentAddress, Major, Faculty, EmailAddress) values (?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, textField.getText());
					pst.setString(2, textField_8.getText());
					pst.setString(3, textField_3.getText());
					pst.setString(4, textField_11.getText());
					pst.setString(5, textField_1.getText());
					pst.setString(6, textField_9.getText());
					pst.setString(7, textField_2.getText());					
					pst.setString(8, textField_4.getText());				
					pst.setString(9, textField_10.getText());
					pst.setString(10, textField_7.getText());
					pst.setString(11, textField_6.getText());
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Form Submitted!");

					pst.close();
					
					contentPane.setOpaque(false);
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "Please fill out all fields.");
				}
				
			}
		});
		btnNewButton.setBounds(397, 385, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_11 = new JLabel("Age");
		lblNewLabel_11.setBounds(361, 85, 46, 14);
		contentPane.add(lblNewLabel_11);
		
		textField_11 = new JTextField();
		textField_11.setBounds(456, 82, 86, 20);
		contentPane.add(textField_11);
		textField_11.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("UPDATE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String query = "UPDATE applicants set FirstName='"+textField.getText()+"', LastName='"+textField_8.getText()+"', ID='"+textField_3.getText()+"', Age='"+textField_11.getText()+"', RoomPreference='"+textField_1.getText()+"', CurrentRoom='"+textField_9.getText()+"', Nationality='"+textField_2.getText()+"', PermanentAddress='"+textField_4.getText()+"', Major='"+textField_10.getText()+"', Faculty='"+textField_7.getText()+"', EmailAddress='"+textField_6.getText()+"' WHERE ID=? ";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, textField_3.getText());
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Information Updated.");

					pst.close();
					
					contentPane.setOpaque(false);
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "Could not update information.");
				}
			}
		});
		btnNewButton_1.setBounds(179, 385, 89, 23);
		contentPane.add(btnNewButton_1);
	}

}
