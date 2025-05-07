package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "autores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String nombre;
    
    @Column(unique = true)
    private String email;
    
    @ManyToMany(mappedBy = "autores", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Libro> libros = new HashSet<>();
}