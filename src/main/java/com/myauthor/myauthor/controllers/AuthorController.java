package com.myauthor.myauthor.controllers;

import com.myauthor.myauthor.models.AuthorRequest;
import com.myauthor.myauthor.models.AuthorResponse;
import com.myauthor.myauthor.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/author")
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @GetMapping("/{id}")
    public AuthorResponse getAuthor(@PathVariable("id") Long id){
        return authorService.getOneAuthor(id);
    }

    @PostMapping("/add")
    public AuthorResponse addAuthor(@RequestBody AuthorRequest authorRequest){
        return authorService.addAuthor(authorRequest);
    }

    @GetMapping("/authors")
    public List<AuthorResponse> allAuthors(){
        return authorService.getAllAuthors();
    }
}
