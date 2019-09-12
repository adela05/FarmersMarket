package com.company.FarmersMarket.Controller;

import com.company.FarmersMarket.Dto.Produce;
import com.company.FarmersMarket.Service.ProduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")  // Adding the Angular api so Java can communicate with frontend.
@RestController
public class ProduceController {
    @Autowired
    private ProduceService prodService;

    // GET
    @RequestMapping(value = "/produce", method = RequestMethod.GET)
    public List<Produce> getProduce(){
        return prodService.getAllProduce();
    }
    // POST
    @RequestMapping(value = "/produce", method = RequestMethod.POST)
    public Produce addProduce(@RequestBody @Valid Produce produce){
        prodService.addProduce(produce);
        return produce;
    }
    // PUT
    @RequestMapping(value = "/produce/{id}", method = RequestMethod.PUT)
    public Produce updateProduce(@RequestBody @Valid Produce produce, @PathVariable Integer id){
        return prodService.updateProduce(produce, id);
    }
    // DELETE
    @RequestMapping(value = "/produce/{id}", method = RequestMethod.DELETE)
    public Integer deleteProduce(@PathVariable Integer id){
        return prodService.deleteProduce(id);
    }
    // POST -- purchasing
    @RequestMapping(value = "/purchase", method = RequestMethod.POST)
    public void purchase(@RequestBody @Valid Produce[] produce){
        prodService.purchase(produce);
    }
}
