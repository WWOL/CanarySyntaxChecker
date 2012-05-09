/**
 * @author Brian McCarthy
 */

import java.util.HashMap;
import java.util.Map;

public abstract class Analyser {
	
	private int minSplit = 0;
	private int maxSplit = 0;
	private String text;
	public static Map<Integer, DataGroup> filteredData = new HashMap<Integer, DataGroup>();
	private int lineNum = 0;
	
	public void setMinSplit(int paramMinSplit){
		minSplit = paramMinSplit;
	}
	
	public int getMinSplit(){
		return minSplit;
	}
	
	public void setMaxSplit(int paramMaxSplit){
		maxSplit = paramMaxSplit;
	}
	
	public int getMaxSplit(){
		return maxSplit;
	}
	
	public void setText(String paramText){
		text = paramText;
	}
	
	public String getText(){
		return text;
	}
	
	public void setLineNum(int paramLineNum){
		lineNum = paramLineNum;
	}
	
	public int getLineNum(){
		return lineNum;
	}
	
	public boolean isComment(String paramString){
		if (paramString.startsWith("#") || paramString.startsWith("//") || paramString.trim().equals("")){
			return true;
		}
		return false;
	}
	
	public static DataGroup getDataGroupFromLineNum(int paramLineNum){
		return filteredData.get(paramLineNum);
	}
	public abstract void startAnalysing();
	
	public abstract void setup();
	
	public abstract String[] fixNullWithDefault(String[] paramStringArray);
	
}
