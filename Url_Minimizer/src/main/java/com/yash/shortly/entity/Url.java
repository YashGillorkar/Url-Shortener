package com.yash.shortly.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "urls", uniqueConstraints = @UniqueConstraint(columnNames = "shortUrl"))
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @URL
    @Column(nullable = false, length = 2048) // Ensures valid URLs and prevents null values
    private String longUrl;

    @NotNull
    @Column(unique = true, nullable = false, length = 10) // Ensures unique short URLs
    private String shortUrl;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
