package com.spring.onetoonechatapp.User.Repository;

import com.spring.onetoonechatapp.User.Enum.Status;
import com.spring.onetoonechatapp.User.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    List<User> findAllByStatus(Status status);
}
