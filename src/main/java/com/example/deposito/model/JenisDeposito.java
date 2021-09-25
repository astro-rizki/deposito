package com.example.deposito.model;

import lombok.Data;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class JenisDeposito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idJenisDeposito;
    private String namaDeposito;
    private String status;
    private long minimumDeposit;
    private int tenor;
    private double bunga;
//    @OneToMany(mappedBy = "jenisDeposito")
//    private List<Deposito> depositos;

}
