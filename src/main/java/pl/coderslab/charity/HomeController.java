package pl.coderslab.charity;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class HomeController {

    @Autowired
    private InstitutionService institutionService;
    @Autowired
    private DonationService donationService;

    @RequestMapping("/")
    public String homeAction(Model model) {

        List<Institution> list = (List<Institution>) institutionService.getInstitutions();
        model.addAttribute("institutions", list);
        Integer totalDonationBags = donationService.totalDonationBags();
        model.addAttribute("totalDonationBags", totalDonationBags);
        Integer totalDonations = donationService.totalDonations();
        model.addAttribute("totalDonations", totalDonations);
        return "index";
    }
}
