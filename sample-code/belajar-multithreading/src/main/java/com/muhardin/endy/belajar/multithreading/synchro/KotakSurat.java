package com.muhardin.endy.belajar.multithreading.synchro;

public class KotakSurat {
	
	private Integer jumlahSurat = 0;
	private Boolean kosong = true;

	public synchronized void taruhSurat() {
		try {
			while(!kosong){
				System.out.println("Masih ada isinya, tunggu kosong dulu");
				wait();
			}

			System.out.println("Tukang pos menaruh surat");
			jumlahSurat++;
			kosong = false;
			notifyAll();
		} catch (Exception err){
			err.printStackTrace();
		} 
	}

	public synchronized void ambilSurat(){
		try {
			while(kosong){
				System.out.println("Belum ada isinya, tunggu diisi dulu");
				wait();
			}

			System.out.println("Tuan rumah mengambil surat");
			jumlahSurat--;
			kosong = true;
			notifyAll();
		} catch (Exception err){
			err.printStackTrace();
		} 
	}

	public void tampilkanIsi(){
		System.out.println("Isi kotak : "+jumlahSurat);
	}

}