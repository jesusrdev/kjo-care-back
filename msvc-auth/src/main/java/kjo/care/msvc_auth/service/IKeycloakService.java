package kjo.care.msvc_auth.service;

import kjo.care.msvc_auth.dto.UserDTO;
import kjo.care.msvc_auth.dto.UserInfoDto;
import org.keycloak.representations.idm.UserRepresentation;

import java.util.List;

public interface IKeycloakService {
    List<UserRepresentation> findAllUser();
    List<UserRepresentation> findAllUserByUsername(String username);
    UserInfoDto findUserById(String userId);
    String createUser(UserDTO userDTO);
    void deleteUser(String userId);
    void updateUser(String userId,UserDTO userDTO);
}
