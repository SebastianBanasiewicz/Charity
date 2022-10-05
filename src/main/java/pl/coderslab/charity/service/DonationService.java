package pl.coderslab.charity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.repository.DonationRepository;

@Service
@RequiredArgsConstructor
public class DonationService {

    @Autowired
    private final DonationRepository donationRepository;

    public void save(Donation donation) {
        donationRepository.save(donation);
    }

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
