package main;

import main.database.Barang;
import main.database.Riwayat;
import main.database.Stok;

public class Toko {
    Stok gudangToko;
    Riwayat riwayatKeuanganToko;
    
    public Toko(){
        this.gudangToko = new Stok();
        this.riwayatKeuanganToko = new Riwayat();
    }
    
    public void lihatPersediaanBarang(){
        int iteration = 0;
        
        for(Barang i: this.gudangToko.getDataStok()){
            System.out.println("Barang Ke-"  + (iteration+1) + " : ");
            System.out.println("    Kode : " + i.getKodeBarang());
            System.out.println("    Nama : " + i.getNamaBarang());
        }
    }
    
    public void beliBarang(String kodeBarang, int jumlah){
        Barang detailBarang = this.gudangToko.detailDataBarang(kodeBarang);
        if(detailBarang != null){
            this.gudangToko.ambilBarang(kodeBarang, jumlah);
            this.riwayatKeuanganToko.addRiwayat(detailBarang, jumlah);          // Ter Register sebagai pemasukan
            System.out.println();
        } else {
            System.out.println("Pembelian Barang Gagal, barang habis, atau tidak ditemukan");
        }
    }
    
    public void restokBarang(String kodeBarang, int jumlah){
        if(!this.gudangToko.restokBarang(kodeBarang, jumlah)){
            System.out.println("Restok barang gagal, barang tidak ter-register");
        } else {
            System.out.println("Restok berhasil");
            Barang barang = this.gudangToko.detailDataBarang(kodeBarang);
            this.riwayatKeuanganToko.addRiwayat(barang, -jumlah);               // Ter register sebagai pengeluaran
        }
    }
    
    public void registerBarangBaru(Barang barang){
        System.out.println("Barang baru ter register");
        this.riwayatKeuanganToko.addRiwayat(barang, -barang.getStok());
    }
    
    public void lihatRiwayat(){
        this.riwayatKeuanganToko.lihatRiwayat();
    }
}
