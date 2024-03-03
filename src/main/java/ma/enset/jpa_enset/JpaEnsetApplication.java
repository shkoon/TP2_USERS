package ma.enset.jpa_enset;

import ma.enset.jpa_enset.entities.Role;
import ma.enset.jpa_enset.entities.User;
import ma.enset.jpa_enset.service.UserService;
import ma.enset.jpa_enset.service.UserServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class JpaEnsetApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaEnsetApplication.class, args);
    }

    @Bean
    CommandLineRunner start(UserService userService){
        return  args -> {
            User user=new User();
            user.setUsername("user1");
            user.setPassword("123456");
            userService.addNewUser(user);

            User u2=new User();
            u2.setUsername("admin");
            u2.setPassword("123456");
            userService.addNewUser(u2);

            Stream.of("STUDENT","ADMIN","USER").forEach(role->{
                Role role1=new Role();
                role1.setRoleName(role);
                userService.addNewRole(role1);
            });

            userService.addRoleToUser("user1","STUDENT");
            userService.addRoleToUser("user1","USER");
            userService.addRoleToUser("admin","ADMIN");
            userService.addRoleToUser("admin","USER");

            try{
                User user1=userService.authenticate("user1","123456");
                System.out.println(user1.getId());
                System.out.println(user1.getUsername());
                user1.getRoles().forEach(role->{
                    System.out.println(role);
                });
            }
            catch (Exception e){
                e.printStackTrace();
            }





        };
    }

}
