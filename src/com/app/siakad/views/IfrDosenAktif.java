
package com.app.siakad.views;

import com.app.siakad.database.AutoFitTableColumns;
import com.app.siakad.entities.Dosen;
import com.app.siakad.entities.DosenAktif;
import com.app.siakad.entities.KriteriaNilai;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class IfrDosenAktif extends javax.swing.JInternalFrame {
 
    DosenAktif dosenaktif = new DosenAktif();
    KriteriaNilai kriteria = new KriteriaNilai();
    
    
    
    
    public IfrDosenAktif() {
        initComponents();
        
        setTabelDosenAktif(); showDataDosenAktif(); setTabelNilai(); showDataNilai(); formTengah();
        jdPenilaianDosen.setSize(1300, 600);
        jdPenilaianDosen.setLocationRelativeTo(this);
    }
    
    
    public void showDataDosenAktif(){
        tbDataDosenAktif.setModel(dosenaktif.tbldosenaktif);
        int row = dosenaktif.tbldosenaktif.getRowCount();
        for(int i=0; i<row; i++){
            dosenaktif.tbldosenaktif.removeRow(0);//mengosongkan isi tabel
        }
        dosenaktif.select();//utk memanggil method select
        dosenaktif.list.forEach((obj) -> {
            dosenaktif.tbldosenaktif.addRow((Object[]) obj);
        });
        tbDataDosenAktif.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        AutoFitTableColumns tca = new AutoFitTableColumns(tbDataDosenAktif);
        tca.adjustColumns();
        lblRecord.setText("Record : " + tbDataDosenAktif.getRowCount());
    }
    
    public void showDataNilai(){
        tbNilaiDosen.setModel(kriteria.tblinputnilai);
        int row = kriteria.tblinputnilai.getRowCount();
        for(int i=0; i<row; i++){
            kriteria.tblinputnilai.removeRow(0);//mengosongkan isi tabel
        }
        kriteria.select_kriteria();//utk memanggil method select
        kriteria.list.forEach((obj) -> {
            kriteria.tblinputnilai.addRow((Object[]) obj);
        });
        tbNilaiDosen.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        AutoFitTableColumns tca = new AutoFitTableColumns(tbNilaiDosen);
        tca.adjustColumns();
        lblRecord.setText("Record : " + tbNilaiDosen.getRowCount());
    }
        
    public void setTabelDosenAktif(){
        String[] kolom1 = {"Kode Dosen","Nama Dosen","Mata Kuliah","SKS Teori","SKS Praktek","Status"};
        dosenaktif.tbldosenaktif = new DefaultTableModel(null, kolom1){
            Class[] types = new Class[]{
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
            int cola = dosenaktif.tbldosenaktif.getColumnCount();
            return (col < cola) ? false : true;
        }
       };
        tbDataDosenAktif.setModel(dosenaktif.tbldosenaktif);
            tbDataDosenAktif.getColumnModel().getColumn(0).setPreferredWidth(75);
            tbDataDosenAktif.getColumnModel().getColumn(1).setPreferredWidth(250);
            tbDataDosenAktif.getColumnModel().getColumn(2).setPreferredWidth(25);
            tbDataDosenAktif.getColumnModel().getColumn(3).setPreferredWidth(75);
            tbDataDosenAktif.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbDataDosenAktif.getColumnModel().getColumn(5).setPreferredWidth(150);
    }
    
    public void setTabelNilai(){
        String[] kolom1 = {"No","Kategori Penilaian","Kode","Kriteria Penilaian","Nilai"};
        kriteria.tblinputnilai = new DefaultTableModel(null, kolom1){
            Class[] types = new Class[]{
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class
                
            };
            public Class getColumnClass(int columnIndex){
            return types [columnIndex];
        }
            
        
       };
        tbNilaiDosen.setModel(kriteria.tblinputnilai);
            tbNilaiDosen.getColumnModel().getColumn(0).setPreferredWidth(75);
            tbNilaiDosen.getColumnModel().getColumn(1).setPreferredWidth(250);
            tbNilaiDosen.getColumnModel().getColumn(2).setPreferredWidth(25);
            tbNilaiDosen.getColumnModel().getColumn(3).setPreferredWidth(75);
   
    }
    
    public void getDataNilai(){
        try{
            dosenaktif.conn=dosenaktif.getConnection();
            dosenaktif.query="select * from mk_jadwalmk a, pg_dosen b where a.kd_dosen=b.kd_dosen";
            dosenaktif.stat=dosenaktif.conn.prepareStatement(dosenaktif.query);
            dosenaktif.res=dosenaktif.stat.executeQuery(dosenaktif.query);
            
            if(dosenaktif.res.first()){
              
                txtKdDosen.setText(dosenaktif.kd_dosen);
                txtNmDosen.setText(dosenaktif.nama_dosen);
                txtPengampu.setText(dosenaktif.nama_mk);        
            }
            
            
        }catch(SQLException ex){
                JOptionPane.showMessageDialog(this, "Error method getDataNilai() : "+ex,
                        "Informasi", JOptionPane.INFORMATION_MESSAGE);
            
        }
        
    }
    
    public void aksiSimpan(){
        
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

        jdPenilaianDosen = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        txtNmDosen = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtPengampu = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtKdDosen = new javax.swing.JTextField();
        panelAlpha22 = new com.app.siakad.views.PanelAlpha2();
        jLabel13 = new javax.swing.JLabel();
        tbDataNilai = new javax.swing.JScrollPane();
        tbNilaiDosen = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        lblSimpan = new javax.swing.JLabel();
        lblClear = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        epMasukan = new javax.swing.JEditorPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        epPesan = new javax.swing.JEditorPane();
        lblNIM = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lblNama = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        panelAlpha21 = new com.app.siakad.views.PanelAlpha2();
        tbDosenAktif = new javax.swing.JScrollPane();
        tbDataDosenAktif = new javax.swing.JTable();
        lblRecord = new javax.swing.JLabel();

        jdPenilaianDosen.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/siakad/icons/icons8-male-user-100.png"))); // NOI18N
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Kode Dosen :");

        txtNmDosen.setEditable(false);
        txtNmDosen.setForeground(new java.awt.Color(255, 255, 255));
        txtNmDosen.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1)));
        txtNmDosen.setOpaque(false);
        txtNmDosen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNmDosenActionPerformed(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText(".....................................");

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Nama Dosen :");

        jTextField3.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1)));
        jTextField3.setOpaque(false);

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText(".....................................");

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Pengampu :");

        txtPengampu.setEditable(false);
        txtPengampu.setForeground(new java.awt.Color(255, 255, 255));
        txtPengampu.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1)));
        txtPengampu.setOpaque(false);
        txtPengampu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPengampuActionPerformed(evt);
            }
        });

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText(".....................................");

        txtKdDosen.setEditable(false);
        txtKdDosen.setForeground(new java.awt.Color(255, 255, 255));
        txtKdDosen.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1)));
        txtKdDosen.setOpaque(false);
        txtKdDosen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKdDosenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNmDosen)
                    .addComponent(txtPengampu)
                    .addComponent(txtKdDosen)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtKdDosen, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNmDosen, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPengampu, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(344, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(450, Short.MAX_VALUE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(178, 178, 178)))
        );

        panelAlpha22.setBackground(new java.awt.Color(0, 153, 153));

        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel13.setText(".: FORM PENILAIAN KINERJA DOSEN");

        tbDataNilai.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Nilai : Masukkan nilai Anda disini !!!", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11))); // NOI18N

        tbNilaiDosen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No.", "Kategori Penilaian", "Kode", "Kriteria Penilaian", "Nilai"
            }
        ));
        tbDataNilai.setViewportView(tbNilaiDosen);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Keterangan :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11))); // NOI18N
        jPanel3.setOpaque(false);

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel14.setText("1 : Tidak Baik");

        jLabel15.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel15.setText("2 : Kurang Baik");

        jLabel16.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel16.setText("3 : Cukup");

        jLabel17.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel17.setText("4 : Baik");

        jLabel18.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel18.setText("5 : Sangat Baik");

        lblSimpan.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        lblSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/siakad/icons/icons8_Save_as_20px.png"))); // NOI18N
        lblSimpan.setText("F2 : Save");
        lblSimpan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lblSimpanKeyPressed(evt);
            }
        });

        lblClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/siakad/icons/icons8_Delete_Document_20px.png"))); // NOI18N
        lblClear.setText("F3 : Clear");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(lblSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblClear))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSimpan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblClear)
                .addContainerGap(368, Short.MAX_VALUE))
        );

        epMasukan.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Kritik / Masukan :"))));
        epMasukan.setOpaque(false);
        jScrollPane2.setViewportView(epMasukan);

        epPesan.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Kritik / Masukan :")), "Kesan / Pesan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11))); // NOI18N
        epPesan.setOpaque(false);
        jScrollPane3.setViewportView(epPesan);

        lblNIM.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblNIM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/siakad/icons/siswa-small.png"))); // NOI18N
        lblNIM.setText("NIM : ");

        jLabel19.setText("|");

        lblNama.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        lblNama.setText("Nama : ");

        javax.swing.GroupLayout panelAlpha22Layout = new javax.swing.GroupLayout(panelAlpha22);
        panelAlpha22.setLayout(panelAlpha22Layout);
        panelAlpha22Layout.setHorizontalGroup(
            panelAlpha22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlpha22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAlpha22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAlpha22Layout.createSequentialGroup()
                        .addGap(0, 66, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addGap(541, 541, 541)
                        .addComponent(lblNIM, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel19)
                        .addGap(11, 11, 11)
                        .addComponent(lblNama, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82))
                    .addGroup(panelAlpha22Layout.createSequentialGroup()
                        .addGroup(panelAlpha22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tbDataNilai)
                            .addGroup(panelAlpha22Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(3, 3, 3))
        );
        panelAlpha22Layout.setVerticalGroup(
            panelAlpha22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlpha22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAlpha22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(lblNIM)
                    .addComponent(jLabel19)
                    .addComponent(lblNama))
                .addGap(18, 18, 18)
                .addGroup(panelAlpha22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAlpha22Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(tbDataNilai, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelAlpha22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jdPenilaianDosenLayout = new javax.swing.GroupLayout(jdPenilaianDosen.getContentPane());
        jdPenilaianDosen.getContentPane().setLayout(jdPenilaianDosenLayout);
        jdPenilaianDosenLayout.setHorizontalGroup(
            jdPenilaianDosenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdPenilaianDosenLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(panelAlpha22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );
        jdPenilaianDosenLayout.setVerticalGroup(
            jdPenilaianDosenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelAlpha22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Apekido v1.0");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/siakad/icons/desktop_22651 (1).png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/siakad/icons/logo-medium.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("APLIKASI PENILAIAN KINERJA DOSEN");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("AKADEMI KOMUNITAS NEGERI KAJEN");

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        tbDosenAktif.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Data Dosen Aktif : Klik 2x pada tabel untuk memilih dosen yang akan dinilai", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        tbDosenAktif.setOpaque(false);
        tbDosenAktif.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDosenAktifMouseClicked(evt);
            }
        });

        tbDataDosenAktif.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "No.", "Kode Dosen", "Nama Dosen", "Mata Kuliah", "SKS Teori", "SKS Praktek", "Status"
            }
        ));
        tbDataDosenAktif.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tbDataDosenAktif.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDataDosenAktifMouseClicked(evt);
            }
        });
        tbDosenAktif.setViewportView(tbDataDosenAktif);

        lblRecord.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        lblRecord.setForeground(new java.awt.Color(255, 255, 255));
        lblRecord.setText("Record : 0");

        javax.swing.GroupLayout panelAlpha21Layout = new javax.swing.GroupLayout(panelAlpha21);
        panelAlpha21.setLayout(panelAlpha21Layout);
        panelAlpha21Layout.setHorizontalGroup(
            panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlpha21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbDosenAktif, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
                    .addGroup(panelAlpha21Layout.createSequentialGroup()
                        .addComponent(lblRecord)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelAlpha21Layout.setVerticalGroup(
            panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAlpha21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbDosenAktif, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRecord)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelAlpha21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbDataDosenAktifMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDataDosenAktifMouseClicked
        if(evt.getClickCount()==2){
           int row = tbDataDosenAktif.getSelectedRow();
           
           dosenaktif.kd_dosen = tbDataDosenAktif.getValueAt(row, 0).toString();
           dosenaktif.nama_dosen = tbDataDosenAktif.getValueAt(row, 1).toString();
           dosenaktif.nama_mk = tbDataDosenAktif.getValueAt(row, 2).toString();
           jdPenilaianDosen.setVisible(true); jdPenilaianDosen.setLocationRelativeTo(this);
           txtKdDosen.setText(dosenaktif.kd_dosen);
           txtNmDosen.setText(dosenaktif.nama_dosen);
           txtPengampu.setText(dosenaktif.nama_mk);
           kriteria.select_kriteria();
           getDataNilai();
           showDataNilai();
       }
           
    }//GEN-LAST:event_tbDataDosenAktifMouseClicked

    private void txtNmDosenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNmDosenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNmDosenActionPerformed

    private void txtPengampuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPengampuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPengampuActionPerformed

    private void txtKdDosenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKdDosenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKdDosenActionPerformed

    private void tbDosenAktifMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDosenAktifMouseClicked
        if(evt.getClickCount()==2){
           jdPenilaianDosen.setVisible(true); jdPenilaianDosen.setLocationRelativeTo(this);
           getDataNilai();
           kriteria.select_kriteria();
           showDataNilai();
           
        }
    }//GEN-LAST:event_tbDosenAktifMouseClicked

    private void lblSimpanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblSimpanKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblSimpanKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane epMasukan;
    private javax.swing.JEditorPane epPesan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JDialog jdPenilaianDosen;
    private javax.swing.JLabel lblClear;
    private javax.swing.JLabel lblNIM;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblRecord;
    private javax.swing.JLabel lblSimpan;
    private com.app.siakad.views.PanelAlpha2 panelAlpha21;
    private com.app.siakad.views.PanelAlpha2 panelAlpha22;
    private javax.swing.JTable tbDataDosenAktif;
    private javax.swing.JScrollPane tbDataNilai;
    private javax.swing.JScrollPane tbDosenAktif;
    private javax.swing.JTable tbNilaiDosen;
    private javax.swing.JTextField txtKdDosen;
    private javax.swing.JTextField txtNmDosen;
    private javax.swing.JTextField txtPengampu;
    // End of variables declaration//GEN-END:variables
}
