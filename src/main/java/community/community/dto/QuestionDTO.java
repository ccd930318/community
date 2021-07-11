package community.community.dto;

import community.community.model.UserAccount;
import lombok.Data;

@Data
public class QuestionDTO {
	private Long id;
	private String title;
	private String description;
	private String tag;
	private Long gmtCreate;
	private Long gmtModified;
	private Long creator;
	private Integer viewCount;
	private Integer commentCount;
	private Integer likeCount;
	private UserAccount userAccount;
}
