package br.edu.utfpr.tsi.prova02.domain.entity;

import br.edu.utfpr.tsi.prova02.structure.EntityApplication;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "jobs")
@Data
@EqualsAndHashCode(callSuper = true)
public class Job extends EntityApplication {
    @Column(nullable = false, length = 10)
    @NotBlank
    @Size(min = 5, max = 10, message = "O campo título de ser entre {min} e {max}")
    private String title;

    @Column(nullable = false, length = 50)
    @NotBlank
    @Size(min = 5, max = 50, message = "O campo descrição de ser entre {min} e {max}")
    private String description;
}

