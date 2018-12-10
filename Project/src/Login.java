import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection = null;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		connection = sqlConnection.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(66, 66, 63, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(66, 130, 63, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(183, 63, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText().length()==9){
					try{
						String query = "SELECT * FROM records WHERE Username=? AND Password=? ";
						PreparedStatement pst = connection.prepareStatement(query);
						pst.setString(1, textField.getText());
						pst.setString(2, passwordField.getText());
						
						ResultSet rs = pst.executeQuery();
						
						int count = 0;
						
						while(rs.next()){
							count++;
						}
						
						if (count == 1){
							JOptionPane.showMessageDialog(null, "Username and password is correct!");
							frame.dispose();
							ResidentUI residentui = new ResidentUI(); 
							residentui.setVisible(true);
						}else{
							JOptionPane.showMessageDialog(null, "Username and password is incorrect.");
						}
						
						rs.close();
						pst.close();
					}catch(Exception e){
						JOptionPane.showMessageDialog(null, e);
					}
				}else{
					try{
						String query = "SELECT * FROM employees WHERE Username=? AND Password=? ";
						PreparedStatement pst = connection.prepareStatement(query);
						pst.setString(1, textField.getText());
						pst.setString(2, passwordField.getText());
						
						
						ResultSet rs = pst.executeQuery();
						
						int count = 0;
						
						while(rs.next()){
							count++;
						}
						
						if (count == 1){
							JOptionPane.showMessageDialog(null, "Username and password is correct!");
							frame.dispose();
							AdminUI adminui = new AdminUI(); 
							adminui.setVisible(true);
						}else{
							JOptionPane.showMessageDialog(null, "Username and password is incorrect.");
						}
						
						rs.close();
						pst.close();
					}catch(Exception e){
						JOptionPane.showMessageDialog(null, e);
					}
				}
				
			}
		});
		btnLogin.setBounds(103, 188, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(186, 127, 83, 20);
		frame.getContentPane().add(passwordField);
	}
}
