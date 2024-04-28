package net.javaguides.lms.service;

import net.javaguides.lms.entity.Author;
import net.javaguides.lms.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public Author findById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    public Author save(Author book) {
        return authorRepository.save(book);
    }

    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }
    
    

    
}
