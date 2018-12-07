package br.edu.utfpr.tsi.prova02.domain.service;

import br.edu.utfpr.tsi.prova02.domain.entity.Candidate;
import br.edu.utfpr.tsi.prova02.domain.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
public class CandidateService {
    private final CandidateRepository candidateRepository;

    @Autowired
    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @Transactional
    public Candidate findById(Long id) {
        return candidateRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("candidato não encontrado"));
    }

    @Transactional
    public Candidate save(Candidate candidate) {
        Candidate current = findById(candidate.getId());

        current.setName(candidate.getName());
        current.setOffice(candidate.getOffice());
        current.setUiUixAccuracy(candidate.getUiUixAccuracy());
        current.setWebsiteDesignAccuracy(candidate.getWebsiteDesignAccuracy());
        current.setWebApplicationAccuracy(candidate.getWebApplicationAccuracy());
        current.setTestAccuracy(candidate.getTestAccuracy());
        current.setBirthday(candidate.getBirthday());

        return candidateRepository.save(current);
    }
}
