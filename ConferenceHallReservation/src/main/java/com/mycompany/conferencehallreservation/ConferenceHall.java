/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.conferencehallreservation;

import java.awt.List;
import java.util.ArrayList;

/**
 * konferansçı
 *
 * @author Jr. Gedik
 */
public class ConferenceHall {

    private  String hallName;
    private int capacity;
    private  boolean availability;
    private  ArrayList<Reservation> rezList;
    private static ArrayList<ConferenceHall> listOfHall;
    private static final int hallCount = 5;

    private ConferenceHall(String conferenceName, int capacity, boolean availability) {
        this.hallName = conferenceName;
        this.capacity = capacity;
        this.availability = availability;
        this.rezList = new ArrayList<>();

    }

    private static void initConferenceHall() {
        listOfHall = new ArrayList<>(hallCount);
        for (int i = 0; i < 5; i++) {
            listOfHall.add(new ConferenceHall("Hall " + (i + 1), (i + 1) * 10, true));
        }
    }

    public static ConferenceHall getConferenceHall(String hallName) {
        if (listOfHall == null) {
            initConferenceHall();
        }
        for (ConferenceHall conferenceHall : listOfHall) {
            if (hallName.equals(conferenceHall.getHallName())) {
                return conferenceHall;
            }
        }
        return null;
    }

    public static ArrayList<ConferenceHall> getAllConferenceHalls() {
        if (listOfHall == null) {
            initConferenceHall();
        }
        return listOfHall;
    }

    public String getHallName() {
        return hallName;
    }

    private void setConferenceName(String conferenceName) {
        this.hallName = conferenceName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isAvailable() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public ArrayList<Reservation> getReservationList() {
        return rezList;
    }

    public void addReservation(Reservation rezervasyon) {
        rezList.add(rezervasyon);
    }

    public boolean makeReservation(Reservation rezervasyon) {
        if (availability) {
            for (Reservation r : rezList) {
            if (r.getStarTime().isBefore(rezervasyon.getEndTime()) && r.getEndTime().isAfter(rezervasyon.getStarTime())) {
                
                return false;
            }
        }
        rezList.add(rezervasyon);
        availability = false;
        return true;
        }
        return false;
    }

    public void cancelReservation(Reservation rezervasyon) {
        if (rezList.contains(rezervasyon)) {
            rezList.remove(rezervasyon); // 
            availability = true;
            System.out.println("Reservation for " + hallName + " has been canceled.");
        } else {
            System.out.println("No reservation found to cancel for " + hallName + ".");
        }
    }

    public void listRezervasyonlar() {
        if (rezList.isEmpty()) {
            System.out.println("No reservations for this hall.");
        } else {
            for (Reservation r : rezList) {
                System.out.println("Reservation for " + r.getUser().getUsername() + " from " + r.getStarTime() + " to " + r.getEndTime());
            }
        }
    }

    @Override
    public String toString() {
        return this.hallName;
    }

}
