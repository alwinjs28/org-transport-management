package com.spangles.orgtransportmanagement.service.impl;

import com.spangles.orgtransportmanagement.dto.PassengerDto;
import com.spangles.orgtransportmanagement.dto.response.*;
import com.spangles.orgtransportmanagement.entity.BusFees;
import com.spangles.orgtransportmanagement.entity.Passenger;
import com.spangles.orgtransportmanagement.entity.TripPrice;
import com.spangles.orgtransportmanagement.repository.BusFeesRepository;
import com.spangles.orgtransportmanagement.repository.PassengerRepository;
import com.spangles.orgtransportmanagement.repository.TripPriceRepository;
import com.spangles.orgtransportmanagement.service.PassengerService;
import com.spangles.orgtransportmanagement.util.Constants;
import com.spangles.orgtransportmanagement.util.HttpStatus;
import com.spangles.orgtransportmanagement.util.MessageLevel;
import com.spangles.orgtransportmanagement.util.TransportUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j

@Service
public class PassengerServiceImpl implements PassengerService {
    @Autowired
    RestTemplate restTemplate;
    @Value("${org.student.service.address}")
    private String studentServiceAddress;
    @Value("${org.staff.service.address}")
    private String staffServiceAddress;
    @Autowired
    PassengerRepository passengerRepository;
    @Autowired
    BusFeesRepository busFeesRepository;
    @Autowired
    TripPriceRepository tripPriceRepository;

    public PassengerResponseWrapperDto getPassenger(Long passengerId) {

        PassengerResponseWrapperDto passengerResponseWrapperDto = new PassengerResponseWrapperDto();
        AdditionalHeaderDto additionalHeaderDto = new AdditionalHeaderDto();
        if (passengerId != null) {
            Passenger passenger = passengerRepository.getPassenger(passengerId);

            if (passenger == null) {
                additionalHeaderDto.setMessage("Invalid passengerId: " + passengerId);
                additionalHeaderDto.setMessageLevel(MessageLevel.ERROR.toString());
            } else {
                TransportUtil transportUtil = new TransportUtil();
                PassengerDto dtoGetResponse = transportUtil.convertEntityToDto(passenger);
                additionalHeaderDto.setMessage("The passenger Id:" + passenger.getPassengerId());
                additionalHeaderDto.setMessageLevel(MessageLevel.INFO.toString());
                passengerResponseWrapperDto.setPassengerDto(dtoGetResponse);

            }
        } else {

            additionalHeaderDto.setMessage("The passenger Id is mandatory");
            additionalHeaderDto.setMessageLevel(MessageLevel.ERROR.toString());
        }

        passengerResponseWrapperDto.setMetaDataDto(additionalHeaderDto);

        return passengerResponseWrapperDto;
    }

    public PassengerDto savePassenger(PassengerDto passengerDto) {

        Long passengerId = passengerDto.getIdNumber();
        String passengerName = null;
        String type = passengerDto.getPassengerType();
        if (type.equals(Constants.PASSENGER_TYPE_STUDENT)) {
            passengerName = getStudentName(passengerId);
        } else if (type.equals(Constants.PASSENGER_TYPE_STAFF)) {
            passengerName = getStaffName(passengerId);
        }


        passengerDto.setPassengerName(passengerName);
        passengerDto.setPassengerId(passengerId);
        TransportUtil transportUtilReference = new TransportUtil();
        Passenger passenger = transportUtilReference.convertDtoToEntity(passengerDto);
        Passenger savePassenger = passengerRepository.save(passenger);
        TransportUtil transportUtil = new TransportUtil();
        PassengerDto dtoSaveResponse = transportUtil.convertEntityToDto(savePassenger);

        return dtoSaveResponse;
    }

    public PassengerDto updatePassenger(Passenger passenger) {
        Passenger updatePassenger = passengerRepository.save(passenger);
        TransportUtil transportUtil = new TransportUtil();
        PassengerDto dtoUpdateResponse = transportUtil.convertEntityToDto(updatePassenger);

        return dtoUpdateResponse;
    }

    public void delete(Passenger passenger) {
        passengerRepository.delete(passenger);
    }

    public String getStudentName(Long passengerId) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);


        // http://localhost:8087/student/g_student

        String url = studentServiceAddress.concat(Constants.GET_STUDENT_BY_ID_URL);

        // url ? id = 1

        String urlWithQueryParam = url.concat(Constants.STUDENT_QUERY).concat(String.valueOf(passengerId));


        log.info("url {}", urlWithQueryParam);
        String name = null;
        ResponseEntity<String> studentResponseEntity = restTemplate.exchange(urlWithQueryParam, HttpMethod.GET, httpEntity, String.class);
        if (studentResponseEntity != null && studentResponseEntity.getStatusCodeValue() == 200) {
            String stringifyJSON = studentResponseEntity.getBody();
            log.info("student response:{}", stringifyJSON);
            String jsonResponse[] = stringifyJSON.split("\"studentName\":\"")[1].split("\",\"");
            name = jsonResponse[0];
            log.info("name: {}", name);
        }
        return name;
    }

    public String getStaffName(Long passengerId) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);

        String url = staffServiceAddress.concat(Constants.GET_STAFF_BY_ID_URL);
        log.info("OutPut is: {}", url);

        String urlWithQueryParam = url.concat(Constants.STAFF_QUERY).concat(String.valueOf(passengerId));
        log.info("OutPut with query is: {}", urlWithQueryParam);
        String name = null;
        ResponseEntity<String> staffResponseEntity = restTemplate.exchange(urlWithQueryParam, HttpMethod.GET, httpEntity, String.class);
        if (staffResponseEntity != null && staffResponseEntity.getStatusCodeValue() == 200) {
            String stringifyJSON = staffResponseEntity.getBody();
            log.info("Staff Response: {}", stringifyJSON);

            String jsonResponse[] = stringifyJSON.split("\"staffName\":\"")[1].split("\",\"");
            name = jsonResponse[0];
        }

        return name;
    }

    public TotalCollectionWrapperDto getTotalCollection(String passengerType) {
        TotalCollectionWrapperDto totalCollectionWrapperDto = new TotalCollectionWrapperDto();
        if (passengerType.equals("all")) {
            totalCollectionWrapperDto = getTotalCollectionByPassengerType(Constants.PASSENGER_TYPE_STUDENT, totalCollectionWrapperDto);
            totalCollectionWrapperDto = getTotalCollectionByPassengerType(Constants.PASSENGER_TYPE_STAFF, totalCollectionWrapperDto);
        } else {
            totalCollectionWrapperDto = getTotalCollectionByPassengerType(passengerType, totalCollectionWrapperDto);
        }
        return totalCollectionWrapperDto;
    }

    public TotalCollectionWrapperDto getTotalCollectionByPassengerType(String passengerType, TotalCollectionWrapperDto totalCollectionWrapperDto) {
        SummaryDto summaryDto = new SummaryDto();
        AdditionalHeaderDto additionalHeaderDto = new AdditionalHeaderDto();
        List<StudentCollectionDto> listOfStudentCollectionDto = new ArrayList<>();
        List<StaffCollectionDto> listOfStaffCollectionDto = new ArrayList<>();

        List<Passenger> passengers = passengerRepository.getTotalCollection(passengerType);
        if (passengers == null || passengers.size() == 0) {
            additionalHeaderDto.setMessage("Invalid PassengerId : " + passengerType);
            additionalHeaderDto.setMessageLevel(MessageLevel.ERROR.toString());
            additionalHeaderDto.setHttpStatus(com.spangles.orgtransportmanagement.util.HttpStatus.BAD_REQUEST.statusCode());
            totalCollectionWrapperDto.setMetaDataDto(additionalHeaderDto);
        }else {

            Double totalCollectedAmount = 0.0;
            Double totalDueAmount = 0.0;
            for (int i = 1; i <= passengers.size(); i++) {
                Passenger passenger = passengers.get(i - 1);
                StudentCollectionDto studentCollectionDto = new StudentCollectionDto();
                StaffCollectionDto staffCollectionDto = new StaffCollectionDto();
                Long passengerId = passenger.getPassengerId();
                String passengerName = passenger.getPassengerName();
                Long idNumber = passenger.getIdNumber();

                BusFees busFees = busFeesRepository.getBusFeesByPassengerId(passengerId);

                Double totalAmount = busFees.getTotalAmount();
                Double paidAmount = busFees.getPaidAmount();
                Double dueAmount = busFees.getDueAmount();

                busFees.getDueAmount();

                totalCollectedAmount = totalAmount + totalCollectedAmount;
                totalDueAmount = dueAmount + totalDueAmount;

                if (passengerType.equals(Constants.PASSENGER_TYPE_STUDENT)) {
                    studentCollectionDto.setsNo((long) i);
                    studentCollectionDto.setStudentId(idNumber);
                    studentCollectionDto.setStudentName(passengerName);
                    studentCollectionDto.setTotalAmount(totalAmount);
                    studentCollectionDto.setPaidAmount(paidAmount);
                } else {
                    staffCollectionDto.setsNo((long) i);
                    staffCollectionDto.setStaffId(idNumber);
                    staffCollectionDto.setStaffName(passengerName);
                    staffCollectionDto.setTotalAmount(totalAmount);
                    staffCollectionDto.setPaidAmount(paidAmount);
                }

                listOfStudentCollectionDto.add(studentCollectionDto);
                listOfStaffCollectionDto.add(staffCollectionDto);

            }
            summaryDto.setTotalAmountCollected(totalCollectedAmount);
            summaryDto.setTotalBalanceAmount(totalDueAmount);
            summaryDto.setTotalPersonsPaid((long) passengers.size());

            if (passengerType.equals(Constants.PASSENGER_TYPE_STUDENT)) {
                totalCollectionWrapperDto.setStudentCollectionDto(listOfStudentCollectionDto);
            } else {
                totalCollectionWrapperDto.setStaffCollectionDto(listOfStaffCollectionDto);
            }
            if (totalCollectionWrapperDto.getSummaryDto() != null) {
                SummaryDto previousSummaryDto = totalCollectionWrapperDto.getSummaryDto();

                Double newTotalAmountCollected = summaryDto.getTotalAmountCollected() + previousSummaryDto.getTotalAmountCollected();
                Double newTotalBalanceAmount = summaryDto.getTotalBalanceAmount() + previousSummaryDto.getTotalBalanceAmount();
                Long totalPersonsPaid = summaryDto.getTotalPersonsPaid() + previousSummaryDto.getTotalPersonsPaid();

                summaryDto.setTotalAmountCollected(newTotalAmountCollected);
                summaryDto.setTotalBalanceAmount(newTotalBalanceAmount);
                summaryDto.setTotalPersonsPaid(totalPersonsPaid);

                totalCollectionWrapperDto.setSummaryDto(summaryDto);
            } else {

                totalCollectionWrapperDto.setSummaryDto(summaryDto);
            }
            additionalHeaderDto.setMessage(" PassengerType : " + passengerType);
            additionalHeaderDto.setMessageLevel(MessageLevel.INFO.toString());
            additionalHeaderDto.setHttpStatus(com.spangles.orgtransportmanagement.util.HttpStatus.SUCCESS.statusCode());
            totalCollectionWrapperDto.setMetaDataDto(additionalHeaderDto);
        }
        return totalCollectionWrapperDto;
    }

    public TotalCollectionWrapperDto getTotalCollectionByTripId(Long tripId) {

        List<Passenger> passengers = passengerRepository.getTotalCollectionByTripId(tripId);
        List<TripPrice> tripPrices = tripPriceRepository.getTripPriceByTripId(tripId);
        TotalCollectionWrapperDto totalCollectionWrapperDto = new TotalCollectionWrapperDto();
        AdditionalHeaderDto additionalHeaderDto = new AdditionalHeaderDto();
        SummaryDto summaryDto = new SummaryDto();
        Map<String, Double> tripAmountForPassenger = new HashMap<>();
        if(passengers == null || passengers.size() == 0){
            additionalHeaderDto.setMessage("Invalid TripId : " + tripId);
            additionalHeaderDto.setMessageLevel(MessageLevel.ERROR.toString());
            additionalHeaderDto.setHttpStatus(com.spangles.orgtransportmanagement.util.HttpStatus.BAD_REQUEST.statusCode());
            totalCollectionWrapperDto.setMetaDataDto(additionalHeaderDto);
        }else {

            Double allTotalAmount = 0.0;
            Double allPaidAmount = 0.0;
            Double totalDueAmount = 0.0;
            int numberOfPersonsPaying = 0;


            for (int i = 0; i < tripPrices.size(); i++) {
                TripPrice tripPrice = tripPrices.get(i);
                tripAmountForPassenger.put(tripPrice.getPassengerType().toLowerCase(), tripPrice.getTotalAmount());

                log.info("Student : {}", tripAmountForPassenger.get(tripPrice.getPassengerType()));
            }

            for (Passenger passenger : passengers) {
                Long passengerId = passenger.getPassengerId();

                BusFees busFees = busFeesRepository.getBusFeesByPassengerId(passengerId);
                if (busFees != null) {
                    Double paidAmount = busFees.getPaidAmount();
                    numberOfPersonsPaying++;

                    allTotalAmount += tripAmountForPassenger.get(passenger.getPassengerType().toLowerCase());
                    allPaidAmount = allPaidAmount + paidAmount;
                    log.info("Passenger*****8");
                } else {
                    allTotalAmount = allTotalAmount + tripAmountForPassenger.get(passenger.getPassengerType().toLowerCase());
                    log.info("He doesn't paid amount : {}", passengerId);
                    // He doesn't
                    // We/they do
                }
                totalDueAmount = allTotalAmount - allPaidAmount;
            }

            summaryDto.setTotalAmountCollected(allPaidAmount);
            summaryDto.setTotalAmount(allTotalAmount);
            summaryDto.setTotalBalanceAmount(totalDueAmount);
            summaryDto.setTotalPersonsPaid((long) numberOfPersonsPaying);

            additionalHeaderDto.setMessage("TripId : " + tripId);
            additionalHeaderDto.setMessageLevel(MessageLevel.INFO.toString());
            additionalHeaderDto.setHttpStatus(HttpStatus.SUCCESS.statusCode());
            totalCollectionWrapperDto.setMetaDataDto(additionalHeaderDto);

            totalCollectionWrapperDto.setSummaryDto(summaryDto);

        }
        return totalCollectionWrapperDto;
    }
    public Long getAllPassenger(){
        List<Passenger> passengers = passengerRepository.getAllPassenger();

//            List<Long> tripIds2 = null;//trips.stream().map(Trip::getTripId).collect(Collectors.toList());
//ASC
//        tripIds2.stream().sorted().forEachOrdered(e->System.out.println(e));
//DESC
//        tripIds2.stream().sorted(Comparator.reverseOrder()).forEachOrdered(e->System.out.println(e));

        //ASC
//         passengers.stream().sorted(Comparator.comparing(Passenger::getPassengerId)).forEachOrdered(e->System.out.println(e.getPassengerId()));
         //DESC
//         passengers.stream().sorted(Comparator.comparing(Passenger::getPassengerId).reversed()).forEachOrdered(e->System.out.println(e.getPassengerId()));
         passengers.stream().sorted(Comparator.comparing(Passenger::getPassengerName)).forEachOrdered(e->System.out.println(e.getPassengerName()));
         long count = passengers.stream().count();

         return count;
    }

}
