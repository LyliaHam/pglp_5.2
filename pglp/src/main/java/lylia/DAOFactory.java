package uvsq.pglp_5_2;

public class DAOFactory {

	public static DAO<Personnel> getPersonneDAO(){
		return new PersonneDAO();
		
		
	}

}
