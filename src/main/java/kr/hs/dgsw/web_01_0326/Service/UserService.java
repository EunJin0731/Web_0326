package kr.hs.dgsw.web_01_0326.Service;

import kr.hs.dgsw.web_01_0326.Domain.User;

import java.util.List;

public interface UserService {

    User addUser(User user);

    List<User> ListUser();

    boolean deleteUser(Long id);

    User updateUser(Long id, User user);
}
