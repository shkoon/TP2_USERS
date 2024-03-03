package ma.enset.jpa_enset.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import ma.enset.jpa_enset.entities.Role;
import ma.enset.jpa_enset.entities.User;
import ma.enset.jpa_enset.repositories.RoleRepository;
import ma.enset.jpa_enset.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private RoleRepository roleRepository;
    private UserRepository userRepository;

    @Override
    public User addNewUser(User user) {
        user.setId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User findUserByUserName(String userName) {
        return userRepository.findByUsername(userName);
    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        User user=findUserByUserName(userName);
        Role role=findRoleByRoleName(roleName);
        if (user.getRoles()!=null)
        {
            user.getRoles().add(role);
            role.getUsers().add(user);
        }


    }

    @Override
    public User authenticate(String userName, String password) {
        User user=findUserByUserName(userName);
        if( user==null){
            throw new RuntimeException("Bad Credentials");
        }
        if(user.getPassword().equals(password)){
            return  user;
        }
        throw new RuntimeException("Bad Credentials");
    }
}
