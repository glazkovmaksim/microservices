package com.example.user_service.service;

import com.example.user_service.dto.DepartmentDTO;
import com.example.user_service.dto.ResponseDTO;
import com.example.user_service.dto.UserDTO;
import com.example.user_service.entity.User;
import com.example.user_service.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private WebClient.Builder webClientBuilder;


    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }


    @Override
    public ResponseDTO getUser(Long userId) {
        ResponseDTO responseDTO = new ResponseDTO();
        User user = userRepository.findById(userId).get();
        UserDTO userDTO = mapToUser(user);

        DepartmentDTO departmentDTO = webClientBuilder.build().get()
                .uri("http://DEPARTMENT-SERVICE/api/departments/" + user.getDepartmentId())
                .retrieve()
                .bodyToMono(DepartmentDTO.class)
                .block();

        responseDTO.setUser(userDTO);
        responseDTO.setDepartment(departmentDTO);

        return responseDTO;
    }

    private UserDTO mapToUser(User user){
        UserDTO userDto = new UserDTO();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}
