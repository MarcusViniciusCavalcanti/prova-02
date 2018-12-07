package br.edu.utfpr.tsi.prova02.domain.service;

import br.edu.utfpr.tsi.prova02.domain.entity.Candidate;
import br.edu.utfpr.tsi.prova02.domain.entity.Job;
import br.edu.utfpr.tsi.prova02.domain.repository.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class JobService {
    private final JobsRepository jobsRepository;

    @Autowired
    public JobService(JobsRepository jobsRepository) {
        this.jobsRepository = jobsRepository;
    }

    @Transactional
    public List<Job> findAll() {
        return jobsRepository.findAll();
    }

    @Transactional
    public void save(Job job) {
        jobsRepository.save(job);
    }

    @Transactional
    public Job findById(Long id) {
        return jobsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Vaga com o id: " + id + " não existe"));
    }

    @Transactional
    public void deleteById(Long id) {
        jobsRepository.deleteById(id);
    }

    @Transactional
    public void candidateAdd(Candidate candidate, Long id) {
        Job job = findById(id);
        job.addCandidate(candidate);
        save(job);
    }
}
