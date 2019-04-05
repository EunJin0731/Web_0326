package kr.hs.dgsw.web_01_0326.Controller;

import kr.hs.dgsw.web_01_0326.Domain.Comment;
import kr.hs.dgsw.web_01_0326.Protocol.CommentUsernameProtocol;
import kr.hs.dgsw.web_01_0326.Repository.CommentRepository;
import kr.hs.dgsw.web_01_0326.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;


    @GetMapping("/comment")
    public List<CommentUsernameProtocol> list() {
        return this.commentService.listAllComments();
    }

    @DeleteMapping("/deletecomment/{id}")
    public boolean delete(@PathVariable Long id){ return this.commentService.DeleteComment(id);}

    @PostMapping("/add")
    public CommentUsernameProtocol add(@RequestBody Comment comment) { return this.commentService.add(comment); }

    @PutMapping("/updatecomment/{id}")
    public Comment updateUser(@PathVariable Long id, @RequestBody Comment comment){
        return this.commentService.updateComment(id, comment);
    }
}
