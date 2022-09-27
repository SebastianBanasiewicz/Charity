package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/donation")
public class DonationController {

    private final CategoryService categoryService;
    private final DonationService donationService;
    private final InstitutionService institutionService;
    private final DonationRepository donationRepository;

    @GetMapping("/add")
    public String addDonation(Model model) {
        model.addAttribute("donation", new Donation());
        model.addAttribute("categories", categoryService.getCategories());
        model.addAttribute("institutions", institutionService.getInstitutions());
        return "addDonation";
    }

    @PostMapping("/add")
    public String saveDonation(@ModelAttribute("donation") @Valid Donation donation, BindingResult result) {
        if (result.hasErrors()) {
            return "form";
        }
        donation.setCategories(donation.getCategories());
        donationRepository.save(donation);
        return "redirect:/";
    }
}
