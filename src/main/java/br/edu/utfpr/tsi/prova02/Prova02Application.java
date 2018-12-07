package br.edu.utfpr.tsi.prova02;

import br.edu.utfpr.tsi.prova02.domain.entity.Candidate;
import br.edu.utfpr.tsi.prova02.domain.entity.Contact;
import br.edu.utfpr.tsi.prova02.domain.entity.Job;
import br.edu.utfpr.tsi.prova02.domain.repository.CandidateRepository;
import br.edu.utfpr.tsi.prova02.domain.repository.ContactRepository;
import br.edu.utfpr.tsi.prova02.domain.repository.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Prova02Application implements CommandLineRunner {
    @Autowired
    JobsRepository jobsRepository;

    @Autowired
    CandidateRepository candidateRepository;

    @Autowired
    ContactRepository contactRepository;

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

        Candidate candidate = new Candidate();
        candidate.setBirthday(LocalDate.now());
        candidate.setName("Vinicius Cavalcanti");
        candidate.setOffice("Desenvolvedor Java");
        candidate.setTestAccuracy(100);
        candidate.setWebApplicationAccuracy(100);
        candidate.setWebsiteDesignAccuracy(70);
        candidate.setUiUixAccuracy(10);

        Contact contact = new Contact();
        contact.setCityName("Pinhão");
        contact.setProvinceName("Paraná");
        contact.setProvinceUF("PR");
        contact.setStreet("Uma rua aew");

//        contact = contactRepository.save(contact);

        candidate.setContact(contact);

        candidateRepository.save(candidate);
    }
}
