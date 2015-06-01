import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class pruebaCheck extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pruebaCheck frame = new pruebaCheck();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public pruebaCheck() {
		setTitle("CheckBox Ariketa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.darkShadow"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JCheckBox checkJon = new JCheckBox("Jon");
		checkJon.setBounds(42, 51, 55, 23);
		contentPane.add(checkJon);
		
		JCheckBox checkAuzmendi = new JCheckBox("Auzmendi");
		checkAuzmendi.setBounds(137, 51, 100, 23);
		contentPane.add(checkAuzmendi);
		
		JCheckBox checkJimenez = new JCheckBox("Jimenez");
		checkJimenez.setBounds(275, 51, 80, 23);
		contentPane.add(checkJimenez);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Lana Aceptar
				if(checkJon.isSelected()==true) {  
					String testua = checkJon.getText();
				    System.out.print(testua);  
				} else {  
				    System.out.print(" ");  
				} 
				
				if(checkAuzmendi.isSelected()==true) {
					String testua = checkAuzmendi.getText();
				    System.out.print(testua);  
				} else {  
				    System.out.print(" ");  
				}
				
				if(checkJimenez.isSelected()==true) {  
					String testua = checkJimenez.getText();
				    System.out.print(testua); 
				} else {  
				    System.out.print(" ");  
				}  
				
			}
		});
		btnAceptar.setBounds(45, 188, 117, 25);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Lana Cancelar
				checkJon.setSelected(false);
				checkAuzmendi.setSelected(false);
				checkJimenez.setSelected(false);


			}
		});
		btnCancelar.setBounds(253, 188, 117, 25);
		contentPane.add(btnCancelar);
	}
}
