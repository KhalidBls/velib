package com.veloslyon.velib.services;

import com.veloslyon.velib.models.Stations;
import com.veloslyon.velib.repository.RequestAPI;
import org.springframework.stereotype.Service;

@Service
public class StationsService {

    private RequestAPI requestAPI = new RequestAPI();

    public StationsService() throws Exception {
    }

    public void createStation(Stations station){
        requestAPI.getStationsRepo().add(station);
    }

    public Stations getStationByNumber(long number){
        return requestAPI.getStationByNumber(number);
    }

    public void updateStation(Stations station ){
        Stations stationUpdated = requestAPI.getStationByNumber(station.getNumber());
        if(stationUpdated!=null)
            stationUpdated.setAddress(station.getAddress());
            stationUpdated.setAvailableBike(station.getAvailableBike());
            stationUpdated.setAvailableBikeStand(station.getAvailableBikeStand());
            stationUpdated.setBanking(station.isBanking());
            stationUpdated.setBonus(station.isBonus());
            stationUpdated.setName(station.getName());
            stationUpdated.setPositions(station.getPositions());
            stationUpdated.setTimestampMoment(station.getTimestampMoment());
            stationUpdated.setContractName(station.getContractName());
    }

    public void deleteStation(Stations station){
        requestAPI.getStationsRepo().remove(station);
    }

    }
