package re.ss18.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import re.ss18.dto.UpdateRoleRequest;
import re.ss18.service.UserService;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PutMapping("/{id}/role")
    @PreAuthorize("hasRole('ADMIN')")
    public User updateRole(
            @PathVariable Long id,
            @RequestBody UpdateRoleRequest request) {

        return userService.updateRole(
                id,
                request.getRole()
        );
    }

    @GetMapping("/me")
    public User me(
            Authentication authentication) {

        return userService.getCurrentUser(
                authentication.getName()
        );
    }
}
