package main;

import main.database.Barang;
import main.database.Riwayat;
import main.database.Stok;

public class Toko {
    private Stok gudangToko;
    private Riwayat riwayatKeuanganToko;
    
    public Toko(){
        this.gudangToko = new Stok();
        this.riwayatKeuanganToko = new Riwayat();
    }
    
    public void lihatPersediaanBarang(){
        this.gudangToko.lihatSemuaBarang();
    }
    
    public void beliBarang(String kodeBarang, int jumlah){
        Barang detailBarang = this.gudangToko.detailDataBarang(kodeBarang);
        
        if(detailBarang != null){
            if(jumlah <= detailBarang.getStok()){
                this.gudangToko.ambilBarang(kodeBarang, jumlah);
                this.riwayatKeuanganToko.addRiwayatPembelian(detailBarang, jumlah);          // Ter Register sebagai pemasukan
                System.out.println("Pembelian Barang Berhasil !");
            } else {
                System.out.println("Pembelian Barang Gagal, Barang Habis");
            }
        } else {
            System.out.println("Pembelian Barang Gagal, tidak ditemukan");
        }
    }
    
    public void restokBarang(String kodeBarang, int jumlah){
        if(!this.gudangToko.restokBarang(kodeBarang, jumlah)){
            System.out.println("Restok barang gagal, barang tidak ter-register");
        } else {
            System.out.println("Restok berhasil");
            Barang barang = this.gudangToko.detailDataBarang(kodeBarang);
            this.gudangToko.restokBarang(kodeBarang, jumlah);
            this.riwayatKeuanganToko.addRiwayatModal(barang, jumlah);                // Ter register sebagai pengeluaran
        }
    }
    
    public void buangBarang(String kodeBarang){
        Barang barang = this.gudangToko.detailDataBarang(kodeBarang);
        if(this.gudangToko.singkirkanBarang(kodeBarang)){
            System.out.println("Barang berhasil di buang!");
            this.riwayatKeuanganToko.addRiwayatModal(barang, barang.getStok());
        } else {
            System.out.println("Barang gagal di buang !");
        }
    }
    
    public void buangBarang(String kodeBarang, int jumlah){
        Barang barang = this.gudangToko.detailDataBarang(kodeBarang);
        if(this.gudangToko.singkirkanBarang(kodeBarang, jumlah)){
            System.out.println("Barang berhasil di buang!");
            this.riwayatKeuanganToko.addRiwayatModal(barang, jumlah);
        } else {
            System.out.println("Barang gagal di buang !");
        }
    }
    
    public void registerBarangBaru(Barang barang){
        System.out.println("Registrasi Barang berhasil !");
        this.gudangToko.restokBarang(barang);
        this.riwayatKeuanganToko.addRiwayatModal(barang, barang.getStok());
    }
    
    public void lihatRiwayat(){
        this.riwayatKeuanganToko.lihatRiwayat();
    }
    
    public Stok getGudangToko(){
        return this.gudangToko;
    }
}
