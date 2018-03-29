/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.siakad.entities;

import com.app.siakad.database.KoneksiDB;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class KriteriaNilai extends KoneksiDB{
    
    public String kd_knd;
    public String kd_katn;
    public String kategori_penilaian;
    public String kriteria_penilaian;
    public int nilai;
    
    public DefaultTableModel tblkriteria = new DefaultTableModel();
    public DefaultTableModel tblinputnilai = new DefaultTableModel();
    
    public void select(){
        tblkriteria.setColumnIdentifiers(new Object[]{"No","Kriteria Penilaian"});
        try{
            conn = getConnection();
            query = "select * from pg_kriterianilaidosen a, pg_kategorikriterianilai b where a.kd_katn=b.kd_katn";
            stat = conn.prepareStatement(query);
            res = stat.executeQuery(query);
            list = new ArrayList<>();
            int i=1;
            while(res.next()){
                kriteria_penilaian = res.getString("kriteria_penilaian");
                
                
                list.add(new Object[]{i++,kriteria_penilaian});
            }
            stat.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error method select() : " + ex);
        }
    }
    
    public void select_kriteria(){
        tblkriteria.setColumnIdentifiers(new Object[]{"No","Kategori Penilaian","Kode","Kriteria Penilaian","Nilai"});
        try{
            conn = getConnection();
            query = "select * from pg_kriterianilaidosen a, pg_kategorikriterianilai b where a.kd_katn=b.kd_katn";
            stat = conn.prepareStatement(query);
            res = stat.executeQuery(query);
            list = new ArrayList<>();
            int i=1;
            while(res.next()){
                
                kategori_penilaian=res.getString("kategori_penilaian");
                kd_knd = res.getString("kd_knd");
                kriteria_penilaian = res.getString("kriteria_penilaian");
                
                list.add(new Object[]{i++, kategori_penilaian, kd_knd, kriteria_penilaian, ""});
            }
            stat.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error method select() : " + ex);
        }
    }
    
   /* public void insert_update(){
        try{
            conn = getConnection();
            if(isUpdate == false){
                query = " insert into pg_kriterianilaidosen values(?,?,?,?,?,?) ";
            }else{
                query = " update pg_kriterianilaidosen set kd_knd=?, kd_katn=?, kriteria_penilaian=?, kd_prodi=?, kategori_penilaian=?,id_th=? "
                        + " where kd_knd='"+kd_knd+"' ";
            }
            stat = conn.prepareStatement(query);
            stat.setString(1, kd_knd);
            stat.setString(2, kd_katn);
            stat.setString(3, kriteria_penilaian);
            stat.setString(4, kd_prodi);
            stat.setString(5, id_th);
            stat.setString(6, kategori_penilaian);
            stat.executeUpdate();
            stat.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error method insert_update() : " + ex);
        }
    }
     
    public void delete(String kd_prodi){
        try{
            conn = getConnection();
            query = "delete from pg_kriterianilaidosen where kd_knd='"+kd_knd+"' ";
            stat = conn.prepareStatement(query);
            stat.executeUpdate();
            stat.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error method delete() : " + ex);
        }
    }
    
    public String[] KeyKriteria, Kriteria;
    public void listKriteria(){
        try{
            conn = getConnection();
            query = "select * from pg_kriterianilaidosen";
            stat = conn.prepareStatement(query);
            res = stat.executeQuery(query);
            int i = 1;
            while(res.next()){
                Kriteria[i] = res.getString(2);
                i++;
            }
            res.first();
            KeyKriteria = new String[i+1];
            for(int x=1 ; x<i ; x++){
                KeyKriteria[x] = res.getString(1);
                res.next();
            }
            stat.close();
        } catch (SQLException ex) {
            System.out.println("Error Method listKriteria : "+ex);
        }
    }*/
    public void createAutoID(){
        try{
            conn = getConnection();
            query = "select max(kd_knd) from pg_kriterianilaidosen";
            stat = conn.prepareStatement(query);
            res = stat.executeQuery(query);
            if(res.first()){
                kd_knd=res.getString(1)+1;
            }else{
                kd_knd="1";
            }
            stat.close();
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error method createAutoID() : "
                + ex, "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    
}
