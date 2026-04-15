package com.algorithm.visualizer.controller;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Controller
public class UserController {
    
    // Store participants per room
    private static Map<String, Map<String, String>> roomUsers = new ConcurrentHashMap<>();
    
    @MessageMapping("/room/{roomCode}/join")
    @SendTo("/topic/room/{roomCode}")
    public Map<String, Object> userJoin(@DestinationVariable String roomCode, Map<String, Object> message) {
        String userName = (String) message.get("userName");
        String sessionId = (String) message.get("sessionId");
        
        // Add user to room
        roomUsers.computeIfAbsent(roomCode, k -> new ConcurrentHashMap<>()).put(sessionId, userName);
        
        Map<String, Object> response = new HashMap<>();
        response.put("type", "USER_JOINED");
        response.put("userName", userName);
        response.put("participants", new ArrayList<>(roomUsers.get(roomCode).values()));
        response.put("count", roomUsers.get(roomCode).size());
        response.put("message", userName + " joined the room!");
        
        return response;
    }
    
    @MessageMapping("/room/{roomCode}/leave")
    @SendTo("/topic/room/{roomCode}")
    public Map<String, Object> userLeave(@DestinationVariable String roomCode, Map<String, Object> message) {
        String userName = (String) message.get("userName");
        String sessionId = (String) message.get("sessionId");
        
        // Remove user from room
        if(roomUsers.containsKey(roomCode)) {
            roomUsers.get(roomCode).remove(sessionId);
        }
        
        Map<String, Object> response = new HashMap<>();
        response.put("type", "USER_LEFT");
        response.put("userName", userName);
        
        if(roomUsers.containsKey(roomCode) && roomUsers.get(roomCode) != null) {
            response.put("participants", new ArrayList<>(roomUsers.get(roomCode).values()));
            response.put("count", roomUsers.get(roomCode).size());
        } else {
            response.put("participants", new ArrayList<>());
            response.put("count", 0);
        }
        response.put("message", userName + " left the room");
        
        return response;
    }
    
    @MessageMapping("/room/{roomCode}/code")
    @SendTo("/topic/room/{roomCode}")
    public Map<String, Object> codeUpdate(@DestinationVariable String roomCode, Map<String, Object> message) {
        Map<String, Object> response = new HashMap<>();
        response.put("type", "CODE_UPDATE");
        response.put("content", message.get("content"));
        response.put("userName", message.get("userName"));
        return response;
    }
}
