package main.database;

import java.util.ArrayList;

public interface StokTemplate<ClassBarang, identifierUnikBarang> {
    // Interface ini dibuat untuk men-simulasi-kan
    // Database dengan operasi CRUD (Create, Read, Update, Delete)
    
    // ---| Create, menambahkan jenis barang baru ke stok
    boolean tambahBarangBaru(ClassBarang barang);                              // Menambahkan barang jenis baru ke StokTemplate sebanyak 1 buah
    
    // ---| Read, membaca detail barang dari stok
    ClassBarang DetailDataBarang(identifierUnikBarang kodeBarang);
    ArrayList<ClassBarang> getDataStok();
    
    // ---| Update, mengubah data barang dalam stok
    boolean restokBarang(identifierUnikBarang kodeBarang, int jumlah);             // menambah stok barang yang sudah ada dalam stok
    int ambilBarang(identifierUnikBarang kodeBarang, int jumlah);              // mengurangi stok. jika 0, data tidak hilang
    
    // ---| Delete, menghapus data barang dalam stok
    boolean singkirkanBarang(identifierUnikBarang kodeBarang);                     // Menyingkirkan semua stock dalam stok sampai 0, dan
                                                                                // menghapus datanya
}
