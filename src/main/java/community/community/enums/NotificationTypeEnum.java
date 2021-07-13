package community.community.enums;

public enum NotificationTypeEnum {
	REPLY_QUESTION(1,"回覆問題"),
	REPLY_COMMENT(1,"回覆評論");
	private int type;
	private String name;
	
	
	
	NotificationTypeEnum(int type,String name) {
		this.type = type;
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public String getName() {
		return name;
	}
	
	public static String nameOfType(int type) {
		for(NotificationTypeEnum notificationTypeEnum : NotificationTypeEnum.values()) {
			return notificationTypeEnum.getName();
		}
		return "";
	}
	

}
