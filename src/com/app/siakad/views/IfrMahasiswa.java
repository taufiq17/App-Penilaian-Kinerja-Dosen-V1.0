/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.siakad.views;

import com.app.siakad.database.AutoFitTableColumns;
import com.app.siakad.entities.Mahasiswa;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class IfrMahasiswa extends javax.swing.JInternalFrame {
       Mahasiswa mahasiswa = new Mahasiswa();
   
    public IfrMahasiswa() {
        initComponents();
        
          clearInput(); disableInput(); setTabelMhs(); showDataMhs(); formTengah();
    }
    
    public void clearInput(){
        txtNIM.setText("");
        txtKdProdi.setText("");
        txtIdTa.setText("");
        txtNamaMhs.setText("");
        txtTmpLahir.setText("");
        dtTglLahir.setDate(new Date());
        epAlamat.setText("");
        rbLk.setText("Laki-laki");
        rbPerempuan.setText("Perempuan");
        cmbAgama.setSelectedIndex(0);
        txtNoTelp.setText("");
        txtNamaAyah.setText("");
        txtNamaIbu.setText("");
        txtStaMhs.setText("");
        txtPkjAyah.setText("");
        txtPkjIbu.setText("");
        txtPenghAyah.setText("");
        txtPenghIbu.setText("");
        txtStaMhs.setText("");
        txtPass.setText("");
        btnTambah.setText("Tambah");
        btnSimpan.setText("Simpan");
        btnTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/siakad/icons/icons8_Add_List_20px.png")));
    }
    
    public void disableInput(){
        txtNIM.setEnabled(false);
        txtKdProdi.setEnabled(false);
        txtIdTa.setEnabled(false);
        txtNamaMhs.setEnabled(false);
        txtTmpLahir.setEnabled(false);
        dtTglLahir.setEnabled(false);
        epAlamat.setEnabled(false);
        rbLk.setEnabled(false);
        rbPerempuan.setEnabled(false);
        cmbAgama.setEnabled(false);
        txtNoTelp.setEnabled(false);
        txtNamaAyah.setEnabled(false);
        txtNamaIbu.setEnabled(false);
        txtStaMhs.setEnabled(false);
        txtPkjAyah.setEnabled(false);
        txtPkjIbu.setEnabled(false);
        txtPenghAyah.setEnabled(false);
        txtPenghIbu.setEnabled(false);
        txtStaMhs.setEnabled(false);
        txtPass.setEnabled(false);
        btnSimpan.setEnabled(false);
        btnHapus.setEnabled(false);
    }
    
    public void enableInput(){
        txtNIM.setEnabled(true);
        txtKdProdi.setEnabled(true);
        txtIdTa.setEnabled(true);
        txtNamaMhs.setEnabled(true);
        txtTmpLahir.setEnabled(true);
        dtTglLahir.setEnabled(true);
        epAlamat.setEnabled(true);
        rbLk.setEnabled(true);
        rbPerempuan.setEnabled(true);
        cmbAgama.setEnabled(true);
        txtNoTelp.setEnabled(true);
        txtNamaAyah.setEnabled(true);
        txtNamaIbu.setEnabled(true);
        txtStaMhs.setEnabled(true);
        txtPkjAyah.setEnabled(true);
        txtPkjIbu.setEnabled(true);
        txtPenghAyah.setEnabled(true);
        txtPenghIbu.setEnabled(true);
        txtStaMhs.setEnabled(true);
        txtPass.setEnabled(true);
        btnSimpan.setEnabled(true);
    }
    
    public void showDataMhs(){
        tbDataMhs.setModel(mahasiswa.tblmahasiswa);
        int row = mahasiswa.tblmahasiswa.getRowCount();
        for(int i=0; i<row; i++){
            mahasiswa.tblmahasiswa.removeRow(0);//mengosongkan isi tabel
        }
        mahasiswa.select();//utk memanggil method select
        mahasiswa.list.forEach((obj) -> {
            mahasiswa.tblmahasiswa.addRow((Object[]) obj);
        });
        tbDataMhs.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        AutoFitTableColumns tca = new AutoFitTableColumns(tbDataMhs);
        tca.adjustColumns();
        lblRecord.setText("Record : " + tbDataMhs.getRowCount());
    }
    
    public void setTabelMhs(){
        String[] kolom1 = {"NIM", "KD. Prodi", "ID. TA", "Nama Mhs", "Tmp Lahir", "Tgl Lahir",
            "Alamat", "Jns Kel", "Agama", "No. Tlp", "Nama Ayah", "Nama Ibu", "Pkj Ayah",
            "Pkj Ibu","Penghasilan Ayah","Penghasilan Ibu","Sta Mahasiswa","Pass"};
        mahasiswa.tblmahasiswa = new DefaultTableModel(null, kolom1){
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
                java.lang.String.class
                
            };
            public Class getColumnClass(int columnIndex){
            return types [columnIndex];
        }
            
        //agar tabel tdk bisa diedit
        public boolean isCellEditable(int row, int col){
            int cola = mahasiswa.tblmahasiswa.getColumnCount();
            return (col < cola) ? false : true;
        }
       };
        tbDataMhs.setModel(mahasiswa.tblmahasiswa);
            tbDataMhs.getColumnModel().getColumn(0).setPreferredWidth(75);
            tbDataMhs.getColumnModel().getColumn(1).setPreferredWidth(250);
            tbDataMhs.getColumnModel().getColumn(2).setPreferredWidth(25);
            tbDataMhs.getColumnModel().getColumn(3).setPreferredWidth(75);
            tbDataMhs.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbDataMhs.getColumnModel().getColumn(5).setPreferredWidth(150);
            tbDataMhs.getColumnModel().getColumn(6).setPreferredWidth(300);
            tbDataMhs.getColumnModel().getColumn(7).setPreferredWidth(150);
            tbDataMhs.getColumnModel().getColumn(8).setPreferredWidth(75);
            tbDataMhs.getColumnModel().getColumn(9).setPreferredWidth(250);
            tbDataMhs.getColumnModel().getColumn(10).setPreferredWidth(25);
            tbDataMhs.getColumnModel().getColumn(11).setPreferredWidth(75);
            tbDataMhs.getColumnModel().getColumn(12).setPreferredWidth(75);
            tbDataMhs.getColumnModel().getColumn(13).setPreferredWidth(150);
            tbDataMhs.getColumnModel().getColumn(14).setPreferredWidth(300);
            tbDataMhs.getColumnModel().getColumn(15).setPreferredWidth(150);
            tbDataMhs.getColumnModel().getColumn(16).setPreferredWidth(75);
            tbDataMhs.getColumnModel().getColumn(17).setPreferredWidth(250);
    }
    
    public void aksiSimpan(){
        if(txtNIM.getText().equals("") || txtKdProdi.getText().equals("") || txtIdTa.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Mohon lengkapi data",
                    "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }else{
            mahasiswa.isUpdate = !btnSimpan.getText().equals("Simpan");
            mahasiswa.nim = txtNIM.getText();
            mahasiswa.kd_prodi = txtKdProdi.getText();
            mahasiswa.id_ta = Integer.parseInt(txtIdTa.getText());
            mahasiswa.nama_mhs = txtNamaMhs.getText();
            mahasiswa.tmp_lahir = txtTmpLahir.getText();
            mahasiswa.tgl_lahir = mahasiswa.tglinput.format(dtTglLahir.getDate());
            mahasiswa.alamat = epAlamat.getText();
            if(rbLk.isSelected()){
                mahasiswa.jns_kel = "L";
            }else{
                mahasiswa.jns_kel = "P";
            }
            mahasiswa.agama = cmbAgama.getSelectedItem().toString();
            mahasiswa.no_telp = txtNoTelp.getText();
            mahasiswa.nama_ayah = txtNamaAyah.getText();
            mahasiswa.nama_ibu = txtNamaIbu.getText();
            mahasiswa.pkj_ayah = txtPkjAyah.getText();
            mahasiswa.pkj_ibu = txtPkjIbu.getText();
            mahasiswa.peng_ayah = Double.parseDouble(txtPenghAyah.getText());
            mahasiswa.peng_ibu = Double.parseDouble(txtPenghIbu.getText());
            mahasiswa.sta_mhs = Integer.parseInt(txtStaMhs.getText());
            mahasiswa.pass = txtPass.getText();
            mahasiswa.insert_update();
            if(btnSimpan.getText().equals("Ubah")){
                JOptionPane.showMessageDialog(this, "Data berhasil diubah",
                    "Informasi", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this, "Data berhasil disimpan",
                    "Informasi", JOptionPane.INFORMATION_MESSAGE);
            }
            clearInput(); disableInput(); showDataMhs();
        }
    }
    
    public void aksiHapus(){
        if(txtNIM.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Informasi",
                    "Anda belum memilih data yang akan dihapus", JOptionPane.INFORMATION_MESSAGE);
        }else{
            int jawab = JOptionPane.showConfirmDialog(this, "Apakah Anda akan menghapus data ini? Kode "+mahasiswa.nim,
                    "Konfirmasi",JOptionPane.YES_NO_OPTION);
            if(jawab == JOptionPane.YES_OPTION){
                mahasiswa.delete(mahasiswa.nim);
                JOptionPane.showMessageDialog(this, "Data berhasil dihapus",
                        "Informasi", JOptionPane.INFORMATION_MESSAGE);
                clearInput(); 
                disableInput(); 
                showDataMhs();
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
        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        panelAlpha21 = new com.app.siakad.views.PanelAlpha2();
        txtNIM = new javax.swing.JTextField();
        txtIdTa = new javax.swing.JTextField();
        txtNamaMhs = new javax.swing.JTextField();
        txtTmpLahir = new javax.swing.JTextField();
        dtTglLahir = new com.toedter.calendar.JDateChooser();
        jScrollPane4 = new javax.swing.JScrollPane();
        epAlamat = new javax.swing.JEditorPane();
        jPanel3 = new javax.swing.JPanel();
        rbLk = new javax.swing.JRadioButton();
        rbPerempuan = new javax.swing.JRadioButton();
        txtNamaAyah = new javax.swing.JTextField();
        txtNamaIbu = new javax.swing.JTextField();
        txtPenghIbu = new javax.swing.JTextField();
        txtPkjIbu = new javax.swing.JTextField();
        txtNoTelp = new javax.swing.JTextField();
        txtStaMhs = new javax.swing.JTextField();
        txtPenghAyah = new javax.swing.JTextField();
        cmbAgama = new javax.swing.JComboBox<>();
        txtPass = new javax.swing.JPasswordField();
        txtPkjAyah = new javax.swing.JTextField();
        txtKdProdi = new javax.swing.JTextField();
        panelAlpha22 = new com.app.siakad.views.PanelAlpha2();
        btnTambah = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        panelAlpha23 = new com.app.siakad.views.PanelAlpha2();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbDataMhs = new javax.swing.JTable();
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

        setClosable(true);
        setMaximizable(true);
        setTitle("Apekido v1.0");
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

        panelAlpha21.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Form Mahasiswa :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        txtNIM.setForeground(new java.awt.Color(255, 255, 255));
        txtNIM.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "NIM", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        txtNIM.setOpaque(false);
        txtNIM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNIMActionPerformed(evt);
            }
        });
        txtNIM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNIMKeyTyped(evt);
            }
        });

        txtIdTa.setForeground(new java.awt.Color(255, 255, 255));
        txtIdTa.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "ID. TA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        txtIdTa.setOpaque(false);
        txtIdTa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdTaKeyTyped(evt);
            }
        });

        txtNamaMhs.setForeground(new java.awt.Color(255, 255, 255));
        txtNamaMhs.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Nama Mahasiswa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        txtNamaMhs.setOpaque(false);
        txtNamaMhs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNamaMhsKeyTyped(evt);
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

        rbLk.setForeground(new java.awt.Color(255, 255, 255));
        rbLk.setText("Laki - laki");
        rbLk.setOpaque(false);

        rbPerempuan.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        rbPerempuan.setForeground(new java.awt.Color(255, 255, 255));
        rbPerempuan.setText("Perempuan");
        rbPerempuan.setOpaque(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbLk)
                    .addComponent(rbPerempuan))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(rbLk, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(rbPerempuan)
                .addContainerGap())
        );

        txtNamaAyah.setForeground(new java.awt.Color(255, 255, 255));
        txtNamaAyah.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Nama Ayah", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        txtNamaAyah.setOpaque(false);
        txtNamaAyah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNamaAyahKeyTyped(evt);
            }
        });

        txtNamaIbu.setForeground(new java.awt.Color(255, 255, 255));
        txtNamaIbu.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Nama Ibu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        txtNamaIbu.setOpaque(false);
        txtNamaIbu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNamaIbuKeyTyped(evt);
            }
        });

        txtPenghIbu.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        txtPenghIbu.setForeground(new java.awt.Color(255, 255, 255));
        txtPenghIbu.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Penghasilan Ibu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        txtPenghIbu.setOpaque(false);
        txtPenghIbu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPenghIbuKeyTyped(evt);
            }
        });

        txtPkjIbu.setForeground(new java.awt.Color(255, 255, 255));
        txtPkjIbu.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Pekerjaan Ibu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        txtPkjIbu.setOpaque(false);
        txtPkjIbu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPkjIbuKeyTyped(evt);
            }
        });

        txtNoTelp.setForeground(new java.awt.Color(255, 255, 255));
        txtNoTelp.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "No. Telepon ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        txtNoTelp.setOpaque(false);
        txtNoTelp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNoTelpKeyTyped(evt);
            }
        });

        txtStaMhs.setForeground(new java.awt.Color(255, 255, 255));
        txtStaMhs.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Status Mahasiswa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        txtStaMhs.setOpaque(false);
        txtStaMhs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStaMhsKeyTyped(evt);
            }
        });

        txtPenghAyah.setForeground(new java.awt.Color(255, 255, 255));
        txtPenghAyah.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Penghasilan Ayah", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        txtPenghAyah.setOpaque(false);
        txtPenghAyah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPenghAyahKeyTyped(evt);
            }
        });

        cmbAgama.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        cmbAgama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih --", "Islam", "Kristen", "Hindu", "Budha" }));
        cmbAgama.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Agama", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        cmbAgama.setOpaque(false);

        txtPass.setForeground(new java.awt.Color(255, 255, 255));
        txtPass.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        txtPass.setOpaque(false);

        txtPkjAyah.setForeground(new java.awt.Color(255, 255, 255));
        txtPkjAyah.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Pekerjaan Ayah", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        txtPkjAyah.setOpaque(false);
        txtPkjAyah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPkjAyahKeyTyped(evt);
            }
        });

        txtKdProdi.setForeground(new java.awt.Color(255, 255, 255));
        txtKdProdi.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "KD. Prodi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        txtKdProdi.setOpaque(false);
        txtKdProdi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtKdProdiKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panelAlpha21Layout = new javax.swing.GroupLayout(panelAlpha21);
        panelAlpha21.setLayout(panelAlpha21Layout);
        panelAlpha21Layout.setHorizontalGroup(
            panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlpha21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelAlpha21Layout.createSequentialGroup()
                        .addComponent(txtNIM, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtKdProdi))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAlpha21Layout.createSequentialGroup()
                        .addGroup(panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPenghAyah))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtPenghIbu)
                            .addComponent(txtNamaIbu, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbAgama, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelAlpha21Layout.createSequentialGroup()
                        .addComponent(txtIdTa, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNamaMhs)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(panelAlpha21Layout.createSequentialGroup()
                            .addComponent(txtTmpLahir, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(dtTglLahir, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelAlpha21Layout.createSequentialGroup()
                            .addComponent(txtNoTelp, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtNamaAyah, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelAlpha21Layout.createSequentialGroup()
                            .addComponent(txtPkjAyah, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtPkjIbu)))
                    .addGroup(panelAlpha21Layout.createSequentialGroup()
                        .addComponent(txtStaMhs, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36))
        );
        panelAlpha21Layout.setVerticalGroup(
            panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlpha21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dtTglLahir, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNIM)
                        .addComponent(txtIdTa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNamaMhs, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTmpLahir)
                        .addComponent(txtKdProdi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(3, 3, 3)
                .addGroup(panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelAlpha21Layout.createSequentialGroup()
                        .addGroup(panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAlpha21Layout.createSequentialGroup()
                                .addComponent(cmbAgama, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNamaIbu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPkjIbu)
                                    .addComponent(txtPkjAyah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelAlpha21Layout.createSequentialGroup()
                                .addGroup(panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNoTelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNamaAyah, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPenghIbu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPenghAyah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStaMhs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(22, Short.MAX_VALUE))
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

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Tabel Mahasiswa : Klik 2x pada tabel untuk mengubah / menghapus data", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setOpaque(false);

        tbDataMhs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "NIM", "KD. Prodi", "ID. TA", "Nm Mhs", "Tmp Lahir", "Tgl Lahir", "Alamat", "Jns Kel", "Agama", "No. Telp", "Nama Ayah", "Nama Ibu", "Pek. Ayah", "Pek. Ibu", "Penghasilan Ayah", "Penghasilan Ibu", "Sta Mhs", "Password"
            }
        ));
        tbDataMhs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDataMhsMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbDataMhs);

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
                    .addGroup(panelAlpha23Layout.createSequentialGroup()
                        .addComponent(lblRecord)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        panelAlpha23Layout.setVerticalGroup(
            panelAlpha23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlpha23Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelAlpha21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 716, Short.MAX_VALUE))
                    .addComponent(panelAlpha22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelAlpha23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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
                .addGap(17, 17, 17)
                .addComponent(panelAlpha22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelAlpha23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

    private void txtTmpLahirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTmpLahirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTmpLahirActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        if(btnTambah.getText().equals("Tambah")){
            clearInput();
            enableInput();
            txtNIM.requestFocus(true);
            btnTambah.setText("Batal");
            btnTambah.setIcon(new javax.swing.ImageIcon(getClass().
                    getResource("/com/app/siakad/icons/btn_delete.png")));
        }else if(btnTambah.getText().equals("Batal")){
            clearInput();
            disableInput();
            btnTambah.setText("Tambah");
            btnTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/siakad/icons/icons8_Add_List_20px.png")));
            btnSimpan.setText("Simpan");
            btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().
                    getResource("/com/app/siakad/icons/icons8_Save_as_20px.png")));
        }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void txtNIMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNIMActionPerformed
        
    }//GEN-LAST:event_txtNIMActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        aksiSimpan();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        aksiHapus();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void tbDataMhsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDataMhsMouseClicked
        if(evt.getClickCount() == 2){
            int row = tbDataMhs.getSelectedRow();
            mahasiswa.nim = tbDataMhs.getValueAt(row, 0).toString();
            mahasiswa.kd_prodi = tbDataMhs.getValueAt(row, 1).toString();
            mahasiswa.id_ta = Integer.parseInt(tbDataMhs.getValueAt(row, 2).toString());
            mahasiswa.nama_mhs = tbDataMhs.getValueAt(row, 3).toString();
            mahasiswa.tmp_lahir = tbDataMhs.getValueAt(row, 4).toString();
            mahasiswa.tgl_lahir = tbDataMhs.getValueAt(row, 5).toString();
            mahasiswa.alamat = tbDataMhs.getValueAt(row, 6).toString();
            mahasiswa.jns_kel = tbDataMhs.getValueAt(row, 7).toString();
            mahasiswa.agama = tbDataMhs.getValueAt(row, 8).toString();
            mahasiswa.no_telp = tbDataMhs.getValueAt(row, 9).toString();
            mahasiswa.nama_ayah = tbDataMhs.getValueAt(row, 10).toString();
            mahasiswa.nama_ibu = tbDataMhs.getValueAt(row, 11).toString();
            mahasiswa.pkj_ayah = tbDataMhs.getValueAt(row, 12).toString();
            mahasiswa.pkj_ibu = tbDataMhs.getValueAt(row, 13).toString();
            mahasiswa.peng_ayah = Double.parseDouble(tbDataMhs.getValueAt(row, 14).toString());
            mahasiswa.peng_ibu = Double.parseDouble(tbDataMhs.getValueAt(row, 15).toString());
            mahasiswa.sta_mhs = Integer.parseInt(tbDataMhs.getValueAt(row, 16).toString());
            mahasiswa.pass = tbDataMhs.getValueAt(row, 17).toString();
            
            txtNIM.setText(mahasiswa.nim);
            txtKdProdi.setText(mahasiswa.kd_prodi);
            txtIdTa.setText(Integer.toString(mahasiswa.id_ta));
            txtNamaMhs.setText(mahasiswa.nama_mhs);
            txtTmpLahir.setText(mahasiswa.tmp_lahir);
            //dtTglLahir.setDate(new java.sql.Date(tglinput));
            epAlamat.setText(mahasiswa.alamat);
            if(mahasiswa.jns_kel.equals("L")){
                rbLk.setSelected(true);
            }else{
                rbPerempuan.setSelected(true);
            }
            cmbAgama.setSelectedItem(mahasiswa.agama);
            txtNoTelp.setText(mahasiswa.no_telp);
            txtNamaAyah.setText(mahasiswa.nama_ayah);
            txtNamaIbu.setText(mahasiswa.nama_ibu);
            txtPkjAyah.setText(mahasiswa.pkj_ayah);
            txtPkjIbu.setText(mahasiswa.pkj_ibu);
            txtPenghAyah.setText(Double.toString(mahasiswa.peng_ayah));
            txtPenghIbu.setText(Double.toString(mahasiswa.peng_ibu));
            txtStaMhs.setText(Integer.toString(mahasiswa.sta_mhs));
            txtPass.setText(mahasiswa.pass);
            
            //txtNIM.setEditable(false);
            btnHapus.setEnabled(true);
            btnSimpan.setEnabled(true);
            btnSimpan.setText("Ubah");
            btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/siakad/icons/update.png")));
            enableInput();
        }
    }//GEN-LAST:event_tbDataMhsMouseClicked

    private void txtNIMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNIMKeyTyped
        char enter=evt.getKeyChar();
        if(txtNIM.getText().length()==9){
            evt.consume();
        }else if(!(Character.isDigit(enter))){//hanya bisa input angka
            evt.consume();
        }
    }//GEN-LAST:event_txtNIMKeyTyped

    private void txtKdProdiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKdProdiKeyTyped
        char enter=evt.getKeyChar();
        if(txtKdProdi.getText().length()==3){
            evt.consume();
        }else if(!(Character.isDigit(enter))){//hanya bisa input angka
            evt.consume();
        }
    }//GEN-LAST:event_txtKdProdiKeyTyped

    private void txtIdTaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdTaKeyTyped
        char enter=evt.getKeyChar();
        if(txtIdTa.getText().length()==4){
            evt.consume();
        }else if(!(Character.isDigit(enter))){//hanya bisa input angka
            evt.consume();
        }
    }//GEN-LAST:event_txtIdTaKeyTyped

    private void txtNamaMhsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaMhsKeyTyped
        char enter=evt.getKeyChar();
        if(txtNamaMhs.getText().length()==50){
            evt.consume();
        }else if((Character.isDigit(enter))){//hanya bisa input angka
            evt.consume();
        }
    }//GEN-LAST:event_txtNamaMhsKeyTyped

    private void txtTmpLahirKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTmpLahirKeyTyped
        char enter=evt.getKeyChar();
        if(txtTmpLahir.getText().length()==25){
            evt.consume();
        }else if((Character.isDigit(enter))){//hanya bisa input angka
            evt.consume();
        }
    }//GEN-LAST:event_txtTmpLahirKeyTyped

    private void txtNoTelpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoTelpKeyTyped
        char enter=evt.getKeyChar();
        if(txtNoTelp.getText().length()==25){
            evt.consume();
        }  
    }//GEN-LAST:event_txtNoTelpKeyTyped

    private void txtNamaAyahKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaAyahKeyTyped
        char enter=evt.getKeyChar();
        if(txtNamaAyah.getText().length()==35){
            evt.consume();
        }else if((Character.isDigit(enter))){//hanya bisa input angka
            evt.consume();
        }
    }//GEN-LAST:event_txtNamaAyahKeyTyped

    private void txtNamaIbuKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaIbuKeyTyped
        char enter=evt.getKeyChar();
        if(txtNamaIbu.getText().length()==35){
            evt.consume();
        }else if((Character.isDigit(enter))){//hanya bisa input angka
            evt.consume();
        }
    }//GEN-LAST:event_txtNamaIbuKeyTyped

    private void txtPkjAyahKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPkjAyahKeyTyped
        char enter=evt.getKeyChar();
        if(txtPkjAyah.getText().length()==25){
            evt.consume();
        }else if((Character.isDigit(enter))){//hanya bisa input angka
            evt.consume();
        }
    }//GEN-LAST:event_txtPkjAyahKeyTyped

    private void txtPkjIbuKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPkjIbuKeyTyped
       char enter=evt.getKeyChar();
        if(txtPkjIbu.getText().length()==25){
            evt.consume();
        }else if((Character.isDigit(enter))){//hanya bisa input angka
            evt.consume();
        }
    }//GEN-LAST:event_txtPkjIbuKeyTyped

    private void txtPenghAyahKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPenghAyahKeyTyped
        char enter=evt.getKeyChar();
        if(txtPenghAyah.getText().length()==20){
            evt.consume();
        }else if(!(Character.isDigit(enter))){//hanya bisa input angka
            evt.consume();
        }
    }//GEN-LAST:event_txtPenghAyahKeyTyped

    private void txtPenghIbuKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPenghIbuKeyTyped
        char enter=evt.getKeyChar();
        if(txtPenghIbu.getText().length()==20){
            evt.consume();
        }else if(!(Character.isDigit(enter))){//hanya bisa input angka
            evt.consume();
        }
    }//GEN-LAST:event_txtPenghIbuKeyTyped

    private void txtStaMhsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStaMhsKeyTyped
        char enter=evt.getKeyChar();
        if(txtStaMhs.getText().length()==4){
            evt.consume();
        }else if(!(Character.isDigit(enter))){//hanya bisa input angka
            evt.consume();
        }
    }//GEN-LAST:event_txtStaMhsKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JComboBox<String> cmbAgama;
    private com.toedter.calendar.JDateChooser dtTglLahir;
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
    private javax.swing.JTable tbDataMhs;
    private javax.swing.JTextField txtIdTa;
    private javax.swing.JTextField txtKdProdi;
    private javax.swing.JTextField txtNIM;
    private javax.swing.JTextField txtNamaAyah;
    private javax.swing.JTextField txtNamaIbu;
    private javax.swing.JTextField txtNamaMhs;
    private javax.swing.JTextField txtNoTelp;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtPenghAyah;
    private javax.swing.JTextField txtPenghIbu;
    private javax.swing.JTextField txtPkjAyah;
    private javax.swing.JTextField txtPkjIbu;
    private javax.swing.JTextField txtStaMhs;
    private javax.swing.JTextField txtTmpLahir;
    // End of variables declaration//GEN-END:variables
}
