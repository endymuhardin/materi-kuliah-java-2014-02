package com.muhardin.endy.belajar.junit;

public class DateUtil {
    public Integer hitungHari(Integer tahun, Integer bulan){
        switch(bulan){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12: return 31;
            case 4:
            case 6:
            case 9:
            case 11: return 30;
            default: throw new IllegalArgumentException("Bulan harus di antara 1 - 12");
        }
    }
}
