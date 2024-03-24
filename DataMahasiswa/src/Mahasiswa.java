public class Mahasiswa {
    private String nim;
    private String nama;
    private String jenisKelamin;
    private String email;

    public Mahasiswa(String nim, String nama, String jenisKelamin, String email) {
        this.nim = nim;
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.email = email;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getNim() {
        return this.nim;
    }

    public String getNama() {
        return this.nama;
    }

    public String getEmail() {
        return this.email;
    }

    public String getJenisKelamin() {
        return this.jenisKelamin;
    }
}