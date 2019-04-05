package kr.hs.dgsw.web_01_0326.Service;

import kr.hs.dgsw.web_01_0326.Domain.Comment;
import kr.hs.dgsw.web_01_0326.Protocol.CommentUsernameProtocol;

import java.util.List;

public interface CommentService {
    List<CommentUsernameProtocol> listAllComments();

    CommentUsernameProtocol add(Comment comment);

    boolean DeleteComment(Long id);

    Comment updateComment(Long id, Comment comment);
}
