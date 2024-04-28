package net.javaguides.lms.controller;

import net.javaguides.lms.entity.Author;
import net.javaguides.lms.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public List<Author> getAllAuthor() {
        return authorService.findAll();
    }

    @GetMapping("/{id}")
    public Author getAuthor(@PathVariable Long id) {
        return authorService.findById(id);
    }

    @PostMapping
    public Author addAuthor(@RequestBody Author book) {
        return authorService.save(book);
    }

    @PutMapping("/{id}")
    public Author updateAuthor(@PathVariable Long id, @RequestBody Author book) {
        // Additional logic to ensure you're updating the correct book
        return authorService.save(book);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        authorService.deleteById(id);
    }

    // ... other endpoints ...

    
}
