package br.edu.utfpr.tsi.prova02.domain.entity;

import br.edu.utfpr.tsi.prova02.structure.EntityApplication;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "contacts")
@Data
@EqualsAndHashCode(callSuper = true)
public class Contact extends EntityApplication {
    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String cityName;

    @Column(nullable = false)
    private String provinceName;

    @Column(nullable = false)
    private String provinceUF;
}
