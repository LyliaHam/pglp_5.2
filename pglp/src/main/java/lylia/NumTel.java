public class NumTel {
	private String nom;
	private String tel;
	

	public NumTel (String nom, String tel) {
		this.nom = nom;
		this.tel = tel;
	}

	@Override
	public String toString() {
		return nom + " - " + tel;
	}

	public String getNom() {
		return nom;
	}

	public String getTelephone() {
		return tel;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setTelephone(String tel) {
		this.tel = tel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NumTel other = (NumTel) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		return true;
	}
	
	
	
	
}
