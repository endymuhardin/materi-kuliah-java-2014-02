package com.muhardin.endy.belajar.multithreading.synchro;

import java.util.Random;

public class ThreadTuanRumah extends Thread {
	private TuanRumah tuanRumah;
	public ThreadTuanRumah(TuanRumah t){
		this.tuanRumah = t;
	}

	@Override
	public void run(){
		Random r = new Random();
		// ulangi 10 kali
		int ulangi = 10;
		for(int i=0; i<ulangi; i++){
			tuanRumah.ambil();
			tuanRumah.lihat();

			try {
				// delay 1-10 detik
				Thread.sleep(r.nextInt(10) * 1000);	
			} catch (Exception err){
				err.printStackTrace();
			}
		}
	}
}