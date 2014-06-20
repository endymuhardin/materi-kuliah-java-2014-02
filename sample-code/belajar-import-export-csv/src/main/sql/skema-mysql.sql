create table mahasiswa(
	id INT AUTO_INCREMENT,
	npm VARCHAR(20) NOT NULL,
	nama VARCHAR(255) NOT NULL,
	email VARCHAR(255) NOT NULL,
	tanggal_lahir DATE NOT NULL,
	tahun_masuk INT NOT NULL,
	PRIMARY KEY ("id"),
	UNIQUE KEY "npm_unik" ("npm"),
	UNIQUE KEY "email_unik" ("email")
);