package net.javaguides.lms.controller;

import net.javaguides.lms.entity.Rental;
import net.javaguides.lms.entity.Book;
import net.javaguides.lms.service.RentalService;
import net.javaguides.lms.service.UserService;
import net.javaguides.lms.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

import java.util.List;

@RestController
@RequestMapping("/api/rental")
public class RentalController {

    @Autowired
    private RentalService rentalService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Rental> getAllRental() {
        return rentalService.findAll();
    }

    @GetMapping("/{id}")
    public Rental getRental(@PathVariable Long id) {
        return rentalService.findById(id);
    }

    //@PostMapping
    //public Rental addRental(@RequestBody Rental book) {
        //return rentalService.save(book);
    //}

    //@PutMapping("/{id}")
    //public Rental updateRental(@PathVariable Long id, @RequestBody Rental book) {
        // Additional logic to ensure you're updating the correct book
        //return rentalService.save(book);
    //}

    @DeleteMapping("/{id}")
    public void deleteRental(@PathVariable Long id) {
    	rentalService.deleteById(id);
    }
    
    @GetMapping("/overdue/{days}")
    public List<Rental> getOverdueBooks(@PathVariable int days) {
        return rentalService.rentalPeriod(days);
    }

    // ... other endpoints ...

    @PostMapping("/{bookId}/borrow/{userId}")
    public ResponseEntity<Book> borrowBook(@PathVariable Long bookId, @PathVariable Long userId) {
        Book borrowedBook = bookService.borrowBook(bookId, userId);
        if (borrowedBook != null) {
        	Rental newRent = new Rental();
        	newRent.setBook(bookId);
        	newRent.setUser(userService.findUsername(userId));
        	newRent.setRentDate(LocalDate.now());
        	rentalService.save(newRent);
            return ResponseEntity.ok(borrowedBook);
        } else {
            return ResponseEntity.badRequest().build(); // or a more descriptive error response
        }
    }

    @PostMapping("/{bookId}/return")
    public ResponseEntity<Book> returnBook(@PathVariable Long bookId) {
        Book returnedBook = bookService.returnBook(bookId);
        if (returnedBook != null) {
        	Rental curRent = rentalService.findByBook(bookId);
        	curRent.setReturnDate( LocalDate.now());
        	rentalService.save(curRent);
            return ResponseEntity.ok(returnedBook);
        } else {
            return ResponseEntity.badRequest().build(); // or a more descriptive error response
        }
    }
}
