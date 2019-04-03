package main;

import java.util.Scanner;
import main.database.Barang;

public class Main {
    public static void main(String[] args) {
        Toko toko = new Toko();
        
        toko.registerBarangBaru(new Barang("PEPM", "Pepsodent Mint 35ml", 27500, 20));
        toko.registerBarangBaru(new Barang("ENZ", "Enzyme Gold 40ml", 48500, 20));
        toko.registerBarangBaru(new Barang("TPHK", "Teh Pucuk Harum 120ml", 3500, 120));
        
        UserInterface ui = new UserInterface(toko);
        
        while(true){
            switch(ui.MainMenu()){
                default: break;
                case 1:
                    ui.menuPenjualan();
                    break;
                case 2:
                    ui.menuManagemen();
                    break;
                case 0:
                    System.out.println("Selamat Tinggal !");
                    return;
            }
        }
    }
}
