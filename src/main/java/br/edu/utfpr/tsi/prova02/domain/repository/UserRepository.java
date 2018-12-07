package br.edu.utfpr.tsi.prova02.domain.repository;

import br.edu.utfpr.tsi.prova02.domain.entity.UserApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserApplication, Long> {
    Optional<UserApplication> findByEmail(String email);
}
