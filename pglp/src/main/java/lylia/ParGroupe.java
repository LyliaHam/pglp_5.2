import java.util.ArrayDeque;

public class ParGroupe extends PersonnelTypeIterator {

	public ParGroupe PersonnelGroupe (personnelGroupe) {
		super(personnelGroupe, new ArrayDeque<PersonnelType>());
	}
	
	@Override
	protected PersonnelType getFromCollection() {
		return ((ArrayDeque<PersonnelType>) collection).remove();
	}

}
