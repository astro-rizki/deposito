package com.example.deposito.controller;

import com.example.deposito.model.JenisDeposito;
import com.example.deposito.repo.JenisDepositoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jenis")
public class JenisDepositoController {

    @Autowired
    JenisDepositoRepo jenisDepositoRepo;

    @GetMapping
    @ResponseBody
    public List<JenisDeposito> getAllJenisDeposito(){
        return this.jenisDepositoRepo.findAll();
    }

    @PostMapping
    @ResponseBody
    public String saveJenisDeposito(@RequestBody JenisDeposito jenisDeposito){
        this.jenisDepositoRepo.save(jenisDeposito);
        return "Berhasil menyimpan jenis deposito";
    }

    @PutMapping
    @ResponseBody
//    TODO: getAllData from existing, check changes, update changed data.
//     move to service!
    public String updateJenisDeposito(@RequestBody JenisDeposito jenisDeposito){
        Optional<JenisDeposito> jd = this.jenisDepositoRepo.findById(jenisDeposito.getIdJenisDeposito());
        this.jenisDepositoRepo.save(jd.get());
        return "Berhasil mengupdate jenis Deposito";
    }

    @DeleteMapping
    @ResponseBody
//    TODO: hapus kalau sudah gaada depositonya, cek dulu!
    public String deleteJenisDeposito(@RequestBody JenisDeposito jenisDeposito){
        Optional<JenisDeposito> jd = this.jenisDepositoRepo.findById(jenisDeposito.getIdJenisDeposito());
        this.jenisDepositoRepo.delete(jd.get());
        return "Berhasil menghapus jenis deposito "+jd.get().getNamaDeposito();
    }

}
