package com.app.siakad.entities;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import com.app.siakad.database.KoneksiDB;
import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class DosenAktif extends KoneksiDB{
    
    public String id_user;
    public String nama_user;
    public String lev_user;
    public String kd_dosen;
    public String nip;
    public String nama_dosen;
    public String nama_mk;
    public int sks_t;
    public int sks_p;
    public String sta_aktif;
    public DefaultTableModel tbldosenaktif = new DefaultTableModel();
   
    
    public void select(){
        tbldosenaktif.setColumnIdentifiers(new Object[]{"Kode Dosen","Nama Dosen","Nama Matakuliah","SKS Teori","SKS Praktik","Status"});
        try{
            conn = getConnection();
            query = "select * from mk_jadwalmk a, mk_matakuliah b, pg_dosen c "
                     +" where a.kd_mk=b.kd_mk and a.kd_dosen=c.kd_dosen order by a.kd_dosen asc ";
            stat = conn.prepareStatement(query);
            res = stat.executeQuery(query);
            list = new ArrayList<>();
            while(res.next()){
                kd_dosen=res.getString("kd_dosen");
                nama_dosen=res.getString("nama_pegawai");
                nama_mk=res.getString("nama_mk");
                sks_t=res.getInt("sks_t");
                sks_p=res.getInt("sks_p");
                sta_aktif=res.getString("sta_aktif");
                
                list.add(new Object[]{kd_dosen,nama_dosen,nama_mk,sks_t,sks_p,sta_aktif});
            }
                stat.close();
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error method select() : " + ex);
        }
    }
    
}
