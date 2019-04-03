package main.database;

import java.util.ArrayList;

public interface StokTemplate<ClassBarang, identifierUnikBarang> {
    // Interface ini dibuat untuk men-simulasi-kan
    // Database dengan operasi CRUD (Create, Read, Update, Delete)
    
    // ---| Read, membaca detail barang dari stok
    ClassBarang detailDataBarang(identifierUnikBarang kodeBarang);              // Melihat detail satu barang
    ArrayList<ClassBarang> getDataStok();                                       // mengambil semua data isi stok
    
    // ---| Create & Update, mengubah data barang dalam stok
    boolean restokBarang(identifierUnikBarang kodeBarang, int jumlah);          // menambah stok barang yang sudah ada dalam stok
    void restokBarang(ClassBarang barang);                                      // menambah stok barang baru sebanyak stok
    int ambilBarang(identifierUnikBarang kodeBarang, int jumlah);               // mengurangi stok. jika 0, data tidak hilang
    
    // ---| Delete, menghapus data barang dalam stok
    boolean singkirkanBarang(identifierUnikBarang kodeBarang);                  // Menyingkirkan semua stock dalam stok sampai 0, dan
                                                                                // menghapus datanya
}
