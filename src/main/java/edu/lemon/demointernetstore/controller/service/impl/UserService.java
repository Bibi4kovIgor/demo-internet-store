package edu.lemon.demointernetstore.controller.service.impl;

import edu.lemon.demointernetstore.model.mapper.UserMapper;
import edu.lemon.demointernetstore.model.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
  private final UserRepository usersRepository;
  private final UserMapper userMapper;

  public UserService(UserRepository usersRepository, UserMapper userMapper) {
    this.usersRepository = usersRepository;
    this.userMapper = userMapper;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return userMapper.toDto(usersRepository.findByName(username));
  }
}
