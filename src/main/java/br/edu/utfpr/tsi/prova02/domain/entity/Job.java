package br.edu.utfpr.tsi.prova02.domain.entity;

import br.edu.utfpr.tsi.prova02.structure.EntityApplication;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "jobs")
@Data
@EqualsAndHashCode(callSuper = true)
public class Job extends EntityApplication {
    @Column private String title;
    @Column private String description;
}

