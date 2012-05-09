/**
 * @author Brian McCarthy
 */

public class DataGroup {
	Validity validity = Validity.UNKNOWN;
	//	private String text;
	private String name;
	private String prefix;
	private String commands;
	private String inherited;
	private String admin;
	private String IP;
	private String group;

	public void setValidity(Validity paramValidity){
		if(paramValidity.getRank() > getValidity().getRank()){// Make sure we don't set and ERROR back down to an OK etc.
			validity = paramValidity;
		}
	}

	public Validity getValidity(){
		return validity;
	}

	public void setName(String paramName){
		name = paramName;
	}

	public String getName(){
		return name;
	}

	public void setPrefix(String paramPrefix){
		prefix = paramPrefix;
	}

	public String getPrefix(){
		return prefix;
	}

	public void setCommands(String paramCommands){
		commands = paramCommands;
	}

	public String getCommands(){
		return commands;
	}

	public void setInherited(String paramInherited){
		inherited = paramInherited;
	}

	public String getInherited(){
		return inherited;
	}

	public void setAdmin(String paramAdmin){
		admin = paramAdmin;
	}

	public String getAdmin(){
		return admin;
	}

	public void setIP(String paramIP){
		IP = paramIP;
	}

	public String getIP(){
		return IP;
	}
	
	public void setGroup(String paramGroup){
		group = paramGroup;
	}
	
	public String getGroup(){
		return group;
	}
}