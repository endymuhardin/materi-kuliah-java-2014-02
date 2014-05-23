package com.muhardin.endy.belajar.multithreading;

public class DoubleThreadDemo {
	
	public static void main(String[] xx){
		System.out.println("Baris pertama");
		System.out.println("Baris kedua");

		new Thread(new Runnable(){
			public void run(){
				System.out.println("Baris ketiga");
				System.out.println("Baris keempat");
				System.out.println("Baris kelima");
			}
		}).start();
		
		System.out.println("Baris keenam");
		System.out.println("Baris ketujuh");
		System.out.println("Baris kedelapan");
	}

}