package net.javaguides.lms.service;

import net.javaguides.lms.entity.Rental;
import net.javaguides.lms.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    

    public List<Rental> findAll() {
        return rentalRepository.findAll();
    }

    public Rental findById(Long id) {
        return rentalRepository.findById(id).orElse(null);
    }
    
    public Rental findByBook(Long bid) {
        return rentalRepository.findByBookId(bid);
    }

    public Rental save(Rental book) {
        return rentalRepository.save(book);
    }

    public void deleteById(Long id) {
    	rentalRepository.deleteById(id);
    }
    
    public List<Rental> rentalPeriod(int days) {
        return rentalRepository.findBooksByRentPeriodGreaterThanNDays(days);
    }

    
}
