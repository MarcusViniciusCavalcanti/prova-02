package br.edu.utfpr.tsi.prova02.domain.security;

import br.edu.utfpr.tsi.prova02.domain.entity.Profile;
import br.edu.utfpr.tsi.prova02.domain.entity.UserDetailsImp;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SecurityFilter extends BasicAuthenticationFilter {
    private final AuthenticationManager authenticationManager;

    private final UserDetailsService userDetailsService;

    public SecurityFilter(AuthenticationManager authenticationManager, UserDetailsService userDetailsService) {
        super(authenticationManager);
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            boolean isAdmin = authentication.getAuthorities().stream()
                    .anyMatch(role -> ((GrantedAuthority) role).getAuthority().equals(Profile.ADMIN.getDescription()));

            UserDetailsImp principal = (UserDetailsImp) authentication.getPrincipal();
            request.getSession().setAttribute("user", principal);
            if (isAdmin) {
                request.getRequestDispatcher("/vagas").forward(request, response);
            } else {
                request.getRequestDispatcher("/candidato/dashboard").forward(request, response);
            }
        }

        chain.doFilter(request, response);
    }

//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        if (authentication.isAuthenticated()) {
//            Object details = authentication.getDetails();
//
//            boolean isAdmin = authentication.getAuthorities().stream()
//                    .anyMatch(role -> ((GrantedAuthority) role).getAuthority().equals(Profile.ADMIN.getDescription()));
//
//            if (isAdmin) {
//                request.getRequestDispatcher("/vagas").forward(request, response);
//            } else {
//                request.getRequestDispatcher("/candidato/dashboard");
//            }
//        }
//
//        chain.doFilter(request, response);
//    }

//    @Override
//    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
//
//        Object details = authResult.getDetails();
//
//        boolean isAdmin = authResult.getAuthorities().stream()
//                .anyMatch(role -> ((GrantedAuthority) role).getAuthority().equals(Profile.ADMIN.getDescription()));
//
//        if (isAdmin) {
//            request.getRequestDispatcher("/vagas").forward(request, response);
//        } else {
//            request.getRequestDispatcher("/candidato/dashboard");
//        }
//    }

}
