package com.example.deposito.controller;

import com.example.deposito.model.Deposito;
import com.example.deposito.model.JenisDeposito;
import com.example.deposito.repo.DepositoRepository;
import com.example.deposito.repo.JenisDepositoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DepositoController {

    @Autowired
    DepositoRepository depositoRepository;

    @GetMapping
    @ResponseBody
    public List<Deposito> getAllDeposito(){
        return this.depositoRepository.findAll();
    }

    @PostMapping
    @ResponseBody
//    TODO: check if deposit is greater or eq than minimum deposit in jenisDeposit
//    TODO: check if jenisDeposit is active
//    TODO: Move to service
    public String saveDeposito(@RequestBody Deposito deposito){
        this.depositoRepository.save(deposito);
        return "Berhasil menyimpan data deposito";
    }

    @PutMapping
    @ResponseBody
//    TODO: update deposito, getAllData from existing, check changes, update changed data.
//    TODO: Move to Service
//    TODO: not change tanggal masuk! Substract balance only if sudah lewat tanggal masuk+tenor,
//     or else dipotong dan masuk ke kas bank!
    public String updateDeposito(@RequestBody Deposito deposito){
        Optional<Deposito> dp = this.depositoRepository.findById(deposito.getId());
        this.depositoRepository.save(dp.get());
        return "Berhasil mengupdate data deposito";
    }

    @DeleteMapping
    @ResponseBody
    public String deleteDeposito(@RequestBody Deposito deposito){
        this.depositoRepository.deleteById(deposito.getId());
        return "berhasil menghapus deposito";
    }
}
