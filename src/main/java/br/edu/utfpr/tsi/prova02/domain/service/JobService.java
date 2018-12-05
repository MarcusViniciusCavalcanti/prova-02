package br.edu.utfpr.tsi.prova02.domain.service;

import br.edu.utfpr.tsi.prova02.domain.entity.Job;
import br.edu.utfpr.tsi.prova02.domain.repository.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class JobService {
    private final JobsRepository jobsRepository;

    @Autowired
    public JobService(JobsRepository jobsRepository) {
        this.jobsRepository = jobsRepository;
    }

    public List<Job> findAll() {
        return jobsRepository.findAll();
    }

    public void save(Job job) {
        jobsRepository.save(job);
    }

    public Job findById(Long id) {
        return jobsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Vaga com o id: " + id + " não existe"));
    }

    public void deleteById(Long id) {
        jobsRepository.deleteById(id);
    }
}
