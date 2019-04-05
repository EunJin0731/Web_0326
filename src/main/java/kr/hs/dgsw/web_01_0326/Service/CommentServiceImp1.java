package kr.hs.dgsw.web_01_0326.Service;

import kr.hs.dgsw.web_01_0326.Domain.Comment;
import kr.hs.dgsw.web_01_0326.Domain.User;
import kr.hs.dgsw.web_01_0326.Protocol.CommentUsernameProtocol;
import kr.hs.dgsw.web_01_0326.Repository.CommentRepository;
import kr.hs.dgsw.web_01_0326.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImp1 implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    private void init(){
        User u = this.userRepository.save(new User("abc", "abcdgsw"));
        this.commentRepository.save(new Comment(u.getId(), "hi 111"));
        this.commentRepository.save(new Comment(u.getId(), "hi 222"));
        this.commentRepository.save(new Comment(u.getId(), "hi 333"));
    }

    @Override
    public List<CommentUsernameProtocol> listAllComments() {
        List<Comment> commentList = this.commentRepository.findAll();

        List<CommentUsernameProtocol> cuplist = new ArrayList<>();

        commentList.forEach(comment -> {
            /*Optional<User> found = this.userRepository.findById(comment.getUserid());
            String username = null;
            if(found.isPresent()) username = found.get().getUsername();
            // String username = (found.isPresent()) ? found.get().getUsername() : null;*/

            cuplist.add(new CommentUsernameProtocol(comment, this.userRepository.findById(comment.getUserid()).map(u->u.getUsername()).orElse(null)));
            // cup = (CommentUsernameProtocol) comment;
            // cup.setUsername(username);
            // cup.setContent(comment.getContent());
        });
        return cuplist;
    }

    @Override
    public CommentUsernameProtocol add(Comment comment){
        Comment added = this.commentRepository.save(comment);
        return new CommentUsernameProtocol(added, this.userRepository.findById(added.getUserid()).map(u->u.getUsername()).orElse(null));
    }

    @Override
    public boolean DeleteComment(Long id) {
        try{
            this.commentRepository.deleteById(id);
            return true;
        } catch (Exception ex){
            return false;
        }
    }

    @Override
    public Comment updateComment(Long id, Comment comment) {
        return this.commentRepository.findById(id)
                .map(found -> {
                    found.setId(Optional.ofNullable(comment.getId()).orElse(found.getId()));
                    found.setContent(Optional.ofNullable(comment.getContent()).orElse(found.getContent()));
                    return this.commentRepository.save(found);
                })
                .orElse(null);
    }
}
