package re.ss18.security;

import lombok.RequiredArgsConstructor;



import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import re.ss18.entity.User;
import re.ss18.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService
        implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(
            String email) {

        User user =
                userRepository
                        .findByEmail(email)
                        .orElseThrow();

        return new UserPrincipal(user);
    }
}
