/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Rushabh
 */
public class CarCatalog {
    
    private ArrayList<Car> carCatalog;
    private Date lastUpdate;
    private String[] pickUpSpots = {"A","B","C","D","E","F"};

    public Date getLastUpdate() {
        return lastUpdate;
    }
    
    public CarCatalog(Date date) {
        carCatalog = new ArrayList<>();
        lastUpdate = date;
    }

    public ArrayList<Car> getCarCatalog() {
        return carCatalog;
    }
    
    public Car addCar() {
        Car p = new Car();
        carCatalog.add(p);
        lastUpdate = new Date();
        return p;
    }
    
    public void addCarList(Car c){
        carCatalog.add(c);
        lastUpdate = new Date();
    }
    
    public void removeCar(Car c) {
        Car toChange;
        for(int i=0; i<carCatalog.size();i++){
            toChange = carCatalog.get(i);
            int tmp = toChange.getId();
            if(tmp > c.getId()){
                toChange.setId(tmp-1);
            }
        }
        carCatalog.remove(c);
        lastUpdate = new Date();
    }
    
    public Car searchCar(int id) {
        Car car;
        for(int i=0;i<carCatalog.size();i++){
            car = carCatalog.get(i);
            if(car.getId() == id){
                return car;
            }
        }
        return null;
    }
    
    public int getCarCount(){
        return carCatalog.size();
    }
    
    public CarCatalog searchCarbySN(String SN){
        CarCatalog res = new CarCatalog(lastUpdate);
        Car result;
        for(int i =0;i<carCatalog.size();i++){
            result = carCatalog.get(i);
            if(result.getSerial().equals(SN)){
                res.addCarList(result);
            }
        }
        return res;
    }
    
    public CarCatalog searchCarbyCerti(String certi){
        CarCatalog res = new CarCatalog(lastUpdate);
        Car result;
        for(int i =0;i<carCatalog.size();i++){
            result = carCatalog.get(i);
            if(result.getCertificate().equals(certi)){
                res.addCarList(result);
            }
        }
        return res;
    }
    
    public CarCatalog searchCarbySeats(int a,int b){
        CarCatalog result = new CarCatalog(lastUpdate);
        Car resCar;
        for(int i=0; i<carCatalog.size();i++){
            resCar = carCatalog.get(i);
            if(resCar.getSeats()>=a&&resCar.getSeats()<=b){
                result.addCarList(resCar);
            }
        }
        return result;
    }
    
    public CarCatalog serachCarbyManu(String manu){
        CarCatalog result = new CarCatalog(lastUpdate);
        Car resCar;
        for(int i=0; i<carCatalog.size();i++){
            resCar = carCatalog.get(i);
            if(resCar.getManufacture().equals(manu)){
                result.addCarList(resCar);
            }
        }
        return result;
    }
    
    public CarCatalog serachCarbyCity(String city){
        CarCatalog result = new CarCatalog(lastUpdate);
        Car resCar;
        for(int i=0; i<carCatalog.size();i++){
            resCar = carCatalog.get(i);
            if(resCar.getCity().equals(city)){
                result.addCarList(resCar);
            }
        }
        return result;
    }
    
    public CarCatalog serachDupilicated(){
        CarCatalog result = new CarCatalog(lastUpdate);
        Car resCar;
        Calendar now = Calendar.getInstance();
        int nowYear = now.get(Calendar.YEAR);
        for(int i=0; i<carCatalog.size();i++){
            resCar = carCatalog.get(i);
            now.setTime(resCar.getExpiry());
            if(nowYear > now.get(Calendar.YEAR)){
                result.addCarList(resCar);
            }
        }
        return result;
    }
    public CarCatalog serachCarbyYear(int year){
        CarCatalog result = new CarCatalog(lastUpdate);
        Car resCar;
        for(int i=0; i<carCatalog.size();i++){
            resCar = carCatalog.get(i);
            if(year == resCar.getYear()){
                result.addCarList(resCar);
            }
        }
        return result;
    }
    
    public CarCatalog serachFirst(String location){
        CarCatalog result = new CarCatalog(lastUpdate);
        Car resCar;
        Car tmpCar = carCatalog.get(0);
        int myLoc = Arrays.binarySearch(pickUpSpots,location);
        int carLoc = 0;
        int length = 0;
        int minlen = Integer.MAX_VALUE;
        for(int i=0; i<carCatalog.size();i++){
            resCar = carCatalog.get(i);
            carLoc = Arrays.binarySearch(pickUpSpots,resCar.getLocation());
            length = Math.abs(myLoc-carLoc);
            if(length < minlen){
                tmpCar = resCar;
            }
        }
        result.addCarList(tmpCar);
        return result;
    }
    
    public int getAvaNum(){
        int result=0;
        Car resCar;
        for(int i=0; i<carCatalog.size();i++){
            resCar = carCatalog.get(i);
            if(resCar.isAvailable()){
                result = result +1;
            }
        }
        return result;
    }
    
    public ArrayList<String> findManufacture(){
        ArrayList<String> result = new ArrayList<>();
        int flag = 0;
        result.add(carCatalog.get(0).getManufacture());
        for(int i=0;i<carCatalog.size();i++){
            flag = 0;
            for(int j=0; j<result.size(); j++){
                if(carCatalog.get(i).getManufacture().equals(result.get(j))){
                    flag = 1;
                }
            }
            if(flag == 0){
                result.add(carCatalog.get(i).getManufacture());
            }
        }
        return result;
    }
}
