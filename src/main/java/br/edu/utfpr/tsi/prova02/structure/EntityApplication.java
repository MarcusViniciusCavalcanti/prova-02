package br.edu.utfpr.tsi.prova02.structure;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@MappedSuperclass
public abstract class EntityApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDate createdAt;

    @Column
    private LocalDate updatedAt;

    @PrePersist
    private void prePersist() {
        this.createdAt = LocalDate.now();
        this.updatedAt = LocalDate.now();
    }

    @PreUpdate
    private void preUpdate() {
        this.updatedAt = LocalDate.now();
    }
}
