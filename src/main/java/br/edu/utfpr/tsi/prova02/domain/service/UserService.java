package br.edu.utfpr.tsi.prova02.domain.service;

import br.edu.utfpr.tsi.prova02.domain.repository.UserRepository;
import br.edu.utfpr.tsi.prova02.domain.entity.UserApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<UserApplication> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
