package com.muhardin.endy.belajar.multithreading.synchro;

import java.util.Random;

public class ThreadTukangPos extends Thread {
	private TukangPos tukangPos;
	public ThreadTukangPos(TukangPos t){
		this.tukangPos = t;
	}

	@Override
	public void run(){
		Random r = new Random();
		// ulangi 10 kali
		int ulangi = 10;
		for(int i=0; i<ulangi; i++){
			tukangPos.taruh();
			tukangPos.lihat();

			try {
				// delay 1-10 detik
				Thread.sleep(r.nextInt(10) * 1000);	
			} catch (Exception err){
				err.printStackTrace();
			}
			
		}
	}
}