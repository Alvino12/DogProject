package com.example.Doc.Dog;

import com.example.Doc.Dog.Exception.DogNotFound;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DogService {


    private final DogRepository dogRepository;


   public DogService(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public List<DogModel> getDog(){
        return  dogRepository.findAll();
    }

    public DogModel getDogByID(Long id){
       DogModel dog= dogRepository.findById(id).orElseThrow(() ->new DogNotFound("Dog not found"));
       return dog;
    }

    public void addNewDog(DogModel dogModel){
        dogRepository.save(dogModel);
    }

    public void deleteDog(Long dogID){
        boolean exist=dogRepository.existsById(dogID);
        if(!exist){
            throw new DogNotFound("Dog not found");
        }
        dogRepository.deleteById(dogID);

    }

    public void updateDog(DogModel dogModel,Long DogID){


        DogModel dogModel1 = dogRepository.findById(DogID).orElseThrow(() ->new DogNotFound("Dog not found"));

        if(dogModel.getNome()!= null && !Objects.equals(dogModel1.getNome(),dogModel.getNome())){
            dogModel1.setNome(dogModel.getNome());
        }

        if(dogModel.getOrigem()!= null && !Objects.equals(dogModel1.getOrigem(),dogModel.getOrigem())){
            dogModel1.setOrigem(dogModel.getOrigem());
        }

        if(dogModel.getIdade()!= null && !Objects.equals(dogModel1.getIdade(),dogModel.getIdade())){
            dogModel1.setIdade(dogModel.getIdade());
        }
        dogRepository.save(dogModel1);
    }



}
