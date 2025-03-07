package gr.aueb.cf.schoolapp;

import gr.aueb.cf.schoolapp.view_controller.*;
import java.awt.EventQueue;

public class Main {
	private static final LandingPage LandingPage = new LandingPage();
	private static final LoginPage LoginPage = new LoginPage();
	private static final Dashboard Dashboard = new Dashboard();
	private static final ShowTeacherPage ShowTeacherPage = new ShowTeacherPage();
	private static final InsertPage InsertPage = new InsertPage();
	private static final ViewPage ViewPage = new ViewPage();
	private static final UpdatePage UpdatePage = new UpdatePage();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LandingPage.setVisible(true);
					LandingPage.setLocationRelativeTo(null);
					
					LoginPage.setVisible(false);
					LoginPage.setLocationRelativeTo(null);
					
					Dashboard.setVisible(false);
					Dashboard.setLocationRelativeTo(null);
					
					ShowTeacherPage.setVisible(false);
					ShowTeacherPage.setLocationRelativeTo(null);
					
					InsertPage.setVisible(false);
					InsertPage.setLocationRelativeTo(null);
					
					ViewPage.setVisible(false);
					ViewPage.setLocationRelativeTo(null);
					
					UpdatePage.setVisible(false);
					UpdatePage.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public static LandingPage getLandingPage() {
		return LandingPage;
	}


	public static LoginPage getLoginPage() {
		return LoginPage;
	}


	public static Dashboard getDashboard() {
		return Dashboard;
	}


	public static ShowTeacherPage getShowTeacherPage() {
		return ShowTeacherPage;
	}


	public static InsertPage getInsertPage() {
		return InsertPage;
	}


	public static ViewPage getViewpage() {
		return ViewPage;
	}


	public static UpdatePage getUpdatePage() {
		return UpdatePage;
	}
	
}
