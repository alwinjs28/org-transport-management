package com.spangles.orgtransportmanagement.util;

import com.spangles.orgtransportmanagement.dto.*;
import com.spangles.orgtransportmanagement.entity.*;


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
    public Trip convertDtoToEntity(TripDto tripDto){
        Trip trip = new Trip();
        trip.setTripId(tripDto.getTripId());
        trip.setVehicleId(tripDto.getVehicleId());
        trip.setTripName(tripDto.getTripName());
        trip.setFromPlace(tripDto.getFromPlace());
        trip.setToPlace(tripDto.getToPlace());
        trip.setNumberOfKm(tripDto.getNumberOfKm());
        trip.setNoOfPassenger(tripDto.getNoOfPassenger());

        return trip;
    }
    @Override
    public PassengerDto convertEntityToDto(Passenger passenger){
       PassengerDto passengerDto = new PassengerDto();

       passengerDto.setPassengerId(passenger.getPassengerId());
       passengerDto.setPassengerType(passenger.getPassengerType());
       passengerDto.setIdNumber(passenger.getIdNumber());
       passengerDto.setPassengerName(passenger.getPassengerName());
       passengerDto.setTripId(passenger.getTripId());

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
        passenger.setTripId(passengerDto.getTripId());

        return passenger;
    }
    public BusFeesDto convertEntityToDto(BusFees busFees){
        BusFeesDto busFeesDto = new BusFeesDto();

        busFeesDto.setBusFeesId(busFees.getBusTypeId());
        busFeesDto.setPassengerId(busFees.getPassengerId());
        busFeesDto.setTotalAmount(busFees.getTotalAmount());
        busFeesDto.setPaidAmount(busFees.getPaidAmount());
        busFeesDto.setDueAmount(busFees.getDueAmount());
        busFeesDto.setPaidDate(busFees.getPaidDate());

        return busFeesDto;
    }

    public BusFees convertDtoToEntity(BusFeesDto busFeesDto){
        BusFees busFees = new BusFees();

        busFees.setBusTypeId(busFeesDto.getBusFeesId());
        busFees.setPassengerId(busFeesDto.getPassengerId());
        busFees.setTotalAmount(busFeesDto.getTotalAmount());
        busFees.setPaidAmount(busFeesDto.getPaidAmount());
        busFees.setDueAmount(busFeesDto.getDueAmount());
        busFees.setPaidDate(busFeesDto.getPaidDate());

        return busFees;
    }
    public VehicleExpense convertDtoToEntity(VehicleExpenseDto vehicleExpenseDto){
        VehicleExpense vehicleExpense = new VehicleExpense();

        vehicleExpense.setExpenseId(vehicleExpenseDto.getExpenseId());
        vehicleExpense.setVehicleId(vehicleExpenseDto.getVehicleId());
        vehicleExpense.setTripId(vehicleExpenseDto.getTripId());
        vehicleExpense.setExpenseName(vehicleExpenseDto.getExpenseName());
        vehicleExpense.setAmount(vehicleExpenseDto.getAmount());
        vehicleExpense.setCreatedBy(vehicleExpenseDto.getCreatedBy());
        vehicleExpense.setCreatedOn(vehicleExpenseDto.getCreatedOn());
        vehicleExpense.setFuel(vehicleExpenseDto.getFuel());

        return vehicleExpense;
    }
    public VehicleExpenseDto convertingEntityToDto(VehicleExpense vehicleExpense){
        VehicleExpenseDto vehicleExpenseDto = new VehicleExpenseDto();

        vehicleExpenseDto.setExpenseId(vehicleExpense.getExpenseId());
        vehicleExpenseDto.setVehicleId(vehicleExpense.getVehicleId());
        vehicleExpenseDto.setTripId(vehicleExpense.getTripId());
        vehicleExpenseDto.setExpenseName(vehicleExpense.getExpenseName());
        vehicleExpenseDto.setAmount(vehicleExpense.getAmount());
        vehicleExpenseDto.setCreatedBy(vehicleExpense.getCreatedBy());
        vehicleExpenseDto.setCreatedOn(vehicleExpense.getCreatedOn());
        vehicleExpenseDto.setFuel(vehicleExpense.getFuel());

        return vehicleExpenseDto;
    }
    public VehicleMileage convertingDtoToEntity(VehicleMileageDto vehicleMileageDto){
        VehicleMileage vehicleMileage = new VehicleMileage();

        vehicleMileage.setVehicleMileageId(vehicleMileageDto.getVehicleMileageId());
        vehicleMileage.setVehicleId(vehicleMileageDto.getVehicleId());
        vehicleMileage.setKmPerLiter(vehicleMileageDto.getKmPerLiter());
        vehicleMileage.setCreatedOn(vehicleMileageDto.getDateOfFc());
        vehicleMileage.setLastFc(vehicleMileageDto.getLastFc());

        return vehicleMileage;
    }
    public VehicleMileageDto convertingEntityToDto(VehicleMileage vehicleMileage){
        VehicleMileageDto vehicleMileageDto = new VehicleMileageDto();

        vehicleMileageDto.setVehicleMileageId(vehicleMileage.getVehicleMileageId());
        vehicleMileageDto.setVehicleId(vehicleMileage.getVehicleId());
        vehicleMileageDto.setKmPerLiter(vehicleMileage.getKmPerLiter());
        vehicleMileageDto.setDateOfFc(vehicleMileage.getCreatedOn());
        vehicleMileageDto.setLastFc(vehicleMileage.getLastFc());

        return vehicleMileageDto;
    }
}
