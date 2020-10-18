package ar.com.codereview.api.codereview.enums;

public enum LoggerTypeEnum {
    
    CONSOLE ("console"), 
	DATABASE ("database"), 
	FILE ("file");
	
	private String type;
	
	private LoggerTypeEnum(final String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}
