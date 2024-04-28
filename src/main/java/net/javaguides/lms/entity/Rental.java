package net.javaguides.lms.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
import java.util.Calendar;

@Getter
@Setter
@Entity
public class Rental {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long bookId;
    private String rentalName;
    private Date rentalDate;
    private Date returnDate;
    private int rentalPeriod = 15;
    
    public void setRentDate(LocalDate lcl) {
    	rentalDate = java.sql.Date.valueOf(lcl);
    	
    	 
    }
    
    public void setBook(Long i) {
    	bookId = i;
    }
    
    public void setUser(String n) {
    	rentalName = n;
    }
    
    public void setReturnDate(LocalDate lcl) {
    	returnDate = java.sql.Date.valueOf(lcl);
    	
    	 
    }
    
    
    
}




