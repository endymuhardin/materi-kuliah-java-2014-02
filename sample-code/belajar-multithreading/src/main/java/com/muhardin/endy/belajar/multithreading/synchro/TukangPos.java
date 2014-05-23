package com.muhardin.endy.belajar.multithreading.synchro;

public class TukangPos {
	private KotakSurat kotakSurat;

	public TukangPos(KotakSurat k){
		this.kotakSurat = k;
	}

	public void taruh(){
		kotakSurat.taruhSurat();
	}

	public void lihat(){
		kotakSurat.tampilkanIsi();
	}
}