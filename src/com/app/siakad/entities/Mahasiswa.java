package com.app.siakad.entities;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import com.app.siakad.database.KoneksiDB;
import javax.swing.table.DefaultTableModel;

public class Mahasiswa extends KoneksiDB{
    
    public String nim;
    public String kd_prodi;
    public int id_ta;
    public String nama_mhs;
    public String tmp_lahir;
    public String tgl_lahir;
    public String alamat;
    public String jns_kel;
    public String agama;
    public String no_telp;
    public String nama_ayah;
    public String nama_ibu;
    public String pkj_ayah;
    public String pkj_ibu;
    public double peng_ayah;
    public double peng_ibu;
    public int sta_mhs;
    public String pass;
    public DefaultTableModel tblmahasiswa = new DefaultTableModel();
    
    
    
    
    public void insert_update(){
        try{
            conn = getConnection();
            if(isUpdate == false){
                query = " insert into mhs_mahasiswa values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
            }else{
                query = " update mhs_mahasiswa set nim=?, kd_prodi=?, id_ta=?, nama_mhs=?, tmp_lahir=?, tgl_lahir=?, alamat=?, jns_kel=?, agama=?, no_telp=?, nama_ayah=?, nama_ibu=?, pkj_ayah=?, pkj_ibu=?, peng_ayah=?, peng_ibu=?, sta_mhs=?, pass=?"
                        + " where nim='"+nim+"' ";
            }
            stat = conn.prepareStatement(query);
            stat.setString(1, nim);
            stat.setString(2, kd_prodi);
            stat.setInt(3, id_ta);
            stat.setString(4, nama_mhs);
            stat.setString(5, tmp_lahir);
            stat.setString(6, tgl_lahir);
            stat.setString(7, alamat);
            stat.setString(8, jns_kel);
            stat.setString(9, agama);
            stat.setString(10, no_telp);
            stat.setString(11, nama_ayah);
            stat.setString(12, nama_ibu);
            stat.setString(13, pkj_ayah);
            stat.setString(14, pkj_ibu);
            stat.setDouble(15, peng_ayah);
            stat.setDouble(16, peng_ibu);
            stat.setInt(17, sta_mhs);
            stat.setString(18, pass);
            stat.executeUpdate();
            stat.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error method insert_update() : " + ex);
        }
    }
    
    public void delete(String nim){
        try{
            conn = getConnection();
            query = "delete from mhs_mahasiswa where nim='"+nim+"' ";
            stat = conn.prepareStatement(query);
            stat.executeUpdate();
            stat.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void select(){
        tblmahasiswa.setColumnIdentifiers(new Object[]{"Nim", "KD. Prodi", "ID. TA", "Nama Mhs", "Tmp Lahir", "Tgl Lahir",
            "Alamat","Jns Kel","Agama","No Telp", "Nama Ayah", "Nama Ibu", "Pkj Ayah","Pkj Ibu","Penghasilan Ayah", "Penghasilan Ibu", "Sta Mhs", "Pass"});
    try {
        conn = getConnection();
        query = "select * from mhs_mahasiswa";
        stat = conn.prepareStatement(query);
        res = stat.executeQuery(query);
        list = new ArrayList<>();
        while (res.next()) {
            nim = res.getString("nim");
            kd_prodi = res.getString("kd_prodi");
            id_ta = res.getInt("id_ta");
            nama_mhs = res.getString("nama_mhs");
            tmp_lahir = res.getString("tmp_lahir");
            tgl_lahir = tglview.format(res.getDate("tgl_lahir"));
            alamat=res.getString("alamat");
            jns_kel=res.getString("jns_kel");
            agama=res.getString("agama");
            no_telp=res.getString("no_telp");
            nama_ayah=res.getString("nama_ayah");
            nama_ibu=res.getString("nama_ibu");
            pkj_ayah=res.getString("pkj_ayah");
            pkj_ibu=res.getString("pkj_ibu");
            peng_ayah=res.getDouble("peng_ayah");
            peng_ibu=res.getDouble("peng_ibu");
            sta_mhs=res.getInt("sta_mhs");
            pass=res.getString("pass");
            list.add(new Object[]{nim, kd_prodi, id_ta, nama_mhs, tmp_lahir, tgl_lahir ,
            alamat, jns_kel, agama, no_telp, nama_ayah, nama_ibu, pkj_ayah, pkj_ibu, peng_ayah, peng_ibu, sta_mhs, pass});
        }
        stat.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error method select() : " + ex);
        }
    }
    
    // Membuat NIM otomatis
    public void createNIM(){
        try{
            conn = getConnection();
            query = "select max(right(nim,4)) from tbmahasiswa where Left(nim, 5)='"+nim+"' ";
            stat = conn.prepareStatement(query);
            res = stat.executeQuery(query);
            if(res.first()){
                int noID = res.getInt(1) + 1;
                String no = String.valueOf(noID);
                int noLong = no.length();
                for(int a=0;a<2-noLong;a++){
                    no = "" + no;
                }
                if(noID < 1){
                    nim = nim+"0000" + no;
                }else if(noID < 10){
                    nim = nim+"000" + no;
                }else if(noID < 100){
                    nim = nim+"00" + no;
                }else if(noID < 1000){
                    nim = nim+"0" + no;
                } else{
                    nim = nim+""+ no;
                }
            }else{
                nim = nim+"0001";
            }
            stat.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error method createNIM() : " 
                    + ex, "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
}
