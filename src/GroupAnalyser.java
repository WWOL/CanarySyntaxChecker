/**
 * @author Brian McCarthy
 */

public class GroupAnalyser extends Analyser{
	DataGroup currDataGroup = null;

	public GroupAnalyser(String paramText){
		setText(paramText);
	}

	public void startAnalysing() {
		String[] stringArray = getText().split("\n");
		for (String line : stringArray){
			if (isComment(line)){
				continue;
			}// end if
			String[] split = line.split(":");
			if (split.length < getMinSplit() || split.length > getMaxSplit()){
				continue;
			}// end if
			DataGroup dataGroup = new DataGroup();
			currDataGroup = dataGroup;
			split = fixNullWithDefault(split);
			dataGroup.setName(split[0]);
			dataGroup.setPrefix(split[1]);
			dataGroup.setCommands(split[2]);
			dataGroup.setInherited(split[3]);
			dataGroup.setAdmin(split[4]);
			dataGroup.setIP("Groups dont have IP's!");
			dataGroup.setGroup("Only users get an assigned group!");
			filteredData.put(getLineNum(), dataGroup);
			setLineNum(getLineNum() + 1);
		}// end for
	}// end startAnalysing

	public void setup() {
		setMinSplit(2);
		setMaxSplit(5);
	}

	public String[] fixNullWithDefault(String[] paramStringArray){
		String[] toRet = new String[6];
		if (paramStringArray.length < 1) {
			toRet[0] = "No Name!";
			currDataGroup.setValidity(Validity.ERROR);
		} else {
			toRet[0] = paramStringArray[0];
		}

		if (paramStringArray.length < 2) {
			toRet[1] = "No Prefix!";
			currDataGroup.setValidity(Validity.INFO);
		} else {
			toRet[1] = paramStringArray[1];
		}

		if (paramStringArray.length < 3) {
			toRet[2] = "No Commands!";
			currDataGroup.setValidity(Validity.INFO);
		} else {
			toRet[2] = paramStringArray[2];
		}

		if (paramStringArray.length < 4) {
			toRet[3] = "No Inheritance!";
			currDataGroup.setValidity(Validity.WARNING);
		} else {
			toRet[3] = paramStringArray[3];
		}

		if (paramStringArray.length < 5) {
			toRet[4] = "No Admin Flag!";
			currDataGroup.setValidity(Validity.INFO);
		} else {
			toRet[4] = paramStringArray[4];
		}
		currDataGroup.setValidity(Validity.OK);
		return toRet;
	}
}
