package com.spring.onetoonechatapp.User.model;


import com.spring.onetoonechatapp.User.Enum.Status;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Setter
@Getter
@Builder
public class User {
    @Id
    private String nickName;
    private String fullName;
    private Status status;
}
