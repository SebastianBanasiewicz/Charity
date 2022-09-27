package pl.coderslab.charity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstitutionService {

    @Autowired
    private final InstitutionRepository institutionRepository;

    public Iterable<Institution> getInstitutions() {
        return institutionRepository.findAll();
    }

}
