package com.Am1n.Instagram_Clone.service;
import com.Am1n.Instagram_Clone.dto.User.UserDTO;
import com.Am1n.Instagram_Clone.model.UserEntity;
import com.Am1n.Instagram_Clone.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {


    @Autowired
    private UserRepository userRepository;
    private ModelMapper modelMapper = new ModelMapper();

    public Page<UserDTO> getAllUsers(int page) {
        Pageable pageable = PageRequest.of(page, 5, Sort.by("joinDate").descending());
        return userRepository.findAll(pageable)
                .map(user -> modelMapper.map(user, UserDTO.class));
    }
}