package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "libros")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String titulo;
    
    @Column(nullable = false)
    private Double precio;
    
    @Column(nullable = false)
    private Integer stock;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "libro_autor",
        joinColumns = @JoinColumn(name = "libro_id"),
        inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    private Set<Autor> autores = new HashSet<>();
    
    @OneToMany(mappedBy = "libro", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<DetalleVenta> detallesVenta = new HashSet<>();
}