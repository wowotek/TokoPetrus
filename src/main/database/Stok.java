package main.database;

import java.util.ArrayList;

public class Stok implements StokTemplate<Barang, String>{
    private final ArrayList<Barang> stok;                                       // List untuk database stock
    
    public Stok(){
        this.stok = new ArrayList<>();
    }

    @Override
    public boolean tambahBarangBaru(Barang barang) {
        for(Barang i: this.stok){                                               // Cek jika barang sudah ada
            if(i.getKodeBarang().equals(barang.getNamaBarang())){
                return false;                                                   // penambahan gagal karena Barang sudah ada
            }
        }
        
        this.stok.add(barang);
        return true;                                                            // Penambahan barang berhasil
    }

    @Override
    public Barang DetailDataBarang(String kodeBarang) {
        for(Barang i: this.stok){
            if(i.getKodeBarang().equals(kodeBarang))
                return i;                                                       // barang ditemukan dan mengembalikan data barang
        }
        return null;
    }

    @Override
    public ArrayList<Barang> getDataStok() {
        return this.stok;
    }
    
    @Override
    public boolean restokBarang(String kodeBarang, int jumlah) {
        for(int i=0; i<this.stok.size(); i++){
            Barang ix = this.stok.get(i);
            if(ix.getKodeBarang().equals(kodeBarang)){
                this.stok.set(i, new Barang(
                        ix.getKodeBarang(), ix.getNamaBarang(),
                        ix.getHargaBarang(), ix.getStok() + jumlah));
                
                return true;                                                    // barang berhasil di restok
            }
        }
        
        return false;                                                           // barang tidak di temukan
    }

    @Override
    public int ambilBarang(String kodeBarang, int jumlah) {
        for(int i=0; i<this.stok.size(); i++){
            Barang ix = this.stok.get(i);
            if(ix.getKodeBarang().equals(kodeBarang)){
                if(ix.getStok() > 0){
                    this.stok.set(i, new Barang(
                            ix.getKodeBarang(), ix.getNamaBarang(),
                            ix.getHargaBarang(), ix.getStok() - jumlah));

                    return 1;                                                   // stok barang berhasil dikurangi
                } else {
                    return -1;                                                  // stok barang habis
                }
            } 
        }
        
        return 0;                                                               // barang yang ingin di ambil tidak ditemukan
    }

    @Override
    public boolean singkirkanBarang(String kodeBarang) {
        for(int i=0; i<this.stok.size(); i++){
            Barang ix = this.stok.get(i);
            if(ix.getKodeBarang().equals(kodeBarang)){
                this.stok.remove(i);
                return true;                                                    // Barang berhasil di singkirkan
            }
        }
        
        return false;                                                           // Barang tidak ditemukan
    }

    
}