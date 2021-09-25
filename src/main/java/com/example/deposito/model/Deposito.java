package com.example.deposito.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Deposito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long nomorRekening;
    private long deposit;
    private Date tanggalMasuk;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "id_jenis_deposito", nullable = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="idJenisDeposito")
//    @JsonIdentityReference(alwaysAsId=true)
//    @JsonProperty("id_jenis_deposito")
//    private JenisDeposito jenisDeposito;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private JenisDeposito jenisDeposito;

}
