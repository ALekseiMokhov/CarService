package com.senla.carservice.dto.mappers.interfaces;

import com.senla.carservice.dto.UserDto;
import com.senla.carservice.entity.user.Role;
import com.senla.carservice.entity.user.User;
import com.senla.carservice.entity.user.User.UserBuilder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-10-26T21:33:26+0300",
    comments = "version: 1.4.0.Final, compiler: javac, environment: Java 14.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto fromUser(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setName( user.getName() );
        userDto.setPassword( user.getPassword() );
        Set<Role> set = user.getRoles();
        if ( set != null ) {
            userDto.setRoles( new HashSet<Role>( set ) );
        }

        return userDto;
    }

    @Override
    public User fromDto(UserDto dto) {
        if ( dto == null ) {
            return null;
        }

        UserBuilder user = User.builder();

        user.name( dto.getName() );
        user.password( dto.getPassword() );
        Set<Role> set = dto.getRoles();
        if ( set != null ) {
            user.roles( new HashSet<Role>( set ) );
        }

        return user.build();
    }

    @Override
    public List<UserDto> userListToDto(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( users.size() );
        for ( User user : users ) {
            list.add( fromUser( user ) );
        }

        return list;
    }

    @Override
    public List<User> dtoToUsers(List<UserDto> dto) {
        if ( dto == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( dto.size() );
        for ( UserDto userDto : dto ) {
            list.add( fromDto( userDto ) );
        }

        return list;
    }
}
