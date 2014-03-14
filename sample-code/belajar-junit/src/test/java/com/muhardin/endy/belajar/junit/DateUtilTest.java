package com.muhardin.endy.belajar.junit;

import org.junit.Test;
import static org.junit.Assert.*;

public class DateUtilTest {
    @Test
    public class testHitungHari(){
        DateUtil d = new DateUtil();
        
        // hasil yang diharapkan
        Integer hasilSeharusnya = 31;
        
        // hasil yang keluar
        Integer hasilAktual = d.hitungHari(2014,1);
        
        // suruh JUnit membandingkan
        assertEquals(hasilAktual, hasilSeharusnya);
    }
}
