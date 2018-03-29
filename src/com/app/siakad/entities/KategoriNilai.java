
package com.app.siakad.entities;

import com.app.siakad.database.KoneksiDB;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class KategoriNilai extends KoneksiDB {
    public String kd_katn;
    public int id_th;
    public String kd_prodi;
    public String kategori_penilaian;
    public Float bobot;
    public String kriteria_penilaian;
    public DefaultTableModel tblkategori = new DefaultTableModel();
   
    public void select(){
        tblkategori.setColumnIdentifiers(new Object[]{"No","Kode Kategori", "Kategori Penilaian"});
        try{
            conn = getConnection();
            query = "select * from pg_kategorikriterianilai a, pg_kriterianilaidosen b where a.kd_katn=b.kd_katn order by a.kd_katn asc";
            stat = conn.prepareStatement(query);
            res = stat.executeQuery(query);
            list = new ArrayList<>();
            int i=1;
            while(res.next()){
                kd_katn = res.getString("kd_katn");
                kategori_penilaian = res.getString("kategori_penilaian");
                
                 list.add(new Object[]{i++, kd_katn, kategori_penilaian});
            }
            stat.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error method select(): "+ex);
        }
    }
    
    public void insert_update(){
        try{
            conn = getConnection();
            if(isUpdate == false){
                query = " insert into pg_kategorikriterianilai values(?,?,?,?) ";
            }else{
                query = "update pg_kategorikriterianilai set kd_katn=?, kategori_penilaian=? "
                        + " where kd_katn='"+kd_katn+"' ";
            }
            stat = conn.prepareStatement(query);
            stat.setString(1, kd_katn);
            stat.setInt(2, id_th);
            stat.setString(3, kd_prodi);
            stat.setString(4, kategori_penilaian);
            stat.executeUpdate();
            stat.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error mothod insert_update(): "+ex);
        }
    }
    
    public void delete(String kd_katn){
        try{
           conn = getConnection();
           query = "delete pg_kategorikriterianilai where kd_katn='"+kd_katn+"' ";
           stat = conn.prepareStatement(query);
           stat.executeUpdate();
           stat.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error method delete(): "+ex);
        }
    }
    
    public String[] KeyKategoriNilai, Kategori;
    public void listKategoriNilai(){
        try{
            conn = getConnection();
            query = "select * from pg_Kategorikriterianilai";
            stat = conn.prepareStatement(query);
            res = stat.executeQuery(query);
            int i = 1;
            while(res.next()){
                Kategori[i] = res.getString(2);
                i++;
            }
            res.first();
            KeyKategoriNilai = new String[i+1];
            for(int x=1 ; x<i ; x++){
                KeyKategoriNilai[x] = res.getString(1);
                res.next();
            }
            stat.close();
        } catch (SQLException ex) {
            System.out.println("Error Method listKategoriNilai() : "+ex);
        }
    }
    
    
}
