package re.ss18.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import re.ss18.dto.LoginRequest;
import re.ss18.dto.LoginResponse;
import re.ss18.dto.RegisterRequest;
import re.ss18.dto.RegisterResponse;
import re.ss18.entity.User;
import re.ss18.repository.UserRepository;
import re.ss18.security.JwtTokenProvider;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public RegisterResponse register(RegisterRequest request) {

        if(userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();

        user.setPhone(request.getPhone());
        user.setEmail(request.getEmail());
        user.setPassword(
                passwordEncoder.encode(request.getPassword())
        );
        user.setRole("ROLE_USER");

        userRepository.save(user);

        return new RegisterResponse(
                "Register success"
        );
    }

    @Override
    public LoginResponse login(LoginRequest request) {

        User user = userRepository
                .findByEmail(request.getEmail())
                .orElseThrow(
                        () -> new RuntimeException("User not found")
                );

        if(!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()
        )) {
            throw new RuntimeException("Wrong password");
        }

        String token =
                jwtTokenProvider.generateToken(
                        user.getEmail()
                );

        return new LoginResponse(
                token,
                token
        );
    }
}
