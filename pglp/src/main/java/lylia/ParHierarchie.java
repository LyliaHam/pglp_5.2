import java.util.Stack;

public class ParHierarchie extends PersonnelTypeIterator {
	
	public ParHierarchie (PersonnelGroupe personnelGroupe) {
		super(personnelGroupe, new Stack<PersonnelType>());
	}

	@Override
	protected PersonnelType getFromCollection() {
		return ((Stack<PersonnelType>) collection).pop();
	}
}
