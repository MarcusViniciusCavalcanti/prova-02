package br.edu.utfpr.tsi.prova02.domain.service;

import br.edu.utfpr.tsi.prova02.domain.entity.UserApplication;
import br.edu.utfpr.tsi.prova02.domain.entity.UserDetailsImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserService usersService;

    @Autowired
    public UserDetailsServiceImpl(UserService usersService) {
        this.usersService = usersService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserApplication user = usersService.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("username not found: " + email));
        return new UserDetailsImp(user);
    }
}
