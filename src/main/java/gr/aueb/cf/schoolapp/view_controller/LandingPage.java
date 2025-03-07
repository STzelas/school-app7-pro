package gr.aueb.cf.schoolapp.view_controller;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LandingPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public LandingPage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LandingPage.class.getResource("/images/eduv2.png")));
		setTitle("Ποιότητα στην εκπαίδευση");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1049, 658);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel header = new JPanel();
		header.setBackground(new Color(0, 52, 117));
		header.setBounds(0, 0, 1033, 57);
		contentPane.add(header);
		header.setLayout(null);
		
		JLabel govImage = new JLabel("");
		govImage.setHorizontalAlignment(SwingConstants.CENTER);
		govImage.setIcon(new ImageIcon(LandingPage.class.getResource("/images/gov_logo_small.png")));
		govImage.setBounds(0, 0, 113, 57);
		header.add(govImage);
		
		JLabel lblAuthRequired = new JLabel("Απαιτείται Ταυτοποίηση");
		lblAuthRequired.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAuthRequired.setBounds(58, 91, 236, 83);
		contentPane.add(lblAuthRequired);
		
		JLabel lblMustConnect = new JLabel("Για να προχωρήσετε πρέπει να συνδεθείτε.");
		lblMustConnect.setBounds(58, 157, 263, 57);
		contentPane.add(lblMustConnect);
		
		JButton btnConnect = new JButton("Σύνδεση");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getLandingPage().setVisible(false);
				Main.getLoginPage().setVisible(true);
			}
		});
		btnConnect.setEnabled(false);
		btnConnect.setForeground(new Color(255, 255, 255));
		btnConnect.setBackground(new Color(0, 136, 0));
		btnConnect.setBounds(58, 280, 113, 46);
		
		JCheckBox privacyCheckBox = new JCheckBox("Δηλώνω ότι αποδέχομαι τη");
		privacyCheckBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					btnConnect.setEnabled(true);
					btnConnect.setBackground(new Color(0, 180, 0));
				} else {
					btnConnect.setEnabled(false);
					btnConnect.setBackground(new Color(0, 140, 0));
				}
			}
		});
		privacyCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		privacyCheckBox.setBounds(58, 221, 169, 23);
		contentPane.add(privacyCheckBox);
		
		JLabel lblPrivacy = new JLabel("Δήλωση Ιδιωτικότητας");
		lblPrivacy.setForeground(new Color(0, 0, 255));
		lblPrivacy.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPrivacy.setBounds(229, 217, 130, 31);
		contentPane.add(lblPrivacy);
		
		
		contentPane.add(btnConnect);
		
		JPanel footer = new JPanel();
		footer.setBounds(0, 534, 1033, 86);
		contentPane.add(footer);
		footer.setLayout(null);
		
		JLabel lblSupport = new JLabel("Εγχειρίδιο Χρήσης");
		lblSupport.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupport.setForeground(new Color(0, 0, 255));
		lblSupport.setBounds(752, 25, 108, 33);
		footer.add(lblSupport);
		
		JLabel lblQuestions = new JLabel("Συχνές Ερωτήσεις");
		lblQuestions.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuestions.setForeground(Color.BLUE);
		lblQuestions.setBounds(473, 25, 108, 33);
		footer.add(lblQuestions);
		
		JLabel lblManual = new JLabel("Υποστήριξη Πολιτών");
		lblManual.setHorizontalAlignment(SwingConstants.CENTER);
		lblManual.setForeground(Color.BLUE);
		lblManual.setBounds(171, 25, 131, 33);
		footer.add(lblManual);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(130, 192, 255));
		separator.setBounds(10, 529, 1013, 1);
		contentPane.add(separator);
	}
}
