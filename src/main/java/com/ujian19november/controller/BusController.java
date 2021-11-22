package com.ujian19november.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ujian19november.model.Booking;
import com.ujian19november.model.Penumpang;
import com.ujian19november.model.TerminalAndTanggal;
import com.ujian19november.repository.BookingRepository;
import com.ujian19november.repository.PenumpangRepository;

@RestController
@RequestMapping("/busbookingsystem")
public class BusController {
	@Autowired
	PenumpangRepository penumpangRepo;


	@Autowired
	BookingRepository bookingRepo;

	@PostMapping("/insertPenumpang")
	public String insertPenumpang(@RequestBody Penumpang penumpang) {
		penumpangRepo.save(penumpang);
		return "Data penumpang berhasil ditambahkan";
	}

	@GetMapping("/getPenumpang/{nik}")
	public String getPenumpang(@PathVariable(value = "nik") String nik) {
		List<Penumpang> hasil = penumpangRepo.findByNik(nik);
		if (hasil.size() == 0) {
			return "Penumpang belum terdaftar, silakan buat akun.";
		} else {
			return "Penumpang telah terdaftar";
		}
	}

	@GetMapping("/findKeberangkatan")
	public List<TerminalAndTanggal> findKeberangkatan(@RequestParam(value = "terminal") String terminal_awal,
			@RequestParam(value = "tanggal") String tanggal) {
		return penumpangRepo.findByTerminalAndTanggal(terminal_awal, tanggal);

	}

	@PostMapping("/booking")
	public String booking(@RequestBody Booking booking) {
		bookingRepo.save(booking);
		return "Pemesanan bus berhasil";
	}

	@DeleteMapping("/cancel")
	public String cancel(@RequestParam(value = "id") long id) {
		bookingRepo.deleteById(id);
		return "Pemesanan dengan nomor id " + id + " telah dibatalkan";

	}
	
}
