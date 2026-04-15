package com.algorithm.visualizer.controller;

import com.algorithm.visualizer.model.Room;
import com.algorithm.visualizer.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/rooms")
@CrossOrigin(origins = "*")
public class RoomController {
    
    @Autowired
    private RoomService roomService;
    
    @PostMapping("/create")
    public ResponseEntity<Map<String, String>> createRoom() {
        Room room = roomService.createRoom();
        Map<String, String> response = new HashMap<>();
        response.put("roomCode", room.getRoomCode());
        return ResponseEntity.ok(response);
    }
    
    @PostMapping("/join/{roomCode}")
    public ResponseEntity<Room> joinRoom(@PathVariable String roomCode) {
        Room room = roomService.joinRoom(roomCode);
        return ResponseEntity.ok(room);
    }
}
