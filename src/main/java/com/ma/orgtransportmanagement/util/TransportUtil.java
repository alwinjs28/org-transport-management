package com.ma.orgtransportmanagement.util;

import com.ma.orgtransportmanagement.dto.PassengerDto;
import com.ma.orgtransportmanagement.dto.TripDto;
import com.ma.orgtransportmanagement.dto.TripPriceDto;
import com.ma.orgtransportmanagement.entity.Passenger;
import com.ma.orgtransportmanagement.entity.Trip;
import com.ma.orgtransportmanagement.entity.TripPrice;


public class TransportUtil {

    public TripDto convertTripEntityToDto(Trip trip){
       TripDto tripDto = new TripDto();

       tripDto.setTripId(trip.getTripId());
       tripDto.setVehicleId(trip.getVehicleId());
       tripDto.setTripName(trip.getTripName());
       tripDto.setFromPlace(trip.getFromPlace());
       tripDto.setToPlace(trip.getToPlace());
       tripDto.setNumberOfKm(trip.getNumberOfKm());
       tripDto.setNoOfPassenger(trip.getNoOfPassenger());
       return tripDto;
    }
    public PassengerDto convertPassengerEntityToDto(Passenger passenger){
       PassengerDto passengerDto = new PassengerDto();

       passengerDto.setPassengerId(passenger.getPassengerId());
       passengerDto.setPassengerType(passenger.getPassengerType());
       passengerDto.setIdNumber(passenger.getIdNumber());
       passengerDto.setPassengerName(passenger.getPassengerName());

       return passengerDto;
    }
    public TripPriceDto convertTripPriceEntityToDto(TripPrice tripPrice){
        TripPriceDto tripPriceDto = new TripPriceDto();

        tripPriceDto.setTripPriceId(tripPrice.getTripPriceId());
        tripPriceDto.setTripId(tripPrice.getTripId());
        tripPriceDto.setPassengerType(tripPrice.getPassengerType());
        tripPriceDto.setTotalAmount(tripPrice.getTotalAmount());

        return tripPriceDto;
    }
    public Passenger convertPassengerDtoToEntity(PassengerDto passengerDto){
        Passenger passenger = new Passenger();

        passenger.setPassengerId(passengerDto.getPassengerId());
        passenger.setPassengerType(passengerDto.getPassengerType());
        passenger.setIdNumber(passengerDto.getIdNumber());
        passenger.setPassengerName(passengerDto.getPassengerName());

        return passenger;
    }
}
