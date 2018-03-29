/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.siakad.views;

import com.app.siakad.database.AutoFitTableColumns;
import com.app.siakad.entities.KategoriNilai;
import com.app.siakad.entities.KriteriaNilai;
import com.app.siakad.entities.Prodi;
import com.app.siakad.entities.TahunAngkatan;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class IfrKategoriKriteriaNilai extends javax.swing.JInternalFrame {
    KriteriaNilai kriteria = new KriteriaNilai();
    KategoriNilai kategori = new KategoriNilai();
    Prodi prodi = new Prodi();
    TahunAngkatan ta = new TahunAngkatan();
   
    public IfrKategoriKriteriaNilai() {
        initComponents();
        
        disableInput();
        showDataKategori(); 
        showDataKriteria(); 
        formTengah(); 
        
    }
    
    public void clearInput(){
        txtKdKategori.setText("");
        txtKategori.setText("");
        lblTambah.setText("Tambah");
        lblTambah.setIcon(new javax.swing.ImageIcon(getClass().
                    getResource("/com/app/siakad/icons/icons8_Add_List_20px.png")));
    }
    
    public void disableInput(){
        txtKdKategori.setEnabled(false);
        txtKategori.setEnabled(false);
        cmbThAjaran.setEnabled(false);
        cmbProdi.setEnabled(false);
    }
    
    public void enableInput(){
        txtKdKategori.setEnabled(true);
        txtKategori.setEnabled(true);
        cmbThAjaran.setEnabled(true);
        cmbProdi.setEnabled(true);
    }
    
    public void showDataKategori(){
        tbDataKategori.setModel(kategori.tblkategori);
        int row = kategori.tblkategori.getRowCount();
        for(int i=0; i<row; i++){
            kategori.tblkategori.removeRow(0);//mengosongkan isi tabel
        }
        kategori.select();//utk memanggil method select
        kategori.list.forEach((obj) -> {
            kategori.tblkategori.addRow((Object[]) obj);
        });
        tbDataKategori.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        AutoFitTableColumns tca = new AutoFitTableColumns(tbDataKategori);
        tca.adjustColumns();
        lblRecord.setText("Record : " + tbDataKategori.getRowCount());
    }
    
    public void showDataKriteria(){
        tbDataKriteria.setModel(kriteria.tblkriteria);
        int row = kriteria.tblkriteria.getRowCount();
        for(int i=0; i<row; i++){
            kriteria.tblkriteria.removeRow(0);//mengosongkan isi tabel
        }
        kriteria.select();//utk memanggil method select
        kriteria.list.forEach((obj) -> {
            kriteria.tblkriteria.addRow((Object[]) obj);
        });
        tbDataKriteria.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        AutoFitTableColumns tca = new AutoFitTableColumns(tbDataKriteria);
        tca.adjustColumns();
        lbRecord.setText("Record : " + tbDataKriteria.getRowCount());
    }
    
    public void setTabelKategori(){
        String[] kolom1 = {"No","Kode Kategori","Kategori Penilaian"};
        kategori.tblkategori = new DefaultTableModel(null, kolom1){
            Class[] types = new Class[]{
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class
                
            };
            public Class getColumnClass(int columnIndex){
            return types [columnIndex];
        }
            
        
       };
        tbDataKategori.setModel(kategori.tblkategori);
            tbDataKategori.getColumnModel().getColumn(0).setPreferredWidth(75);
            tbDataKategori.getColumnModel().getColumn(1).setPreferredWidth(250);
            tbDataKategori.getColumnModel().getColumn(2).setPreferredWidth(25);
    }
    
    public void setTabelKriteria(){
        String[] kolom1 = {"No","Kriteria Penilaian"};
        kriteria.tblinputnilai = new DefaultTableModel(null, kolom1){
            Class[] types = new Class[]{
                java.lang.String.class,
                java.lang.String.class
            };
            public Class getColumnClass(int columnIndex){
            return types [columnIndex];
        }
            
        
       };
        tbDataKriteria.setModel(kriteria.tblkriteria);
            tbDataKriteria.getColumnModel().getColumn(0).setPreferredWidth(75);
            tbDataKriteria.getColumnModel().getColumn(1).setPreferredWidth(250);
   
    }
    public void aksiSimpan(){
        if(txtKdKategori.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Mohon lengkapi data",
                    "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }else{
            kategori.isUpdate = !lblSimpan.getText().equals("Simpan");
            kategori.kd_katn = txtKdKategori.getText();
            //prodi.prodi =prodi.KeyProdi[cmbProdi.getSelectedIndex()];
            kategori.kategori_penilaian = txtKategori.getText();
            
            kategori.insert_update();
            if(lblSimpan.getText().equals("Ubah")){
                JOptionPane.showMessageDialog(this, "Data berhasil diubah",
                    "Informasi", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this, "Data berhasil disimpan",
                    "Informasi", JOptionPane.INFORMATION_MESSAGE);
            }
            
            clearInput(); disableInput(); showDataKategori();
        }

    }
    
    public void aksiHapus(){
        if(txtKdKategori.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Informasi",
                    "Anda belum memilih data yang akan dihapus", JOptionPane.INFORMATION_MESSAGE);
        }else{
            int jawab = JOptionPane.showConfirmDialog(this, "Apakah Anda akan menghapus data ini? Kode "+kategori.kd_katn,
                    "Konfirmasi",JOptionPane.YES_NO_OPTION);
            if(jawab == JOptionPane.YES_OPTION){
                kategori.delete(kategori.kd_katn);
                JOptionPane.showMessageDialog(this, "Data berhasil dihapus",
                        "Informasi", JOptionPane.INFORMATION_MESSAGE);
                clearInput(); 
                disableInput(); 
                showDataKategori();
            }
        }
    }
    
    private void formTengah(){
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension framesize = this.getSize();
        if(framesize.height < screensize.height){
            framesize.height = screensize.height;
        }
        if(framesize.width > screensize.width){
            framesize.width = screensize.width;
        }
        this.setLocation((screensize.width - framesize.width)/2, 
                (screensize.height - framesize.height)/2);

    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelAlpha21 = new com.app.siakad.views.PanelAlpha2();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        cmbThAjaran = new javax.swing.JComboBox<>();
        cmbProdi = new javax.swing.JComboBox<>();
        lblTambah = new javax.swing.JLabel();
        panelAlpha22 = new com.app.siakad.views.PanelAlpha2();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDataKategori = new javax.swing.JTable();
        lblRecord = new javax.swing.JLabel();
        panelAlpha23 = new com.app.siakad.views.PanelAlpha2();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        txtKdKategori = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        txtKategori = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        panelAlpha24 = new com.app.siakad.views.PanelAlpha2();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbDataKriteria = new javax.swing.JTable();
        lbRecord = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblSimpan = new javax.swing.JLabel();
        lblAdd = new javax.swing.JLabel();
        lblHapus = new javax.swing.JLabel();

        setClosable(true);
        setMaximizable(true);
        setTitle("Apekido v1.0");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/siakad/icons/desktop_22651 (1).png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Navigasi :");

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        cmbThAjaran.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        cmbThAjaran.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Tahun Ajaran --" }));
        cmbThAjaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbThAjaranActionPerformed(evt);
            }
        });

        cmbProdi.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        cmbProdi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Program Studi --" }));
        cmbProdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProdiActionPerformed(evt);
            }
        });

        lblTambah.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblTambah.setForeground(new java.awt.Color(255, 255, 255));
        lblTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/siakad/icons/icons8_Add_List_20px.png"))); // NOI18N
        lblTambah.setText("Tambah");
        lblTambah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblTambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTambahMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelAlpha21Layout = new javax.swing.GroupLayout(panelAlpha21);
        panelAlpha21.setLayout(panelAlpha21Layout);
        panelAlpha21Layout.setHorizontalGroup(
            panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlpha21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAlpha21Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAlpha21Layout.createSequentialGroup()
                        .addGroup(panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelAlpha21Layout.createSequentialGroup()
                                .addComponent(cmbThAjaran, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbProdi, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblTambah)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(6, 6, 6))))
        );
        panelAlpha21Layout.setVerticalGroup(
            panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlpha21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbThAjaran, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbProdi, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Kategori Penilaian : Klik 2x untuk mengubah data", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jScrollPane1.setOpaque(false);

        tbDataKategori.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "No.", "Kode Kategori", "Kategori Penilaian"
            }
        ));
        jScrollPane1.setViewportView(tbDataKategori);

        lblRecord.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        lblRecord.setForeground(new java.awt.Color(255, 255, 255));
        lblRecord.setText("Record : 0");

        javax.swing.GroupLayout panelAlpha22Layout = new javax.swing.GroupLayout(panelAlpha22);
        panelAlpha22.setLayout(panelAlpha22Layout);
        panelAlpha22Layout.setHorizontalGroup(
            panelAlpha22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlpha22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAlpha22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(panelAlpha22Layout.createSequentialGroup()
                        .addComponent(lblRecord)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelAlpha22Layout.setVerticalGroup(
            panelAlpha22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlpha22Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblRecord)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Input Kriteria Penilaian :");

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Kode Kategori");

        txtKdKategori.setForeground(new java.awt.Color(255, 255, 255));
        txtKdKategori.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtKdKategori.setDisabledTextColor(new java.awt.Color(0, 153, 153));
        txtKdKategori.setOpaque(false);
        txtKdKategori.setSelectionColor(new java.awt.Color(255, 255, 255));
        txtKdKategori.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtKdKategoriKeyTyped(evt);
            }
        });

        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Kategori Penilaian :");

        txtKategori.setForeground(new java.awt.Color(255, 255, 255));
        txtKategori.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtKategori.setDisabledTextColor(new java.awt.Color(0, 153, 153));
        txtKategori.setOpaque(false);
        txtKategori.setSelectionColor(new java.awt.Color(255, 255, 255));
        txtKategori.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtKategoriKeyTyped(evt);
            }
        });

        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelAlpha23Layout = new javax.swing.GroupLayout(panelAlpha23);
        panelAlpha23.setLayout(panelAlpha23Layout);
        panelAlpha23Layout.setHorizontalGroup(
            panelAlpha23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlpha23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAlpha23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jSeparator2)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelAlpha23Layout.createSequentialGroup()
                        .addGroup(panelAlpha23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelAlpha23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtKdKategori, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(panelAlpha23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator4)
                            .addGroup(panelAlpha23Layout.createSequentialGroup()
                                .addGroup(panelAlpha23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(txtKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 22, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelAlpha23Layout.setVerticalGroup(
            panelAlpha23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlpha23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(panelAlpha23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(1, 1, 1)
                .addGroup(panelAlpha23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtKdKategori)
                    .addComponent(txtKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(panelAlpha23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Data Kriteria Penilaian : Klik 2x untuk mengubah data", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jScrollPane2.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setOpaque(false);

        tbDataKriteria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "No.", "Kriteria Penilaian"
            }
        ));
        jScrollPane2.setViewportView(tbDataKriteria);

        lbRecord.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        lbRecord.setForeground(new java.awt.Color(255, 255, 255));
        lbRecord.setText("Record : 0");

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("|");

        lblSimpan.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblSimpan.setForeground(new java.awt.Color(255, 255, 255));
        lblSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/siakad/icons/icons8_Save_as_20px.png"))); // NOI18N
        lblSimpan.setText("Simpan");
        lblSimpan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSimpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSimpanMouseClicked(evt);
            }
        });

        lblAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/siakad/icons/icons8_Add_List_20px.png"))); // NOI18N
        lblAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/siakad/icons/icons8_Delete_File_20px.png"))); // NOI18N
        lblHapus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblHapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHapusMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelAlpha24Layout = new javax.swing.GroupLayout(panelAlpha24);
        panelAlpha24.setLayout(panelAlpha24Layout);
        panelAlpha24Layout.setHorizontalGroup(
            panelAlpha24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlpha24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAlpha24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAlpha24Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelAlpha24Layout.createSequentialGroup()
                        .addComponent(lbRecord)
                        .addGap(76, 76, 76)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(lblAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblSimpan)))
                .addContainerGap())
        );
        panelAlpha24Layout.setVerticalGroup(
            panelAlpha24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAlpha24Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAlpha24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblAdd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblHapus, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSimpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelAlpha22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelAlpha21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelAlpha24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelAlpha23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(8, 8, 8))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelAlpha21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelAlpha23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelAlpha22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelAlpha24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbProdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProdiActionPerformed
        //prodi.Prodi = prodi.KeyProdi[cmbProdi.getSelectedIndex()];
    }//GEN-LAST:event_cmbProdiActionPerformed

    private void lblTambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTambahMouseClicked
        if(evt.getClickCount() == 1){
           enableInput();
           txtKdKategori.requestFocus(true);
           lblTambah.setText("Batal");
           lblTambah.setIcon(new javax.swing.ImageIcon(getClass().
                   getResource("/com/app/siakad/icons/btn_delete.png")));
        }else{
            clearInput();
            disableInput();
            
        }
    }//GEN-LAST:event_lblTambahMouseClicked

    private void lblSimpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSimpanMouseClicked
        aksiSimpan();
    }//GEN-LAST:event_lblSimpanMouseClicked

    private void cmbThAjaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbThAjaranActionPerformed
        
    }//GEN-LAST:event_cmbThAjaranActionPerformed

    private void txtKdKategoriKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKdKategoriKeyTyped
        if(txtKdKategori.getText().length()==8){
            evt.consume();
        }
    }//GEN-LAST:event_txtKdKategoriKeyTyped

    private void txtKategoriKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKategoriKeyTyped
        char enter=evt.getKeyChar();
        if(txtKategori.getText().length()==10){
            evt.consume();
        }
    }//GEN-LAST:event_txtKategoriKeyTyped

    private void lblHapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHapusMouseClicked
        aksiHapus();
    }//GEN-LAST:event_lblHapusMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbProdi;
    private javax.swing.JComboBox<String> cmbThAjaran;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lbRecord;
    private javax.swing.JLabel lblAdd;
    private javax.swing.JLabel lblHapus;
    private javax.swing.JLabel lblRecord;
    private javax.swing.JLabel lblSimpan;
    private javax.swing.JLabel lblTambah;
    private com.app.siakad.views.PanelAlpha2 panelAlpha21;
    private com.app.siakad.views.PanelAlpha2 panelAlpha22;
    private com.app.siakad.views.PanelAlpha2 panelAlpha23;
    private com.app.siakad.views.PanelAlpha2 panelAlpha24;
    private javax.swing.JTable tbDataKategori;
    private javax.swing.JTable tbDataKriteria;
    private javax.swing.JTextField txtKategori;
    private javax.swing.JTextField txtKdKategori;
    // End of variables declaration//GEN-END:variables
}
