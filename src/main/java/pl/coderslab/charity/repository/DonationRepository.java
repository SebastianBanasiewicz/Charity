package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.model.Donation;

public interface DonationRepository extends JpaRepository<Donation, Long> {

    @Query("SELECT SUM(d.quantity) FROM Donation d")
    Integer totalDonationBags();

    @Query("SELECT count(d.id) FROM Donation d")
    Integer totalDonations();

}
