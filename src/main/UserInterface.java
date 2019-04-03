package main;

import java.util.ArrayList;
import java.util.Scanner;
import main.database.Barang;
import main.database.Stok;

public class UserInterface {
    Toko toko;
    
    public UserInterface(Toko toko){
        this.toko = toko;
    }
    
    public int MainMenu(){
        System.out.println("|------------------------------|");
        System.out.println("| Selamat Datang Di Petrusmart |");
        System.out.println("|------------------------------|\n");
        System.out.println("1. Penjualan");
        System.out.println("2. Managemen");
        System.out.println("0. Matikan Sistem");
        
        return menuInputHandler(new int[]{1, 2, 0}, "Masukkan Pilihan Menu : ", "Pilihan tidak ditemukan Di Main Menu !");
    }
    
    public int menuPenjualan(){
        ArrayList<String> belanjaan = new ArrayList<>();
        ArrayList<Integer> banyak = new ArrayList<>();
        
        int exitCode;
        while(true){
            System.out.println("Kode : 9090 -> Menu Utama");
            System.out.println("       9091 -> Konfirmasi Pembelian");
            System.out.println("       9092 -> Lihat Belanjaan\n");
            System.out.print("Masukkan Kode Barang : ");

            String kodeBarang = new Scanner(System.in).nextLine();
            if(kodeBarang.equals("9090")){
                exitCode = 1;
                break;
            }
            if(kodeBarang.equals("9091")){
                if(belanjaan.isEmpty()){
                    System.out.println("Belanjaan Kosong, tidak ada yang perlu dibayar");
                    continue;
                }
                exitCode = 0;
                break;
            }
            if(kodeBarang.equals("9092")){
                Stok s = this.toko.getGudangToko();
                for(String i: belanjaan){
                    s.printDetailBarang(i);
                }
                continue;
            }
            
            System.out.print("Masukkan Jumlah Item : ");
            int jumlahBarang = new Scanner(System.in).nextInt();
            if(jumlahBarang == 0) continue;
            
            belanjaan.add(kodeBarang);
            banyak.add(jumlahBarang);
        }
        
        if(exitCode == 1){
            return 1;
        } else {
            if(menuBayar(belanjaan, banyak)){
                for(int i=0; i<belanjaan.size(); i++){
                    this.toko.beliBarang(belanjaan.get(i), banyak.get(i));
                }
                return this.menuPenjualan();
            } else {
                return this.menuPenjualan();
            }
        }
    }
    
    public int uiMenuManagemen(){
        System.out.println("Menu Managemen");
        System.out.println("1. Lihat Riwayat Transaksi");
        System.out.println("2. Lihat Stok Barang");
        System.out.println("3. Registrasi Barang Baru");
        System.out.println("4. Restok Barang");
        System.out.println("5. Buang Barang Sebagian");
        System.out.println("6. Buang Barang");
        System.out.println("0. Kembali Ke Menu Utama");
        
        return menuInputHandler(new int[]{1, 2, 3, 4, 5, 6, 0}, "Pilih Menu >> ", "Menu Tidak Ada !");
    }
    
    public void menuManagemen(){
        while(true){
            switch(this.uiMenuManagemen()){
                default: break;
                case 1: this.toko.lihatRiwayat(); break;
                case 2: this.toko.lihatPersediaanBarang(); break;
                case 3: this.uiRegistrasi(); break;
                case 4: this.uiRestock(); break;
                case 5: this.uiBuangSebagian(); break;
                case 6: this.uiBuang(); break;
                case 0: return;
            }
        }
    }
    
    public void uiBuangSebagian(){
        System.out.print("Masukkan Kode Barang untuk Dibuang : ");
        String kodeBarang = new Scanner(System.in).nextLine();
        
        System.out.print("Masukkan Jumlah Barang untuk dibuang : ");
        int jumlah = new Scanner(System.in).nextInt();
        
        System.out.print("Apakah Anda Yakin ? 1. Ya\n2. Tidak\n");
        if(menuInputHandler(new int[]{1, 2}, ">>", "Hanya ada 1 untuk ya, atau 2 untuk tidak")==1){
            this.toko.buangBarang(kodeBarang, jumlah);
        }
    }
    
    public void uiBuang(){
        System.out.print("Masukkan Kode Barang untuk Dibuang : ");
        String kodeBarang = new Scanner(System.in).nextLine();
        
        System.out.print("Apakah Anda Yakin ? 1. Ya\n2. Tidak\n");
        if(menuInputHandler(new int[]{1, 2}, ">>", "Hanya ada 1 untuk ya, atau 2 untuk tidak")==1){
            this.toko.buangBarang(kodeBarang);
        }
    }
    
    public void uiRegistrasi(){
        System.out.print("Masukkan Kode Barang Baru : ");
        String kodeBarang = new Scanner(System.in).nextLine();
        
        System.out.print("Masukkan Nama Barang Baru : ");
        String namaBarang = new Scanner(System.in).nextLine();
        
        System.out.print("Masukkan Harga Barang Baru : Rp");
        int hargaBarang = new Scanner(System.in).nextInt();
        
        System.out.print("Masukkan Stok Awal Barang baru : ");
        int stokAwal = new Scanner(System.in).nextInt();
        
        this.toko.registerBarangBaru(new Barang(kodeBarang, namaBarang, hargaBarang, stokAwal));
    }
    
    public void uiRestock(){
        System.out.print("Masukkan Kode Barang Restok : ");
        String kodeBarang = new Scanner(System.in).nextLine();
        System.out.print("Masukkan Jumlah Restok : ");
        int jumlahBarang = new Scanner(System.in).nextInt();
        
        this.toko.restokBarang(kodeBarang, jumlahBarang);
    }
    
    private boolean menuBayar(ArrayList<String> daftarKode, ArrayList<Integer> daftarJumlah){
        Stok s = this.toko.getGudangToko();
        int totalHarga = 0;
        for(int i=0; i<daftarKode.size(); i++){
            Barang b = s.detailDataBarang(daftarKode.get(i));
            int jumlah = daftarJumlah.get(i);
            System.out.print(b.getNamaBarang() + "  " + jumlah + " x " + b.getHargaBarang());
            System.out.println("  Rp" + Integer.toString(b.getHargaBarang() * jumlah) + ",-");
            totalHarga += b.getHargaBarang() * jumlah;
        }
        
        System.out.println("Total Yang Harus Dibayar : Rp" + Integer.toString(totalHarga) + ",-");
        
        int pilihan = menuInputHandler(new int[]{1, 2}, "Bayar?\n1. Ya\n2. Tidak\n>> ", "Hanya ada 1 untuk ya, atau 2 untuk tidak");
        return pilihan == 1;
    }
    
    private int menuInputHandler(int acceptedInput[], String prompt, String errorMsg){
        int userInput;
        while(true){
            System.out.print(prompt);
            userInput = new Scanner(System.in).nextInt();
            
            for(int i: acceptedInput){
                if(userInput == i){
                    return userInput;
                }
            }
            System.out.println(errorMsg);
        }
    }
}
