package net.javaguides.lms.repository;

import net.javaguides.lms.entity.Book;
import net.javaguides.lms.entity.Rental;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Long> {
	Rental findByBookId(Long bookId);
	
	@Query("SELECT b FROM Rental b WHERE DATEDIFF(b.returnDate, b.rentalDate) > ?1")
    List<Rental> findBooksByRentPeriodGreaterThanNDays(int days);
}
