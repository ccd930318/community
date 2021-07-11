package community.community.dto;

import community.community.model.UserAccount;
import lombok.Data;

@Data
public class CommentDTO {

   private Long id;
   private Long parentId;
   private String content;
   private Integer type;
   private Long commentator;
   private Long gmtCreate;
   private Long gmtModified;
   private Long likeCount;
   private Integer commentCount;
   private UserAccount userAccount;
}
