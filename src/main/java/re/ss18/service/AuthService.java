package re.ss18.service;


import re.ss18.dto.LoginRequest;
import re.ss18.dto.LoginResponse;
import re.ss18.dto.RegisterRequest;
import re.ss18.dto.RegisterResponse;

public interface AuthService {

    RegisterResponse register(RegisterRequest request);

    LoginResponse login(LoginRequest request);
}