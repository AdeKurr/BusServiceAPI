package com.ujian19november.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Jurusan")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Jurusan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	private String deskripsi;
	private String terminal_awal;
	private String terminal_akhir;

}
