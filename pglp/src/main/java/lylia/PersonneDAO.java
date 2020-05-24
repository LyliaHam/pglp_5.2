package uvsq.pglp_5_2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class PersonneDAO implements DAO<Personnel>{

	private static String dbURL = "jdbc:derby:jdbcDB;";
	public static Connection connect = null;

	
	public PersonneDAO(){
		
		try {
			connect = DriverManager.getConnection(dbURL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	
	
	public Personnel create(Personnel obj) {

		try{
			PreparedStatement prepare = (PreparedStatement) connect.prepareStatement(
				"INSERT INTO personne ( nom, prenom, fonction) VALUES (?, ?, ?)");
			prepare.setString(1, obj.nom);
			prepare.setString(2, obj.prenom);
			prepare.setString(3, obj.fonction);

			boolean i = prepare.execute();
						
			prepare.close();
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return obj;
	}

	public Personnel read(String nom) {
		
		try{
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT *"
                    + " FROM personne where nom = '"+nom+"'");
			while (rs.next()) {
				
				return new Personnel
		        		.Builder(rs.getString("nom"), rs.getString("prenom"), LocalDateTime.now())
		        		.add_tel(3)
		        		.function(rs.getString("fonction"))
		        		.build();
            }
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	public Personnel update(Personnel obj) {
		return null;
	}

	public void delete(CompositePersonnel obj) {

		
	}



	public void delete(Personnel obj) {
		
	}

}
