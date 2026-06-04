package re.ss18.service;


import org.springframework.security.core.userdetails.User;

public interface UserService {

    User updateRole(Long id, String role);

    User getCurrentUser(String email);
}