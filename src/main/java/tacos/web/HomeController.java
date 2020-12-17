package tacos.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

   @GetMapping("/")
   public String home() {
            return "home";
   }

   @GetMapping("/thankyou")
   public String thankyou() {
       return "thankyou";
   }

   @GetMapping("/accessDenied")
   public String accessDenied() {
       return "accessDenied";
   }
}
