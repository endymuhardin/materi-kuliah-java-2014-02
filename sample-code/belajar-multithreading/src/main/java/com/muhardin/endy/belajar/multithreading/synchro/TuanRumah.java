package com.muhardin.endy.belajar.multithreading.synchro;

public class TuanRumah {
	private KotakSurat kotakSurat;

	public TuanRumah(KotakSurat k){
		this.kotakSurat = k;
	}

	public void ambil(){
		kotakSurat.ambilSurat();
	}

	public void lihat(){
		kotakSurat.tampilkanIsi();
	}
}