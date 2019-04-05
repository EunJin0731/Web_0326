package kr.hs.dgsw.web_01_0326.Service;

import kr.hs.dgsw.web_01_0326.Domain.User;
import kr.hs.dgsw.web_01_0326.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp1 implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        Optional<User> found = this.userRepository.findByEmail(user.getEmail());
        if(found.isPresent()) return null;
        return this.userRepository.save(user);
        // return this.userRepository.findByEmail(user.getEmail()).map(u->(User)null).orElse(this.userRepository.save(user));
    }

    @Override
    public List<User> ListUser() {
        return this.userRepository.findAll();
    }

    @Override
    public boolean deleteUser(Long id) {
        try{
            this.userRepository.deleteById(id);
            return true;
        } catch (Exception ex){
            return false;
        }
    }

    @Override
    public User updateUser(Long id, User user) {
        return this.userRepository.findById(id)
                .map(found -> {
                    found.setUsername(Optional.ofNullable(user.getUsername()).orElse(found.getUsername()));
                    found.setEmail(Optional.ofNullable(user.getEmail()).orElse(found.getEmail()));
                    found.setFilelocal(Optional.ofNullable(user.getFilelocal()).orElse(found.getFilelocal()));
                    found.setFilename(Optional.ofNullable(user.getFilename()).orElse(found.getFilename()));
                    return this.userRepository.save(found);
                })
                .orElse(null);
    }

//    @Override
//    public User deleteUser(User user){
//        Optional<User> found = this.userRepository.findByEmail(user.getUsername());
//        if(found.isPresent()) return null;
//        return this.userRepository.delete();
//    }

}
