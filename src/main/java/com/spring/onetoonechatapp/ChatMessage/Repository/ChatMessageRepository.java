package com.spring.onetoonechatapp.ChatMessage.Repository;

import com.spring.onetoonechatapp.ChatMessage.Model.ChatMessage;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ChatMessageRepository extends MongoRepository<ChatMessage, String> {
    List<ChatMessage> findByChatId(String chatId);

}
