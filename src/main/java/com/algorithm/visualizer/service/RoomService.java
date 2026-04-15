package com.algorithm.visualizer.service;

import com.algorithm.visualizer.model.Room;
import com.algorithm.visualizer.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class RoomService {
    
    @Autowired
    private RoomRepository roomRepository;
    
    public Room createRoom() {
        Room room = new Room();
        room.setRoomCode(generateRoomCode());
        return roomRepository.save(room);
    }
    
    private String generateRoomCode() {
        return UUID.randomUUID().toString().substring(0, 6).toUpperCase();
    }
    
    public Room joinRoom(String roomCode) {
        return roomRepository.findByRoomCode(roomCode)
            .orElseThrow(() -> new RuntimeException("Room not found"));
    }
    
    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }
}
