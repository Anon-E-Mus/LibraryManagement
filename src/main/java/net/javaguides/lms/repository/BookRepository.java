package net.javaguides.lms.repository;

import net.javaguides.lms.entity.Book;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
	List<Book> findByAuthor(String author);
	List<Book> findByBorrowed(boolean borrowed);
	
}
