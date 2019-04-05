package kr.hs.dgsw.web_01_0326.Protocol;

import kr.hs.dgsw.web_01_0326.Domain.Comment;
import kr.hs.dgsw.web_01_0326.Domain.User;
import lombok.Data;

import java.util.List;

@Data
public class CommentUsernameProtocol extends Comment {

    private String username;
//    User user;
//    List<Comment> comment;

    public CommentUsernameProtocol(Comment c, String username){
        super(c);
        this.username = username;
    }

//    public CommentUsernameProtocol(User user, List<Comment> comment){
//        this.user = user;
//        this.comment = comment;
//    }
}
