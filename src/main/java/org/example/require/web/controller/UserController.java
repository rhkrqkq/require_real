package org.example.require.web.controller;

import lombok.RequiredArgsConstructor;
import org.example.require.service.UserService;
import org.example.require.web.dto.UserRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<String> signup(@RequestBody UserRequestDTO.joinDTO joinDTO) {
        userService.signup(joinDTO.getEmail(), joinDTO.getName(), joinDTO.getPassword());

        return ResponseEntity.ok("회원가입이 완료되었습니다.");
    }
}
