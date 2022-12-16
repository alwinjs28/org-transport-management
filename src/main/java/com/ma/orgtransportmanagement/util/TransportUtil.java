package com.ma.orgtransportmanagement.util;

import com.ma.orgtransportmanagement.dto.BusFeesDto;
import com.ma.orgtransportmanagement.dto.PassengerDto;
import com.ma.orgtransportmanagement.dto.TripDto;
import com.ma.orgtransportmanagement.dto.TripPriceDto;
import com.ma.orgtransportmanagement.entity.BusFees;
import com.ma.orgtransportmanagement.entity.Passenger;
import com.ma.orgtransportmanagement.entity.Trip;
import com.ma.orgtransportmanagement.entity.TripPrice;


public class TransportUtil extends MainUtil {

    @Override
    public TripDto convertEntityToDto(Trip trip){
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
    @Override
    public PassengerDto convertEntityToDto(Passenger passenger){
       PassengerDto passengerDto = new PassengerDto();

       passengerDto.setPassengerId(passenger.getPassengerId());
       passengerDto.setPassengerType(passenger.getPassengerType());
       passengerDto.setIdNumber(passenger.getIdNumber());
       passengerDto.setPassengerName(passenger.getPassengerName());

       return passengerDto;
    }
    public TripPriceDto convertEntityToDto(TripPrice tripPrice){
        TripPriceDto tripPriceDto = new TripPriceDto();

        tripPriceDto.setTripPriceId(tripPrice.getTripPriceId());
        tripPriceDto.setTripId(tripPrice.getTripId());
        tripPriceDto.setPassengerType(tripPrice.getPassengerType());
        tripPriceDto.setTotalAmount(tripPrice.getTotalAmount());

        return tripPriceDto;
    }
    public Passenger convertDtoToEntity(PassengerDto passengerDto){
        Passenger passenger = new Passenger();

        passenger.setPassengerId(passengerDto.getPassengerId());
        passenger.setPassengerType(passengerDto.getPassengerType());
        passenger.setIdNumber(passengerDto.getIdNumber());
        passenger.setPassengerName(passengerDto.getPassengerName());

        return passenger;
    }
    public BusFeesDto convertEntityToDto(BusFees busFees){
        BusFeesDto busFeesDto = new BusFeesDto();

        busFeesDto.setBusTypeId(busFees.getBusTypeId());
        busFeesDto.setPassengerId(busFees.getPassengerId());
        busFeesDto.setTotalAmount(busFees.getTotalAmount());
        busFeesDto.setPaidAmount(busFees.getPaidAmount());
        busFeesDto.setDueAmount(busFees.getDueAmount());

        return busFeesDto;
    }

    public BusFees convertDtoToEntity(BusFeesDto busFeesDto){
        BusFees busFees = new BusFees();

        busFees.setBusTypeId(busFeesDto.getBusTypeId());
        busFees.setPassengerId(busFeesDto.getPassengerId());
        busFees.setTotalAmount(busFeesDto.getTotalAmount());
        busFees.setPaidAmount(busFeesDto.getPaidAmount());
        busFees.setDueAmount(busFeesDto.getDueAmount());

        return busFees;
    }
}
