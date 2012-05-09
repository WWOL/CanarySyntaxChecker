/**
 * @author Brian McCarthy
 */

public enum Validity {
	UNKNOWN(0),
	OK(1),
	INFO(2),
	WARNING(3),
	ERROR(4);
	
	private int rank;
	
	private Validity(int paramRank){
		rank = paramRank;
	}
	
	public int getRank(){
		return rank;
	}
}
