package com.example.controller;
import com.example.dto.BookingDTO;
import com.example.model.Booking;
import com.example.service.BookingService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping("/create")
    public ResponseEntity<BookingDTO> createBooking(@Valid @RequestBody BookingDTO bookingDTO) {
        BookingDTO createBooking = bookingService.createBooking(bookingDTO);
        return new ResponseEntity<>(createBooking, HttpStatus.CREATED);
    }

    @GetMapping("/{pnr}")
    public ResponseEntity<BookingDTO> getBookingByPnr(@PathVariable String pnr) {
        BookingDTO bookingDTO = bookingService.getBookingByPnr(pnr);
        return new ResponseEntity<>(bookingDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{pnr}")
    public ResponseEntity<Void> cancelBooking(@PathVariable String pnr ) {
        bookingService.cancelBooking(pnr);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}