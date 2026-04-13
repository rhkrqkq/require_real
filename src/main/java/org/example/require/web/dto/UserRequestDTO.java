package org.example.require.web.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

public class UserRequestDTO {
    @Getter
    public static class joinDTO {
        @NotBlank(message = "이메일을 입력해주세요.")
        private String email;

        @NotBlank(message = "이름을 입력해주세요")
        private String name;

        @NotBlank(message = "비밀번호를 입력해주세요")
        private String password;

        @NotBlank(message = "비밀번호를 다시 입력해주세요")
        private String passwordConfirm;
    }
}
