package main.database;

import java.util.ArrayList;

public class Riwayat {
    private final ArrayList<String>  riwayatPembelianNama;
    private final ArrayList<Integer> riwayatPembelianJumlah;
    private final ArrayList<Integer> riwayatPembelianHarga;
    
    public Riwayat(){
        this.riwayatPembelianNama   = new ArrayList<>();
        this.riwayatPembelianJumlah = new ArrayList<>();
        this.riwayatPembelianHarga  = new ArrayList<>();
    }
    
    public void addRiwayat(Barang barang, int jumlahBarang){
        this.riwayatPembelianNama.add(barang.getNamaBarang());
        this.riwayatPembelianJumlah.add(jumlahBarang);
        this.riwayatPembelianHarga.add(barang.getHargaBarang());
    }
    
    public void lihatRiwayat(){
        int namaTerpanjang = 0;
        int jumlahTerpanjang = 0;
        
        // cek nama terpanjang
        for(String i: this.riwayatPembelianNama){
            if(i.length() >= namaTerpanjang){
                namaTerpanjang = i.length();
            }
        }
        
        // cek jumlah Terpanjang
        for(int i: this.riwayatPembelianJumlah){
            if(Integer.toString(i).length() >= jumlahTerpanjang){
                jumlahTerpanjang = Integer.toString(i).length();
            }
        }
        
        // menambahkan Offset
        jumlahTerpanjang += 5;
        namaTerpanjang += 6;
        
        // Print riwayat
        for(int i=0; i<this.riwayatPembelianNama.size(); i++){
            String nama = this.riwayatPembelianNama.get(i);
            String harga = Integer.toString(this.riwayatPembelianHarga.get(i));
            String jumlah = Integer.toString(this.riwayatPembelianHarga.get(i));
            
            System.out.print(nama);
            for(int j=0; j<namaTerpanjang - nama.length(); j++){
                System.out.print(" ");
            }
            
            System.out.print(jumlah + "x");
            for(int j=0; j<jumlahTerpanjang - jumlah.length(); j++){
                System.out.print(" ");
            }
            
            System.out.println("Rp " + harga + ",-");
        }
    }
}
