package gr.aueb.cf.schoolapp.view_controller;

import gr.aueb.cf.schoolapp.Main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class UpdatePage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textName;
	private JTextField textTaxNo;
	private JTextField textPhoneNumber;
	private JTextField textAddress;
	private JTextField textAddressNo;
	private JTextField textEmail;
	private JTextField textFatherName;
	private JTextField textLastname;
	private JTextField textZipNo;
	private JTextField textAddressError;
	private JTextField textPhoneError;
	private JTextField textTaxError;
	private JTextField textNameError;
	private JTextField textAddressNoError;
	private JTextField textEmailError;
	private JTextField textFatherNameError;
	private JTextField textLastnameError;
	private JTextField textZipNoError;
	private JLabel lblName;
	private JLabel lblTaxNo;
	private JLabel lblPhoneNumber;
	private JLabel lblAddress;
	private JLabel lblCity;
	private JLabel lblLastname;
	private JLabel lblFatherName;
	private JLabel lblEmail;
	private JLabel lblAddressNo;
	private JLabel lblZipNo;
	private JTextField textId;

	
	public UpdatePage() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1049, 862);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel header = new JPanel();
		header.setLayout(null);
		header.setBackground(new Color(0, 52, 117));
		header.setBounds(0, 0, 1033, 57);
		contentPane.add(header);
		
		JLabel govImage = new JLabel("");
		govImage.setIcon(new ImageIcon(UpdatePage.class.getResource("/images/gov_logo_small.png")));
		govImage.setHorizontalAlignment(SwingConstants.CENTER);
		govImage.setBounds(0, 0, 113, 57);
		header.add(govImage);
		
		JLabel lblHomePage_3_1_1 = new JLabel("SOTIRIS TZELATIDIS");
		lblHomePage_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHomePage_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblHomePage_3_1_1.setForeground(Color.WHITE);
		lblHomePage_3_1_1.setBounds(809, 11, 214, 34);
		header.add(lblHomePage_3_1_1);
		
		JPanel footer = new JPanel();
		footer.setBackground(new Color(192, 192, 192));
		footer.setLayout(null);
		footer.setBounds(0, 738, 1033, 85);
		contentPane.add(footer);
		
		JLabel lblSupport = new JLabel("Εγχειρίδιο Χρήσης");
		lblSupport.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSupport.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupport.setForeground(new Color(0, 0, 179));
		lblSupport.setBounds(752, 25, 108, 33);
		footer.add(lblSupport);
		
		JLabel lblQuestions = new JLabel("Συχνές Ερωτήσεις");
		lblQuestions.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblQuestions.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuestions.setForeground(new Color(0, 0, 179));
		lblQuestions.setBounds(473, 25, 108, 33);
		footer.add(lblQuestions);
		
		JLabel lblManual = new JLabel("Υποστήριξη Πολιτών");
		lblManual.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblManual.setHorizontalAlignment(SwingConstants.CENTER);
		lblManual.setForeground(new Color(0, 0, 179));
		lblManual.setBounds(171, 25, 131, 33);
		footer.add(lblManual);
		
		JButton btnClose = new JButton("Κλείσιμο");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getUpdatePage().setVisible(false);
				Main.getUpdatePage().setEnabled(false);
				Main.getShowTeacherPage().setEnabled(true);
				Main.getShowTeacherPage().setVisible(true);
			}
		});
		btnClose.setForeground(Color.WHITE);
		btnClose.setBackground(new Color(192, 192, 192));
		btnClose.setBounds(170, 643, 261, 51);
		contentPane.add(btnClose);
		
		JButton btnSubmit = new JButton("Υποβολή");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btnSubmit, "Successfully Submitted");
				Main.getInsertPage().revalidate();
				
			}
		});
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.setBackground(new Color(70, 140, 140));
		btnSubmit.setBounds(657, 643, 261, 51);
		contentPane.add(btnSubmit);
		
		JLabel lblTeacherInfo = new JLabel("Ενημέρωση Στοιχείων");
		lblTeacherInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeacherInfo.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTeacherInfo.setBounds(340, 68, 351, 57);
		contentPane.add(lblTeacherInfo);
		
		textName = new JTextField();
		textName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(textName.getText().isEmpty()) {
					textNameError.setText("Το όνομα είναι υποχρεωτικό πεδίο");
				} else {
					textNameError.setText("");
				}
			}
		});
		textName.setBounds(170, 224, 261, 42);
		contentPane.add(textName);
		textName.setColumns(10);
		
		textTaxNo = new JTextField();
		textTaxNo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(textTaxNo.getText().isEmpty()) {
					textTaxError.setText("Το Α.Φ.Μ. είναι υποχρεωτικό πεδίο");
				} else {
					textTaxError.setText("");
				}
			}
		});
		textTaxNo.setColumns(10);
		textTaxNo.setBounds(170, 304, 261, 42);
		contentPane.add(textTaxNo);
		
		textPhoneNumber = new JTextField();
		textPhoneNumber.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(textPhoneNumber.getText().isEmpty()) {
					textPhoneError.setText("Το τηλέφωνο είναι υποχρεωτικό πεδίο");
				} else {
					textPhoneError.setText("");
				}
			}
		});
		textPhoneNumber.setColumns(10);
		textPhoneNumber.setBounds(170, 384, 261, 42);
		contentPane.add(textPhoneNumber);
		
		textAddress = new JTextField();
		textAddress.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(textAddress.getText().isEmpty()) {
					textAddressError.setText("Η διεύθυνση είναι υποχρεωτικό πεδίο");
				} else {
					textAddressError.setText("");
				}
			}
		});
		textAddress.setColumns(10);
		textAddress.setBounds(170, 462, 261, 42);
		contentPane.add(textAddress);
		
		textAddressNo = new JTextField();
		textAddressNo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(textAddressNo.getText().isEmpty()) {
					textAddressNoError.setText("Το νούμερο διεύθυνσης είναι υποχρεωτικό πεδίο");
				} else {
					textAddressNoError.setText("");
				}
			}
		});
		textAddressNo.setColumns(10);
		textAddressNo.setBounds(657, 462, 261, 42);
		contentPane.add(textAddressNo);
		
		textEmail = new JTextField();
		textEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(textEmail.getText().isEmpty()) {
					textEmailError.setText("Το e-mail είναι υποχρεωτικό πεδίο");
				} else {
					textEmailError.setText("");
				}
			}
		});
		textEmail.setColumns(10);
		textEmail.setBounds(657, 384, 261, 42);
		contentPane.add(textEmail);
		
		textFatherName = new JTextField();
		textFatherName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(textFatherName.getText().isEmpty()) {
					textFatherNameError.setText("Το πατρώνυμο είναι υποχρεωτικό πεδίο");
				} else {
					textFatherNameError.setText("");
				}
			}
		});
		textFatherName.setColumns(10);
		textFatherName.setBounds(657, 304, 261, 42);
		contentPane.add(textFatherName);
		
		textLastname = new JTextField();
		textLastname.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(textLastname.getText().isEmpty()) {
					textLastnameError.setText("Το επώνυμο είναι υποχρεωτικό πεδίο");
				} else {
					textLastnameError.setText("");
				}
			}
		});
		textLastname.setColumns(10);
		textLastname.setBounds(657, 224, 261, 42);
		contentPane.add(textLastname);
		
		textZipNo = new JTextField();
		textZipNo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(textZipNo.getText().isEmpty()) {
					textZipNoError.setText("Το Τ.Κ. είναι υποχρεωτικό πεδίο");
				} else {
					textZipNoError.setText("");
				}
			}
		});
		textZipNo.setColumns(10);
		textZipNo.setBounds(657, 544, 261, 42);
		contentPane.add(textZipNo);
		
		textAddressError = new JTextField();
		textAddressError.setEditable(false);
		textAddressError.setBorder(null);
		textAddressError.setForeground(new Color(206, 0, 0));
		textAddressError.setBackground(new Color(240, 240, 240));
		textAddressError.setColumns(10);
		textAddressError.setBounds(170, 504, 261, 36);
		contentPane.add(textAddressError);
		
		textPhoneError = new JTextField();
		textPhoneError.setEditable(false);
		textPhoneError.setBorder(null);
		textPhoneError.setForeground(new Color(206, 0, 0));
		textPhoneError.setColumns(10);
		textPhoneError.setBackground(UIManager.getColor("Button.background"));
		textPhoneError.setBounds(170, 426, 261, 36);
		contentPane.add(textPhoneError);
		
		textTaxError = new JTextField();
		textTaxError.setEditable(false);
		textTaxError.setBorder(null);
		textTaxError.setForeground(new Color(206, 0, 0));
		textTaxError.setColumns(10);
		textTaxError.setBackground(UIManager.getColor("Button.background"));
		textTaxError.setBounds(170, 346, 261, 36);
		contentPane.add(textTaxError);
		
		textNameError = new JTextField();
		textNameError.setBorder(null);
		textNameError.setEditable(false);
		textNameError.setForeground(new Color(206, 0, 0));
		textNameError.setColumns(10);
		textNameError.setBackground(UIManager.getColor("Button.background"));
		textNameError.setBounds(170, 266, 261, 36);
		contentPane.add(textNameError);
		
		textAddressNoError = new JTextField();
		textAddressNoError.setEditable(false);
		textAddressNoError.setBorder(null);
		textAddressNoError.setForeground(new Color(206, 0, 0));
		textAddressNoError.setColumns(10);
		textAddressNoError.setBackground(UIManager.getColor("Button.background"));
		textAddressNoError.setBounds(657, 504, 261, 36);
		contentPane.add(textAddressNoError);
		
		textEmailError = new JTextField();
		textEmailError.setEditable(false);
		textEmailError.setBorder(null);
		textEmailError.setForeground(new Color(206, 0, 0));
		textEmailError.setColumns(10);
		textEmailError.setBackground(UIManager.getColor("Button.background"));
		textEmailError.setBounds(657, 426, 261, 36);
		contentPane.add(textEmailError);
		
		textFatherNameError = new JTextField();
		textFatherNameError.setEditable(false);
		textFatherNameError.setBorder(null);
		textFatherNameError.setForeground(new Color(206, 0, 0));
		textFatherNameError.setColumns(10);
		textFatherNameError.setBackground(UIManager.getColor("Button.background"));
		textFatherNameError.setBounds(657, 346, 261, 36);
		contentPane.add(textFatherNameError);
		
		textLastnameError = new JTextField();
		textLastnameError.setEditable(false);
		textLastnameError.setBorder(null);
		textLastnameError.setForeground(new Color(206, 0, 0));
		textLastnameError.setColumns(10);
		textLastnameError.setBackground(UIManager.getColor("Button.background"));
		textLastnameError.setBounds(657, 266, 261, 36);
		contentPane.add(textLastnameError);
		
		textZipNoError = new JTextField();
		textZipNoError.setEditable(false);
		textZipNoError.setBorder(null);
		textZipNoError.setForeground(new Color(206, 0, 0));
		textZipNoError.setColumns(10);
		textZipNoError.setBackground(UIManager.getColor("Button.background"));
		textZipNoError.setBounds(657, 521, 261, 36);
		contentPane.add(textZipNoError);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(240, 240, 240));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Αθήνα", "Θεσσαλονίκη", "Πάτρα", "Λαμία", "Βόλος"}));
		comboBox.setBounds(170, 544, 261, 42);
		contentPane.add(comboBox);
		
		lblName = new JLabel("Όνομα*");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblName.setBounds(114, 238, 46, 14);
		contentPane.add(lblName);
		
		lblTaxNo = new JLabel("Α.Φ.Μ.*");
		lblTaxNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTaxNo.setBounds(114, 319, 46, 14);
		contentPane.add(lblTaxNo);
		
		lblPhoneNumber = new JLabel("Τηλέφωνο*");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPhoneNumber.setBounds(93, 399, 67, 14);
		contentPane.add(lblPhoneNumber);
		
		lblAddress = new JLabel("Διεύθυνση*");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAddress.setBounds(93, 477, 67, 14);
		contentPane.add(lblAddress);
		
		lblCity = new JLabel("Πόλη*");
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCity.setBounds(114, 559, 46, 14);
		contentPane.add(lblCity);
		
		lblLastname = new JLabel("Επώνυμο*");
		lblLastname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLastname.setBounds(580, 239, 67, 14);
		contentPane.add(lblLastname);
		
		lblFatherName = new JLabel("Πατρώνυμο*");
		lblFatherName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFatherName.setBounds(569, 319, 78, 14);
		contentPane.add(lblFatherName);
		
		lblEmail = new JLabel("e-mail*");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmail.setBounds(601, 399, 46, 14);
		contentPane.add(lblEmail);
		
		lblAddressNo = new JLabel("Αριθμός*");
		lblAddressNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAddressNo.setBounds(589, 477, 58, 14);
		contentPane.add(lblAddressNo);
		
		lblZipNo = new JLabel("Τ.Κ.*");
		lblZipNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblZipNo.setBounds(610, 559, 37, 14);
		contentPane.add(lblZipNo);
		
		textId = new JTextField();
		textId.setColumns(10);
		textId.setBounds(170, 144, 261, 42);
		contentPane.add(textId);
		
		JLabel lblId = new JLabel("Κωδικός");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblId.setBounds(93, 158, 67, 14);
		contentPane.add(lblId);
		
		JButton btnSearch = new JButton("Αναζήτηση");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textId.getText().equals("1")) {
					textName.setText("Σωτήρης");
					textName.setEnabled(false);
					textLastname.setText("Τζελατίδης");
					textLastname.setEnabled(false);
					textTaxNo.setText("123456789");
					textTaxNo.setEnabled(false);
					textFatherName.setText("Νίκος");
					textFatherName.setEnabled(false);
					textPhoneNumber.setText("6942352632");
					textAddress.setText("Ολύμπου");
					textAddressNo.setText("21");
					textZipNo.setText("52362");
					textEmail.setText("xxxx@gmail.com");
				}
			}
		});
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setBackground(new Color(70, 140, 140));
		btnSearch.setBounds(695, 147, 184, 36);
		contentPane.add(btnSearch);
	}
}
