package re.ss18.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import re.ss18.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl
        implements UserService {

    private final UserRepository userRepository;

    @Override
    public User updateRole(
            Long id,
            String role
    ) {

        User user =
                userRepository.findById(id)
                        .orElseThrow();

        user.setRole(role);

        return userRepository.save(user);
    }

    @Override
    public User getCurrentUser(
            String email
    ) {

        return userRepository
                .findByEmail(email)
                .orElseThrow();
    }
}