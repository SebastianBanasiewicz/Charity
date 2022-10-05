package pl.coderslab.charity.security;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import pl.coderslab.charity.model.Role;
import pl.coderslab.charity.model.User;

import java.util.Collection;
import java.util.stream.Collectors;

@AllArgsConstructor
public class UserDetails implements org.springframework.security.core.userdetails.UserDetails {

    private final User user;

    @Override // pobiera uprawnienia
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getRoleList()
                .stream()
                .map((Role role) -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toSet());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
