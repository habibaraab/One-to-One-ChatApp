package com.spring.onetoonechatapp.ChatMessage.Service;


import com.spring.onetoonechatapp.ChatMessage.Model.ChatMessage;
import com.spring.onetoonechatapp.ChatMessage.Repository.ChatMessageRepository;
import com.spring.onetoonechatapp.ChatRoom.Service.ChatRoomService;
import com.spring.onetoonechatapp.Exception.ChatRoomNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatMessageService {
    private final ChatMessageRepository chatMessageRepository;
    private final ChatRoomService chatRoomService;

    public ChatMessage save(ChatMessage chatMessage) {
        var chatId = chatRoomService
                .getChatRoomId(chatMessage.getSenderId(), chatMessage.getRecipientId(), true)
                .orElseThrow(() -> new ChatRoomNotFoundException("Chat room not found for senderId: "
                        + chatMessage.getSenderId() + " and recipientId: " + chatMessage.getRecipientId()));

        chatMessage.setChatId(chatId);
        return chatMessageRepository.save(chatMessage);
    }

    public List<ChatMessage> findChatMessages(String senderId, String recipientId) {
        var chatId = chatRoomService.getChatRoomId(senderId, recipientId, false);
        return chatId.map(chatMessageRepository::findByChatId).orElse(new ArrayList<>());
    }
}
