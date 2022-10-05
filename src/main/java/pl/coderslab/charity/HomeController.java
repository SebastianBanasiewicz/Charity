package pl.coderslab.charity;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;
import pl.coderslab.charity.service.UserService;

import java.util.List;


@Controller
@AllArgsConstructor
public class HomeController {

    @Autowired
    private InstitutionService institutionService;
    @Autowired
    private DonationService donationService;
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String homeAction(Model model) {

        List<Institution> institutions = (List<Institution>) institutionService.getInstitutions();
        model.addAttribute("institutions", institutions);
        Integer totalDonationBags = donationService.totalDonationBags();
        model.addAttribute("totalDonationBags", totalDonationBags);
        Integer totalDonations = donationService.totalDonations();
        model.addAttribute("totalDonations", totalDonations);
        return "index";
    }

    @RequestMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(User user) {
        userService.save(user);
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String afterLogin() {
        return "index";
    }

    @GetMapping("/info")
    public String info(Model model) {
        List<Institution> list = (List<Institution>) institutionService.getInstitutions();
        model.addAttribute("institutions", list);
        Integer totalDonationBags = donationService.totalDonationBags();
        model.addAttribute("totalDonationBags", totalDonationBags);
        Integer totalDonations = donationService.totalDonations();
        model.addAttribute("totalDonations", totalDonations);
        return "info";
    }

    @GetMapping("/institutions")
    public String institutions(Model model) {
        List<Institution> institutions = (List<Institution>) institutionService.getInstitutions();
        model.addAttribute("institutions", institutions);
        return "institutions";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

}

