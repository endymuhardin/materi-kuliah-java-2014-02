package com.muhardin.endy.belajar.threeten;

import org.threeten.bp.*;
import org.threeten.bp.temporal.*;
import org.threeten.bp.format.*;
import org.threeten.bp.chrono.*;

import java.util.Locale;

public class App {
    public static void main( String[] args ) {
    	Instant a = Instant.now();
        System.out.println( "Waktu saat ini : " +a);

        // Waktu Indonesia Barat
        ZonedDateTime waktuLokal = a.atZone(ZoneId.of("GMT+7"));
        System.out.println( "Waktu lokal : " +waktuLokal);

        // Format
        String format = "EEEE, dd MMMM yyyy";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        String hasilFormat = formatter.format(waktuLokal);
        System.out.println("Hasil Format : "+hasilFormat);

        // Locale Indonesia
        Locale indonesia = new Locale("ID");
        DateTimeFormatter formatterIndonesia
        	= formatter.withLocale(indonesia);
       	String hasilFormatIndonesia = formatterIndonesia.format(waktuLokal);
        System.out.println("Hasil Format Indonesia: "+hasilFormatIndonesia);

        // Parsing
        String strWaktu = "15 Juni 2012";
        DateTimeFormatter parser
        	= DateTimeFormatter
        	.ofPattern("dd MMMM yyyy")
        	.withLocale(indonesia);

       	LocalDate waktu = LocalDate.parse(strWaktu, parser);
       	System.out.println("Hasil parsing : "+waktu+", hari "+waktu.getDayOfWeek());

       	// Hitung selisih hari
       	ChronoPeriod selisih = waktu.until(LocalDate.from(waktuLokal));
       	System.out.println("Jumlah hari : "+selisih.get(ChronoUnit.DAYS));
    }
}
