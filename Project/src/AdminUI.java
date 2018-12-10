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


public class AdminUI extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminUI frame = new AdminUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection = null;
	private JTextField textField;
	/**
	 * Create the frame.
	 */
	public AdminUI() {
		connection = sqlConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLoadTable = new JButton("View Residents");
		btnLoadTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String query = "SELECT FirstName, LastName, Age, RoomNumber, Faculty, Major, RoomIssue, GeneralIssue, Contact, Nationality, EmailAddress, SID FROM records";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					rs.close();
					pst.close();
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "An error occured while loading information.");
				}
			}
		});
		btnLoadTable.setBounds(245, 43, 129, 23);
		contentPane.add(btnLoadTable);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 93, 1200, 316);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("View Applicants");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String query = "SELECT * FROM applicants";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					rs.close();
					pst.close();
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "An error occured while loading information.");
				}
			}
		});
		btnNewButton.setBounds(36, 43, 150, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try{
					String query = "SELECT * FROM records WHERE RoomNumber=? ";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, textField.getText());
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "Room is unassigned.");
				}
			}
		});
		textField.setBounds(1095, 44, 141, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
