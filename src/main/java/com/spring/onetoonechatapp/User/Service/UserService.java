package com.spring.onetoonechatapp.User.Service;

import com.spring.onetoonechatapp.Exception.UserNotFoundException;
import com.spring.onetoonechatapp.User.Enum.Status;
import com.spring.onetoonechatapp.User.Repository.UserRepository;
import com.spring.onetoonechatapp.User.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void saveUser(User user) {
        user.setStatus(Status.ONLINE);
        userRepository.save(user);
    }

    public void disconnectUser(User user) {
        var storedUser = userRepository.findById(user.getNickName())
                .orElseThrow(() -> new UserNotFoundException("User not found with nickname: " + user.getNickName()));
        storedUser.setStatus(Status.OFFLINE);
        userRepository.save(storedUser);
    }

    public List<User> findConnectedUsers() {
        return userRepository.findAllByStatus(Status.ONLINE);
    }
}
