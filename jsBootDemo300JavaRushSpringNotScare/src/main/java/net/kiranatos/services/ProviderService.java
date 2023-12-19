package net.kiranatos.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import net.kiranatos.entities.ProviderEntity;
import net.kiranatos.repositories.ProviderRepository;
import org.springframework.data.domain.Example;

@Service
@RequiredArgsConstructor
public class ProviderService {

    private final ProviderRepository providerRepository;
    
    public Optional<ProviderEntity> getById(Integer id) {
        return providerRepository.findById(id);
    }

    public void delById(Integer id) {
        providerRepository.deleteById(id);
    }

    public Boolean exist(Example<? extends ProviderEntity> example) {
        return providerRepository.exists(example);
    }

    public void saveAll(List<ProviderEntity> providerEntity){
        providerRepository.saveAll(providerEntity);
    }

    public void save(ProviderEntity providerEntity){
        providerRepository.save(providerEntity);
    }

    public List<ProviderEntity> getAll(){ 
       return providerRepository.findAll();
    }
}