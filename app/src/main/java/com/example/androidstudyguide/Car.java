package com.example.androidstudyguide;

import androidx.annotation.NonNull;

public class Car {
    private String carName;
    private String carType;
    private int carQuantity;

    public Car(String carName, String carType, int carQuantity) {
        this.carName = carName;
        this.carType = carType;
        this.carQuantity = carQuantity;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public int getCarQuantity() {
        return carQuantity;
    }

    public void setCarQuantity(int carQuantity) {
        this.carQuantity = carQuantity;
    }
}
