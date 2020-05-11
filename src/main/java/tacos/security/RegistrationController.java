package tacos.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tacos.Role;
import tacos.data.RoleRepository;
import tacos.data.UserRepository;

import java.util.Arrays;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private UserRepository userRepo;
    @Autowired
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public RegistrationController(
            UserRepository userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String registerForm() {
        return "registration";
    }

    @PostMapping
    public String processRegistration(RegistrationForm form) {
        Role userRole = roleRepository.findByName("ROLE_USER");
        form.setRoles(Arrays.asList(userRole));
        userRepo.save(form.toUser(passwordEncoder));
        return "registration_thankyou";
//        return "redirect:/login";
    }

}