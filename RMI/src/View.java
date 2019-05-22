import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import java.awt.TextArea;

public class View extends JFrame {

	private JPanel contentPane;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Registry registry = LocateRegistry.getRegistry(3030);
	Metodos stub = (Metodos) registry.lookup("Metodos");
	
	
	TextArea textArea = new TextArea();
	
	
	public View() throws RemoteException, NotBoundException {
		
		registry = LocateRegistry.getRegistry(3030);
	    stub = (Metodos) registry.lookup("Metodos");	    
	    
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblCliente.setBounds(249, 11, 64, 14);
		contentPane.add(lblCliente);
		
		JButton Hora = new JButton("Hora");
		Hora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {					
				    
					String response = stub.hora();
					System.out.println("response: "+response);	
					textArea.setText(response);
					textArea.setVisible(true);
					
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		Hora.setBounds(24, 62, 89, 23);
		contentPane.add(Hora);
		
		JButton btnMetodo = new JButton("Frase");
		btnMetodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {					
					
					String response = stub.fraseMotivacional();
					System.out.println("response: "+response);	
					textArea.setText(response);
					textArea.setVisible(true);
					
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnMetodo.setBounds(136, 62, 89, 23);
		contentPane.add(btnMetodo);
		
		JButton btnMetodo_1 = new JButton("Hello");
		btnMetodo_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					String response = stub.sayHello();
					textArea.setText(response);
					textArea.setVisible(true);
					
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnMetodo_1.setBounds(241, 62, 89, 23);
		contentPane.add(btnMetodo_1);
		
		JButton btnMetodo_2 = new JButton("Mult");
		btnMetodo_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
				
					String response = String.valueOf(stub.multiplicacao());
					textArea.setText("Resultado da multiplica��o: "+response);
					textArea.setVisible(true);
					
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnMetodo_2.setBounds(346, 62, 89, 23);
		contentPane.add(btnMetodo_2);
		
		JButton btnMetodo_3 = new JButton("Soma");
		btnMetodo_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

				try {
					registry = LocateRegistry.getRegistry(3030);
					stub = (Metodos) registry.lookup("Metodos");
					String response = String.valueOf(stub.soma());
					textArea.setText("Resulta da soma: "+response);
					textArea.setVisible(true);
					
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NotBoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		btnMetodo_3.setBounds(453, 62, 89, 23);
		contentPane.add(btnMetodo_3);
		
		
		textArea.setBounds(91, 139, 380, 96);
		contentPane.add(textArea);
	}
}
