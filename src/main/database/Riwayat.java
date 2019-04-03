package main.database;

import java.util.ArrayList;

public class Riwayat {
    private final ArrayList<String>  riwayatPembelianNama;
    private final ArrayList<Integer> riwayatPembelianJumlah;
    private final ArrayList<Integer> riwayatPembelianHarga;
    private final ArrayList<String>  riwayatTipePembelian;
    
    public Riwayat(){
        this.riwayatPembelianNama   = new ArrayList<>();
        this.riwayatPembelianJumlah = new ArrayList<>();
        this.riwayatPembelianHarga  = new ArrayList<>();
        this.riwayatTipePembelian   = new ArrayList<>();
    }
    
    public void addRiwayatPembelian(Barang barang, int jumlahBarang){
        this.riwayatPembelianNama   .add(barang.getNamaBarang());
        this.riwayatPembelianJumlah .add(jumlahBarang);
        this.riwayatPembelianHarga  .add(barang.getHargaBarang());
        this.riwayatTipePembelian   .add("Penjualan");
    }
    
    public void addRiwayatModal(Barang barang, int jumlahBarang){
        this.riwayatPembelianNama   .add(barang.getNamaBarang());
        this.riwayatPembelianJumlah .add(jumlahBarang);
        this.riwayatPembelianHarga  .add(-barang.getHargaBarang());
        this.riwayatTipePembelian   .add("Belanja Modal");
    }
    
    public void lihatRiwayat(){
        int namaTerpanjang = 0;
        int jumlahTerpanjang = 0;
        int hargaTerpanjang = 0;
        
        // Mencari jumlah karakter terpanjang
        for(int i=0; i<this.riwayatPembelianNama.size(); i++){
            String rpn = this.riwayatPembelianNama.get(i);
            String rpj = Integer.toString(this.riwayatPembelianJumlah.get(i));
            String rph = Integer.toString(this.riwayatPembelianHarga.get(i));
            
            if(rpn.length() >= namaTerpanjang)
                namaTerpanjang = rpn.length();
            if(rpj.length() >= jumlahTerpanjang)
                jumlahTerpanjang = rpj.length();
            if(rph.length() >= hargaTerpanjang)
                hargaTerpanjang = rph.length();
        }
        
        // menambahkan Offset
        namaTerpanjang += 2;
        jumlahTerpanjang += 6;
        hargaTerpanjang += 5;
        
        // Print riwayat
        System.out.print("|");
        for(int i=0; i<namaTerpanjang + jumlahTerpanjang + hargaTerpanjang + 38; i++){
            System.out.print("-");
        }
        System.out.println("|");
        
        System.out.print("|   Nama");
        for(int i=0; i<namaTerpanjang - "Nama".length(); i++){
            System.out.print(" ");
        }
        System.out.print(" |   Jumlah");
        for(int i=0; i<jumlahTerpanjang - "Jumlah".length(); i++){
            System.out.print(" ");
        }
        System.out.print(" |   Harga");
        for(int i=0; i<hargaTerpanjang - ("Harga".length()-4); i++){
            System.out.print(" ");
        }
        System.out.print(" |   Tipe");
        for(int i=0; i<13 - 2; i++){
            System.out.print(" ");
        }
        System.out.println(" | ");
        
        System.out.print("|");
        for(int i=0; i<namaTerpanjang + jumlahTerpanjang + hargaTerpanjang + 38; i++){
            System.out.print("-");
        }
        System.out.println("|");
        
        for(int i=0; i<this.riwayatPembelianNama.size(); i++){
            String nama = this.riwayatPembelianNama.get(i);
            String jumlah = Integer.toString(this.riwayatPembelianJumlah.get(i));
            String harga = Integer.toString(this.riwayatPembelianHarga.get(i) * this.riwayatPembelianJumlah.get(i));
            String tipe = this.riwayatTipePembelian.get(i);
            
            System.out.print("|   ");
            System.out.print(nama);
            for(int j=0; j<namaTerpanjang - nama.length(); j++){
                System.out.print(" ");
            }
            System.out.print(" |   ");
            System.out.print(jumlah);
            for(int j=0; j<jumlahTerpanjang - jumlah.length(); j++){
                System.out.print(" ");
            }
            System.out.print(" |   ");
            System.out.print("Rp " + harga + ",-");
            for(int j=0; j<hargaTerpanjang - harga.length(); j++){
                System.out.print(" ");
            }
            System.out.print("|   ");
            System.out.print(tipe);
            for(int j=0; j<13 - tipe.length(); j++){
                System.out.print(" ");
            }
            System.out.println("   |");
        }
        
        System.out.print("|");
        for(int i=0; i<namaTerpanjang + jumlahTerpanjang + hargaTerpanjang + 38; i++){
            System.out.print("-");
        }
        System.out.println("|");
    }
}
