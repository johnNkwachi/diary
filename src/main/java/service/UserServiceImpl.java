package service;

import dto.*;
import exception.DiaryException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import models.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import repositories.UserRepo;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j

public class UserServiceImpl implements UserService{
    @Autowired
private final UserRepo userRepo;
private final ModelMapper mapper;
private LoginResponse loginResponse;

    @Autowired
    public UserServiceImpl(UserRepo userRepo, ModelMapper modelMapper) {
        this.userRepo = userRepo;
        this.mapper=new ModelMapper();
    }

    @Override
    public UserRegistrationResponse register(UserRegistrationRequest request) {
        Optional<User> foundUser = userRepo.findByEmail(request.getEmail());
        if (foundUser.isPresent())throw new DiaryException("User already exist");
        User appUser = mapper.map(request, User.class);
        userRepo.save(appUser);
        log.info("save user to db {}", appUser);
        return UserRegistrationResponse.builder().message("Successful").build();
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        User appUser = userRepo.findByEmail(loginRequest.getEmail())
                .orElseThrow(()-> new DiaryException(""));
        if (appUser.getEmail().equals(loginRequest.getEmail())){
            loginResponse.setMessage("Login Successful");
        }else {
            loginResponse.setMessage("authentication failed");
        }
        return loginResponse;
    }

    @Override
    public DeleteDiaryResponse delete(DeleteDiaryRequest deleteDiaryRequest) {
        return null;
    }
}
