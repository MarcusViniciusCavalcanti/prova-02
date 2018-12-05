package br.edu.utfpr.tsi.prova02.domain.service;

import br.edu.utfpr.tsi.prova02.domain.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateService {
    private final CandidateRepository candidateRepository;

    @Autowired
    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }
}
