package gr.aueb.cf.schoolapp.view_controller;

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
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShowTeacherPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textLastnameSearch;
	private JTable table;
	private DefaultTableModel model = new DefaultTableModel();
	private String selectedUUID;

	
	public ShowTeacherPage() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				buildTable();
			}
		});
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1049, 771);
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
		govImage.setIcon(new ImageIcon(ShowTeacherPage.class.getResource("/images/gov_logo_small.png")));
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
		footer.setBounds(0, 647, 1033, 85);
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
		
		JLabel lblQuality = new JLabel("Αιτήσεις Εκπαιδευτών");
		lblQuality.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuality.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblQuality.setBounds(309, 68, 415, 78);
		contentPane.add(lblQuality);
		
		JButton btnShow = new JButton("Προβολή");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getShowTeacherPage().setEnabled(false);
				Main.getViewpage().setEnabled(true);
				Main.getViewpage().setVisible(true);
			}
		});
		btnShow.setForeground(Color.WHITE);
		btnShow.setBackground(new Color(0, 136, 0));
		btnShow.setBounds(816, 290, 183, 46);
		contentPane.add(btnShow);
		
		JButton btnEdit = new JButton("Επεξεργασία");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getShowTeacherPage().setEnabled(false);
				Main.getUpdatePage().setEnabled(true);
				Main.getUpdatePage().setVisible(true);
			}
		});
		btnEdit.setForeground(Color.WHITE);
		btnEdit.setBackground(new Color(0, 136, 0));
		btnEdit.setBounds(816, 347, 183, 46);
		contentPane.add(btnEdit);
		
		JButton btnDelete = new JButton("Διαγραφή");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doDelete(selectedUUID);
			}
		});
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBackground(new Color(0, 136, 0));
		btnDelete.setBounds(816, 403, 183, 46);
		contentPane.add(btnDelete);
		
		JButton btnClose = new JButton("Κλείσιμο");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getShowTeacherPage().setVisible(false);
				Main.getShowTeacherPage().setEnabled(false);
				Main.getDashboard().setEnabled(true);
				Main.getDashboard().setVisible(true);
			}
		});
		btnClose.setForeground(Color.WHITE);
		btnClose.setBackground(new Color(192, 192, 192));
		btnClose.setBounds(816, 579, 183, 57);
		contentPane.add(btnClose);
		
		JButton btnSearch = new JButton("Αναζήτηση");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buildTable();
			}
		});
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setBackground(new Color(0, 136, 0));
		btnSearch.setBounds(332, 157, 183, 46);
		contentPane.add(btnSearch);
		
		JButton btnClearAll = new JButton("Εκκαθάριση");
		btnClearAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textLastnameSearch.setText("");
				buildTable();
			}
		});
		btnClearAll.setForeground(Color.WHITE);
		btnClearAll.setBackground(new Color(120, 201, 209));
		btnClearAll.setBounds(525, 157, 183, 46);
		contentPane.add(btnClearAll);
		
		textLastnameSearch = new JTextField();
		textLastnameSearch.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textLastnameSearch.setBounds(126, 157, 183, 46);
		contentPane.add(textLastnameSearch);
		textLastnameSearch.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Επώνυμο");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(60, 172, 56, 14);
		contentPane.add(lblNewLabel);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                // Check if the selection is still adjusting
                if (!e.getValueIsAdjusting()) {
                    // Get the selected row index
                    int selectedRow = table.getSelectedRow();

                    // Check if a row is selected
                    if (selectedRow != -1) {
                        // Get data from the selected row
                        //String selectedStr = (String) model.getValueAt(selectedRow, 0); // ID column
                        //selectedId = Integer.parseInt(selectedStr);
                        //selectedId = Integer.parseInt(selectedStr);
                    	selectedUUID = (String) model.getValueAt(selectedRow, 0);
                        
                    }
                }
            }
        });
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBorder(new LineBorder(new Color(210, 210, 210)));
		scrollPane.setBounds(60, 240, 665, 396);
		contentPane.add(scrollPane);
		
		
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Κωδικός", "Όνομα", "Επώνυμο"
			}
		));
		table.setBounds(57, 192, 507, 307);
		model = (DefaultTableModel) table.getModel();
		
	
	}
	
	private void buildTable() {
		String sql = "SELECT uuid, firstname, lastname FROM teachers WHERE lastname LIKE ?";
		Connection connection = Dashboard.getConnection();
		
		try(PreparedStatement ps = connection.prepareStatement(sql);) {
			
			
			ps.setString(1, textLastnameSearch.getText().trim() + "%");
			ResultSet rs = ps.executeQuery();
			
			model.setRowCount(0); // clears table
			while(rs.next()) {
				Object[] row = {
						rs.getString("uuid"),
						rs.getString("firstname"),
						rs.getString("lastname")
				};
				model.addRow(row);
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "Λάθος στην αναζήτηση", "Error.", JOptionPane.ERROR_MESSAGE);
		}
	}

	public String getSelectedUUID() {
		return selectedUUID;
	}
	
	private void doDelete(String uuid) {
//		String sql = "DELETE FROM teachers WHERE id = ?";
		String sql = "DELETE FROM teachers WHERE uuid = ?";
		Connection conn = Dashboard.getConnection();
		
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			
			//ps.setInt(1, id);
			ps.setString(1, uuid);
			
			int answer = JOptionPane.showConfirmDialog(null, "Είστε σίγουρη/ος", "Διαγραφή", 
					JOptionPane.YES_NO_OPTION);
			if (answer == JOptionPane.YES_OPTION) {
				int rowsAffected = ps.executeUpdate();
				JOptionPane.showMessageDialog(null, rowsAffected + " γρααμμή/ες διαγράφηκαν", "Διαγραφή", 
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				return;
			}							
		} catch (SQLException ex) {
			//ex.printStackTrace();
			JOptionPane.showMessageDialog(null,  "Delete error", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
}
