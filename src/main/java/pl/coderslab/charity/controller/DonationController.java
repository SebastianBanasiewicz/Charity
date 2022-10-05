package pl.coderslab.charity.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/donation")
public class DonationController {

    @Autowired
    private final CategoryService categoryService;
    @Autowired
    private final DonationService donationService;
    @Autowired
    private final InstitutionService institutionService;

    @GetMapping("/add")
    public String addDonation(Model model) {
        model.addAttribute("donation", new Donation());
        List<Category> categories = (List<Category>) categoryService.getCategories();
        model.addAttribute("categories", categories);
        List<Institution> institutions = (List<Institution>) institutionService.getInstitutions();
        model.addAttribute("institutions", institutions);
        return "addDonationForm";
    }

    @PostMapping("/add")
    public String saveDonation(@ModelAttribute("donation") @Valid Donation donation, BindingResult result) {
        if (result.hasErrors()) {
            return "addDonationForm";
        }
        donation.setCategories(donation.getCategories());
        donationService.save(donation);
        return "redirect:/";
    }
}
