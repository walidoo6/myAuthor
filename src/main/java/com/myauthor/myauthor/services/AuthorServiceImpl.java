package com.myauthor.myauthor.services;

import com.myauthor.myauthor.entities.Author;
import com.myauthor.myauthor.models.AuthorRequest;
import com.myauthor.myauthor.models.AuthorResponse;
import com.myauthor.myauthor.repositories.AuthorRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    AuthorRepo authorRepo;
    @Override
    public AuthorResponse addAuthor(AuthorRequest authorRequest) {
        Author newAuthor = new Author();
        newAuthor.setNom(authorRequest.getNom());
        newAuthor.setPays((authorRequest.getPays()));
        authorRepo.save(newAuthor);
        return new AuthorResponse(newAuthor);
    }

    @Override
    public AuthorResponse getOneAuthor(Long id) {
        /*Author author = authorRepo.getAuthorById(id);
        return new AuthorResponse(author);*/

        Optional<Author> author = Optional.ofNullable(authorRepo.getAuthorById(id));
        if (author.isPresent())
            return new AuthorResponse(author.get());
        else
            throw new EntityNotFoundException("Author with id :"+id+" not found");
    }

    @Override
    public List<AuthorResponse> getAllAuthors() {
        List<AuthorResponse> repAuthors = new ArrayList<>();
        List<Author> authors = authorRepo.findAll();
        for (Author b:authors) {
            repAuthors.add(new AuthorResponse(b));
        }
        return repAuthors;
    }

    @Override
    public AuthorResponse updateAuthor(AuthorRequest authorRequest, Long id) {
        Optional<Author> author = Optional.ofNullable(authorRepo.getAuthorById(id));
        if(author.isPresent())
            return new AuthorResponse(author.get());
        else
            throw new EntityNotFoundException("Author with id :"+id+" not found");
    }

    @Override
    public void deleteAuthor(Long id) {

    }
}
