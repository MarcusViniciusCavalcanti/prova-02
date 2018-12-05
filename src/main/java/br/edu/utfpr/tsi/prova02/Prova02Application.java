package br.edu.utfpr.tsi.prova02;

import br.edu.utfpr.tsi.prova02.domain.entity.Job;
import br.edu.utfpr.tsi.prova02.domain.repository.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Prova02Application implements CommandLineRunner {
    @Autowired
    JobsRepository jobsRepository;

    public static void main(String[] args) {
        SpringApplication.run(Prova02Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Job job = new Job();
            job.setTitle("Vaga " + i);
            job.setDescription("com a descrição " + i);
            jobs.add(job);
        }

        jobsRepository.saveAll(jobs);
    }
}
