package br.edu.utfpr.tsi.prova02.domain.entity;

import br.edu.utfpr.tsi.prova02.structure.EntityApplication;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "candidates")
@Data
@EqualsAndHashCode(callSuper = true)
public class Candidate extends EntityApplication {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate birthday;

    @Column(nullable = false)
    private String office;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    private Contact contact;

    @Column
    private int webApplicationAccuracy;

    @Column
    private int websiteDesignAccuracy;

    @Column
    private int testAccuracy;

    @Column
    private int uiUixAccuracy;
}
