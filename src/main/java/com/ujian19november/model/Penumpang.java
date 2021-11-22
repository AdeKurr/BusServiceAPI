package com.ujian19november.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Penumpang")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Penumpang {
	@Id
	private String nik;
	private String nama;
	private String telepon;

}
