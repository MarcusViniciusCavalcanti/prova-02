package br.edu.utfpr.tsi.prova02.domain.repository;

import br.edu.utfpr.tsi.prova02.domain.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}
