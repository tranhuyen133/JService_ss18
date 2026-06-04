package re.ss18.dto;


import lombok.Data;

@Data
public class RegisterRequest {

    private String phone;

    private String email;

    private String password;
}