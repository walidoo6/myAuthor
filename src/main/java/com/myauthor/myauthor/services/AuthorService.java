package com.myauthor.myauthor.services;

import com.myauthor.myauthor.models.AuthorRequest;
import com.myauthor.myauthor.models.AuthorResponse;

import java.util.List;

public interface AuthorService {

    AuthorResponse addAuthor(AuthorRequest authorRequest);
    AuthorResponse getOneAuthor(Long id);
    List<AuthorResponse> getAllAuthors();
    AuthorResponse updateAuthor(AuthorRequest authorRequest, Long id);
    void deleteAuthor(Long id);


}
