package records;
import java.util.Comparator;

/**
 * The malesComparatoe method for comparing the number of
 * males of the location.
 * @author Gurutejachowdary
 */
public abstract class Malescomparator implements Comparator<BankRecords> {

	@Override
	public int compare(BankRecords mal1, BankRecords mal2) {
		int result = mal2.getSex().compareTo(mal1.getSex());
		return result;
	}

}