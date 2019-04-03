package main.database;

public class Barang {
    private final String KODEBARANG;
    private final String NAMABARANG;
    private int hargaBarang;
    private int stok;
    
    Barang(String kodeBarang, String namaBarang, int hargaBarang, int stokAwal){
        this.KODEBARANG = kodeBarang;
        this.NAMABARANG = namaBarang;
        this.hargaBarang = hargaBarang;
        this.stok = stokAwal;
    }
    
    Barang(String kodeBarang, String namaBarang, int hargaBarang){
        this.KODEBARANG = kodeBarang;
        this.NAMABARANG = namaBarang;
        this.hargaBarang = hargaBarang;
        this.stok = 1;
    }

    public String getKodeBarang() {
        return KODEBARANG;
    }

    public String getNamaBarang() {
        return NAMABARANG;
    }

    public int getHargaBarang() {
        return hargaBarang;
    }

    public int getStok() {
        return stok;
    }

    public void setHargaBarang(int hargaBarang) {
        this.hargaBarang = hargaBarang;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
}
