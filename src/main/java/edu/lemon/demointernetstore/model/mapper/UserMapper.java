package edu.lemon.demointernetstore.model.mapper;

import edu.lemon.demointernetstore.model.database.entity.User;
import edu.lemon.demointernetstore.utils.IdTransformUtility;
import edu.lemon.demointernetstore.utils.Role;
import edu.lemon.demointernetstore.view.web.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface UserMapper {
  @Mapping(target = "role", source = "role", qualifiedByName = "getEnumRole")
  UserDto toDto(User user) ;

  @Mapping(target = "role", source = "role", qualifiedByName = "getRoleName")
  User fromDto(UserDto userDto);

  @Named("getEnumRole")
  default Role getEnumRole(String role) {
    return Role.valueOf(role);
  }

  @Named("getRoleName")
  default String getRoleName(Role role) {
    return role.name();
  }



}
