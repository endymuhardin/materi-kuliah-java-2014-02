package com.muhardin.endy.belajar.junit;

import org.junit.Test;
import static org.junit.Assert.*;

public class DateUtilTest {
    @Test
    public void testHitungHari31(){
        DateUtil d = new DateUtil();
        
        // hasil yang diharapkan
        Integer hasilSeharusnya = 31;
        
        // hasil yang keluar
        Integer hasilAktual = d.hitungHari(2014,1);
        
        // suruh JUnit membandingkan
        assertEquals(hasilSeharusnya, hasilAktual);
    }
    
    @Test
    public void testHitungHari30(){
        DateUtil d = new DateUtil();
        
        // hasil yang diharapkan
        Integer hasilSeharusnya = 30;
        
        // hasil yang keluar
        Integer hasilAktual = d.hitungHari(2014,4);
        
        // suruh JUnit membandingkan
        assertEquals(hasilSeharusnya, hasilAktual);
    }
}
