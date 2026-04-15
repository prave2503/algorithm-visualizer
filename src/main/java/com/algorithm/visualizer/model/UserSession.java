package com.algorithm.visualizer.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class UserSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String sessionId;
    private String userName;
    private String cursorPosition;
    private LocalDateTime joinTime;
    
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
    
    public UserSession() {}
    
    @PrePersist
    protected void onCreate() {
        joinTime = LocalDateTime.now();
        cursorPosition = "0,0";
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getSessionId() { return sessionId; }
    public void setSessionId(String sessionId) { this.sessionId = sessionId; }
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
    public String getCursorPosition() { return cursorPosition; }
    public void setCursorPosition(String cursorPosition) { this.cursorPosition = cursorPosition; }
    public LocalDateTime getJoinTime() { return joinTime; }
    public void setJoinTime(LocalDateTime joinTime) { this.joinTime = joinTime; }
    public Room getRoom() { return room; }
    public void setRoom(Room room) { this.room = room; }
}
