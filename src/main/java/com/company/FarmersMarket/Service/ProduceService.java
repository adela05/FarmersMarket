package com.company.FarmersMarket.Service;

import com.company.FarmersMarket.Dao.ProduceRepository;
import com.company.FarmersMarket.Dto.Produce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProduceService {
    @Autowired
    private ProduceRepository produceRepo;

    // Adding a produce to the array-- POST
    public Produce addProduce(Produce produce){
        produceRepo.save(produce);
        return produce;
    }
    // Update a produce to the array --PUT
    public Produce updateProduce(Produce produce, Integer id){
        if (produce.getId() == id){
            produceRepo.save(produce);
        }
        return null;
    }
    // Search for all produce --GET
    public List<Produce> getAllProduce(){
        return produceRepo.findAll();
    }
    // Delete individual item --DELETE
    public Integer deleteProduce(Integer id){
        produceRepo.deleteById(id);
        return null;
    }
    // Search produce by Id
    public Produce getProduceById(Integer id){
        return produceRepo.getOne(id);
    }
    // Purchasing produce in cart
    public void purchase(Produce[] produce){
        for(Produce p: produce){
            Produce currProduce= this.getProduceById(p.getId());

            currProduce.setQuantity(currProduce.getQuantity()- p.getQuantity());
            this.updateProduce(currProduce, currProduce.getId());
        }
    }
}
