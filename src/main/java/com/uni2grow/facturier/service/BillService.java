package com.uni2grow.facturier.service;

import com.uni2grow.facturier.dto.BillDto;
import com.uni2grow.facturier.model.Adress;
import com.uni2grow.facturier.model.Bill;
import com.uni2grow.facturier.repository.BillRepository;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class BillService {
    @Autowired
    private BillRepository billRepository;

   ModelMapper modelMapper = new ModelMapper();

    public BillDto getBillById(final Long idFacture) {
      Optional<Bill> bill = billRepository.findById(idFacture);
      BillDto billDto = modelMapper.map(bill, BillDto.class);
      return billDto;
    }

//    public Optional<Bill> getBillsById(final Long idAdresse){
//        return billRepository.findById(idAdresse);
//    }
    public BillDto getBills(){
       Iterable<Bill> bill = billRepository.findAll();
       BillDto billDto = modelMapper.map(bill, BillDto.class);
       return billDto;
    }


    public void deleteBill(final Long idFacture) {
        billRepository.deleteById(idFacture);
    }

    public Bill saveBill(Bill bill) {
        Bill savedFacture = billRepository.save(bill);
        return savedFacture;
    }
}
