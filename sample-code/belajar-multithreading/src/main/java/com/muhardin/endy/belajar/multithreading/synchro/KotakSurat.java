package com.muhardin.endy.belajar.multithreading.synchro;

public class KotakSurat {
	
	private Integer jumlahSurat = 0;

	public void taruhSurat() {
		System.out.println("Tukang pos menaruh surat");
		jumlahSurat++;
	}

	public void ambilSurat(){
		System.out.println("Tuan rumah mengambil surat");
		jumlahSurat--;
	}

	public void tampilkanIsi(){
		System.out.println("Isi kotak : "+jumlahSurat);
	}

}