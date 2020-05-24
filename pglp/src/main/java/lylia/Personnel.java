import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class Personnel extends PersonnelType {

	private final String nom;
	private final String prenom;
	private final String fonction;
	private final LocalDate dateNaissance;
	private final List<NumTel> numerosTelephone;
	
	public static class PersonnelBuilder {
		
		
		private final String nom;
		private final String prenom;
		private final String fonction;
		
		// Optionnel
		private LocalDate dateNaissance = null;
		private List<NumTel> numerosTelephone = new ArrayList<NumTel>();
		
		public PersonnelBuilder(String nom, String prenom, String fonction) {
			this.nom = nom;
			this.prenom = prenom;
			this.fonction = fonction;
		}
		
		public PersonnelBuilder dateNaissance(LocalDate dateNaissance) {
			this.dateNaissance = dateNaissance;
			return this;
		}
		
		public PersonnelBuilder addNumeroTelephone(NumTel numeroTelephone) {
			this.numerosTelephone.add(numeroTelephone);
			return this;
		}
		
		public Personnel build() {
			return new Personnel(this);
		}
	}
	
	private Personnel(PersonnelBuilder builder) {
		nom = builder.nom;
		prenom = builder.prenom;
		fonction = builder.fonction;
		dateNaissance = builder.dateNaissance;
		numerosTelephone = builder.numerosTelephone;
	}
	
public String toString() {
		return nom + " " + prenom + " " + fonction + " "
				+ dateNaissance.format(DateTimeFormatter.ISO_DATE) + " "
				+ numerosTelephone.stream().map(NumTel::toString).collect(Collectors.toList());
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getFonction() {
		return fonction;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public List<NumTel> getNumerosTelephone() {
		return numerosTelephone;
	}
	
	@Override
	public boolean isGroupe() {
		return false;
	}
	
}
