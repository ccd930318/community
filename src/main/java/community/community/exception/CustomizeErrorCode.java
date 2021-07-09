package community.community.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode {

    QUESTION_NOT_FOUND(2001, "你找的問題不在了，要不要換其他的試試？"),
    TARGET_PARAM_NOT_FOUND(2002, "為選中任何問題或評論進行回覆"),
    NO_LOGIN(2003, "請登入後重試"),
    SYS_ERROR(2004, "伺服器壞了，稍後再試試！！！"),
    TYPE_PARAM_WRONG(2005, "評論類型錯誤或不存在"),
    COMMENT_NOT_FOUND(2006, "回覆的評論不存在，換個試試？"),
    CONTENT_IS_EMPTY(2007, "輸入內容不能為空"),
    READ_NOTIFICATION_FAIL(2008, "讀別人訊息?"),
    NOTIFICATION_NOT_FOUND(2009, "消息不見了"),
    FILE_UPLOAD_FAIL(2010, "圖片上傳失敗"),
    INVALID_INPUT(2011, "非法輸入"),
    INVALID_OPERATION(2012, "進入錯誤網頁，請重試"),
    ;

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    private Integer code;
    private String message;

    CustomizeErrorCode(Integer code, String message) {
        this.message = message;
        this.code = code;
    }
}
