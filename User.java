/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.conferencehallreservation;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Jr. Gedik
 */
public class User {

    private String username;
    private String password;
    private ArrayList<Reservation> reservations = new ArrayList<>(); 
    
    

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        
        
    }
    
    public ArrayList<Reservation> getReservations(){
        
        return reservations;
        
    }
    
    public void addReservation(Reservation reservation){
        reservations.add(reservation);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   /* public static boolean login(String inputUsername, String inputPassword) {
    for (User user : userList) {
        if (user.getUsername().equals(inputUsername) && user.getPassword().equals(inputPassword)) {
            System.out.println("Login successful!");
            return true;
        }
    }
    System.out.println("Invalid username or password");
    return false;
}


    public static void addUser(String username, String password) {
        new User(username, password);
    }

    public static void listUser() {
        for (User user : userList) {
            System.out.println("Username: " + user  .getUsername());
        }
    }*/

    @Override
    public String toString() {
        return "User{" + "username= " + username + '}';
    } 

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.username);
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
        final User other = (User) obj;
        return Objects.equals(this.username, other.username);
    }
    
    

}
