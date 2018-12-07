package br.edu.utfpr.tsi.prova02.domain.entity;

import br.edu.utfpr.tsi.prova02.structure.EntityApplication;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Candidate> candidates = new HashSet<>();

    public void addCandidate(Candidate candidate) {
        this.candidates.add(candidate);
    }
}

