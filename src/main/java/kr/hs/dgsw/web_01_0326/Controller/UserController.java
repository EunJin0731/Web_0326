package kr.hs.dgsw.web_01_0326.Controller;

import kr.hs.dgsw.web_01_0326.Domain.User;
import kr.hs.dgsw.web_01_0326.Repository.UserRepository;
import kr.hs.dgsw.web_01_0326.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/adduser")
    public User addUser(@RequestBody User user){
        return this.userService.addUser(user);
    }

    @GetMapping("/user")
    public List<User> list(){
        return this.userService.ListUser();
    }

    @DeleteMapping("/deleteuser/{id}")
    public boolean deleteUser(@PathVariable Long id){
        return this.userService.deleteUser(id);
    }

    @PutMapping("/updateuser/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user){
        return this.userService.updateUser(id, user);
    }
}
