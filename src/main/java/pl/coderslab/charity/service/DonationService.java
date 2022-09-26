package pl.coderslab.charity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.repository.DonationRepository;

@Service
public class DonationService {

    @Autowired
    private DonationRepository donationRepository;

    public Iterable<Donation> getDonations() {
        return donationRepository.findAll();
    }

    public Integer totalDonationBags() {
        return donationRepository.totalDonationBags();
    }

    public Integer totalDonations() {
        return donationRepository.totalDonations();
    }
}
