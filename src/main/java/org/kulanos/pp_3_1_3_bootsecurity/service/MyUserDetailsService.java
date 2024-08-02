package org.kulanos.pp_3_1_3_bootsecurity.service;

import org.kulanos.pp_3_1_3_bootsecurity.model.User;
import org.kulanos.pp_3_1_3_bootsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);

       return user.map(MyUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

    }
}
