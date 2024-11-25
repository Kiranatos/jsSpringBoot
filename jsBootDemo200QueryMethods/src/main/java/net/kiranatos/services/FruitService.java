package net.kiranatos.services;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import net.kiranatos.entities.FruitEntity;
import net.kiranatos.repositories.FruitRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class FruitService {

    private final FruitRepository fruitRepository;

    public FruitService(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    public void save(FruitEntity[] fruitEntity) {
        for (FruitEntity f : fruitEntity) {
            save(f);
        }
    }

    /* ============= Demonstration #0 methods that exist in repository from the beginning ============= */
    /* Ці методи можна також переглянути в інтерфейсах CrudRepository, QueryByExampleExecutor */
    public void save(FruitEntity fruitEntity) {
        fruitRepository.save(fruitEntity);
    }
    
    public void saveAll(List<FruitEntity> fruits) {
        fruitRepository.saveAll(fruits);
    }
    
    public List<FruitEntity> getAll() {
        return fruitRepository.findAll();
    }
    
    public Optional<FruitEntity> getById(int id) {
        return fruitRepository.findById(id);
    }
    
    public void delById(int id) {
        fruitRepository.deleteById(id);
    }

    public Boolean exist(Example<? extends FruitEntity> example) {
        return fruitRepository.exists(example);
    }
    
    /* ============= Demonstration #1 [ find…By, read…By, get…By, query…By, search…By, stream…By ] ============= */
    public List<FruitEntity> findByName(String fruitName) { 
        //return fruitRepository.findByFruitName(fruitName);

        //return fruitRepository.getByFruitName(fruitName);
        //return fruitRepository.queryByFruitName(fruitName);
        //return fruitRepository.readByFruitName(fruitName);
        
        //return fruitRepository.findALLByFruitName(fruitName);
        //return fruitRepository.findAllByFruitName(fruitName);
        //return fruitRepository.findFruitEntityByFruitName(fruitName);
        
        //return fruitRepository.findFruitByFruitName(fruitName);
        //return fruitRepository.findFruitEntitiesByFruitName(fruitName);
        //return fruitRepository.findFruitEntitysByFruitName(fruitName);
        //return fruitRepository.findSOMETHINGEntitysByFruitName(fruitName);
        return fruitRepository.findByFruitName(fruitName);
        //return fruitRepository.findByName(fruitName);
    }

    /* ============= Demonstration #2 returned type ============= */
    public FruitEntity findOneByName(String fruitName) { 
        //return fruitRepository.readByFruitName(fruitName);
        return fruitRepository.getByFruitName(fruitName).get();
    }

    /* ============= Demonstration #3 findFirst ============= */
    public FruitEntity findFirstByName(String fruitName) { 
        return fruitRepository.findFirstByFruitName(fruitName).get();
    }
        
    public List<FruitEntity> findThreeByName(String fruitName) { 
        return fruitRepository.findFirst3ByFruitName(fruitName);
    }
    
    /* ============= Demonstration #5 ============= */
    public List<FruitEntity> findStartsWith(String partOfFruitName) { 
        return fruitRepository.findByFruitNameIsStartingWith(partOfFruitName);
        //return fruitRepository.findByFruitNameStartingWith(partOfFruitName);
        //return fruitRepository.findByFruitNameStartsWith(partOfFruitName);     
        //return fruitRepository.findDistinctByFruitNameStartsWith(partOfFruitName);
        //return fruitRepository.findDistinctEntitiesByFruitNameStartsWith(partOfFruitName);
    }
    
    /* ============= Demonstration #6 ============= */
    public List<FruitEntity> findEntitiesGreaterThan(Integer n) { 
        return fruitRepository.findDistinctByProviderCodeIsGreaterThan(n);
        //return fruitRepository.findByproviderCodeIsGreaterThan(n);
    }
    
    /* ============= Demonstration #7 AND ============= */
    public List<FruitEntity> findStartingWithAndGreaterThan(String partOfFruitName, Integer n) { 
        return fruitRepository.findByFruitNameStartsWithAndProviderCodeIsGreaterThan(partOfFruitName, n);        
    }
    
    /* ============= Demonstration #8 OR ============= */
    public List<FruitEntity> findEndingWithOrLessThanEqual(String partOfFruitName, Integer n) { 
        return fruitRepository.findByFruitNameIsEndingWithOrProviderCodeLessThanEqual(partOfFruitName, n);        
    }

    /* ============= Demonstration #9 Iterable ============= */
    public List<FruitEntity> findByNames(Iterable names) { 
        return fruitRepository.findByFruitNameIn(names);        
    }
    
    /* ============= Demonstration #10 Pagination ============= */
    public Page<FruitEntity> findByName(String name, Pageable pageable) { 
        return fruitRepository.findByFruitName(name, pageable);        
    }
    
    /* ============= Demonstration #11 orderBy sort ============= */
    public List<FruitEntity> findByPartNameAndOrder(String partOfFruitName) { 
        //return fruitRepository.findByFruitNameContainingOrderByFruitNameAsc(partOfFruitName);
        //return fruitRepository.findByFruitNameContainingOrderByProviderCodeDesc(partOfFruitName);
        return fruitRepository.findByFruitNameContainingOrderByFruitNameAscProviderCodeDesc(partOfFruitName);
    }
    
    /* ============= Demonstration #12 class Sort ============= */
    public List<FruitEntity> findByPartNameAndOrder(String partOfFruitName, Sort sort) { 
        return fruitRepository.findByFruitNameContaining(partOfFruitName, sort);
    }
    
    /* ============= Demonstration #13 count ============= */
    public int countAllByName(String name) { 
        return fruitRepository.countAllByFruitName(name);
    }
    
    public int countAllBySubString(String partOfName) { 
        return fruitRepository.countDistinctByFruitNameContaining(partOfName);
    }
    
    /* ============= Demonstration #14 remove/delete ============= */  
    @Transactional
    public int deleteByName(String name) { 
        return fruitRepository.deleteByFruitName(name);
    }
    
    @Transactional
    public void deleteBySubString(String partOfName) { 
        fruitRepository.removeSomethingByFruitNameContaining(partOfName);
    }
    
}
