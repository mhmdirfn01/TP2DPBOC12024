# TP2DPBOC12024
# Saya Muhamad Irfan 2201897 berjanji mengerjakan TP2 dengan jujur, atas keberkahannya saya berjanji tidak melakukan kecurangan seperti yang dispesifikasikan.

Deskripsi Alur Kode, Desain, dan Penggunaan Aplikasi Manajemen Data Mahasiswa
1. Pendahuluan
Aplikasi Manajemen Data Mahasiswa adalah program sederhana yang dibangun menggunakan Java dengan antarmuka pengguna berbasis Java Swing. Aplikasi ini memungkinkan pengguna untuk melakukan operasi dasar seperti menambahkan, mengedit, dan menghapus data mahasiswa dari database.

2. Alur Kode
Impor Paket Java Swing: Paket Java Swing diimpor untuk memungkinkan penggunaan komponen GUI seperti tombol, label, dan tabel.

Deklarasi Variabel: Variabel dideklarasikan untuk menyimpan data mahasiswa, mengelola koneksi database, dan mengatur komponen GUI.

Konstruktor Menu: Konstruktor digunakan untuk menginisialisasi objek Menu. Di dalam konstruktor, tata letak disusun, komponen GUI diinisialisasi, dan perilaku tombol ditambahkan.

Metode setTable(): Metode ini digunakan untuk mendefinisikan model tabel yang menampilkan data mahasiswa dari database.

Metode insertData(): Menangani operasi penambahan data mahasiswa ke dalam database. Program memeriksa apakah ada input yang kosong dan apakah NIM sudah ada dalam database untuk menghindari duplikasi.

Metode updateData(): Memperbarui data mahasiswa dalam database. Program memeriksa apakah ada input yang kosong sebelum melakukan pembaruan.

Metode deleteData(): Menghapus data mahasiswa dari database. Program menampilkan dialog konfirmasi sebelum menghapus data.

Metode clearForm(): Membersihkan formulir setelah operasi selesai atau ketika tombol "Cancel" ditekan.

Metode populateList(): Mengisi daftar mahasiswa dengan data dummy untuk pengujian dan demonstrasi.

Metode main(): Titik masuk utama program. Di sini, objek Menu dibuat dan ditampilkan kepada pengguna.

3. Desain Aplikasi
Antarmuka Pengguna (UI): Desain antarmuka pengguna sederhana namun informatif. Komponen-komponen GUI ditempatkan secara logis untuk memudahkan pengguna dalam melakukan operasi.

Database Structure: Aplikasi ini menggunakan tabel mahasiswa dalam database untuk menyimpan data mahasiswa. Struktur tabel minimalnya mencakup kolom nim, nama, jenis_kelamin, dan email.

Responsiveness: Antarmuka pengguna dirancang agar responsif dan mudah digunakan. Tombol dan field-form disusun dengan baik untuk memfasilitasi operasi CRUD.

4. Penggunaan Aplikasi
Tambah Data: Pengguna dapat menambahkan data mahasiswa baru dengan mengisi formulir dan menekan tombol "Add".

Edit Data: Data mahasiswa dapat diedit dengan memilih baris yang diinginkan dari tabel, mengedit informasi yang diperlukan, dan menekan tombol "Update".

Hapus Data: Data mahasiswa dapat dihapus dengan memilih baris yang diinginkan dari tabel, lalu menekan tombol "Delete" setelah dialog konfirmasi muncul.

Batal: Jika pengguna ingin membatalkan operasi, mereka dapat menekan tombol "Cancel" untuk membersihkan formulir.

5. Persyaratan
Java Runtime Environment (JRE) harus terinstal di komputer pengguna.
Aplikasi ini memerlukan koneksi database yang sudah dikonfigurasi dengan benar untuk menyimpan dan mengelola data mahasiswa.



# DOKUMENTASI HASIL COMPILE
![Screenshot 2024-03-24 221033](https://github.com/mhmdirfn01/TP2DPBOC12024/assets/145920545/5ece180a-51c4-4c1c-8504-20f77e713af0)
![Screenshot 2024-03-24 221051](https://github.com/mhmdirfn01/TP2DPBOC12024/assets/145920545/46cab272-f112-48f8-bd78-bf58ec1cd3b0)
![Screenshot 2024-03-24 221132](https://github.com/mhmdirfn01/TP2DPBOC12024/assets/145920545/f5a94db6-d37d-4b83-ac9b-78c375827cb4)
![Screenshot 2024-03-24 221136](https://github.com/mhmdirfn01/TP2DPBOC12024/assets/145920545/1337a7bb-1ee9-4aea-95e9-2eab7306c7bc)
![Screenshot 2024-03-24 221153](https://github.com/mhmdirfn01/TP2DPBOC12024/assets/145920545/d8161717-9e57-44f1-b364-becfbd2b3e74)
![Screenshot 2024-03-24 221157](https://github.com/mhmdirfn01/TP2DPBOC12024/assets/145920545/dfb6f6b0-8b08-4935-83c4-8bc709cb38c1)
![Screenshot 2024-03-24 221222](https://github.com/mhmdirfn01/TP2DPBOC12024/assets/145920545/d8a1a0d5-d5a0-4e6a-9d0e-fd91604d9feb)
![Screenshot 2024-03-24 221227](https://github.com/mhmdirfn01/TP2DPBOC12024/assets/145920545/65648f53-6a14-40b4-8020-bd473b6f7538)

