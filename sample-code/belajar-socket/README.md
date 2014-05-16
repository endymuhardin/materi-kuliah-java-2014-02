# Contoh Kode Program Socket #

Aplikasi client-server sederhana melalui TCP/IP dengan Java.

## Cara Menjalankan ##

* Aplikasi Server : `mvn clean package exec:java -Dexec.mainClass=com.muhardin.endy.belajar.socket.ServerDemo`
* Aplikasi Client : `mvn exec:java -Dexec.mainClass=com.muhardin.endy.belajar.socket.ClientDemo`
* Terima File : `mvn clean package exec:java -Dexec.mainClass=com.muhardin.endy.belajar.socket.TerimaFile`
* Kirim File : `mvn exec:java -Dexec.mainClass=com.muhardin.endy.belajar.socket.KirimFile`