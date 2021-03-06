package com.ujian19november.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Keberangkatan")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Keberangkatan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int harga;
	private String kelas;
	private String tanggal;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_jurusan", referencedColumnName = "id")
	private Jurusan id_jurusan;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "no_polisi", referencedColumnName = "nomor_polisi")
	private Bus no_polisi;

}
