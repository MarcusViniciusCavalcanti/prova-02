package br.edu.utfpr.tsi.prova02.domain.entity;

import br.edu.utfpr.tsi.prova02.structure.EntityApplication;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Inheritance(strategy = InheritanceType.JOINED)
public class UserApplication extends EntityApplication {
    @Column private String email;
    @Column private String password;
    @Column private boolean accountNonExpired = true;
    @Column private boolean accountNonLocked = true;
    @Column private boolean enabled = true;
    @Column private boolean credentialsNonExpired = true;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "profiles_users")
    private Set<Integer> profiles = new HashSet<>();

    public Set<Profile> getProfiles() {
        return profiles.stream().map(Profile::toEnum).collect(Collectors.toSet());
    }

    public void addProfile(Profile profile) {
        this.profiles.add(profile.getCode());
    }

    @PrePersist
    private void addUserProfile() {
        this.addProfile(Profile.USER);
    }
}
