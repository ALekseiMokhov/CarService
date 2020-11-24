package com.senla.carservice.dto;

import com.senla.carservice.entity.user.Role;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String password;

    @NotNull
    @NotEmpty
    private Set<Role> roles;

}
