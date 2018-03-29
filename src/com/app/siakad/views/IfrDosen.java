/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.siakad.views;

import com.app.siakad.database.AutoFitTableColumns;
import com.app.siakad.entities.Dosen;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class IfrDosen extends javax.swing.JInternalFrame {
    
    Dosen dosen = new Dosen();

    
    public IfrDosen() {
        initComponents();
        
        clearInput(); disableInput(); setTabelDosen(); showDataDosen(); formTengah();
    }
    
    public void clearInput(){
        txtNIK.setText("");
        txtKdDosen.setText("");
        txtNIP.setText("");
        txtNamaPegawai.setText("");
        txtTmpLahir.setText("");
        dtTglLahir.setDate(new Date());
        epAlamat.setText("");
        rbLk.setText("Laki-laki");
        rbPerempuan.setText("Perempuan");
        cmbAgama.setSelectedIndex(0);
        txtNoTelp1.setText("");
        txtNoTelp2.setText("");
        txtEmail.setText("");
        dtTmt.setDate(new Date());
        txtNamaIbu.setText("");
        cmbStaMenikah.setSelectedIndex(0);
        txtJmlTanggungan.setText("");
        cmbStaPegawai.setSelectedIndex(0);
        cmbStaAktif.setSelectedIndex(0);
        btnTambah.setText("Tambah");
        btnSimpan.setText("Simpan");
        btnTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/siakad/icons/icons8_Add_List_20px.png")));
    }
    
    public void disableInput(){
        txtNIK.setEnabled(false);
        txtKdDosen.setEnabled(false);
        txtNIP.setEnabled(false);
        txtNamaPegawai.setEnabled(false);
        txtTmpLahir.setEnabled(false);
        dtTglLahir.setEnabled(false);
        epAlamat.setEnabled(false);
        rbLk.setEnabled(false);
        rbPerempuan.setEnabled(false);
        cmbAgama.setEnabled(false);
        txtNoTelp1.setEnabled(false);
        txtNoTelp2.setEnabled(false);
        txtEmail.setEnabled(false);
        dtTmt.setEnabled(false);
        txtNamaIbu.setEnabled(false);
        cmbStaMenikah.setEnabled(false);
        txtJmlTanggungan.setEnabled(false);
        cmbStaPegawai.setEnabled(false);
        cmbStaAktif.setEnabled(false);
        btnSimpan.setEnabled(false);
        btnHapus.setEnabled(false);
    }
    
    public void enableInput(){
        txtNIK.setEnabled(true);
        txtKdDosen.setEnabled(true);
        txtNIP.setEnabled(true);
        txtNamaPegawai.setEnabled(true);
        txtTmpLahir.setEnabled(true);
        dtTglLahir.setEnabled(true);
        epAlamat.setEnabled(true);
        rbLk.setEnabled(true);
        rbPerempuan.setEnabled(true);
        cmbAgama.setEnabled(true);
        txtNoTelp1.setEnabled(true);
        txtNoTelp2.setEnabled(true);
        txtEmail.setEnabled(true);
        dtTmt.setEnabled(true);
        txtNamaIbu.setEnabled(true);
        cmbStaMenikah.setEnabled(true);
        txtJmlTanggungan.setEnabled(true);
        cmbStaPegawai.setEnabled(true);
        cmbStaAktif.setEnabled(true);
        btnSimpan.setEnabled(true);
    }
    
    
    public void showDataDosen(){
        tbDataDosen.setModel(dosen.tbldosen);
        int row = dosen.tbldosen.getRowCount();
        for(int i=0; i<row; i++){
            dosen.tbldosen.removeRow(0);//mengosongkan isi tabel
        }
        dosen.select();//utk memanggil method select
        dosen.list.forEach((obj) -> {
            dosen.tbldosen.addRow((Object[]) obj);
        });
        tbDataDosen.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        AutoFitTableColumns tca = new AutoFitTableColumns(tbDataDosen);
        tca.adjustColumns();
        lblRecord.setText("Record : " + tbDataDosen.getRowCount());
      
    }
    
    public void setTabelDosen(){
        String[] kolom1 = {"NIK", "KD. Dosen", "NIP", "Nm Pegawai", "Jns Kel", "Tmp Lahir", "Tgl Lahir",
            "Agama", "Alamat", "No. Tlp 1", "No. Tlp 2", "Email", "Tmt", "Nm Ibu", "Sta Menikah",
            "Jml Tanggungan","Sta Pegawai","Sta Aktif" , "Pass"};
        dosen.tbldosen = new DefaultTableModel(null, kolom1){
            Class[] types = new Class[]{
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class
            };
            public Class getColumnClass(int columnIndex){
            return types [columnIndex];
        }
            
        //agar tabel tdk bisa diedit
        public boolean isCellEditable(int row, int col){
            int cola = dosen.tbldosen.getColumnCount();
            return (col < cola) ? false : true;
        }
       };
        tbDataDosen.setModel(dosen.tbldosen);
            tbDataDosen.getColumnModel().getColumn(0).setPreferredWidth(75);
            tbDataDosen.getColumnModel().getColumn(1).setPreferredWidth(250);
            tbDataDosen.getColumnModel().getColumn(2).setPreferredWidth(25);
            tbDataDosen.getColumnModel().getColumn(3).setPreferredWidth(75);
            tbDataDosen.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbDataDosen.getColumnModel().getColumn(5).setPreferredWidth(150);
            tbDataDosen.getColumnModel().getColumn(6).setPreferredWidth(300);
            tbDataDosen.getColumnModel().getColumn(7).setPreferredWidth(150);
            tbDataDosen.getColumnModel().getColumn(8).setPreferredWidth(75);
            tbDataDosen.getColumnModel().getColumn(9).setPreferredWidth(250);
            tbDataDosen.getColumnModel().getColumn(10).setPreferredWidth(25);
            tbDataDosen.getColumnModel().getColumn(11).setPreferredWidth(75);
            tbDataDosen.getColumnModel().getColumn(12).setPreferredWidth(75);
            tbDataDosen.getColumnModel().getColumn(13).setPreferredWidth(150);
            tbDataDosen.getColumnModel().getColumn(14).setPreferredWidth(300);
            tbDataDosen.getColumnModel().getColumn(15).setPreferredWidth(150);
            tbDataDosen.getColumnModel().getColumn(16).setPreferredWidth(75);
            tbDataDosen.getColumnModel().getColumn(17).setPreferredWidth(250);
            tbDataDosen.getColumnModel().getColumn(18).setPreferredWidth(250);
    }
    
    public void aksiSimpan(){
        if(txtNIK.getText().equals("") || txtKdDosen.getText().equals("") || txtNIP.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Mohon lengkapi data",
                    "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }else{
            dosen.isUpdate = !btnSimpan.getText().equals("Simpan");
            dosen.nik = txtNIK.getText();
            dosen.kd_dosen = txtKdDosen.getText();
            dosen.nip = txtNIP.getText();
            dosen.nama_pegawai = txtNamaPegawai.getText();
            if(rbLk.isSelected()){
                dosen.jk = "L";
            }else{
                dosen.jk = "P";
            }
            dosen.tmp_lahir = txtTmpLahir.getText();
            dosen.tgl_lahir = dosen.tglinput.format(dtTglLahir.getDate());
            dosen.agama = cmbAgama.getSelectedItem().toString();
            dosen.alamat = epAlamat.getText();
            dosen.no_telepon1 = txtNoTelp1.getText();
            dosen.no_telepon2 = txtNoTelp2.getText();
            dosen.email = txtEmail.getText();
            dosen.tmt = dosen.tglinput.format(dtTmt.getDate());
            dosen.nama_ibu = txtNamaIbu.getText();
            dosen.sta_menikah = cmbStaMenikah.getSelectedItem().toString();
            dosen.jml_tanggungan = Integer.parseInt(txtJmlTanggungan.getText());
            dosen.sta_pegawai = cmbStaPegawai.getSelectedItem().toString(); 
            dosen.sta_aktif = cmbStaAktif.getSelectedItem().toString();
            dosen.pass = txtPass.getText();
            
            dosen.insert_update();
            if(btnSimpan.getText().equals("Ubah")){
                JOptionPane.showMessageDialog(this, "Data berhasil diubah",
                    "Informasi", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this, "Data berhasil disimpan",
                    "Informasi", JOptionPane.INFORMATION_MESSAGE);
            }
            
            clearInput(); disableInput(); showDataDosen();
        }

    }
    
    public void aksiHapus(){
        if(txtNIK.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Informasi",
                    "Anda belum memilih data yang akan dihapus", JOptionPane.INFORMATION_MESSAGE);
        }else{
            int jawab = JOptionPane.showConfirmDialog(this, "Apakah Anda akan menghapus data ini? Kode "+dosen.nik,
                    "Konfirmasi",JOptionPane.YES_NO_OPTION);
            if(jawab == JOptionPane.YES_OPTION){
                dosen.delete(dosen.nik);
                JOptionPane.showMessageDialog(this, "Data berhasil dihapus",
                        "Informasi", JOptionPane.INFORMATION_MESSAGE);
                clearInput(); 
                disableInput(); 
                showDataDosen();
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        JK = new javax.swing.ButtonGroup();
        txtEmail1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        panelAlpha21 = new com.app.siakad.views.PanelAlpha2();
        txtNIK = new javax.swing.JTextField();
        txtKdDosen = new javax.swing.JTextField();
        txtNIP = new javax.swing.JTextField();
        txtNamaPegawai = new javax.swing.JTextField();
        txtTmpLahir = new javax.swing.JTextField();
        dtTglLahir = new com.toedter.calendar.JDateChooser();
        jScrollPane4 = new javax.swing.JScrollPane();
        epAlamat = new javax.swing.JEditorPane();
        jPanel3 = new javax.swing.JPanel();
        rbLk = new javax.swing.JRadioButton();
        rbPerempuan = new javax.swing.JRadioButton();
        txtNoTelp1 = new javax.swing.JTextField();
        txtNoTelp2 = new javax.swing.JTextField();
        dtTmt = new com.toedter.calendar.JDateChooser();
        txtNamaIbu = new javax.swing.JTextField();
        cmbStaMenikah = new javax.swing.JComboBox<>();
        txtJmlTanggungan = new javax.swing.JTextField();
        cmbStaPegawai = new javax.swing.JComboBox<>();
        txtEmail = new javax.swing.JTextField();
        cmbStaAktif = new javax.swing.JComboBox<>();
        cmbAgama = new javax.swing.JComboBox<>();
        txtPass = new javax.swing.JPasswordField();
        panelAlpha22 = new com.app.siakad.views.PanelAlpha2();
        btnTambah = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        panelAlpha23 = new com.app.siakad.views.PanelAlpha2();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbDataDosen = new javax.swing.JTable();
        lblRecord = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        txtEmail1.setForeground(new java.awt.Color(255, 255, 255));
        txtEmail1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Email", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        txtEmail1.setOpaque(false);

        setClosable(true);
        setTitle("Apekido v1.0");
        setAutoscrolls(true);
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/siakad/icons/desktop_22651 (1).png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setToolTipText("");

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/siakad/icons/logo-medium.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("APLIKASI PENILAIAN KINERJA DOSEN");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("AKADEMI KOMUNITAS NEGERI KAJEN");

        panelAlpha21.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Form Dosen :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        txtNIK.setForeground(new java.awt.Color(255, 255, 255));
        txtNIK.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "NIK", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        txtNIK.setOpaque(false);
        txtNIK.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNIKKeyTyped(evt);
            }
        });

        txtKdDosen.setForeground(new java.awt.Color(255, 255, 255));
        txtKdDosen.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Kode Dosen", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        txtKdDosen.setOpaque(false);
        txtKdDosen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtKdDosenKeyTyped(evt);
            }
        });

        txtNIP.setForeground(new java.awt.Color(255, 255, 255));
        txtNIP.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "NIP", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        txtNIP.setOpaque(false);
        txtNIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNIPActionPerformed(evt);
            }
        });
        txtNIP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNIPKeyTyped(evt);
            }
        });

        txtNamaPegawai.setForeground(new java.awt.Color(255, 255, 255));
        txtNamaPegawai.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Nama Pegawai", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        txtNamaPegawai.setOpaque(false);
        txtNamaPegawai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNamaPegawaiKeyTyped(evt);
            }
        });

        txtTmpLahir.setForeground(new java.awt.Color(255, 255, 255));
        txtTmpLahir.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Tempat Lahir", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        txtTmpLahir.setOpaque(false);
        txtTmpLahir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTmpLahirActionPerformed(evt);
            }
        });
        txtTmpLahir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTmpLahirKeyTyped(evt);
            }
        });

        dtTglLahir.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Tanggal Lahir", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        dtTglLahir.setOpaque(false);

        jScrollPane4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Alamat", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jScrollPane4.setOpaque(false);

        epAlamat.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        epAlamat.setOpaque(false);
        jScrollPane4.setViewportView(epAlamat);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Jenis Kelamin", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel3.setOpaque(false);

        JK.add(rbLk);
        rbLk.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        rbLk.setForeground(new java.awt.Color(255, 255, 255));
        rbLk.setText("Laki - laki");
        rbLk.setOpaque(false);

        JK.add(rbPerempuan);
        rbPerempuan.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        rbPerempuan.setForeground(new java.awt.Color(255, 255, 255));
        rbPerempuan.setText("Perempuan");
        rbPerempuan.setOpaque(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(rbLk, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbPerempuan)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbLk, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbPerempuan, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtNoTelp1.setForeground(new java.awt.Color(255, 255, 255));
        txtNoTelp1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "No. Telepon 1", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        txtNoTelp1.setOpaque(false);
        txtNoTelp1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNoTelp1KeyTyped(evt);
            }
        });

        txtNoTelp2.setForeground(new java.awt.Color(255, 255, 255));
        txtNoTelp2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "No. Telepon 2", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        txtNoTelp2.setOpaque(false);
        txtNoTelp2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNoTelp2KeyTyped(evt);
            }
        });

        dtTmt.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Tanggal Masuk Tugas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        dtTmt.setOpaque(false);

        txtNamaIbu.setForeground(new java.awt.Color(255, 255, 255));
        txtNamaIbu.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Nama Ibu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        txtNamaIbu.setOpaque(false);
        txtNamaIbu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNamaIbuKeyTyped(evt);
            }
        });

        cmbStaMenikah.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        cmbStaMenikah.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih --", "Belum Menikah", "Menikah", "Pernah Menikah" }));
        cmbStaMenikah.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Status Menikah", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        cmbStaMenikah.setOpaque(false);

        txtJmlTanggungan.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        txtJmlTanggungan.setForeground(new java.awt.Color(255, 255, 255));
        txtJmlTanggungan.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Jumlah tanggungan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        txtJmlTanggungan.setOpaque(false);
        txtJmlTanggungan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtJmlTanggunganKeyTyped(evt);
            }
        });

        cmbStaPegawai.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        cmbStaPegawai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih --", "PNS", "Kontrak" }));
        cmbStaPegawai.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Status Pegawai", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        cmbStaPegawai.setOpaque(false);

        txtEmail.setForeground(new java.awt.Color(255, 255, 255));
        txtEmail.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Email", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        txtEmail.setOpaque(false);
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmailKeyTyped(evt);
            }
        });

        cmbStaAktif.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        cmbStaAktif.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih --", "Aktif", "Cuti", "MD", "Pensiun", "Meninggal" }));
        cmbStaAktif.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Status Aktif", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        cmbStaAktif.setOpaque(false);

        cmbAgama.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        cmbAgama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih --", "Islam", "Kristen", "Hindu", "Budha" }));
        cmbAgama.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Agama", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        cmbAgama.setOpaque(false);

        txtPass.setForeground(new java.awt.Color(255, 255, 255));
        txtPass.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        txtPass.setOpaque(false);

        javax.swing.GroupLayout panelAlpha21Layout = new javax.swing.GroupLayout(panelAlpha21);
        panelAlpha21.setLayout(panelAlpha21Layout);
        panelAlpha21Layout.setHorizontalGroup(
            panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlpha21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                    .addGroup(panelAlpha21Layout.createSequentialGroup()
                        .addComponent(txtNIK, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtKdDosen, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNIP)
                    .addComponent(txtNamaIbu, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelAlpha21Layout.createSequentialGroup()
                        .addGroup(panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbAgama, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbStaMenikah, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtJmlTanggungan, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                            .addComponent(txtNoTelp1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNoTelp2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbStaPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtNamaPegawai))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTmpLahir)
                    .addComponent(txtEmail)
                    .addComponent(cmbStaAktif, 0, 172, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dtTglLahir, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                    .addComponent(dtTmt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPass))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelAlpha21Layout.setVerticalGroup(
            panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlpha21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNIK)
                        .addComponent(txtKdDosen)
                        .addComponent(txtNIP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNamaPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTmpLahir))
                    .addComponent(dtTglLahir, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAlpha21Layout.createSequentialGroup()
                        .addGroup(panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtNoTelp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNoTelp2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbAgama, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(dtTmt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPass, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtNamaIbu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbStaMenikah, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtJmlTanggungan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbStaPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbStaAktif, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        panelAlpha22.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Navigasi : ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        btnTambah.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        btnTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/siakad/icons/icons8_Add_List_20px.png"))); // NOI18N
        btnTambah.setText("Tambah");
        btnTambah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnSimpan.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/siakad/icons/icons8_Save_as_20px.png"))); // NOI18N
        btnSimpan.setText("Simpan");
        btnSimpan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnHapus.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/siakad/icons/icons8_Delete_File_20px.png"))); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAlpha22Layout = new javax.swing.GroupLayout(panelAlpha22);
        panelAlpha22.setLayout(panelAlpha22Layout);
        panelAlpha22Layout.setHorizontalGroup(
            panelAlpha22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlpha22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnTambah)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSimpan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHapus)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelAlpha22Layout.setVerticalGroup(
            panelAlpha22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlpha22Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(panelAlpha22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Tabel Dosen : Klik 2x pada tabel untuk mengubah / menghapus data", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setOpaque(false);

        tbDataDosen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "NIK", "Kode Dosen", "NIP", "Nama Pegawai", "Tmp Lahir", "Tgl Lahir", "Alamat", "Jns Kel", "Agama", "No. Tlp 1", "No. Tlp 2", "Email", "Tmt", "Nama Ibu", "Sta Menikah", "Jml Tanggungan", "Sta Pegawai", "Sta Aktif"
            }
        ));
        tbDataDosen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDataDosenMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbDataDosen);

        jScrollPane1.setViewportView(jScrollPane3);

        lblRecord.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        lblRecord.setForeground(new java.awt.Color(255, 255, 255));
        lblRecord.setText("Record : 0");

        javax.swing.GroupLayout panelAlpha23Layout = new javax.swing.GroupLayout(panelAlpha23);
        panelAlpha23.setLayout(panelAlpha23Layout);
        panelAlpha23Layout.setHorizontalGroup(
            panelAlpha23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlpha23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAlpha23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1380, Short.MAX_VALUE)
                    .addGroup(panelAlpha23Layout.createSequentialGroup()
                        .addComponent(lblRecord)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelAlpha23Layout.setVerticalGroup(
            panelAlpha23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlpha23Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRecord)
                .addGap(4, 4, 4))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(420, 420, 420))
                    .addComponent(panelAlpha22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelAlpha23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelAlpha21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelAlpha21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelAlpha22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelAlpha23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTmpLahirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTmpLahirActionPerformed
        
    }//GEN-LAST:event_txtTmpLahirActionPerformed

    private void txtNIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNIPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNIPActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        if(btnTambah.getText().equals("Tambah")){
            clearInput();
            enableInput();
            txtNIK.requestFocus(true);
            btnTambah.setText("Batal");
            btnTambah.setIcon(new javax.swing.ImageIcon(getClass().
                    getResource("/com/app/siakad/icons/btn_delete.png")));
        }else{
            clearInput();
            disableInput();
            btnTambah.setText("Tambah");
            btnTambah.setIcon(new javax.swing.ImageIcon(getClass().
                    getResource("/com/app/siakad/icons/icons8_Add_List_20px.png")));
            btnSimpan.setText("Simpan");
            btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().
                    getResource("/com/app/siakad/icons/icons8_Save_as_20px.png")));
            
        }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        aksiHapus();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        aksiSimpan();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void tbDataDosenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDataDosenMouseClicked
            if(evt.getClickCount() == 2){
            int row = tbDataDosen.getSelectedRow();
            dosen.nik = tbDataDosen.getValueAt(row, 0).toString();
            dosen.kd_dosen = tbDataDosen.getValueAt(row, 1).toString();
            dosen.nip = tbDataDosen.getValueAt(row, 2).toString();
            dosen.nama_pegawai = tbDataDosen.getValueAt(row, 3).toString();
            dosen.jk = tbDataDosen.getValueAt(row, 4).toString();
            dosen.tmp_lahir = tbDataDosen.getValueAt(row, 5).toString();
            dosen.tgl_lahir =  tbDataDosen.getValueAt(row, 6).toString();
            dosen.agama = tbDataDosen.getValueAt(row, 7).toString();
            dosen.alamat = tbDataDosen.getValueAt(row, 8).toString();
            dosen.no_telepon1 = tbDataDosen.getValueAt(row, 9).toString();
            dosen.no_telepon2 = tbDataDosen.getValueAt(row, 10).toString();
            dosen.email = tbDataDosen.getValueAt(row, 11).toString();
            dosen.tmt = tbDataDosen.getValueAt(row, 12).toString();
            dosen.nama_ibu = tbDataDosen.getValueAt(row, 13).toString();
            dosen.sta_menikah = tbDataDosen.getValueAt(row, 14).toString();
            dosen.jml_tanggungan = Integer.parseInt(tbDataDosen.getValueAt(row, 15).toString());
            dosen.sta_pegawai = tbDataDosen.getValueAt(row, 16).toString();
            dosen.sta_aktif = tbDataDosen.getValueAt(row, 17).toString();
            dosen.pass = tbDataDosen.getValueAt(row, 18).toString();
            
            txtNIK.setText(dosen.nik);
            txtKdDosen.setText(dosen.kd_dosen);
            txtNIP.setText(dosen.nip);
            txtNamaPegawai.setText(dosen.nama_pegawai);
            if(dosen.jk.equals("L")){
                rbLk.setSelected(true);
            }else{
                rbPerempuan.setSelected(true);
            }
            txtTmpLahir.setText(dosen.tmp_lahir);
            //dtTglLahir.setDate(new java.sql.Date(dosen.tglinput));
            cmbAgama.setSelectedItem(dosen.agama);
            epAlamat.setText(dosen.alamat);
            txtNoTelp1.setText(dosen.no_telepon1);
            txtNoTelp2.setText(dosen.no_telepon2);
            txtEmail.setText(dosen.email);
            //tTmt.setDate(new Date(dosen.tmt));
            txtNamaIbu.setText(dosen.nama_ibu);
            cmbStaMenikah.setSelectedItem(dosen.sta_menikah);
            txtJmlTanggungan.setText(Integer.toString(dosen.jml_tanggungan));
            cmbStaPegawai.setSelectedItem(dosen.sta_pegawai);
            cmbStaAktif.setSelectedItem(dosen.sta_aktif);
            txtPass.setText(dosen.pass);
            
            txtNIK.setEditable(false);
            btnHapus.setEnabled(true);
            btnSimpan.setEnabled(true);
            btnSimpan.setText("Ubah");
            btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/siakad/icons/update.png")));
            enableInput();
            
        }        
    }//GEN-LAST:event_tbDataDosenMouseClicked

    private void txtNIKKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNIKKeyTyped
        char enter=evt.getKeyChar();
        if(txtNIK.getText().length()==9){
            evt.consume();
        }else if(!(Character.isDigit(enter))){//hanya bisa input angka
            evt.consume();
        }
    }//GEN-LAST:event_txtNIKKeyTyped

    private void txtKdDosenKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKdDosenKeyTyped
        char enter=evt.getKeyChar();
        if(txtKdDosen.getText().length()==6){
            evt.consume();
        }else if(!(Character.isDigit(enter))){//hanya bisa input angka
            evt.consume();
        }
    }//GEN-LAST:event_txtKdDosenKeyTyped

    private void txtNIPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNIPKeyTyped
        char enter=evt.getKeyChar();
        if(txtNIP.getText().length()==9){
            evt.consume();
        }else if(!(Character.isDigit(enter))){//hanya bisa input angka
            evt.consume();
        }
    }//GEN-LAST:event_txtNIPKeyTyped

    private void txtNamaPegawaiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaPegawaiKeyTyped
        char enter=evt.getKeyChar();
        if(txtNamaPegawai.getText().length()==45){
            evt.consume();
        }else if((Character.isDigit(enter))){//hanya bisa input angka
            evt.consume();
        }
    }//GEN-LAST:event_txtNamaPegawaiKeyTyped

    private void txtTmpLahirKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTmpLahirKeyTyped
        char enter=evt.getKeyChar();
        if(txtTmpLahir.getText().length()==25){
            evt.consume();
        }else if((Character.isDigit(enter))){//hanya bisa input angka
            evt.consume();
        }
    }//GEN-LAST:event_txtTmpLahirKeyTyped

    private void txtNamaIbuKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaIbuKeyTyped
        char enter=evt.getKeyChar();
        if(txtNamaIbu.getText().length()==45){
            evt.consume();
        }else if((Character.isDigit(enter))){//hanya bisa input angka
            evt.consume();
        }
    }//GEN-LAST:event_txtNamaIbuKeyTyped

    private void txtNoTelp1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoTelp1KeyTyped
        char enter=evt.getKeyChar();
        if(txtNoTelp1.getText().length()==12){
            evt.consume();
        }else if(!(Character.isDigit(enter))){//hanya bisa input angka
            evt.consume();
        }
    }//GEN-LAST:event_txtNoTelp1KeyTyped

    private void txtNoTelp2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoTelp2KeyTyped
        char enter=evt.getKeyChar();
        if(txtNoTelp2.getText().length()==12){
            evt.consume();
        }else if(!(Character.isDigit(enter))){//hanya bisa input angka
            evt.consume();
        }
    }//GEN-LAST:event_txtNoTelp2KeyTyped

    private void txtEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyTyped
        char enter=evt.getKeyChar();
        if(txtEmail.getText().length()==30){
            evt.consume();
        }
    }//GEN-LAST:event_txtEmailKeyTyped

    private void txtJmlTanggunganKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJmlTanggunganKeyTyped
        char enter=evt.getKeyChar();
        if(txtJmlTanggungan.getText().length()==2){
            evt.consume();
        }else if(!(Character.isDigit(enter))){//hanya bisa input angka
            evt.consume();
        }
    }//GEN-LAST:event_txtJmlTanggunganKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup JK;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JComboBox<String> cmbAgama;
    private javax.swing.JComboBox<String> cmbStaAktif;
    private javax.swing.JComboBox<String> cmbStaMenikah;
    private javax.swing.JComboBox<String> cmbStaPegawai;
    private com.toedter.calendar.JDateChooser dtTglLahir;
    private com.toedter.calendar.JDateChooser dtTmt;
    private javax.swing.JEditorPane epAlamat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblRecord;
    private com.app.siakad.views.PanelAlpha2 panelAlpha21;
    private com.app.siakad.views.PanelAlpha2 panelAlpha22;
    private com.app.siakad.views.PanelAlpha2 panelAlpha23;
    private javax.swing.JRadioButton rbLk;
    private javax.swing.JRadioButton rbPerempuan;
    private javax.swing.JTable tbDataDosen;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmail1;
    private javax.swing.JTextField txtJmlTanggungan;
    private javax.swing.JTextField txtKdDosen;
    private javax.swing.JTextField txtNIK;
    private javax.swing.JTextField txtNIP;
    private javax.swing.JTextField txtNamaIbu;
    private javax.swing.JTextField txtNamaPegawai;
    private javax.swing.JTextField txtNoTelp1;
    private javax.swing.JTextField txtNoTelp2;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtTmpLahir;
    // End of variables declaration//GEN-END:variables
}
