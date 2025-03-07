package gr.aueb.cf.schoolapp.view_controller;

import gr.aueb.cf.schoolapp.Main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static Connection connection;

	
	public Dashboard() {
//		addWindowListener(new WindowAdapter() {
//			@Override
//			public void windowOpened(WindowEvent e) {
//				String sql = "jdbc:mysql://localhost:3306/school7dbpro?serverTimezone=UTC";
//				String username = "user7pro";
//				String password = "12345";
//
//				try {
//					connection = DriverManager.getConnection(sql, username, password);
//					System.out.println("Connection Success");
//				} catch (SQLException e1) {
//					e1.printStackTrace();
//				}
//			}
//		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1049, 658);
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
		govImage.setIcon(new ImageIcon(Dashboard.class.getResource("/images/gov_logo_small.png")));
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
		footer.setBounds(0, 534, 1033, 85);
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
		
		JPanel nav = new JPanel();
		nav.setLayout(null);
		nav.setBackground(new Color(0, 52, 117));
		nav.setBounds(0, 56, 192, 478);
		contentPane.add(nav);
		
		JLabel lblHomePage = new JLabel("Αρχική");
		lblHomePage.setBackground(new Color(255, 255, 255));
		lblHomePage.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHomePage.setBounds(22, 22, 120, 33);
		nav.add(lblHomePage);
		lblHomePage.setHorizontalAlignment(SwingConstants.LEFT);
		lblHomePage.setForeground(new Color(255, 239, 36));
		
		JLabel lblTeachersPage = new JLabel("Εκπαιδευτές");
		lblTeachersPage.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTeachersPage.setHorizontalAlignment(SwingConstants.LEFT);
		lblTeachersPage.setForeground(Color.WHITE);
		lblTeachersPage.setBounds(22, 51, 120, 33);
		nav.add(lblTeachersPage);
		
		JLabel lblInsertTeacher = new JLabel("Εισαγωγή εκπαιδευτή");
		lblInsertTeacher.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblInsertTeacher.setForeground(Color.BLUE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblInsertTeacher.setForeground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.getDashboard().setEnabled(false);
				Main.getInsertPage().setVisible(true);
				Main.getInsertPage().setEnabled(true);
			}
		});
		lblInsertTeacher.setHorizontalAlignment(SwingConstants.LEFT);
		lblInsertTeacher.setForeground(Color.WHITE);
		lblInsertTeacher.setBounds(30, 107, 152, 14);
		nav.add(lblInsertTeacher);
		
		JLabel lblShowTeacher = new JLabel("Προβολή εκπαιδευτών");
		lblShowTeacher.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblShowTeacher.setForeground(Color.BLUE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblShowTeacher.setForeground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.getDashboard().setEnabled(false);
				Main.getShowTeacherPage().setVisible(true);
				Main.getShowTeacherPage().setEnabled(true);
			}
		});
		lblShowTeacher.setHorizontalAlignment(SwingConstants.LEFT);
		lblShowTeacher.setForeground(Color.WHITE);
		lblShowTeacher.setBounds(30, 84, 136, 14);
		nav.add(lblShowTeacher);
		
		JLabel lblQuality = new JLabel("Ποιότητα στην Εκπαίδευση");
		lblQuality.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuality.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblQuality.setBounds(386, 68, 415, 78);
		contentPane.add(lblQuality);
		
		JLabel lblShowRecord = new JLabel("Προβολή Μητρώου Εκπαιδευτών");
		lblShowRecord.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblShowRecord.setBounds(280, 190, 346, 21);
		contentPane.add(lblShowRecord);
		
		JLabel lblRecordMessage = new JLabel("Προβολή Μητρώου Εγγεγραμένων Εκπαιδευτών στο Μητρώο του Coding Factory");
		lblRecordMessage.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRecordMessage.setBounds(280, 210, 540, 31);
		contentPane.add(lblRecordMessage);
		
		JLabel lblInsertRecord = new JLabel("Εισαγωγή Εκπαιδευτή στο Μητρώο Εκπαιδευτών");
		lblInsertRecord.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblInsertRecord.setBounds(280, 365, 481, 21);
		contentPane.add(lblInsertRecord);
		
		JButton btnNext = new JButton("Συνέχεια");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getDashboard().setEnabled(false);
				Main.getShowTeacherPage().setVisible(true);
				Main.getShowTeacherPage().setEnabled(true);
			}
		});
		btnNext.setForeground(Color.WHITE);
		btnNext.setBackground(new Color(0, 136, 0));
		btnNext.setBounds(280, 252, 113, 46);
		contentPane.add(btnNext);
		
		JButton btnNext_2 = new JButton("Συνέχεια");
		btnNext_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getDashboard().setEnabled(false);
				Main.getInsertPage().setVisible(true);
				Main.getInsertPage().setEnabled(true);
			}
		});
		btnNext_2.setForeground(Color.WHITE);
		btnNext_2.setBackground(new Color(0, 136, 0));
		btnNext_2.setBounds(280, 439, 113, 46);
		contentPane.add(btnNext_2);
		
		JLabel lblInsertMessage = new JLabel("Εισαγωγή Εκπαιδευτή στο μητρώο του Coding Factory");
		lblInsertMessage.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInsertMessage.setBounds(280, 397, 540, 31);
		contentPane.add(lblInsertMessage);
	}


	public static Connection getConnection() {
		return connection;
	}	
}
