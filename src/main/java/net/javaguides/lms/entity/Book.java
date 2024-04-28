package net.javaguides.lms.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import net.javaguides.lms.entity.Author;

@Getter
@Setter
@Entity
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author authorid;
    
    private String author;
    
    
    
    private boolean borrowed;
    private Long isbn;
    private int publicationYear;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User borrowedBy;
    
    public boolean isBorrowed() {
    	return(borrowed);
    }
    
    public void setBorrowedBy(User name) {
    	borrowedBy = name;
    }
    
    public void setBorrowed(boolean x) {
    	borrowed = x;
    }
    
    public void setAuthName() {
    	author = authorid.getName();
    }
    
}
