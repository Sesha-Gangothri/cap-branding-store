package com.example.service;
import com.example.client.TrainServiceClient;
import com.example.dto.BookingDTO;
import com.example.model.Booking;
import com.example.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private TrainServiceClient trainServiceClient;


    private String generatePNR(){
        return "PNR"+System.currentTimeMillis();
    }
    
    public BookingDTO getBookingByPnr(String pnr){
        Booking booking = bookingRepository.findByPnr(pnr);
        if (booking == null) {
            throw new RuntimeException("Booking not found with PNR: " + pnr);
        }
        return convertToDTO(booking);
    }
    public BookingDTO createBooking(BookingDTO bookingDTO){
        if (bookingDTO.getNumSeats() > 6) {
            throw new RuntimeException("Maximum 6 seats can be booked at a time");
        }
        String pnr = generatePNR();
        bookingDTO.setPnr(pnr);
        int availableSeats = trainServiceClient.getTrainAvailability(
                bookingDTO.getTrainId(), bookingDTO.getDate(), bookingDTO.getClassType()
        );
        if (availableSeats >= bookingDTO.getNumSeats()) {
            Booking booking = convertToEntity(bookingDTO);
            Booking savedBooking = bookingRepository.save(booking);
            return convertToDTO(savedBooking);
        } else {
            throw new RuntimeException("Not enough seats available");
        }
    }
    public void cancelBooking(String pnr){
        Booking booking = bookingRepository.findByPnr(pnr);
        if (booking == null) {
            throw new RuntimeException("Booking not found with PNR: " + pnr);
        }
        booking.setStatus("Cancelled");
        bookingRepository.save(booking);
        trainServiceClient.increaseTrainAvailability(
                booking.getTrainId(), booking.getDate(), booking.getClassType(), booking.getNumSeats()
        );
    }



    private BookingDTO convertToDTO(Booking booking) {
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setPnr(booking.getPnr());
        bookingDTO.setUserId(booking.getUserId());
        bookingDTO.setTrainId(booking.getTrainId());
        bookingDTO.setDate(booking.getDate());
        bookingDTO.setClassType(booking.getClassType());
        bookingDTO.setNumSeats(booking.getNumSeats());
        bookingDTO.setStatus(booking.getStatus());
        return bookingDTO;
    }

    private Booking convertToEntity(BookingDTO bookingDTO) {
        Booking booking = new Booking();
        booking.setPnr(bookingDTO.getPnr());
        booking.setUserId(bookingDTO.getUserId());
        booking.setTrainId(bookingDTO.getTrainId());
        booking.setDate(bookingDTO.getDate());
        booking.setClassType(bookingDTO.getClassType());
        booking.setNumSeats(bookingDTO.getNumSeats());
        booking.setStatus(bookingDTO.getStatus());
        return booking;
    }
}