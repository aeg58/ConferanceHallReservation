/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.conferencehallreservation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Jr. Gedik
 */
public class Reservation {

    private User user;
    private ConferenceHall conferanceHall;
    private LocalDateTime starTime;
    private LocalDateTime endTime;

    public Reservation(User user, ConferenceHall conferanceHall, LocalDateTime starTime, LocalDateTime endTime) {
        this.user = user;
        this.conferanceHall = conferanceHall;
        this.starTime = starTime;
        this.endTime = endTime;

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ConferenceHall getConferanceHall() {
        return conferanceHall;
    }

    public void setConferanceRoom(ConferenceHall conferanceRoom) {
        this.conferanceHall = conferanceRoom;
    }

    public LocalDateTime getStarTime() {
        return starTime;
    }

    public void setStarTime(LocalDateTime starTime) {
        this.starTime = starTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public void updateReservation(LocalDateTime newStartTime, LocalDateTime newEndTime) {
        this.starTime = newStartTime;
        this.endTime = newEndTime;
        System.out.println("Resarvation updated for " + conferanceHall.getHallName() + " to new time: " + starTime + " - " + endTime);
    }

    public void cancelReservation() {
        System.out.println("Reservation for " + conferanceHall.getHallName() + " has been canceled.");
        
        conferanceHall.cancelReservation(this);
    }

    @Override
    public String toString() {
    
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    
    return String.format(
        "User: %s | Hall: %s | Start: %s | End: %s",
        user.getUsername(),  // Kullanıcı adı
        conferanceHall.getHallName(),  
        starTime.format(formatter),  
        endTime.format(formatter)  
    );
}

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.user);
        hash = 79 * hash + Objects.hashCode(this.conferanceHall);
        hash = 79 * hash + Objects.hashCode(this.starTime);
        hash = 79 * hash + Objects.hashCode(this.endTime);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reservation other = (Reservation) obj;
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (!Objects.equals(this.conferanceHall, other.conferanceHall)) {
            return false;
        }
        if (!Objects.equals(this.starTime, other.starTime)) {
            return false;
        }
        return Objects.equals(this.endTime, other.endTime);
    }
    

    

}
