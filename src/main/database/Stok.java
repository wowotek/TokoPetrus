package main.database;

import java.util.ArrayList;

public class Stok implements StokTemplate<Barang, String>{
    private final ArrayList<Barang> stok;                                       // List untuk database stock
    
    public Stok(){
        this.stok = new ArrayList<>();
    }

    @Override
    public Barang detailDataBarang(String kodeBarang) {
        for(Barang i: this.stok){
            if(i.getKodeBarang().equals(kodeBarang))
                return i;                                                       // barang ditemukan dan mengembalikan data barang
        }
        return null;
    }
    
    public void printDetailBarang(String kodeBarang){
        Barang b = this.detailDataBarang(kodeBarang);
        if(b != null){
            System.out.println(b.getNamaBarang() + " @ Rp " + b.getHargaBarang() + ",-");
        }
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
                
                return true;
            }
        }
        
        return false;
    }
    
    @Override
    public void restokBarang(Barang barang){
        this.stok.add(barang);
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
    
    public boolean singkirkanBarang(String kodeBarang, int jumlah){
        for(int i=0; i<this.stok.size(); i++){
            Barang ix = this.stok.get(i);
            if(ix.getKodeBarang().equals(kodeBarang) && ix.getStok() - jumlah >= 0){
                this.stok.set(i, new Barang(
                        ix.getKodeBarang(), ix.getNamaBarang(),
                        ix.getHargaBarang(), ix.getStok() - jumlah
                ));
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
    
    public void lihatSemuaBarang(){
        int namaTerbanyak = 0;
        int stokTerbanyak = 0;
        
        // Mencari Karakter Terpanjang
        for(Barang i: this.stok){
            if(i.getNamaBarang().length() >= namaTerbanyak)
                namaTerbanyak = i.getNamaBarang().length();
            if(Integer.toString(i.getStok()).length() >= stokTerbanyak)
                stokTerbanyak = Integer.toString(i.getStok()).length();
        }
        
        if(4 > namaTerbanyak){
            namaTerbanyak = 4;
        }
        
        if(10 > stokTerbanyak){
            stokTerbanyak = 8;
        }
        
        namaTerbanyak += 2;
        stokTerbanyak += 2;
        System.out.println(stokTerbanyak);
        System.out.print("|");
        for(int i=0; i<namaTerbanyak + stokTerbanyak + 11; i++){
            System.out.print("-");
        }
        System.out.println("|");
        
        System.out.print("|   Nama");
        for(int i=0; i<namaTerbanyak - 4; i++){
            System.out.print(" ");
        }
        System.out.print(" |   Sisa Stock");
        for(int i=0; i<stokTerbanyak - 10; i++){
            System.out.print(" ");
        }
        System.out.println("   | ");
        
        System.out.print("|");
        for(int i=0; i<namaTerbanyak + stokTerbanyak + 11; i++){
            System.out.print("-");
        }
        System.out.println("|");
        
        for(Barang i: this.stok){
            System.out.print("|   ");
            System.out.print(i.getNamaBarang());
            for(int j=0; j<namaTerbanyak - i.getNamaBarang().length(); j++){
                System.out.print(" ");
            }
            System.out.print(" |   ");
            System.out.print(i.getStok());
            for(int j=0; j<stokTerbanyak - Integer.toString(i.getStok()).length(); j++){
                System.out.print(" ");
            }
            System.out.println("   | ");
        }
        
        System.out.print("|");
        for(int i=0; i<namaTerbanyak + stokTerbanyak + 11; i++){
            System.out.print("-");
        }
        System.out.println("|");
    }
}

















