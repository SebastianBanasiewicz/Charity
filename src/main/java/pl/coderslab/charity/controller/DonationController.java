package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/donation")
public class DonationController {

    private final CategoryService categoryService;
    private final DonationService donationService;
    private final InstitutionService institutionService;

    @GetMapping("/add")
    public String addDonation(Model model) {
        model.addAttribute("donation", new Donation());
        model.addAttribute("categories", categoryService.getCategories());
        model.addAttribute("institutions", institutionService.getInstitutions());
        return "addDonation";
    }
}
