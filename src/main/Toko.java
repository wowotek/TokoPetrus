package main;

import main.database.Barang;
import main.database.Stok;

public class Toko {
    Stok gudangToko = new Stok();
    Stok riwayatPembelian = new Stok();
    
    void lihatPersediaanBarang(){
        for(Barang i: gudangToko.getDataStok()){
            System.out.println("");
        }
    }
}
