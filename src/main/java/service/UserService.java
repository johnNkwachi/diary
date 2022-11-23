package service;

import dto.*;

public interface UserService {

   UserRegistrationResponse register (UserRegistrationRequest request);
   LoginResponse login(LoginRequest loginRequest);
   DeleteDiaryResponse delete(DeleteDiaryRequest deleteDiaryRequest);

}