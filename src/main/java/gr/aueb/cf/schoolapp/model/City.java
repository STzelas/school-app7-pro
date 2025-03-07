package gr.aueb.cf.schoolapp.model;

public class City {
	private int id;
	private String name;
	
	public City() {
		
	}

	public City(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// Όταν το combo box γίνει populate με τα 
	// cities θέλει μία toString που να 
	// επιστρέφει μόνο το name για να το δείχνει
	@Override
	public String toString() {
		return name;                
	}
	
	
}
