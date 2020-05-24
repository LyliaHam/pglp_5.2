public abstract class PersonnelType {

	abstract public boolean isGroupe();
	
	public String typeString() {
		return (isGroupe() ? "Groupe" : "Personnel");
	}
}
