package com.veloslyon.velib.models;

public class Stations {

    private long number;
    private String contractName;
    private String name;
    private String address;
    private double[] positions = new double[2];
    private boolean bonus;
    private boolean banking;
    private long bikeStand;
    private long availableBikeStand;
    private long availableBike;
    private String status;
    private long timestampMoment;

    public Stations(){}

    public Stations(long number, String contractName, String name, String address
            , double[] positions, boolean banking, boolean bonus,  long bikeStand
            , long availableBikeStand, long availableBike, String status, long timestampMoment) {
        this.number = number;
        this.contractName = contractName;
        this.name = name;
        this.address = address;
        this.positions = positions;
        this.bonus = bonus;
        this.banking = banking;
        this.bikeStand = bikeStand;
        this.availableBikeStand = availableBikeStand;
        this.availableBike = availableBike;
        this.status = status;
        this.timestampMoment = timestampMoment;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double[] getPositions() {
        return positions;
    }

    public void setPositions(double[] positions) {
        this.positions = positions;
    }

    public boolean isBonus() {
        return bonus;
    }

    public void setBonus(boolean bonus) {
        this.bonus = bonus;
    }

    public boolean isBanking() {
        return banking;
    }

    public void setBanking(boolean banking) {
        this.banking = banking;
    }

    public long getBikeStand() {
        return bikeStand;
    }

    public void setBikeStand(long bikeStand) {
        this.bikeStand = bikeStand;
    }

    public long getAvailableBikeStand() {
        return availableBikeStand;
    }

    public void setAvailableBikeStand(long availableBikeStand) {
        this.availableBikeStand = availableBikeStand;
    }

    public long getAvailableBike() {
        return availableBike;
    }

    public void setAvailableBike(long availableBike) {
        this.availableBike = availableBike;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getTimestampMoment() {
        return timestampMoment;
    }

    public void setTimestampMoment(long timestampMoment) {
        this.timestampMoment = timestampMoment;
    }
}
