package com.muhardin.endy.belajar.multithreading.synchro;

import java.util.Random;

public class SyncDemo {
	public static void main(String[] x){
		KotakSurat ks = new KotakSurat();
		TukangPos tp = new TukangPos(ks);
		TuanRumah tr = new TuanRumah(ks);

		// buat threadnya kemudian jalankan
		new ThreadTukangPos(tp).start();
		new ThreadTuanRumah(tr).start();
	}
}