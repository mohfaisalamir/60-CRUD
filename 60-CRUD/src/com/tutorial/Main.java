package com.tutorial;

import java.io.*;
import java.time.Year;
import java.time.YearMonth;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //test kode ini adalah kode hasil copy dari kode backe-up saya sendiri

        Scanner terminalInput = new Scanner(System.in);
        String userOption;
        boolean isNext = true;
        while (isNext) {
            clearScreen();
            System.out.println("\nDatabase Perpustakaan  : ");
            System.out.println("1.\t Lihat semua buku");
            System.out.println("2.\t Cari buku");
            System.out.println("3.\t Membuat data buku");
            System.out.println("4.\t Ubah data buku");
            System.out.println("5.\t Hapus data buku");

            System.out.print("Pilihan anda :  ");
            userOption = terminalInput.next();
            switch (userOption) {
                case "1":
                    System.out.println("=====================");
                    System.out.println("TAMPILKAN DAFTAR BUKU");
                    System.out.println("=====================");
                    //Kita akan tampilkan data disini brader ehehehe,
                    showData();
                    break;
                case "2":
                    System.out.println("==========");
                    System.out.println("CARI BUKU");
                    System.out.println("==========");
                    //sekarang tombol 2, kita Cari buku(Data)
                    seacrhData();
                    break;
                case "3":
                    System.out.println("==================");
                    System.out.println("TAMBAH DAFTAR BUKU");
                    System.out.println("==================");
                    //nambah data
                    addBookData();
                    showData();
                    break;
                case "4":
                    System.out.println("================");
                    System.out.println("UBAH DAFTAR BUKU");
                    System.out.println("================");
                    updateData();
                    break;
                case "5":
                    System.out.println("================");
                    System.out.println("HAPUS DAFTAR BUKU");
                    System.out.println("================");
                    deleteData();
                    showData();
                    break;
                default:
                    System.err.println("\n masukan input sesuai perintah ! (1-5)");

            }
            isNext = getYesOrNo("\n Apakah anda ngin melanjutkan?");
        }
    }
    private static void updateData()throws IOException{
        // kita ambil database original
        File database = new File("database.txt");
        FileReader fileInput = new FileReader(database);
        BufferedReader bufferedInput = new BufferedReader(fileInput);

        // kita buat database temp / temporary (sementara)
        File tempDB = new File("tempDB.txt");
        FileWriter fileOutput = new FileWriter(tempDB);
        BufferedWriter bufferedOutput = new BufferedWriter(fileOutput);

        // tampilkan data
        System.out.println("List Buku");
        showData();

        // ambil userInput / tombol yang dipilih user
        Scanner terminalInput = new Scanner(System.in);
        System.out.println("\nMasukan nomor buku yang akan di-Update : ");
        int updateNumber = terminalInput.nextInt();

        // tampilkan data yang ingin di-update
        String data = bufferedInput.readLine();
        int entryCounts = 0;
        StringTokenizer st;

        while (data != null){
            entryCounts++;
            st = new StringTokenizer(data,",");

            if (updateNumber==entryCounts){
                System.out.println("\nData yang ingin anda UPDATE adalah : ");
                System.out.println("---------------------------------------");
                System.out.println("Nomer Referensi Buku    : "+st.nextToken());
                System.out.println("Tahun Terbit            : "+ st.nextToken());
                System.out.println("Penulis                 : "+ st.nextToken());
                System.out.println("Penerbit                : "+ st.nextToken());
                System.out.println("Judul Buku              : "+ st.nextToken());

                // data diupdate
                // Mengambil input dari User

                String[] fieldData = {"Tahun","Penulis","Penerbit","Judul"};
                String[] dataTemp  = new String[4];

                // Refresh Token
                st = new StringTokenizer(data,",");
                String originalData = st.nextToken(); // lakukan pembacaan "st.nextToken();" dahulu, untuk
                // men-skip "Nomer Referensi Buku " dan yang paling penteng meski "st.nextToken();" tampak bewarna abu2 seperti tidak aktif
                // dia itu sebenarnya Aktif, AKTIF!!! "st.nextToken();" ==> ini bekerja..
                for (int i = 0; i<fieldData.length ; i++){
                    boolean isUpdate = getYesOrNo("Apakah anda akan mengubah "+fieldData[i]+" ?");
                    originalData = st.nextToken();
                    if (isUpdate) {
                        // user input data baru
                        terminalInput = new Scanner(System.in); //di refres, biar data enternya tidak kebaca lagi
                        System.out.println("\nMasukan " + fieldData[i] + " baru");
                        dataTemp[i] = terminalInput.nextLine();
                    }else {
                        dataTemp[i] = originalData;
                    }
                }
                // tampilkan data baru ke layar
                st = new StringTokenizer(data,",");
                st.nextToken();
                System.out.println("\nData yang ingin anda Ter-UPDATE adalah : ");
                System.out.println("-------------------------------------------");
                System.out.println("Tahun Terbit            : "+ st.nextToken()+"===>"+dataTemp[0]);
                System.out.println("Penulis                 : "+ st.nextToken()+"===>"+dataTemp[1]);
                System.out.println("Penerbit                : "+ st.nextToken()+"===>"+dataTemp[2]);
                System.out.println("Judul Buku              : "+ st.nextToken()+"===>"+dataTemp[3]);

                System.out.println("Sak wise    : "+ Arrays.toString(dataTemp));

                // Tanya ke User, apakah yakin mau mengubah data tersebut?
                boolean isUpdate = getYesOrNo("Anda yakin mau UPDATE data tersebut");

                if (isUpdate){
                    // cpertama, Cek Eksistensi buku
                    boolean isExist = checkBookAvailability(dataTemp, true);
                    System.out.println(isExist);

                }else {
                    // data di copy ke tempDB
                    bufferedOutput.write(data);
                    bufferedOutput.newLine();
                }
            }else {
                // data di copy ke tempDB
                bufferedOutput.write(data);
                bufferedOutput.newLine();
            }
            data = bufferedInput.readLine();
        }

        bufferedOutput.flush();

    }
    private static void deleteData()throws IOException {
        // kita ambil database Original
        // kita pakai File, karane cuma dia yang bisa di rename, FileWrite dan FileRead atau File2 lainnya ga bisa di rename
        File database = new File("database.txt");
        FileReader fileInput = new FileReader(database);
        BufferedReader bufferedInput = new BufferedReader(fileInput);

        // kita buat databse penampung (Sementara)
        File tempDB = new File("tempDB.txt");
        FileWriter fileOutput = new FileWriter(tempDB);
        BufferedWriter bufferedOutput = new BufferedWriter(fileOutput);
        // kita tampilkan data
        System.out.println(" Berikut ini Adalah Kumpulan Buku perpustakaan ini");
        showData();

        //kita ambil user input (perintah, tombol mana yang akan di "klik" untuk dihapus dari user)
        Scanner terminalInput = new Scanner(System.in);
        System.out.println("\nMasukan nomer data yang akan dihapus : ");
        int dataNumber = terminalInput.nextInt();

        boolean isFound = false; // apa yang anda ekspresikan jika anda tidak menemukan data?


        //looping untuk membaca data perbaris dan skip data yang akan didelete
        int entryCount = 0;
        String data = bufferedInput.readLine();
        while (data != null){
            boolean isDelete = false; // belum tahu ini buat apa

            StringTokenizer st = new StringTokenizer(data, ",");
            entryCount++;
            if(entryCount == dataNumber){
                System.out.println("Data yang ingin anda Hapus adalah : ");
                System.out.println("====================================");
                System.out.println("Referensi         : "+ st.nextToken());
                System.out.println("Tahun             : "+ st.nextToken());
                System.out.println("Penulis           : "+ st.nextToken());
                System.out.println("Penerbit          : "+ st.nextToken());
                System.out.println("Judul Buku        : "+ st.nextToken());

                isDelete = getYesOrNo("Yakin data buku ke " +dataNumber+ " akan anda di Hapus?");
                isFound  = true;

            }
            if (isDelete){
                // skip pindahkan data (tampak ter-delete) dari original ke temp (sementara)
                System.out.println("Data berhasil dihapus");
            }else {
                // kita pindahkan data dari original ke temp (sementara)
                bufferedOutput.write(data);
                bufferedOutput.newLine();
                // jika File tidak di rename maka yang terhapus tetap terhapus tapi,
                // data yang lama akan kembali karena tertulis ulang, sebab file lama tidak pernah terhapus,
                // karena ini hanya mes-skip data yang ingin dihapus, ==> (kelebihannya ini tidak mengubah isi data asli)
            }

            data = bufferedInput.readLine();
        }
        if (!isFound){
            System.err.println("Data tidak ada, silahkan hapus yang ada");
        }
        // menulis data ke file (mengalirkan doang sih wkwkwkwk)
        bufferedOutput.flush();
        // delete data lama
        database.delete();
        // rename data Temp menjadi data lama
        tempDB.renameTo(database);
    }
    private static void showData()throws IOException{
        System.out.println("Kita akan tampilkan data disini brader ehehehe,\n");
        FileReader fileReader;
        BufferedReader bufferedReader;
        try {

            fileReader = new FileReader("database.txt");
            bufferedReader = new BufferedReader(fileReader);
        }catch (Exception e){
            System.err.println("Datamu ra enek cok, jancok");
            System.err.println("Silakan tambah data terlebih dahulu");
            addBookData();
            return;
        }
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("|\tNo.|\tTahun |\tPenulis               |\tPenerbit              |\tJudul Buku            |");
        System.out.println("------------------------------------------------------------------------------------------");
        String data = bufferedReader.readLine();
        int dataNUmber = 0;
        while (data != null){
            dataNUmber++;
            StringTokenizer stringTokenizer= new StringTokenizer(data,",");
            stringTokenizer.nextToken();
            System.out.printf("|\t %d ",dataNUmber);
            System.out.printf("|\t %s ",stringTokenizer.nextToken());
            System.out.printf("|\t %-20s ",stringTokenizer.nextToken());
            System.out.printf("|\t %-20s ",stringTokenizer.nextToken());
            System.out.printf("|\t %-20s ",stringTokenizer.nextToken());
            System.out.println("|");

            data = bufferedReader.readLine();
        }
        System.out.println("------------------------------------------------------------------------------------------");

        /*
        data = bufferedReader.readLine();
        stringTokenizer = new StringTokenizer(data,",");
        stringTokenizer.nextToken();
        System.out.printf("|\t %s",stringTokenizer.nextToken());
        System.out.printf("|\t %s",stringTokenizer.nextToken());
        System.out.printf("|\t %s",stringTokenizer.nextToken());
        System.out.printf("|\t %s",stringTokenizer.nextToken());
        System.out.println("\n");

        data = bufferedReader.readLine();
        stringTokenizer = new StringTokenizer(data,",");
        stringTokenizer.nextToken();
        System.out.printf("|\t %s",stringTokenizer.nextToken());
        System.out.printf("|\t %s",stringTokenizer.nextToken());
        System.out.printf("|\t %s",stringTokenizer.nextToken());
        System.out.printf("|\t %s",stringTokenizer.nextToken());
        System.out.println("\n");

        data = bufferedReader.readLine();
        stringTokenizer = new StringTokenizer(data,",");
        stringTokenizer.nextToken();
        System.out.printf("|\t %s",stringTokenizer.nextToken());
        System.out.printf("|\t %s",stringTokenizer.nextToken());
        System.out.printf("|\t %s",stringTokenizer.nextToken());
        System.out.printf("|\t %s",stringTokenizer.nextToken());
*/

        //Boolean isTambah = getYesOrNo("Yakin nambah daftar buku?");

    }
    private static void seacrhData()throws IOException{
        //Membaca data base, (ada atau tidak)
        try {
            File  file = new File("database.txt");
            // gak tau apa ini?
            // sepertinya bang Pukis salah atau lupa kalau kode ini (membaca database) tidak jalan atau berfungsi
            // sesuai tujuan...
        }catch (Exception e){
            System.err.println("Data mu Ora Enek su..");
            addBookData();
            return;
        }
        //Ambill Keyword dari User (misal, cari buku "Madilog", maka ketik "madilog" atau nama penulis misal "Tan" atau "Malaka")
        Scanner terminalInput = new Scanner(System.in);
        System.out.print("Masukan Kata Kunci untuk mencari buku : ");
        String searchString = terminalInput.nextLine();
//        System.out.println(searchString); // ini cuma ngecek fungsional atau keberadaan string yang di input
        String[] keyWords = searchString.split("\\s");// jadikan serachString tadi menjadi array [aa,ss,dd,ff]
//        System.out.println(keyWords[1]); // ini juga, cuma ngecek fungsional atau keberadaan string yang di pecah pecah menjadi array terpecah berdasarka \\s (white space)
//        System.out.println(keyWords[0]);

        //Kita cek key word di data base
        checkBookAvailability(keyWords, true);
    }
    private static void addBookData()throws IOException{
        // cara mana nih file yang akan kita tulis (kita tambah data buku, berupa tulisan)
        FileWriter fileOutput = new FileWriter("database.txt",true);
        BufferedWriter buffereOutput = new BufferedWriter(fileOutput);

        // mengambil input dari user
        Scanner terminalInput = new Scanner(System.in);
        String penulis,judul,penerbit,tahun;
        System.out.print("Masukan nama Penulis : ");
        penulis = terminalInput.nextLine();
        System.out.print("Masukan Judul Buku   : ");
        judul   = terminalInput.nextLine();
        System.out.print("Masukan nama Penerbit: ");
        penerbit= terminalInput.nextLine();
        System.out.print("Masukan tahun terbit : ");
        tahun   = getYear();

        //cek buku di database
        // contoh format : fiersabesari_2012_1,2012,fiersa besari,media kita,jejak langkah
        String[] stringInput = {tahun+","+penulis+","+penerbit+","+judul};

        boolean isExist = checkBookAvailability(stringInput,true);
        System.out.println(isExist+ " ada cok");
        // pada fungsi disamping, stringInput nanti ditangkap sebagai keywords fan true/false sebagai isDisplay
        if (isExist){
            System.out.println("Eh,, buku dengan data " +Arrays.toString(stringInput)+ " ini stoknya sudah ada");
        }else {
            System.out.println("Eh,, buku dengan data " +Arrays.toString(stringInput)+ " ini stoknya belum ada, kamu bisa list untuk di pesan nanti");
            System.out.println("apa ini??? ========>" + takeEntryPerYears(penulis,tahun));
            long entryNumber = takeEntryPerYears(penulis,tahun)+ 1;
            String authorWithoutSpace = penulis.replaceAll("\\s","");
            String primaryKey = authorWithoutSpace+"_"+tahun+"_"+entryNumber;

            System.out.println("\nData yang akan anda masukan adalah");
            System.out.println("-------------------------------------");
            System.out.println("Primary Key : "+primaryKey);
            System.out.println("Tahun Terbit: "+tahun);
            System.out.println("Penulis     : "+penulis);
            System.out.println("Penerbit    : "+penerbit);
            System.out.println("Judul Buku  : "+judul);

            // M.E.N.U.L.I.S data berkas buku di database
            // tanya dulu, yakin mau anda tambahkan data tersebut?
            boolean isAdd = getYesOrNo(" yakin mau anda tambahkan data tersebut? ");
            if (isAdd){
                buffereOutput.write(primaryKey+","+tahun+","+penulis+","+penerbit+","+judul);
                buffereOutput.newLine();
                buffereOutput.flush();
            }

        }


        // format primary key ==> faqihza_2019_2,2019,faqihza,gramedia,belajar python

        buffereOutput.close();

    }
    private static long takeEntryPerYears(String author, String  years)throws IOException{
        FileReader fileInput = new FileReader("database.txt");
        BufferedReader bufferedInput = new BufferedReader(fileInput);
        long entry = 0;
        String data = bufferedInput.readLine();
        Scanner dataScanner;
        String primaryKey;
        while (data != null){
            dataScanner = new Scanner(data);
            dataScanner.useDelimiter(",");
            primaryKey = dataScanner.next();
            dataScanner = new Scanner(primaryKey);
            dataScanner.useDelimiter("_");

            author = author.replaceAll("\\s","");

            if (author.equalsIgnoreCase(dataScanner.next()) && years.equalsIgnoreCase(dataScanner.next())){
                entry = dataScanner.nextInt();
            }
            data = bufferedInput.readLine();
        }
        return entry;

    }
    private static boolean checkBookAvailability(String[] keyWords,boolean isDisplay)throws  IOException{ // nyocokin tiap tiap keywords yang di inputkan user dengan kata kata (char ) yang ada di dalam database
        FileReader fileReader = new FileReader("database.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String data = bufferedReader.readLine();
        boolean isExist = false; // jika buku ada maka true, jika ga ada maka False.
        int dataNUmber = 0;

        //Hiasan I

        if (isDisplay) {
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println("|\tNo.|\tTahun |\tPenulis               |\tPenerbit              |\tJudul Buku            |");
            System.out.println("------------------------------------------------------------------------------------------");
        }
        //System.out.println(isExist + " cek"); // ngecek status kebenaran

        while (data!=null){

            // cek key words didalam baris
            isExist=true;

            for (String keyword:keyWords){
                isExist = isExist && data.toLowerCase().contains(keyword.toLowerCase());
            }

            // jika keywordnya cocok maka tampilkan
            // TAPI, bary akan tampil jika di kehendaki untuk tampil (dengan isDisplay = true)
            if(isExist){
                if (isDisplay) {
                    //System.out.println(data);
                    dataNUmber++;
                    StringTokenizer stringTokenizer = new StringTokenizer(data, ",");

                    stringTokenizer.nextToken();
                    System.out.printf("|\t %d ", dataNUmber);
                    System.out.printf("|\t %s ", stringTokenizer.nextToken());
                    System.out.printf("|\t %-20s ", stringTokenizer.nextToken());
                    System.out.printf("|\t %-20s ", stringTokenizer.nextToken());
                    System.out.printf("|\t %-20s ", stringTokenizer.nextToken());
                    System.out.println("|");
                }else {
                    break;
                }
                //System.out.println(isExist + " cek"); // ngecek status kebenaran
            }
            data = bufferedReader.readLine();

        }


        if (isDisplay) {
            System.out.println("------------------------------------------------------------------------------------------");
        }
        //System.out.println(isExist + " cek"); // ngecek status kebenaran


        return isExist;
    }
    private static String getYear()throws IOException{
        boolean isValidYear = false;
        Scanner terminalInput = new Scanner(System.in);
        String yearInput = terminalInput.nextLine();
        while (!isValidYear){
            try {
                Year.parse(yearInput);
                isValidYear=true;
            }catch (Exception e){
                System.err.println("Masukan tahun dengan format yang benar (yyyy) !");
                System.err.println("Silahkan masukan tahun terbit lagi ! ");
                yearInput = terminalInput.nextLine();
                isValidYear=false;
            }
        }
        return yearInput;
    }
    private static boolean getYesOrNo(String message){
        Scanner terminalInput = new Scanner(System.in);
        System.out.println(message+" tekan ya atau tidak (y/n) ! ");
        String userOption = terminalInput.next();
        while (!userOption.equalsIgnoreCase("y") && !userOption.equalsIgnoreCase("n")){
            System.err.println("Tombol sesaaattt!!!, harus \"y\" atau \"n\" ");
            System.out.println(message+" tekan ya atau tidak (y/n) ! ");
            userOption = terminalInput.next();
        }
        return userOption.equalsIgnoreCase("y");

    }
    // membuat fungsi untuk menghapus screen setelah di tekan tembol "y" (yes), biar gak numpuk atas tulisan2 menu sebelumnya.
    private static void clearScreen(){
        // jadi begini, kan clearScreen pada tiap2 OS (Operating System) di terminal kan beda2, dan ini aplikasi nanti dibuat
        // untuk komputer dengan OS apapun, maka kami buat pengondisian menyesuaikan jenis command pada OS (Windows,Linux dan MacOS)
        try {
            if (System.getProperty("os.name").contains("Window")){
                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
            }else {
                System.out.println("\033\143");
            }
        }catch (Exception e){
            System.err.println("Raiso clear screen "+e);
        }
    }
}