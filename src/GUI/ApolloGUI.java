package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;

public class ApolloGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApolloGUI window = new ApolloGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ApolloGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.setLocation(10, 234);
		addPopup(frame.getContentPane(), popupMenu);
		
		JButton btnNewButton_2 = new JButton("Dodaj kontrahenta");
		popupMenu.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Dodaj produkt");
		popupMenu.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Zamknij");
		popupMenu.add(btnNewButton_4);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Dodaj kontrahenta");
		btnNewButton.setBounds(135, 49, 165, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Dodaj Produkt");
		btnNewButton_1.setBounds(135, 89, 165, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnZamknij = new JButton("Zamknij");
		btnZamknij.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(btnZamknij);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
