package me.sup2is.securitylogin2;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {

    @GetMapping(value = {"/", "/index"})
    public String index(){
        return "index";
    }

    @GetMapping("/home")
    public String home(Principal principal, Model model){
        model.addAttribute("user", principal.getName());
        model.addAttribute("roles", ((UsernamePasswordAuthenticationToken) principal).getAuthorities());
        return "home";
    }

    @GetMapping("/admin")
    public String admin(Principal principal, Model model){
        model.addAttribute("user", principal.getName());
        model.addAttribute("roles", ((UsernamePasswordAuthenticationToken) principal).getAuthorities());
        return "admin";
    }

    @GetMapping("/403")
    public String forbidden() {
        return "403";
    }

}
