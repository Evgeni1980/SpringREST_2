package ru.kremenia.model.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;

    @NotBlank(message = "can not be emty!!!")
    private String username;

    @NotBlank
    @Email
    private String email;

    @Pattern(regexp = "^(?=.*?\\d)(?=.*[A-Z]).{8,}$", message = "Password too simple")
    private String password;

    @JsonIgnore
    private String matchingPassword;

    public UserDto(Long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
