package com.app.siakad.views;

import com.app.siakad.database.KoneksiDB;
import java.awt.Color;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class FrMenu extends javax.swing.JFrame {
    KoneksiDB getCnn = new KoneksiDB();//deklarasikan class koneksi database yg bernama KoneksiDB
    Connection _Cnn;
    
    
    String vid_user, vnama_user, vpass, vlev_user;
    String sqlselect;
    IfrNilaiAkhirDosen ifrnilaiakhirdosen;
    
    public boolean panelmenu;

   
    public FrMenu() {
        initComponents();
        ifrnilaiakhirdosen = new IfrNilaiAkhirDosen();
        disabledMenu();
        
        this.setExtendedState(this.getExtendedState () | FrMenu.MAXIMIZED_BOTH);
    }
    
    public void disabledMenu(){
        btnLogin.setEnabled(false);
        txtIDUser.setEnabled(false);
        txtPass.setEnabled(false);
        PanelLeft.setVisible(false);
        btnNADosen.setEnabled(false);
        btnNilaiPerMhs.setEnabled(false);
        btnDosen.setEnabled(false);
        btnMhs.setEnabled(false);
        btnKategoriKriteria.setEnabled(false);
        btnDosenAktif.setEnabled(false);
        btnNilai.setEnabled(false);
    }
    
    public void enabledMenu(){
        btnLogin.setEnabled(true);
        txtIDUser.setEnabled(true);
        txtPass.setEnabled(true);
       
    }
    
    public void userKaprodi(){
        btnNADosen.setEnabled(true);
        btnNilaiPerMhs.setEnabled(true);
        panelMhs.setVisible(false);
        panelTU.setVisible(false);
    }
    
    void userTU(){
        btnDosen.setEnabled(true);
        btnMhs.setEnabled(true);
        btnKategoriKriteria.setEnabled(true);
        panelMhs.setVisible(false);
        panelKaprodi.setVisible(false);
    }
    void mahasiswa(){
        btnNilai.setEnabled(true);
        btnDosenAktif.setEnabled(true);
        panelKaprodi.setVisible(false);
        panelTU.setVisible(false);
        
    }
    
    private void aksilogin(){//method yg berisi validasi login
        if(txtIDUser.getText().equals("")|| txtPass.getText().equals("")){
            JOptionPane.showMessageDialog(this, "ID User dan Password belum diisi");
        }else if(lblKet.getText().equals("Ket : Kepala Prodi")){
            vid_user = txtIDUser.getText();//memberikan nilai pd variabel vid_user
            vpass = txtPass.getText();
            try{
                _Cnn = null;//mengkosongkan koneksi
                _Cnn = getCnn.getConnection();//membuka koneksi dg getCnn(object koneksiDB)
                sqlselect = "select * from akn_user where id_user='"+vid_user+"' "
                        + " and pass=md5('"+vpass+"') ";//query
                Statement stat = _Cnn.createStatement();//membuat statement query
                ResultSet res = stat.executeQuery(sqlselect);//menjalankan query, ResultSet hanya jika querynya select
                if(res.first()){//jika hasilnya(query select) ditemukan
                    vlev_user = res.getString("lev_user");//memberikan nilai pd variabel vlev_user dr hasil query select kolom lev_user
                    vnama_user = res.getString("nama_user");//variabel nama_user diberi nilai pd tabel
                    lblKeterangan.setText("ID. User : "+vid_user+" - "+vnama_user+
                            "   | Status : "+vlev_user);//menampilkan id user dan lev user yg sedang login di label keterangan
                    lblUsername.setText(vnama_user);
                    lblLevUser.setText(vlev_user);
                    PanelLoginAs.setVisible(false);
                    PanelLogin.setVisible(false);
                    jSeparator1.setVisible(false);
                    enabledMenu();
                    if(vlev_user.equals("Kaprodi")){
                        userKaprodi();
                    }else if(vlev_user.equals("Tata Usaha")){
                        userTU();
                    }else if(vlev_user.equals("Mahasiswa")){
                        mahasiswa();
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "ID. User dan Password salah ");
                }
            
            }catch(SQLException se){
                JOptionPane.showMessageDialog(this, "Error method aksilogin() : " +se);
            }
        }else if(lblKet.getText().equals("Ket : Petugas TU")){
            vid_user = txtIDUser.getText();//memberikan nilai pd variabel vid_user
            vpass = txtPass.getText();
            try{
                _Cnn = null;//mengkosongkan koneksi
                _Cnn = getCnn.getConnection();//membuka koneksi dg getCnn(object koneksiDB)
                sqlselect = "select * from akn_user where id_user='"+vid_user+"' "
                        + " and pass=md5('"+vpass+"') ";//query
                Statement stat = _Cnn.createStatement();//membuat statement query
                ResultSet res = stat.executeQuery(sqlselect);//menjalankan query, ResultSet hanya jika querynya select
                if(res.first()){//jika hasilnya(query select) ditemukan
                    vlev_user = res.getString("lev_user");//memberikan nilai pd variabel vlev_user dr hasil query select kolom lev_user
                    vnama_user = res.getString("nama_user");//variabel nama_user diberi nilai pd tabel
                    lblKeterangan.setText("ID. User : "+vid_user+" - "+vnama_user+
                            "   | Status : "+vlev_user);//menampilkan id user dan lev user yg sedang login di label keterangan
                    lblUsername.setText(vnama_user);
                    lblLevUser.setText(vlev_user);
                    PanelLoginAs.setVisible(false);
                    PanelLogin.setVisible(false);
                    jSeparator1.setVisible(false);
                    enabledMenu();
                    if(vlev_user.equals("Kaprodi")){
                        userKaprodi();
                    }else if(vlev_user.equals("Tata Usaha")){
                        userTU();
                    }else if(vlev_user.equals("Mahasiswa")){
                        mahasiswa();
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "ID. User dan Password salah ");
                }
            
            }catch(SQLException se){
                JOptionPane.showMessageDialog(this, "Error method aksilogin() : " +se);
            }
        }else if(lblKet.getText().equals("Ket : Mahasiswa")){
            vid_user = txtIDUser.getText();//memberikan nilai pd variabel vid_user
            vpass = txtPass.getText();
            try{
                _Cnn = null;//mengkosongkan koneksi
                _Cnn = getCnn.getConnection();//membuka koneksi dg getCnn(object koneksiDB)
                sqlselect = "select * from mhs_mahasiswa where nim='"+vid_user+"' "
                        + " and pass=md5('"+vpass+"') ";//query
                Statement stat = _Cnn.createStatement();//membuat statement query
                ResultSet res = stat.executeQuery(sqlselect);//menjalankan query, ResultSet hanya jika querynya select
                if(res.first()){//jika hasilnya(query select) ditemukan
                    vlev_user = "Mahasiswa";//memberikan nilai pd variabel vlev_user dr hasil query select kolom lev_user
                    vnama_user = res.getString("nama_mhs");//variabel nama_user diberi nilai pd tabel
                    lblKeterangan.setText("ID. User : "+vid_user+" - "+vnama_user+
                            "   | Status : "+vlev_user);//menampilkan id user dan lev user yg sedang login di label keterangan
                    lblUsername.setText(vnama_user);
                    lblLevUser.setText(vlev_user);
                    PanelLoginAs.setVisible(false);
                    PanelLogin.setVisible(false);
                    jSeparator1.setVisible(false);
                    enabledMenu();
                    if(vlev_user.equals("Kaprodi")){
                        userKaprodi();
                    }else if(vlev_user.equals("Tata Usaha")){
                        userTU();
                    }else if(vlev_user.equals("Mahasiswa")){
                        mahasiswa();
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "ID. User dan Password salah ");
                }
            
            }catch(SQLException se){
                JOptionPane.showMessageDialog(this, "Error method aksilogin() : " +se);
            }
        }
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jSeparator2 = new javax.swing.JSeparator();
        panelAlpha21 = new com.app.siakad.views.PanelAlpha2();
        PanelMenu = new com.app.siakad.views.PanelAlpha2();
        PanelLoginAs = new javax.swing.JPanel();
        lblKaProdi = new javax.swing.JLabel();
        lbkaprodi = new javax.swing.JLabel();
        lblWaliKelas = new javax.swing.JLabel();
        lbwakel = new javax.swing.JLabel();
        lblDosen = new javax.swing.JLabel();
        lbdosen = new javax.swing.JLabel();
        lblMhs = new javax.swing.JLabel();
        lbmhs = new javax.swing.JLabel();
        lblTU = new javax.swing.JLabel();
        lbtu = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        PanelLogin = new javax.swing.JPanel();
        btnLogin = new javax.swing.JButton();
        lblKet = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        txtIDUser = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        jLabel12 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        PanelLeft = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblLevUser = new javax.swing.JLabel();
        panelKaprodi = new com.app.siakad.views.PanelAlpha2();
        jPanel1 = new javax.swing.JPanel();
        btnNADosen = new javax.swing.JButton();
        btnNilaiPerMhs = new javax.swing.JButton();
        panelTU = new com.app.siakad.views.PanelAlpha2();
        jPanel3 = new javax.swing.JPanel();
        btnMhs = new javax.swing.JButton();
        btnKategoriKriteria = new javax.swing.JButton();
        btnDosen = new javax.swing.JButton();
        panelMhs = new com.app.siakad.views.PanelAlpha2();
        jPanel4 = new javax.swing.JPanel();
        btnDosenAktif = new javax.swing.JButton();
        btnNilai = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        PanelSlide = new javax.swing.JPanel();
        lbSlide = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        lblKeterangan = new javax.swing.JLabel();
        lbClose = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        javax.swing.GroupLayout panelAlpha21Layout = new javax.swing.GroupLayout(panelAlpha21);
        panelAlpha21.setLayout(panelAlpha21Layout);
        panelAlpha21Layout.setHorizontalGroup(
            panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        panelAlpha21Layout.setVerticalGroup(
            panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Apekido v1.0");
        setBackground(new java.awt.Color(0, 153, 153));

        PanelMenu.setBackground(new java.awt.Color(0, 153, 153));

        PanelLoginAs.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), ".: Login :.", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255)), ".: Login As :.", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        PanelLoginAs.setOpaque(false);
        PanelLoginAs.setLayout(new java.awt.GridBagLayout());

        lblKaProdi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/siakad/icons/customer_person_people_woman_user_client_1631.png"))); // NOI18N
        lblKaProdi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblKaProdi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblKaProdiMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 3;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(59, 153, 0, 0);
        PanelLoginAs.add(lblKaProdi, gridBagConstraints);

        lbkaprodi.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lbkaprodi.setForeground(new java.awt.Color(255, 255, 255));
        lbkaprodi.setText("KETUA PRODI");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 153, 42, 0);
        PanelLoginAs.add(lbkaprodi, gridBagConstraints);

        lblWaliKelas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/siakad/icons/bootloader_users_person_people_6080.png"))); // NOI18N
        lblWaliKelas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblWaliKelas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblWaliKelasMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 4;
        gridBagConstraints.ipady = 28;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 6, 0, 0);
        PanelLoginAs.add(lblWaliKelas, gridBagConstraints);

        lbwakel.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lbwakel.setForeground(new java.awt.Color(255, 255, 255));
        lbwakel.setText("WALI KELAS");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 24;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 16, 42, 0);
        PanelLoginAs.add(lbwakel, gridBagConstraints);

        lblDosen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/siakad/icons/groups_people_people_1716 (2).png"))); // NOI18N
        lblDosen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblDosen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDosenMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 8;
        gridBagConstraints.ipady = 32;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(36, 10, 0, 0);
        PanelLoginAs.add(lblDosen, gridBagConstraints);

        lbdosen.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lbdosen.setForeground(new java.awt.Color(255, 255, 255));
        lbdosen.setText("DOSEN");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 32, 42, 0);
        PanelLoginAs.add(lbdosen, gridBagConstraints);

        lblMhs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/siakad/icons/community_users_12977 (1).png"))); // NOI18N
        lblMhs.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblMhs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMhsMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 4;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(52, 6, 0, 0);
        PanelLoginAs.add(lblMhs, gridBagConstraints);

        lbmhs.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lbmhs.setForeground(new java.awt.Color(255, 255, 255));
        lbmhs.setText("MAHASISWA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 16, 42, 0);
        PanelLoginAs.add(lbmhs, gridBagConstraints);

        lblTU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/siakad/icons/writer_person_people_man_you_1633.png"))); // NOI18N
        lblTU.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblTU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTUMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(60, 12, 0, 117);
        PanelLoginAs.add(lblTU, gridBagConstraints);

        lbtu.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lbtu.setForeground(new java.awt.Color(255, 255, 255));
        lbtu.setText("PETUGAS TU");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 18, 42, 0);
        PanelLoginAs.add(lbtu, gridBagConstraints);

        jSeparator1.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));

        PanelLogin.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PanelLogin.setOpaque(false);

        btnLogin.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/siakad/icons/login-blue.png"))); // NOI18N
        btnLogin.setText("Masuk");
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        lblKet.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lblKet.setForeground(new java.awt.Color(255, 255, 255));
        lblKet.setText("Ket : ");

        lblUser.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lblUser.setForeground(new java.awt.Color(255, 255, 255));
        lblUser.setText("ID. User");

        txtIDUser.setForeground(new java.awt.Color(255, 255, 255));
        txtIDUser.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtIDUser.setOpaque(false);
        txtIDUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDUserActionPerformed(evt);
            }
        });
        txtIDUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIDUserKeyTyped(evt);
            }
        });

        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/siakad/icons/siswa-small.png"))); // NOI18N
        jLabel11.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        txtPass.setForeground(new java.awt.Color(255, 255, 255));
        txtPass.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtPass.setOpaque(false);
        txtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Password");

        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/siakad/icons/key.png"))); // NOI18N
        jLabel13.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout PanelLoginLayout = new javax.swing.GroupLayout(PanelLogin);
        PanelLogin.setLayout(PanelLoginLayout);
        PanelLoginLayout.setHorizontalGroup(
            PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLoginLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLoginLayout.createSequentialGroup()
                        .addGroup(PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(PanelLoginLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIDUser, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblKet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(PanelLoginLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator4)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator3))
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLoginLayout.createSequentialGroup()
                        .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        PanelLoginLayout.setVerticalGroup(
            PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUser)
                .addGap(2, 2, 2)
                .addGroup(PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(txtIDUser, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addGap(2, 2, 2)
                .addGroup(PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblKet, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/siakad/icons/desktop_22651 (1).png"))); // NOI18N

        jLabel16.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Akademi Komunitas Negeri Kajen");

        jLabel17.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Jalan Bahurekso No. 1, Kajen 51161");

        jLabel22.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Kab. Pekalongan, Jawa Tengah");

        jLabel23.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Telp.(0285)381400, Fax.(0285)381734");

        javax.swing.GroupLayout PanelMenuLayout = new javax.swing.GroupLayout(PanelMenu);
        PanelMenu.setLayout(PanelMenuLayout);
        PanelMenuLayout.setHorizontalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(PanelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelLoginAs, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenuLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PanelLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenuLayout.createSequentialGroup()
                                .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)))))
                .addContainerGap())
        );
        PanelMenuLayout.setVerticalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenuLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(PanelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PanelLoginAs, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenuLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel23)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel22)
                        .addGap(19, 19, 19))
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        PanelLeft.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/siakad/icons/icons8-male-user-100.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblUsername.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsername.setText("(Username)");

        lblLevUser.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        lblLevUser.setForeground(new java.awt.Color(255, 255, 255));
        lblLevUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLevUser.setText("(Level User)");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Menu Kepala Program Studi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setOpaque(false);

        btnNADosen.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        btnNADosen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/siakad/icons/1-61_icon-icons.com_68882.png"))); // NOI18N
        btnNADosen.setText("   Nilai Akhir Dosen");
        btnNADosen.setAlignmentX(2.0F);
        btnNADosen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNADosen.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNADosen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNADosenActionPerformed(evt);
            }
        });

        btnNilaiPerMhs.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        btnNilaiPerMhs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/siakad/icons/ic_grade_128_28330.png"))); // NOI18N
        btnNilaiPerMhs.setText("   Nilai Per Mahasiswa");
        btnNilaiPerMhs.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNilaiPerMhs.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNilaiPerMhs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNilaiPerMhsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNADosen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNilaiPerMhs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNADosen, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNilaiPerMhs, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelKaprodiLayout = new javax.swing.GroupLayout(panelKaprodi);
        panelKaprodi.setLayout(panelKaprodiLayout);
        panelKaprodiLayout.setHorizontalGroup(
            panelKaprodiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelKaprodiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelKaprodiLayout.setVerticalGroup(
            panelKaprodiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelKaprodiLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Menu Kepala TU", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel3.setOpaque(false);

        btnMhs.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        btnMhs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/siakad/icons/scholar_21747.png"))); // NOI18N
        btnMhs.setText("   Data Mahasiswa");
        btnMhs.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMhs.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMhs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMhsActionPerformed(evt);
            }
        });

        btnKategoriKriteria.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        btnKategoriKriteria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/siakad/icons/data-servers_icon-icons.com_52838.png"))); // NOI18N
        btnKategoriKriteria.setText("   Data Kriteria Nilai Dosen");
        btnKategoriKriteria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnKategoriKriteria.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnKategoriKriteria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKategoriKriteriaActionPerformed(evt);
            }
        });

        btnDosen.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        btnDosen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/siakad/icons/data-lock_icon-icons.com_52840.png"))); // NOI18N
        btnDosen.setText("   Data Dosen");
        btnDosen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDosen.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDosen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDosenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnKategoriKriteria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDosen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnMhs, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDosen, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMhs, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnKategoriKriteria, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelTULayout = new javax.swing.GroupLayout(panelTU);
        panelTU.setLayout(panelTULayout);
        panelTULayout.setHorizontalGroup(
            panelTULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTULayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        panelTULayout.setVerticalGroup(
            panelTULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTULayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255))), "Menu Mahasiswa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel4.setOpaque(false);

        btnDosenAktif.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        btnDosenAktif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/siakad/icons/Group_40731.png"))); // NOI18N
        btnDosenAktif.setText("   Data Dosen Aktif");
        btnDosenAktif.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDosenAktif.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDosenAktif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDosenAktifActionPerformed(evt);
            }
        });

        btnNilai.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        btnNilai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/siakad/icons/1486503759-book-bookmark-education-school-favorite-mark_81266.png"))); // NOI18N
        btnNilai.setText("   Data Nilai");
        btnNilai.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNilai.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNilai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNilaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDosenAktif, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                    .addComponent(btnNilai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDosenAktif, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNilai, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout panelMhsLayout = new javax.swing.GroupLayout(panelMhs);
        panelMhs.setLayout(panelMhsLayout);
        panelMhsLayout.setHorizontalGroup(
            panelMhsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMhsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelMhsLayout.setVerticalGroup(
            panelMhsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMhsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel21.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Aplikasi Penilaian Kinerja Dosen v1.0");

        javax.swing.GroupLayout PanelLeftLayout = new javax.swing.GroupLayout(PanelLeft);
        PanelLeft.setLayout(PanelLeftLayout);
        PanelLeftLayout.setHorizontalGroup(
            PanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLeftLayout.createSequentialGroup()
                .addGroup(PanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLeftLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelTU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelKaprodi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelMhs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(PanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel21))
                            .addComponent(lblUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(PanelLeftLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(lblLevUser, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jSeparator5)
        );
        PanelLeftLayout.setVerticalGroup(
            PanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLeftLayout.createSequentialGroup()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUsername)
                .addGap(2, 2, 2)
                .addComponent(lblLevUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(panelKaprodi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(panelTU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelMhs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        PanelSlide.setBackground(new java.awt.Color(0, 153, 153));

        lbSlide.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        lbSlide.setForeground(new java.awt.Color(255, 255, 255));
        lbSlide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/siakad/icons/icons8_Menu_30px.png"))); // NOI18N
        lbSlide.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbSlide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbSlideMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PanelSlideLayout = new javax.swing.GroupLayout(PanelSlide);
        PanelSlide.setLayout(PanelSlideLayout);
        PanelSlideLayout.setHorizontalGroup(
            PanelSlideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSlideLayout.createSequentialGroup()
                .addComponent(lbSlide)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelSlideLayout.setVerticalGroup(
            PanelSlideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSlideLayout.createSequentialGroup()
                .addComponent(lbSlide)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel20.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel20.setText("Aplikasi Penilaian Kinerja Dosen v1.0");

        lblKeterangan.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lblKeterangan.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblKeterangan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/siakad/icons/siswa-small.png"))); // NOI18N
        lblKeterangan.setText("ID. User : ..... - .....   | Status : .....");

        lbClose.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lbClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/siakad/icons/close.png"))); // NOI18N
        lbClose.setText("Close");
        lbClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCloseMouseClicked(evt);
            }
        });

        jLabel18.setBackground(new java.awt.Color(0, 0, 0));
        jLabel18.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel18.setText("|");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblKeterangan, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbClose))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblKeterangan)
                        .addComponent(lbClose))
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(PanelLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(PanelSlide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(PanelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(1, 1, 1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelSlide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelLeft, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNilaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNilaiActionPerformed
        JdPenilaianDosen fr = new JdPenilaianDosen(this, true);
        
        fr.setVisible(true);
        
    }//GEN-LAST:event_btnNilaiActionPerformed

    private void btnDosenAktifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDosenAktifActionPerformed
        IfrDosenAktif fr = new IfrDosenAktif();
        PanelMenu.add(fr);
        fr.setVisible(true);
    }//GEN-LAST:event_btnDosenAktifActionPerformed

    private void btnKategoriKriteriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKategoriKriteriaActionPerformed
        IfrKategoriKriteriaNilai fr = new IfrKategoriKriteriaNilai();
        PanelMenu.add(fr);
        fr.setVisible(true);
    }//GEN-LAST:event_btnKategoriKriteriaActionPerformed

    private void btnNilaiPerMhsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNilaiPerMhsActionPerformed
        IfrNilaiPerMhs fr = new IfrNilaiPerMhs();
        PanelMenu.add(fr);
        fr.setVisible(true);
    }//GEN-LAST:event_btnNilaiPerMhsActionPerformed

    private void btnNADosenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNADosenActionPerformed
        if(!ifrnilaiakhirdosen.getVisible() && !ifrnilaiakhirdosen.isShowing());
        ifrnilaiakhirdosen = new IfrNilaiAkhirDosen();//memanggil form IfrUser
        PanelMenu.add(ifrnilaiakhirdosen);
        ifrnilaiakhirdosen.setVisible(true);
     
        
    }//GEN-LAST:event_btnNADosenActionPerformed

    private void lblKaProdiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKaProdiMouseClicked
        if(evt.getClickCount()==1){
            lblKet.setText("Ket : Kepala Prodi");
            lblUser.setText("ID. User");
            lbkaprodi.setForeground(Color.black);
        }
        txtIDUser.requestFocus(true);
        enabledMenu();
        
    }//GEN-LAST:event_lblKaProdiMouseClicked

    private void lblWaliKelasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblWaliKelasMouseClicked
        if(evt.getClickCount()==1){
            lblKet.setText("Ket : Wali Kelas");
            lblUser.setText("NIP");
            lbwakel.setForeground(Color.black);
        }
        txtIDUser.requestFocus(true);
        enabledMenu();
    }//GEN-LAST:event_lblWaliKelasMouseClicked

    private void lblDosenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDosenMouseClicked
        if(evt.getClickCount()==1){
            lblKet.setText("Ket : Dosen");
            lblUser.setText("NIP");
            lbdosen.setForeground(Color.black);
        }
        txtIDUser.requestFocus(true);
        enabledMenu();
    }//GEN-LAST:event_lblDosenMouseClicked

    private void lblMhsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMhsMouseClicked
        if(evt.getClickCount()==1){
            lblKet.setText("Ket : Mahasiswa");
            lblUser.setText("NIM");
            lbmhs.setForeground(Color.black);
        }
        txtIDUser.requestFocus(true);
        enabledMenu();
    }//GEN-LAST:event_lblMhsMouseClicked

    private void lblTUMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTUMouseClicked
        if(evt.getClickCount()==1){
            lblKet.setText("Ket : Petugas TU");
            lblUser.setText("ID. User");
            lbtu.setForeground(Color.black);
        }
        txtIDUser.requestFocus(true);
        enabledMenu();
    }//GEN-LAST:event_lblTUMouseClicked

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        
        aksilogin();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnDosenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDosenActionPerformed
        IfrDosen fr = new IfrDosen();
        PanelMenu.add(fr);
        fr.setVisible(true);
        
    }//GEN-LAST:event_btnDosenActionPerformed

    private void btnMhsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMhsActionPerformed
        IfrMahasiswa fr = new IfrMahasiswa();
        PanelMenu.add(fr);
        fr.setVisible(true);
    }//GEN-LAST:event_btnMhsActionPerformed

    private void lbSlideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSlideMouseClicked
        if(panelmenu==false){
            PanelLeft.setVisible(true); panelmenu=true;
        }else{
            PanelLeft.setVisible(false); panelmenu=false;
        }
        
    }//GEN-LAST:event_lbSlideMouseClicked

    private void txtIDUserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDUserKeyTyped
        if(txtIDUser.getText().length()==9){
            JOptionPane.showMessageDialog(null, "ID. User tidak boleh lebih dari 9 karakter");
            evt.consume();
        }
    }//GEN-LAST:event_txtIDUserKeyTyped

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassActionPerformed
        aksilogin();
    }//GEN-LAST:event_txtPassActionPerformed

    private void txtIDUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDUserActionPerformed
        txtPass.requestFocus(true);
    }//GEN-LAST:event_txtIDUserActionPerformed

    private void lbCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCloseMouseClicked
        int jawab = JOptionPane.showConfirmDialog(this, "Apakah anda akan keluar dari sistem?","Informasi",
            JOptionPane.YES_NO_OPTION);
        if(jawab == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_lbCloseMouseClicked

    public static void main(String[] args) throws UnsupportedLookAndFeelException,
           IOException, ClassNotFoundException, InstantiationException, IllegalAccessException{
       try{
           com.jtattoo.plaf.mcwin.McWinLookAndFeel.setTheme("Default", "Java Swing", "");
           UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
           SwingUtilities.updateComponentTreeUI(new FrMenu());
       } finally {
           new FrMenu().setVisible(true);
       }
   }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelLeft;
    private javax.swing.JPanel PanelLogin;
    private javax.swing.JPanel PanelLoginAs;
    private com.app.siakad.views.PanelAlpha2 PanelMenu;
    private javax.swing.JPanel PanelSlide;
    private javax.swing.JButton btnDosen;
    private javax.swing.JButton btnDosenAktif;
    private javax.swing.JButton btnKategoriKriteria;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnMhs;
    private javax.swing.JButton btnNADosen;
    private javax.swing.JButton btnNilai;
    private javax.swing.JButton btnNilaiPerMhs;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel lbClose;
    private javax.swing.JLabel lbSlide;
    private javax.swing.JLabel lbdosen;
    private javax.swing.JLabel lbkaprodi;
    private javax.swing.JLabel lblDosen;
    private javax.swing.JLabel lblKaProdi;
    private javax.swing.JLabel lblKet;
    private javax.swing.JLabel lblKeterangan;
    private javax.swing.JLabel lblLevUser;
    private javax.swing.JLabel lblMhs;
    private javax.swing.JLabel lblTU;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblWaliKelas;
    private javax.swing.JLabel lbmhs;
    private javax.swing.JLabel lbtu;
    private javax.swing.JLabel lbwakel;
    private com.app.siakad.views.PanelAlpha2 panelAlpha21;
    private com.app.siakad.views.PanelAlpha2 panelKaprodi;
    private com.app.siakad.views.PanelAlpha2 panelMhs;
    private com.app.siakad.views.PanelAlpha2 panelTU;
    private javax.swing.JTextField txtIDUser;
    private javax.swing.JPasswordField txtPass;
    // End of variables declaration//GEN-END:variables
}
