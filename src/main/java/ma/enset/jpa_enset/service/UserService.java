package ma.enset.jpa_enset.service;

import ma.enset.jpa_enset.entities.Role;
import ma.enset.jpa_enset.entities.User;

public interface UserService {

    User addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByUserName(String userName);
    Role findRoleByRoleName(String roleName);
    void addRoleToUser(String userName,String roleName);
    User authenticate(String userName,String password);
}
