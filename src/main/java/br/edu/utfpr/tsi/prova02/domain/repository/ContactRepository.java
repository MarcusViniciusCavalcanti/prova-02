package br.edu.utfpr.tsi.prova02.domain.repository;

import br.edu.utfpr.tsi.prova02.domain.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

}
