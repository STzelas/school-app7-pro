package gr.aueb.cf.schoolapp.view_controller;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gr.aueb.cf.schoolapp.model.City;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ViewPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
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
	private JSeparator separator;
	private JTextField uuidText;
	private JTextField firstnameText;
	private JTextField vatText;
	private JTextField phoneNumText;
	private JTextField streetText;
	private JTextField cityText;
	private JTextField lastnameText;
	private JTextField fathernameText;
	private JTextField emailText;
	private JTextField streetNumText;
	private JTextField zipcodeText;

	private List<City> cities = new ArrayList<>();
	
	public ViewPage() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				cities = fetchCitiesFromDatabase();
				//cities.forEach(city -> cityComboBox.addItem(city));
				fetchTeacherFromDatabase(Main.getShowTeacherPage().getSelectedUUID());
			}
		});
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
		govImage.setIcon(new ImageIcon(ViewPage.class.getResource("/images/gov_logo_small.png")));
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
				Main.getViewpage().setVisible(false);
				Main.getViewpage().setEnabled(false);
				Main.getShowTeacherPage().setEnabled(true);
				Main.getShowTeacherPage().setVisible(true);
			}
		});
		btnClose.setForeground(Color.WHITE);
		btnClose.setBackground(new Color(192, 192, 192));
		btnClose.setBounds(772, 651, 220, 50);
		contentPane.add(btnClose);
		
		JLabel lblTeacherInfo = new JLabel("Στοιχεία Εκπαιδευτή");
		lblTeacherInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeacherInfo.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblTeacherInfo.setBounds(340, 76, 351, 57);
		contentPane.add(lblTeacherInfo);
		
		lblName = new JLabel("Όνομα :");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblName.setBounds(106, 252, 46, 14);
		contentPane.add(lblName);
		
		lblTaxNo = new JLabel("Α.Φ.Μ. :");
		lblTaxNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTaxNo.setBounds(106, 332, 67, 14);
		contentPane.add(lblTaxNo);
		
		lblPhoneNumber = new JLabel("Τηλέφωνο :");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPhoneNumber.setBounds(106, 412, 67, 14);
		contentPane.add(lblPhoneNumber);
		
		lblAddress = new JLabel("Διεύθυνση :");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAddress.setBounds(106, 490, 67, 14);
		contentPane.add(lblAddress);
		
		lblCity = new JLabel("Πόλη:");
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCity.setBounds(106, 572, 46, 14);
		contentPane.add(lblCity);
		
		lblLastname = new JLabel("Επώνυμο :");
		lblLastname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLastname.setBounds(569, 252, 67, 14);
		contentPane.add(lblLastname);
		
		lblFatherName = new JLabel("Πατρώνυμο :");
		lblFatherName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFatherName.setBounds(569, 332, 78, 14);
		contentPane.add(lblFatherName);
		
		lblEmail = new JLabel("e-mail :");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmail.setBounds(569, 412, 46, 14);
		contentPane.add(lblEmail);
		
		lblAddressNo = new JLabel("Αριθμός :");
		lblAddressNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAddressNo.setBounds(569, 490, 58, 14);
		contentPane.add(lblAddressNo);
		
		lblZipNo = new JLabel("Τ.Κ. :");
		lblZipNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblZipNo.setBounds(569, 572, 37, 14);
		contentPane.add(lblZipNo);
		
		JButton btnPrint = new JButton("Εκτύπωση");
		btnPrint.setForeground(Color.WHITE);
		btnPrint.setBackground(new Color(0, 125, 63));
		btnPrint.setBounds(510, 651, 220, 50);
		contentPane.add(btnPrint);
		
		separator = new JSeparator();
		separator.setBounds(74, 380, 798, 2);
		contentPane.add(separator);
		
		JLabel lblUUID = new JLabel("Κωδικός");
		lblUUID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUUID.setBounds(106, 183, 46, 14);
		contentPane.add(lblUUID);
		
		uuidText = new JTextField();
		uuidText.setEditable(false);
		uuidText.setBackground(new Color(240, 240, 240));
		uuidText.setBorder(null);
		uuidText.setBounds(260, 181, 210, 20);
		contentPane.add(uuidText);
		uuidText.setColumns(10);
		
		firstnameText = new JTextField();
		firstnameText.setEditable(false);
		firstnameText.setColumns(10);
		firstnameText.setBorder(null);
		firstnameText.setBackground(UIManager.getColor("Button.background"));
		firstnameText.setBounds(260, 250, 210, 20);
		contentPane.add(firstnameText);
		
		vatText = new JTextField();
		vatText.setEditable(false);
		vatText.setColumns(10);
		vatText.setBorder(null);
		vatText.setBackground(UIManager.getColor("Button.background"));
		vatText.setBounds(260, 330, 210, 20);
		contentPane.add(vatText);
		
		phoneNumText = new JTextField();
		phoneNumText.setEditable(false);
		phoneNumText.setColumns(10);
		phoneNumText.setBorder(null);
		phoneNumText.setBackground(UIManager.getColor("Button.background"));
		phoneNumText.setBounds(260, 410, 210, 20);
		contentPane.add(phoneNumText);
		
		streetText = new JTextField();
		streetText.setEditable(false);
		streetText.setColumns(10);
		streetText.setBorder(null);
		streetText.setBackground(UIManager.getColor("Button.background"));
		streetText.setBounds(260, 488, 210, 20);
		contentPane.add(streetText);
		
		cityText = new JTextField();
		cityText.setEditable(false);
		cityText.setColumns(10);
		cityText.setBorder(null);
		cityText.setBackground(UIManager.getColor("Button.background"));
		cityText.setBounds(260, 570, 210, 20);
		contentPane.add(cityText);
		
		lastnameText = new JTextField();
		lastnameText.setEditable(false);
		lastnameText.setColumns(10);
		lastnameText.setBorder(null);
		lastnameText.setBackground(UIManager.getColor("Button.background"));
		lastnameText.setBounds(662, 250, 210, 20);
		contentPane.add(lastnameText);
		
		fathernameText = new JTextField();
		fathernameText.setEditable(false);
		fathernameText.setColumns(10);
		fathernameText.setBorder(null);
		fathernameText.setBackground(UIManager.getColor("Button.background"));
		fathernameText.setBounds(662, 330, 210, 20);
		contentPane.add(fathernameText);
		
		emailText = new JTextField();
		emailText.setEditable(false);
		emailText.setColumns(10);
		emailText.setBorder(null);
		emailText.setBackground(UIManager.getColor("Button.background"));
		emailText.setBounds(662, 410, 210, 20);
		contentPane.add(emailText);
		
		streetNumText = new JTextField();
		streetNumText.setEditable(false);
		streetNumText.setColumns(10);
		streetNumText.setBorder(null);
		streetNumText.setBackground(UIManager.getColor("Button.background"));
		streetNumText.setBounds(662, 488, 210, 20);
		contentPane.add(streetNumText);
		
		zipcodeText = new JTextField();
		zipcodeText.setEditable(false);
		zipcodeText.setColumns(10);
		zipcodeText.setBorder(null);
		zipcodeText.setBackground(UIManager.getColor("Button.background"));
		zipcodeText.setBounds(662, 570, 210, 20);
		contentPane.add(zipcodeText);
	}
	
	private void fetchTeacherFromDatabase(String uuid) {
//		String sql = "SELECT * FROM teachers WHERE id = ?";
		String sql = "SELECT * FROM teachers WHERE uuid = ?";
		Connection connection = Dashboard.getConnection();
		
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			
			//ps.setInt(1, id);
			ps.setString(1, uuid);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				uuidText.setText(rs.getString("uuid"));
				
				uuidText.setText(rs.getString("uuid"));
				firstnameText.setText(rs.getString("firstname"));
				lastnameText.setText(rs.getString("lastname"));
				vatText.setText(rs.getString("vat"));
				fathernameText.setText(rs.getString("fathername"));
				phoneNumText.setText(rs.getString("phone_num"));
				emailText.setText(rs.getString("email"));
				streetText.setText(rs.getString("street"));
				streetNumText.setText(rs.getString("street_num"));
				int cityIdFromDB = rs.getInt("city_id"); // Get city_id from DB
				// Find the matching city using Streams
				City selectedCity = cities.stream()
				    .filter(city -> city.getId() == cityIdFromDB)
				    .findFirst()
				    .orElse(null); // Returns null if no match is found
				System.out.println("Selected City: " + selectedCity);
				// Select the city in the JComboBox
				if (selectedCity != null) {
				    cityText.setText(selectedCity.getName());
				}
				
				
				zipcodeText.setText(rs.getString("zipcode"));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,  "Select error in fetch teacher", "Error", JOptionPane.ERROR_MESSAGE);	
		}
	}
	
	private List<City> fetchCitiesFromDatabase() {
		String sql = "SELECT * FROM cities order by name asc";
		List<City> cities = new ArrayList<>();
		Connection conn = Dashboard.getConnection();
		
		try (PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			
	        while (rs.next()) {
	            int id = rs.getInt("id"); // Get the id column
	            String name = rs.getString("name"); // Get the name column

	            // Create a City object and add it to the list
	            City city = new City(id, name);
	            cities.add(city);
	        }     
		} catch (SQLException e) {
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null,  "Select error in fetch cities", "Error", JOptionPane.ERROR_MESSAGE);
		}
		return cities;	
	}
}
