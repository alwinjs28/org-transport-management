package com.spangles.orgtransportmanagement.service.impl;

import com.spangles.orgtransportmanagement.dto.TripDto;
import com.spangles.orgtransportmanagement.dto.VehicleExpenseDto;
import com.spangles.orgtransportmanagement.dto.response.*;
import com.spangles.orgtransportmanagement.entity.*;
import com.spangles.orgtransportmanagement.repository.*;
import com.spangles.orgtransportmanagement.service.TripService;
import com.spangles.orgtransportmanagement.service.VehicleExpenseService;
import com.spangles.orgtransportmanagement.service.VehicleService;
import com.spangles.orgtransportmanagement.util.Constants;
import com.spangles.orgtransportmanagement.util.HttpStatus;
import com.spangles.orgtransportmanagement.util.MessageLevel;
import com.spangles.orgtransportmanagement.util.TransportUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j

@Service
public class VehicleExpenseServiceImpl implements VehicleExpenseService {
    @Autowired
    VehicleExpenseRepository vehicleExpenseRepository;
    @Autowired
    TripRepository tripRepository;
    @Autowired
    VehicleRepository vehicleRepository;
    @Autowired
    PassengerRepository passengerRepository;
    @Autowired
    TripPriceRepository tripPriceRepository;
    @Value("${expense.names}")
    private String expenseNames;
    @Value("${fuel.limit}")
    private Integer fuelLimit;

    @Autowired
    VehicleService vehicleService;
    @Autowired
    TripService tripService;

    @Override
    public VehicleExpenseDto getVehicleExpense(Long expenseId) {
        VehicleExpense vehicleExpense = vehicleExpenseRepository.getVehiclesExpense(expenseId);
        TransportUtil transportUtil = new TransportUtil();
        VehicleExpenseDto vehicleExpenseDto = transportUtil.convertingEntityToDto(vehicleExpense);
        return vehicleExpenseDto;
    }

    @Override
    public VehicleExpenseWrapperDto saveVehicleExpense(VehicleExpenseDto vehicleExpenseDto) {
        TransportUtil transportUtil = new TransportUtil();
        VehicleExpense vehicleExpense = transportUtil.convertDtoToEntity(vehicleExpenseDto);

        AdditionalHeaderDto additionalHeaderDto = new AdditionalHeaderDto();
        VehicleExpenseWrapperDto vehicleExpenseWrapperDto = new VehicleExpenseWrapperDto();
        TripDto tripDto = tripService.getTrip(vehicleExpense.getTripId());

        Vehicle vehicle = vehicleService.getVehicle(vehicleExpense.getVehicleId());
        if (vehicleExpense.getVehicleId() == null) {
            additionalHeaderDto.setMessage(Constants.INPUT_NOT_GIVEN);
            additionalHeaderDto.setMessageLevel(MessageLevel.ERROR.toString());
            additionalHeaderDto.setHttpStatus(HttpStatus.BAD_REQUEST.statusCode());
            vehicleExpenseWrapperDto.setAdditionalHeaderDto(additionalHeaderDto);
        } else if (vehicle == null) {

            additionalHeaderDto.setMessage(Constants.VEHICLE_ID_NOT_FOUND + vehicleExpense.getVehicleId());
            additionalHeaderDto.setMessageLevel(MessageLevel.ERROR.toString());
            additionalHeaderDto.setHttpStatus(HttpStatus.NO_FOUND.statusCode());
            vehicleExpenseWrapperDto.setAdditionalHeaderDto(additionalHeaderDto);
        } else if (vehicleExpense.getTripId() != null && tripDto == null) {

            additionalHeaderDto.setMessage(Constants.TRIP_ID + vehicleExpense.getTripId());
            additionalHeaderDto.setMessageLevel(MessageLevel.ERROR.toString());
            additionalHeaderDto.setHttpStatus(HttpStatus.BAD_REQUEST.statusCode());
            vehicleExpenseWrapperDto.setAdditionalHeaderDto(additionalHeaderDto);

        } else if (vehicleExpense.getAmount() != null && vehicleExpense.getAmount() < 0) {
            additionalHeaderDto.setMessage(Constants.BELOW_AMOUNT + vehicleExpense.getAmount());
            additionalHeaderDto.setMessageLevel(MessageLevel.ERROR.toString());
            additionalHeaderDto.setHttpStatus(HttpStatus.BAD_REQUEST.statusCode());
            vehicleExpenseWrapperDto.setAdditionalHeaderDto(additionalHeaderDto);

        } else if (vehicleExpense.getFuel() != null && vehicleExpense.getFuel() > fuelLimit) {
            additionalHeaderDto.setMessage(Constants.THE_FUEL_LIMIT + vehicleExpense.getFuel());
            additionalHeaderDto.setMessageLevel(MessageLevel.ERROR.toString());
            additionalHeaderDto.setHttpStatus(HttpStatus.BAD_REQUEST.statusCode());
            vehicleExpenseWrapperDto.setAdditionalHeaderDto(additionalHeaderDto);

        } else if (!checkExpenseName(vehicleExpense.getExpenseName())) {

            additionalHeaderDto.setMessage(Constants.EXPENSE_NAME + vehicleExpense.getExpenseName());
            additionalHeaderDto.setMessageLevel(MessageLevel.ERROR.toString());
            additionalHeaderDto.setHttpStatus(HttpStatus.BAD_REQUEST.statusCode());
            vehicleExpenseWrapperDto.setAdditionalHeaderDto(additionalHeaderDto);

        } else {
            TransportUtil transportUtilReference = new TransportUtil();
            Date todaysDate = new Date();
            vehicleExpense.setCreatedOn(todaysDate);
            VehicleExpense saveVehicleExpense = vehicleExpenseRepository.save(vehicleExpense);
            VehicleExpenseDto vehicleExpenseDtoResponse = transportUtilReference.convertingEntityToDto(saveVehicleExpense);
            additionalHeaderDto.setMessage(Constants.VEHICLE_ID + vehicleExpense.getVehicleId());
            additionalHeaderDto.setMessageLevel(MessageLevel.INFO.toString());
            additionalHeaderDto.setHttpStatus(HttpStatus.SUCCESS.statusCode());
            vehicleExpenseWrapperDto.setAdditionalHeaderDto(additionalHeaderDto);
            vehicleExpenseWrapperDto.setVehicleExpenseDto(vehicleExpenseDtoResponse);
        }
        return vehicleExpenseWrapperDto;
    }


    @Override
    public VehicleExpenseDto updateVehicleExpense(VehicleExpenseDto vehicleExpenseDto) {
        TransportUtil transportUtil = new TransportUtil();
        VehicleExpense vehicleExpense = transportUtil.convertDtoToEntity(vehicleExpenseDto);
        VehicleExpense vehicleExpenseEntity = vehicleExpenseRepository.save(vehicleExpense);
        VehicleExpenseDto vehicleExpenseDtoResponse = transportUtil.convertingEntityToDto(vehicleExpenseEntity);
        return vehicleExpenseDtoResponse;
    }

    @Override
    public void delete(VehicleExpenseDto vehicleExpenseDto) {
        TransportUtil transportUtil = new TransportUtil();
        VehicleExpense vehicleExpense = transportUtil.convertDtoToEntity(vehicleExpenseDto);
        vehicleExpenseRepository.delete(vehicleExpense);
    }

    public boolean checkExpenseName(String expenseName) {
        String splitExpenseName[] = expenseNames.split(",");
        boolean inputExpenseName = false;
        for (String expenseNames : splitExpenseName) {
            log.info("name : {}", expenseName);
            if (expenseName.equals(expenseNames)) {
                inputExpenseName = true;
            }
        }
        return inputExpenseName;
    }

    public ExpenseReportDto getExpenseByVehicleId(Long vehicleId) {
        ExpenseSummaryDto expenseSummaryDto = new ExpenseSummaryDto();
        ExpenseReportDto expenseReportDto = new ExpenseReportDto();
        List<VehicleExpenseDto> listOfVehicleExpenseDtos = new ArrayList<>();
        AdditionalHeaderDto additionalHeaderDto = new AdditionalHeaderDto();

        if (vehicleId != null) {
            List<VehicleExpense> vehicleExpenses = vehicleExpenseRepository.getExpenseByVehicleId(vehicleId);

            Vehicle vehicles = vehicleRepository.getVehicle(vehicleId);

            double expenseTotal = 0.0;
            if (vehicleExpenses != null) {


                if (vehicles != null) {
                    for (int i = 0; i < vehicleExpenses.size(); i++) {
                        VehicleExpenseDto vehicleExpenseDto = new VehicleExpenseDto();
                        VehicleExpense vehicleExpense = vehicleExpenses.get(i);
                        expenseTotal = expenseTotal + vehicleExpense.getAmount();

                        List<Trip> trips = tripRepository.getTripByVehicleId(vehicleExpense.getVehicleId());

                        String name = trips.stream().map(Trip::getTripName).collect(Collectors.joining(","));

                        String tripNames[] = new String[trips.size()];
                        for (int j = 0; j < trips.size(); j++) {
                            Trip trip = trips.get(j);
                            log.info("Trip Name is : " + trip.getTripName());
                            tripNames[j] = trip.getTripName();
                        }

                        String tripNameWithCommaSeparator = String.join(",", tripNames);

                        String allTripNames = "";
                        for (int j = 0; j < trips.size(); j++) {
                            Trip trip = trips.get(j);
                            log.info("Trip Name is : " + trip.getTripName());
                            if (j != trips.size() - 1) {
                                allTripNames += trip.getTripName() + ",";
                            } else {
                                allTripNames += trip.getTripName();
                            }
                        }
                        /*for (int k = 0; k < tripName.length; k++) {
                            if (k!=tripName.length-1)  {
                                allTripNames += tripName[k] + ",";
                            } else {
                                allTripNames += tripName[k];
                            }
                        }*/
                        log.info("All Names : " + allTripNames);
//                        tripName = null;
//
//                        if (tripName != null && tripName.length > 0) {
//                            log.info("All Names : ");
//                            allTripNames = allTripNames.substring(0, allTripNames.length() - 2);
//                            log.info("The Trip Names is : " + allTripNames);
//                        }
//                        allTripNames = allTripNames.replaceAll(", $","");
//                        log.info("The outPut is : "+allTripNames);
                        expenseSummaryDto.setTripNames(allTripNames);

                        vehicleExpenseDto.setExpenseId(vehicleExpense.getExpenseId());
                        vehicleExpenseDto.setVehicleId(vehicleExpense.getVehicleId());
                        vehicleExpenseDto.setTripId(vehicleExpense.getTripId());
                        vehicleExpenseDto.setExpenseName(vehicleExpense.getExpenseName());
                        vehicleExpenseDto.setAmount(vehicleExpense.getAmount());
                        vehicleExpenseDto.setCreatedBy(vehicleExpense.getCreatedBy());
                        vehicleExpenseDto.setCreatedOn(vehicleExpense.getCreatedOn());
                        vehicleExpenseDto.setFuel(vehicleExpense.getFuel());

                        listOfVehicleExpenseDtos.add(vehicleExpenseDto);
                    }

                    String vehicleName = vehicles.getVehicleName();
                    String vehicleNumber = vehicles.getVehicleNumber();

                    expenseSummaryDto.setExpenseTotal(expenseTotal);
                    expenseSummaryDto.setVehicleName(vehicleName);
                    expenseSummaryDto.setVehicleNumber(vehicleNumber);
                    expenseSummaryDto.setNoOfExpense(vehicleExpenses.size());

                    additionalHeaderDto.setMessage(Constants.VEHICLE_ID + vehicleId);
                    additionalHeaderDto.setMessageLevel(MessageLevel.INFO.toString());
                    additionalHeaderDto.setHttpStatus(HttpStatus.SUCCESS.statusCode());
                } else {

                    additionalHeaderDto.setMessage(Constants.VEHICLE_ID + vehicleId);
                    additionalHeaderDto.setMessageLevel(MessageLevel.ERROR.toString());
                    additionalHeaderDto.setHttpStatus(HttpStatus.BAD_REQUEST.statusCode());

                    expenseReportDto.setAdditionalHeaderDto(additionalHeaderDto);
                }
            } else {
                additionalHeaderDto.setMessage(Constants.VEHICLE_ID + vehicleId);
                additionalHeaderDto.setMessageLevel(MessageLevel.ERROR.toString());
                additionalHeaderDto.setHttpStatus(HttpStatus.BAD_REQUEST.statusCode());

                expenseReportDto.setAdditionalHeaderDto(additionalHeaderDto);
            }


            additionalHeaderDto.setMessage(Constants.VEHICLE_ID + vehicleId);
            additionalHeaderDto.setMessageLevel(MessageLevel.ERROR.toString());
            additionalHeaderDto.setHttpStatus(HttpStatus.BAD_REQUEST.statusCode());


            expenseReportDto.setVehicleExpenseDtos(listOfVehicleExpenseDtos);
            expenseReportDto.setExpenseSummaryDto(expenseSummaryDto);
            expenseReportDto.setAdditionalHeaderDto(additionalHeaderDto);
        }


        return expenseReportDto;
    }

    public ProfitDto getProfitByVehicleId(Long vehicleId) {

        ProfitDto profitDto = new ProfitDto();

        Double expenseTotal = 0.0;
        if (vehicleId != null) {
            ExpenseReportDto expenseReportDto = getExpenseByVehicleId(vehicleId);

            if (expenseReportDto != null) {
                ExpenseSummaryDto expenseSummaryDto = expenseReportDto.getExpenseSummaryDto();

                if (expenseSummaryDto != null) {
                    expenseTotal = expenseSummaryDto.getExpenseTotal();
                    String vehicleName = expenseSummaryDto.getVehicleName();
                    String vehicleNumber = expenseSummaryDto.getVehicleNumber();
                    String tripNames = expenseSummaryDto.getTripNames();

                    profitDto.setExpense(expenseTotal);
                    profitDto.setVehicleName(vehicleName);
                    profitDto.setVehicleNumber(vehicleNumber);
                    profitDto.setTripName(tripNames);
                }

            }
//            int a[] = {5,3,5,6,6};
//            Arrays.asList(a).stream();
//            List.of(a).stream().sorted().forEachOrdered(e->System.out.println(e));
//            Stream.of(a).sorted().forEachOrdered(e->System.out.println(e));
//            Stream.of(a).sorted().forEachOrdered(System.out::println);


            List<Trip> trips = tripRepository.getTripByVehicleId(vehicleId);
            List<Long> tripIds = trips.stream().map(e -> e.getTripId()).collect(Collectors.toList());
//            List<Long> tripIds2 = trips.stream().map(Trip::getTripId).collect(Collectors.toList());
            List<Passenger> passengers = passengerRepository.getPassengerByTripIds(tripIds);
            Double tripTotalAmount = 0.0;
            if (passengers != null) {
                for (Passenger passenger : passengers) {
                    String passengerType = passenger.getPassengerType();
                    Long passengerTripId = passenger.getTripId();


                    Map<String, Double> tripPriceAmount = new HashMap<>();
                    String key = passengerType + passengerTripId;
                    /*Double tripAmount = null;
                    if (tripPriceAmount.get(key) != null) {
                        tripAmount = tripPriceAmount.get(key);
                    } else {
                        TripPrice tripPrice = tripPriceRepository.findByPassengerTypeAndTripId(passengerType, passengerTripId);
                        tripPriceAmount.put(key, tripPrice.getTotalAmount());
                        tripAmount = tripPrice.getTotalAmount();
                    }*/

                    if (tripPriceAmount.get(key) == null) {
                        TripPrice tripPrice = tripPriceRepository.findByPassengerTypeAndTripId(passengerType, passengerTripId);
                        tripPriceAmount.put(key, tripPrice.getTotalAmount());
                    }
                    Double tripAmount = tripPriceAmount.get(key);


                    tripTotalAmount = tripAmount + tripTotalAmount;
                }
            }
            Double profit = tripTotalAmount - expenseTotal;
            profitDto.setAmount(tripTotalAmount);
            profitDto.setProfit(profit);
        }

        return profitDto;
    }
}
