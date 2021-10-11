/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Rushabh
 */
public class Car {
    
    private String certificate;
    private String serial;
    private String location;
    private String city;
    private String manufacture;
    private boolean available;
    private int year;
    private int seats;
    private int id;
    private Date expiry;

    public Date getExpiry() {
        return expiry;
    }

    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }

    private static int count = 0;
    
    public Car() {
        count++;
        id = count;
    }

    public String getCertificate(){
        return certificate;
    }
    
    public void setCertificate(String certificate){
        this.certificate = certificate;
    }

    public String getSerial() {
        return serial;
    }

    public String getLocation() {
        return location;
    }

    public String getCity() {
        return city;
    }

    public String getManufacture() {
        return manufacture;
    }

    public boolean isAvailable() {
        return available;
    }

    public int getYear() {
        return year;
    }

    public int getSeats() {
        return seats;
    }

    public static int getCount() {
        return count;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void setCount(int count) {
        Car.count = count;
    }
    
    public int getId() {
        return id;
    }
    
    
    
    
    
}
