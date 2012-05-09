/**
 * @author Brian McCarthy
 */

public class UserAnalyser extends Analyser{
	DataGroup currDataGroup = null;
	
	public UserAnalyser(String paramText){
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
			dataGroup.setGroup(split[1]);
			dataGroup.setAdmin(split[2]);
			dataGroup.setPrefix(split[3]);
			dataGroup.setCommands(split[3]);
			dataGroup.setIP(split[5]);
			dataGroup.setInherited("Users inherit via groups!");
			filteredData.put(getLineNum(), dataGroup);
			setLineNum(getLineNum() + 1);
		}// end for
	}

	public void setup() {
		setMinSplit(2);
		setMaxSplit(6);
	}

	public String[] fixNullWithDefault(String[] paramStringArray) {
		String[] toRet = new String[6];
		if (paramStringArray.length < 1) {
			toRet[0] = "No Name!";
			currDataGroup.setValidity(Validity.ERROR);
		} else {
			toRet[0] = paramStringArray[0];
		}
		
		if (paramStringArray.length < 2) {
			toRet[1] = "No Group!";
			currDataGroup.setValidity(Validity.ERROR);
		} else {
			toRet[1] = paramStringArray[1];
		}
		
		if (paramStringArray.length < 3) {
			toRet[2] = "No Admin Flag!";
			currDataGroup.setValidity(Validity.OK);
		} else {
			toRet[2] = paramStringArray[2];
		}
		
		if (paramStringArray.length < 4) {
			toRet[3] = "No Prefix!";
			currDataGroup.setValidity(Validity.OK);
		} else {
			toRet[3] = paramStringArray[3];
		}
		
		if (paramStringArray.length < 5) {
			toRet[4] = "No Commands!!";
			currDataGroup.setValidity(Validity.OK);
		} else {
			toRet[4] = paramStringArray[4];
		}
		
		if (paramStringArray.length < 6) {
			toRet[5] = "No IP!";
			currDataGroup.setValidity(Validity.OK);
		} else {
			toRet[5] = paramStringArray[5];
		}
		currDataGroup.setValidity(Validity.OK);		return toRet;
	}
}
