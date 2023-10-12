package com.myauthor.myauthor.models;

import com.myauthor.myauthor.entities.Author;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter
@Setter
public class AuthorResponse {
    private Long id;
    private String nom;
    private String pays;

    public AuthorResponse(Author author) {
        this.id = author.getId();
        this.nom = author.getNom();
        this.pays = author.getPays();
    }
}