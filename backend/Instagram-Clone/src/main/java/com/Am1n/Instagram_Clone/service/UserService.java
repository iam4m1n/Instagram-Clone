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

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;


    public Page<UserDTO> getAllUsers(int page) {
        Pageable pageable = PageRequest.of(page, 5, Sort.by("joinDate").descending());
        return userRepository.findAll(pageable)
                .map(user -> modelMapper.map(user, UserDTO.class));
    }

    private final Map<UUID, String> userProfiles = new HashMap<>();

    public String getProfile(UUID userId) {
        return userRepository.findBioByUserId(userId);
    }

    public void updateProfile(UUID userId, String newBio) throws Exception {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new Exception(String.valueOf(userId)));
        user.setBio(newBio);
        userRepository.save(user);}
}

