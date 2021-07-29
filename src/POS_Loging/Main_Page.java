/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS_Loging;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author asus
 */
public final class Main_Page extends javax.swing.JFrame {

        Connection con=null;        
        
        double SumofPrice[]=new double[100];   
        String SumofItems[]=new String[100];
        double UnitsCount[]=new double[100];
        double Total_price;
        double sum;
        double balance;
        String InvoiceId;
        String select;
    /**
     * Creates new form Main_Page
     */
    
            
        
        
    public Main_Page() {
        initComponents();
        showDate();
        ShowTime();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        jPanemain.setVisible(true);
        jPanelHome.setVisible(true);
        jPanelPrices.setVisible(false);
        jPanelSummary.setVisible(false);
        jPanelSettings.setVisible(false);
        
        jPanelHomeButton.setBackground(new Color(0,0,153));
        jPanelPricesButton.setBackground(new Color(0,0,51));
        jPanelSummaryButton.setBackground(new Color(0,0,51));
        jPanelSettongBtton.setBackground(new Color(0,0,51));
        jPanelTitle.setBackground(new Color(0,0,153));
        
        
        jTextFieldTotal.setEditable(false);

        
    }
    public Main_Page(String para)
    {
        initComponents();
        showDate();
        ShowTime();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        jLabelUserName.setText(para);
        
        jPanemain.setVisible(true);
        jPanelHome.setVisible(true);
        jPanelPrices.setVisible(false);
        jPanelSummary.setVisible(false);
        jPanelSettings.setVisible(false);
        
        jPanelHomeButton.setBackground(new Color(0,0,153));
        jPanelPricesButton.setBackground(new Color(0,0,51));
        jPanelSummaryButton.setBackground(new Color(0,0,51));
        jPanelSettongBtton.setBackground(new Color(0,0,51));
        jPanelTitle.setBackground(new Color(0,0,153));
        
        
        jTextFieldTotal.setEditable(false);
        
        
                

    }
    void itemId()
    {
        int refs = (int) (Math.random()*8527419);
        String ItemId = "ITMVMC";
        ItemId = ItemId+refs ;
        jTextField6EItemCode.setText(ItemId);
    }
    void showDate()
    {
        Date d = new Date();
        SimpleDateFormat s= new SimpleDateFormat("yyyy:MM:dd");
        jLabelDate.setText(s.format(d));
    }
    void ShowTime()
    {
        new Timer(0,new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Date d = new Date();
                 SimpleDateFormat s= new SimpleDateFormat("hh:mm:ss a");
                   jLabelTime.setText(s.format(d));
            }
        }
        
        ).start();
    }
    public void showTabledataPrices()
    {
        try
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos_system","root","");
            String sql = "SELECT * FROM items";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            jTableAllPrices.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
            
            
            
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    public void showTabledataExpireANDOutofStock()
    {
        try
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos_system","root","");
            String sql = "SELECT item_code,item_name,quantity,expire_date FROM items where quantity<0 or expire_date<CURRENT_DATE";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            jTableExpireStock.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
            
            
            
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    public void showTabledataOrder()
    {
        try
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos_system","root","");
            String sql = "SELECT invoice_id, invoice_by, date, time, order_amount FROM order_summary";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            jTableOrderSamary.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
            
            
            
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
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

        jPanelTitle = new javax.swing.JPanel();
        jButtonExit = new javax.swing.JButton();
        jButtonMax = new javax.swing.JButton();
        jButtonExit1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanelHomeButton = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanelPricesButton = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanelSummaryButton = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanelSettongBtton = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonLogOut = new javax.swing.JButton();
        jLabelUserName = new javax.swing.JLabel();
        jLabelTime = new javax.swing.JLabel();
        jLabelDate = new javax.swing.JLabel();
        jPanemain = new javax.swing.JPanel();
        jPanelHome = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jTextFieldSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListSerch = new javax.swing.JList();
        jTextFieldQuentity = new javax.swing.JTextField();
        jButtonClearItems = new javax.swing.JButton();
        jButtonAdd = new javax.swing.JButton();
        jTextFieldItemPrice = new javax.swing.JTextField();
        jTextFieldItemName = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTablePrices = new javax.swing.JTable();
        jButtonSelectedDelete = new javax.swing.JButton();
        jButtonCancleOrder = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jTextFieldTotal = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextAreaBill = new javax.swing.JTextArea();
        jButton4 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldPaymet = new javax.swing.JTextField();
        jButtonBalance = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldBalance = new javax.swing.JTextField();
        jButtonReset = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabledatabase = new javax.swing.JTable();
        jButtondeleterow = new javax.swing.JButton();
        jButtonTableReset = new javax.swing.JButton();
        jPanelSummary = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTableOrderSamary = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jTextFieldSearchInvoicee = new javax.swing.JTextField();
        jScrollPane8 = new javax.swing.JScrollPane();
        jListOr = new javax.swing.JList();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTextAreaOrder = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jPanelSettings = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jTextFieldSearchIemsSettings = new javax.swing.JTextField();
        jScrollPane11 = new javax.swing.JScrollPane();
        jListEditItem = new javax.swing.JList();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButtonDele = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jTextFieldENo = new javax.swing.JTextField();
        jTextField6EItemCode = new javax.swing.JTextField();
        jTextFieldEItemName = new javax.swing.JTextField();
        jTextFieldEQuantity = new javax.swing.JTextField();
        jTextFieldEUnitPrice = new javax.swing.JTextField();
        jButtonUpdateI = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jPanel12 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jTextFieldEUserAccount = new javax.swing.JTextField();
        jScrollPane12 = new javax.swing.JScrollPane();
        jListUser = new javax.swing.JList();
        jLabel35 = new javax.swing.JLabel();
        jTextFieldMobile = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jTextFieldNic = new javax.swing.JTextField();
        jTextFieldNoU = new javax.swing.JTextField();
        jTextFieldaddress = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jTextFieldUser = new javax.swing.JTextField();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jRadioButtonAdmin = new javax.swing.JRadioButton();
        jRadioButtonUser = new javax.swing.JRadioButton();
        jTextFieldPassword = new javax.swing.JPasswordField();
        jPanel13 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jTextFieldESummary = new javax.swing.JTextField();
        jScrollPane13 = new javax.swing.JScrollPane();
        jListESummayList = new javax.swing.JList();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanelPrices = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableAllPrices = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jTextFieldSerchI = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        jListIPrices = new javax.swing.JList();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextFieldItem_name = new javax.swing.JTextField();
        jTextFieldQuantity = new javax.swing.JTextField();
        jTextFieldUnitPrice = new javax.swing.JTextField();
        jTextFieldMFD = new javax.swing.JTextField();
        jTextFieldEXP = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldNo = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableExpireStock = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanelTitle.setBackground(new java.awt.Color(0, 204, 204));

        jButtonExit.setBackground(new java.awt.Color(0, 0, 0));
        jButtonExit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonExit.setForeground(new java.awt.Color(255, 255, 255));
        jButtonExit.setText("X");
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });

        jButtonMax.setBackground(new java.awt.Color(0, 0, 0));
        jButtonMax.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jButtonMax.setForeground(new java.awt.Color(255, 255, 255));
        jButtonMax.setText("🗖");
        jButtonMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMaxActionPerformed(evt);
            }
        });

        jButtonExit1.setBackground(new java.awt.Color(0, 0, 0));
        jButtonExit1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButtonExit1.setForeground(new java.awt.Color(255, 255, 255));
        jButtonExit1.setText("-");
        jButtonExit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExit1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Teko SemiBold", 1, 30)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Thilak Store");

        javax.swing.GroupLayout jPanelTitleLayout = new javax.swing.GroupLayout(jPanelTitle);
        jPanelTitle.setLayout(jPanelTitleLayout);
        jPanelTitleLayout.setHorizontalGroup(
            jPanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTitleLayout.createSequentialGroup()
                .addGap(400, 400, 400)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(421, 421, 421)
                .addComponent(jButtonExit1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButtonMax, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButtonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelTitleLayout.setVerticalGroup(
            jPanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanelTitleLayout.createSequentialGroup()
                .addGroup(jPanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonMax, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonExit1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 0, 51));
        jPanel2.setForeground(new java.awt.Color(204, 0, 0));

        jPanelHomeButton.setBackground(new java.awt.Color(0, 102, 102));
        jPanelHomeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelHomeButtonMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS_Loging/home.png"))); // NOI18N
        jLabel5.setText(" Home");

        javax.swing.GroupLayout jPanelHomeButtonLayout = new javax.swing.GroupLayout(jPanelHomeButton);
        jPanelHomeButton.setLayout(jPanelHomeButtonLayout);
        jPanelHomeButtonLayout.setHorizontalGroup(
            jPanelHomeButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHomeButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelHomeButtonLayout.setVerticalGroup(
            jPanelHomeButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHomeButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelPricesButton.setBackground(new java.awt.Color(0, 102, 102));
        jPanelPricesButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelPricesButtonMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS_Loging/prices.png"))); // NOI18N
        jLabel6.setText(" Items List");

        javax.swing.GroupLayout jPanelPricesButtonLayout = new javax.swing.GroupLayout(jPanelPricesButton);
        jPanelPricesButton.setLayout(jPanelPricesButtonLayout);
        jPanelPricesButtonLayout.setHorizontalGroup(
            jPanelPricesButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPricesButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelPricesButtonLayout.setVerticalGroup(
            jPanelPricesButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPricesButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelSummaryButton.setBackground(new java.awt.Color(0, 102, 102));
        jPanelSummaryButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelSummaryButtonMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS_Loging/summary.png"))); // NOI18N
        jLabel3.setText(" Summary");

        javax.swing.GroupLayout jPanelSummaryButtonLayout = new javax.swing.GroupLayout(jPanelSummaryButton);
        jPanelSummaryButton.setLayout(jPanelSummaryButtonLayout);
        jPanelSummaryButtonLayout.setHorizontalGroup(
            jPanelSummaryButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSummaryButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelSummaryButtonLayout.setVerticalGroup(
            jPanelSummaryButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSummaryButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelSettongBtton.setBackground(new java.awt.Color(0, 102, 102));
        jPanelSettongBtton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelSettongBttonMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS_Loging/settings.jpg"))); // NOI18N
        jLabel7.setText(" Settings");

        javax.swing.GroupLayout jPanelSettongBttonLayout = new javax.swing.GroupLayout(jPanelSettongBtton);
        jPanelSettongBtton.setLayout(jPanelSettongBttonLayout);
        jPanelSettongBttonLayout.setHorizontalGroup(
            jPanelSettongBttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSettongBttonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelSettongBttonLayout.setVerticalGroup(
            jPanelSettongBttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSettongBttonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS_Loging/mainIcon.jpg"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Vivaldi", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Thilak Store");

        jButtonLogOut.setBackground(new java.awt.Color(0, 0, 0));
        jButtonLogOut.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonLogOut.setForeground(new java.awt.Color(255, 255, 255));
        jButtonLogOut.setText("Log Out");
        jButtonLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogOutActionPerformed(evt);
            }
        });

        jLabelUserName.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        jLabelUserName.setForeground(new java.awt.Color(0, 255, 0));
        jLabelUserName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelUserName.setText("T.N.Kumara");

        jLabelTime.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabelDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDate.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelHomeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelPricesButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelSummaryButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelSettongBtton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jButtonLogOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(24, 24, 24))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelUserName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelDate, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTime, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jPanelHomeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelPricesButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelSummaryButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelSettongBtton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(58, 58, 58)
                .addComponent(jLabelUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButtonLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        jPanemain.setBackground(new java.awt.Color(255, 255, 255));

        jPanelHome.setBackground(new java.awt.Color(0, 0, 153));
        jPanelHome.setPreferredSize(new java.awt.Dimension(1449, 860));

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        jTextFieldSearch.setBackground(new java.awt.Color(0, 102, 255));
        jTextFieldSearch.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextFieldSearch.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldSearch.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldSearch.setText("Search");
        jTextFieldSearch.setAlignmentX(5.0F);
        jTextFieldSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldSearchMouseClicked(evt);
            }
        });
        jTextFieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldSearchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSearchKeyReleased(evt);
            }
        });

        jListSerch.setBackground(new java.awt.Color(0, 102, 255));
        jListSerch.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jListSerch.setAutoscrolls(false);
        jListSerch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListSerchMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jListSerch);

        jTextFieldQuentity.setBackground(new java.awt.Color(0, 102, 255));
        jTextFieldQuentity.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextFieldQuentity.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldQuentity.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldQuentityMouseClicked(evt);
            }
        });
        jTextFieldQuentity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldQuentityActionPerformed(evt);
            }
        });

        jButtonClearItems.setBackground(new java.awt.Color(51, 0, 153));
        jButtonClearItems.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButtonClearItems.setForeground(new java.awt.Color(51, 255, 255));
        jButtonClearItems.setText("clear");
        jButtonClearItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearItemsActionPerformed(evt);
            }
        });

        jButtonAdd.setBackground(new java.awt.Color(51, 0, 153));
        jButtonAdd.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButtonAdd.setForeground(new java.awt.Color(51, 255, 255));
        jButtonAdd.setText("Add");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jTextFieldItemPrice.setBackground(new java.awt.Color(0, 102, 255));
        jTextFieldItemPrice.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextFieldItemPrice.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextFieldItemName.setBackground(new java.awt.Color(0, 102, 255));
        jTextFieldItemName.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextFieldItemName.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Item :");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Price :");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Quantity :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonClearItems, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldItemPrice, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextFieldItemName, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextFieldQuentity, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                    .addComponent(jTextFieldItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldItemPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldQuentity, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonClearItems, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(0, 0, 153));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        jTablePrices.setAutoCreateRowSorter(true);
        jTablePrices.setBackground(new java.awt.Color(102, 102, 255));
        jTablePrices.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTablePrices.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Quantity", "Price"
            }
        ));
        jTablePrices.setGridColor(new java.awt.Color(0, 0, 0));
        jTablePrices.setRowHeight(28);
        jTablePrices.setSelectionBackground(new java.awt.Color(0, 0, 51));
        jScrollPane3.setViewportView(jTablePrices);

        jButtonSelectedDelete.setBackground(new java.awt.Color(51, 0, 153));
        jButtonSelectedDelete.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButtonSelectedDelete.setForeground(new java.awt.Color(51, 255, 255));
        jButtonSelectedDelete.setText("Delete");
        jButtonSelectedDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelectedDeleteActionPerformed(evt);
            }
        });

        jButtonCancleOrder.setBackground(new java.awt.Color(51, 0, 153));
        jButtonCancleOrder.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButtonCancleOrder.setForeground(new java.awt.Color(51, 255, 255));
        jButtonCancleOrder.setText("Cancle Order");
        jButtonCancleOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancleOrderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButtonSelectedDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancleOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonCancleOrder, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(jButtonSelectedDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(0, 0, 153));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        jTextFieldTotal.setBackground(new java.awt.Color(0, 102, 255));
        jTextFieldTotal.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jTextFieldTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldTotal.setText("0.0");
        jTextFieldTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTotalActionPerformed(evt);
            }
        });

        jTextAreaBill.setBackground(new java.awt.Color(204, 204, 204));
        jTextAreaBill.setColumns(20);
        jTextAreaBill.setRows(5);
        jScrollPane4.setViewportView(jTextAreaBill);

        jButton4.setBackground(new java.awt.Color(51, 0, 153));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton4.setForeground(new java.awt.Color(51, 255, 255));
        jButton4.setText("Print");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Payment :");

        jTextFieldPaymet.setBackground(new java.awt.Color(0, 102, 255));
        jTextFieldPaymet.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        jButtonBalance.setBackground(new java.awt.Color(51, 0, 153));
        jButtonBalance.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButtonBalance.setForeground(new java.awt.Color(51, 255, 255));
        jButtonBalance.setText("Balance");
        jButtonBalance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBalanceActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Balance :");

        jTextFieldBalance.setBackground(new java.awt.Color(0, 102, 255));
        jTextFieldBalance.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        jButtonReset.setBackground(new java.awt.Color(51, 0, 153));
        jButtonReset.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButtonReset.setForeground(new java.awt.Color(51, 255, 255));
        jButtonReset.setText("Reset");
        jButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4)
                    .addComponent(jTextFieldTotal, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonBalance, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldBalance))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldPaymet))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButtonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldPaymet, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(jTextFieldBalance))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(0, 0, 153));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        jTabledatabase.setBackground(new java.awt.Color(102, 102, 102));
        jTabledatabase.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTabledatabase.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTabledatabase.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Invoice Id", "Date", "Time", "Amount"
            }
        ));
        jTabledatabase.setGridColor(new java.awt.Color(0, 0, 0));
        jTabledatabase.setRowHeight(25);
        jTabledatabase.setSelectionBackground(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(jTabledatabase);

        jButtondeleterow.setBackground(new java.awt.Color(51, 0, 153));
        jButtondeleterow.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButtondeleterow.setForeground(new java.awt.Color(51, 255, 255));
        jButtondeleterow.setText("Delete Row");
        jButtondeleterow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtondeleterowActionPerformed(evt);
            }
        });

        jButtonTableReset.setBackground(new java.awt.Color(51, 0, 153));
        jButtonTableReset.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButtonTableReset.setForeground(new java.awt.Color(51, 255, 255));
        jButtonTableReset.setText("Reset Table");
        jButtonTableReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTableResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtondeleterow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonTableReset, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jButtondeleterow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonTableReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelHomeLayout = new javax.swing.GroupLayout(jPanelHome);
        jPanelHome.setLayout(jPanelHomeLayout);
        jPanelHomeLayout.setHorizontalGroup(
            jPanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHomeLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelHomeLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanelHomeLayout.setVerticalGroup(
            jPanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHomeLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelHomeLayout.createSequentialGroup()
                        .addGroup(jPanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(47, 47, 47))
        );

        jPanelSummary.setBackground(new java.awt.Color(0, 204, 204));

        jPanel9.setBackground(new java.awt.Color(0, 204, 204));
        jPanel9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        jTableOrderSamary.setBackground(new java.awt.Color(153, 153, 153));
        jTableOrderSamary.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTableOrderSamary.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableOrderSamary.setGridColor(new java.awt.Color(255, 255, 255));
        jTableOrderSamary.setRowHeight(22);
        jTableOrderSamary.setSelectionBackground(new java.awt.Color(0, 0, 0));
        jScrollPane10.setViewportView(jTableOrderSamary);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 1056, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10)
                .addContainerGap())
        );

        jPanel10.setBackground(new java.awt.Color(0, 204, 204));
        jPanel10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        jTextFieldSearchInvoicee.setEditable(false);
        jTextFieldSearchInvoicee.setBackground(new java.awt.Color(51, 51, 51));
        jTextFieldSearchInvoicee.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextFieldSearchInvoicee.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldSearchInvoicee.setText(" Search");
        jTextFieldSearchInvoicee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldSearchInvoiceeMouseClicked(evt);
            }
        });
        jTextFieldSearchInvoicee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSearchInvoiceeKeyReleased(evt);
            }
        });

        jListOr.setBackground(new java.awt.Color(51, 51, 51));
        jListOr.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jListOr.setForeground(new java.awt.Color(255, 255, 255));
        jListOr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListOrMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(jListOr);

        jTextAreaOrder.setBackground(new java.awt.Color(0, 0, 0));
        jTextAreaOrder.setColumns(20);
        jTextAreaOrder.setForeground(new java.awt.Color(255, 255, 255));
        jTextAreaOrder.setRows(5);
        jScrollPane9.setViewportView(jTextAreaOrder);

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(102, 0, 102));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Search Invoices");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldSearchInvoicee, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(120, 120, 120))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldSearchInvoicee, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelSummaryLayout = new javax.swing.GroupLayout(jPanelSummary);
        jPanelSummary.setLayout(jPanelSummaryLayout);
        jPanelSummaryLayout.setHorizontalGroup(
            jPanelSummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSummaryLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        jPanelSummaryLayout.setVerticalGroup(
            jPanelSummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSummaryLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanelSummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(72, 72, 72))
        );

        jPanelSettings.setBackground(new java.awt.Color(51, 153, 0));

        jPanel11.setBackground(new java.awt.Color(51, 153, 0));
        jPanel11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Edit Items");

        jTextFieldSearchIemsSettings.setBackground(new java.awt.Color(51, 102, 0));
        jTextFieldSearchIemsSettings.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextFieldSearchIemsSettings.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldSearchIemsSettings.setText("  Search");
        jTextFieldSearchIemsSettings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldSearchIemsSettingsMouseClicked(evt);
            }
        });
        jTextFieldSearchIemsSettings.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSearchIemsSettingsKeyReleased(evt);
            }
        });

        jListEditItem.setBackground(new java.awt.Color(51, 102, 0));
        jListEditItem.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jListEditItem.setForeground(new java.awt.Color(255, 255, 255));
        jListEditItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListEditItemMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(jListEditItem);

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel26.setText("  No (auto)                :");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel27.setText("  Item Code (auto)  :");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel28.setText("  Item Name             :");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel29.setText("  Quantity                  :");

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel30.setText("  Unit Price                :");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel31.setText("  Manufacture Date :");

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel32.setText("  Expire Date             :");

        jButton3.setBackground(new java.awt.Color(0, 51, 0));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Insert");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButtonDele.setBackground(new java.awt.Color(0, 51, 0));
        jButtonDele.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonDele.setForeground(new java.awt.Color(255, 255, 255));
        jButtonDele.setText("Delete");
        jButtonDele.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(0, 51, 0));
        jButton8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Clear");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jTextFieldENo.setBackground(new java.awt.Color(51, 102, 0));
        jTextFieldENo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextFieldENo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextField6EItemCode.setBackground(new java.awt.Color(51, 102, 0));
        jTextField6EItemCode.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField6EItemCode.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextFieldEItemName.setBackground(new java.awt.Color(51, 102, 0));
        jTextFieldEItemName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextFieldEItemName.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextFieldEQuantity.setBackground(new java.awt.Color(51, 102, 0));
        jTextFieldEQuantity.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextFieldEQuantity.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextFieldEUnitPrice.setBackground(new java.awt.Color(51, 102, 0));
        jTextFieldEUnitPrice.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextFieldEUnitPrice.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButtonUpdateI.setBackground(new java.awt.Color(0, 51, 0));
        jButtonUpdateI.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonUpdateI.setForeground(new java.awt.Color(255, 255, 255));
        jButtonUpdateI.setText("Update");
        jButtonUpdateI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateIActionPerformed(evt);
            }
        });

        jDateChooser1.setBackground(new java.awt.Color(51, 102, 0));
        jDateChooser1.setDateFormatString("yyyy-MM-dd");
        jDateChooser1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jDateChooser1.setMaxSelectableDate(new java.util.Date(253370748715000L));

        jDateChooser2.setBackground(new java.awt.Color(51, 102, 0));
        jDateChooser2.setDateFormatString("yyyy-MM-dd");
        jDateChooser2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldSearchIemsSettings, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField6EItemCode)
                            .addComponent(jTextFieldENo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldEUnitPrice)
                            .addComponent(jTextFieldEItemName)
                            .addComponent(jTextFieldEQuantity)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDele, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonUpdateI, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldSearchIemsSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldENo, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField6EItemCode, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldEItemName, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldEQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldEUnitPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDele, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonUpdateI, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel12.setBackground(new java.awt.Color(51, 153, 0));
        jPanel12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Edit User Accounts");

        jTextFieldEUserAccount.setBackground(new java.awt.Color(51, 102, 0));
        jTextFieldEUserAccount.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextFieldEUserAccount.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldEUserAccount.setText(" Search");
        jTextFieldEUserAccount.setToolTipText("");
        jTextFieldEUserAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldEUserAccountMouseClicked(evt);
            }
        });
        jTextFieldEUserAccount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldEUserAccountKeyReleased(evt);
            }
        });

        jListUser.setBackground(new java.awt.Color(51, 102, 0));
        jListUser.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jListUser.setForeground(new java.awt.Color(255, 255, 255));
        jListUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListUserMouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(jListUser);

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel35.setText("  Password              :");

        jTextFieldMobile.setBackground(new java.awt.Color(51, 102, 0));
        jTextFieldMobile.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextFieldMobile.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel34.setText("  User Name            :");

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel37.setText("  NIC No                   :");

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel38.setText("  Address                  :");

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel39.setText("  Mobile No              :");

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel33.setText("  No (auto)              :");

        jTextFieldNic.setBackground(new java.awt.Color(51, 102, 0));
        jTextFieldNic.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextFieldNic.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextFieldNoU.setBackground(new java.awt.Color(51, 102, 0));
        jTextFieldNoU.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextFieldNoU.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextFieldaddress.setBackground(new java.awt.Color(51, 102, 0));
        jTextFieldaddress.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextFieldaddress.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel36.setText("  User Type              :");

        jTextFieldUser.setBackground(new java.awt.Color(51, 102, 0));
        jTextFieldUser.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextFieldUser.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButton12.setBackground(new java.awt.Color(0, 51, 0));
        jButton12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("Add");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setBackground(new java.awt.Color(0, 51, 0));
        jButton13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setText("Modify");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton16.setBackground(new java.awt.Color(0, 51, 0));
        jButton16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton16.setForeground(new java.awt.Color(255, 255, 255));
        jButton16.setText("Delete");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(0, 51, 0));
        jButton10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("Clear");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jRadioButtonAdmin.setBackground(new java.awt.Color(51, 153, 0));
        jRadioButtonAdmin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jRadioButtonAdmin.setText("Admin");
        jRadioButtonAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonAdminActionPerformed(evt);
            }
        });

        jRadioButtonUser.setBackground(new java.awt.Color(51, 153, 0));
        jRadioButtonUser.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jRadioButtonUser.setText("User");
        jRadioButtonUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonUserActionPerformed(evt);
            }
        });

        jTextFieldPassword.setBackground(new java.awt.Color(51, 102, 0));
        jTextFieldPassword.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextFieldPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldEUserAccount)
                    .addComponent(jScrollPane12)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                                    .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(4, 4, 4)))
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldNoU)
                            .addComponent(jTextFieldUser)
                            .addComponent(jTextFieldNic)
                            .addComponent(jTextFieldaddress)
                            .addComponent(jTextFieldMobile)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jRadioButtonAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButtonUser, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                            .addComponent(jTextFieldPassword))))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldEUserAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldNoU)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldUser)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(jTextFieldPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(jRadioButtonAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldNic)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldaddress)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldMobile, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel13.setBackground(new java.awt.Color(51, 153, 0));
        jPanel13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Edit Summary Details");

        jTextFieldESummary.setBackground(new java.awt.Color(51, 102, 0));
        jTextFieldESummary.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextFieldESummary.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldESummary.setText("  Search");
        jTextFieldESummary.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldESummaryMouseClicked(evt);
            }
        });
        jTextFieldESummary.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldESummaryKeyReleased(evt);
            }
        });

        jListESummayList.setBackground(new java.awt.Color(51, 102, 0));
        jListESummayList.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jListESummayList.setForeground(new java.awt.Color(255, 255, 255));
        jListESummayList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListESummayListMouseClicked(evt);
            }
        });
        jScrollPane13.setViewportView(jListESummayList);

        jTextArea1.setBackground(new java.awt.Color(51, 102, 0));
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane14.setViewportView(jTextArea1);

        jButton6.setBackground(new java.awt.Color(0, 51, 0));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Delete");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(0, 51, 0));
        jButton7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Clear");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(0, 51, 0));
        jButton9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Reset");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane14)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel13Layout.createSequentialGroup()
                        .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldESummary, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldESummary, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelSettingsLayout = new javax.swing.GroupLayout(jPanelSettings);
        jPanelSettings.setLayout(jPanelSettingsLayout);
        jPanelSettingsLayout.setHorizontalGroup(
            jPanelSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSettingsLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        jPanelSettingsLayout.setVerticalGroup(
            jPanelSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSettingsLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanelSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(55, 55, 55))
        );

        jPanelPrices.setBackground(new java.awt.Color(204, 0, 255));

        jPanel6.setBackground(new java.awt.Color(204, 0, 255));
        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        jTableAllPrices.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTableAllPrices.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableAllPrices.setRowHeight(25);
        jTableAllPrices.setSelectionBackground(new java.awt.Color(0, 0, 0));
        jScrollPane5.setViewportView(jTableAllPrices);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 877, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(204, 0, 255));
        jPanel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        jTextFieldSerchI.setBackground(new java.awt.Color(153, 0, 255));
        jTextFieldSerchI.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextFieldSerchI.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldSerchI.setText(" Search");
        jTextFieldSerchI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldSerchIMouseClicked(evt);
            }
        });
        jTextFieldSerchI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSerchIActionPerformed(evt);
            }
        });
        jTextFieldSerchI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSerchIKeyReleased(evt);
            }
        });

        jListIPrices.setBackground(new java.awt.Color(153, 0, 255));
        jListIPrices.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jListIPrices.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListIPricesMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jListIPrices);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setText("Item Code               :");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setText("Item Name             :");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setText("Quantity                  :");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setText("Available Stock       :");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel18.setText("Manufacture Date :");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel19.setText("Expire Date             :");

        jTextField2.setBackground(new java.awt.Color(153, 0, 255));
        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextFieldItem_name.setBackground(new java.awt.Color(153, 0, 255));
        jTextFieldItem_name.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextFieldItem_name.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextFieldQuantity.setBackground(new java.awt.Color(153, 0, 255));
        jTextFieldQuantity.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextFieldQuantity.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextFieldUnitPrice.setBackground(new java.awt.Color(153, 0, 255));
        jTextFieldUnitPrice.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextFieldUnitPrice.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextFieldMFD.setBackground(new java.awt.Color(153, 0, 255));
        jTextFieldMFD.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextFieldMFD.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextFieldEXP.setBackground(new java.awt.Color(153, 0, 255));
        jTextFieldEXP.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextFieldEXP.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("No :");

        jTextFieldNo.setBackground(new java.awt.Color(153, 0, 255));
        jTextFieldNo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextFieldNo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel20.setBackground(new java.awt.Color(255, 51, 51));
        jLabel20.setFont(new java.awt.Font("Teko SemiBold", 1, 26)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 255, 0));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Search Items");

        jButton1.setBackground(new java.awt.Color(51, 0, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Clear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldSerchI, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jTextFieldNo)
                                .addGap(38, 38, 38))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldMFD)
                            .addComponent(jTextFieldUnitPrice, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldQuantity, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldItem_name, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldEXP))))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldNo, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jTextFieldSerchI, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jScrollPane7)))
                .addGap(2, 2, 2)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldItem_name, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldUnitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldMFD, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldEXP, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4))
        );

        jPanel8.setBackground(new java.awt.Color(204, 0, 255));
        jPanel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        jTableExpireStock.setBackground(new java.awt.Color(153, 0, 51));
        jTableExpireStock.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTableExpireStock.setForeground(new java.awt.Color(255, 255, 255));
        jTableExpireStock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Code", "Item Name", "Stock", "Expire Date"
            }
        ));
        jTableExpireStock.setRowHeight(25);
        jTableExpireStock.setSelectionBackground(new java.awt.Color(0, 0, 0));
        jScrollPane6.setViewportView(jTableExpireStock);

        jLabel21.setBackground(new java.awt.Color(255, 51, 51));
        jLabel21.setFont(new java.awt.Font("Teko SemiBold", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 255, 0));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Expire Items & Stock Out Items");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelPricesLayout = new javax.swing.GroupLayout(jPanelPrices);
        jPanelPrices.setLayout(jPanelPricesLayout);
        jPanelPricesLayout.setHorizontalGroup(
            jPanelPricesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPricesLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(29, 29, 29)
                .addGroup(jPanelPricesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(44, 44, 44))
        );
        jPanelPricesLayout.setVerticalGroup(
            jPanelPricesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPricesLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanelPricesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelPricesLayout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(27, 27, 27)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(70, 70, 70))
        );

        javax.swing.GroupLayout jPanemainLayout = new javax.swing.GroupLayout(jPanemain);
        jPanemain.setLayout(jPanemainLayout);
        jPanemainLayout.setHorizontalGroup(
            jPanemainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelHome, javax.swing.GroupLayout.DEFAULT_SIZE, 1602, Short.MAX_VALUE)
            .addGroup(jPanemainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelSummary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanemainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelSettings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanemainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelPrices, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanemainLayout.setVerticalGroup(
            jPanemainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelHome, javax.swing.GroupLayout.DEFAULT_SIZE, 951, Short.MAX_VALUE)
            .addGroup(jPanemainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelSummary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanemainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelSettings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanemainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelPrices, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanemain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanemain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMaxActionPerformed
        if(this.getExtendedState() != Main_Page.MAXIMIZED_BOTH)
        {
            this.setExtendedState(Main_Page.MAXIMIZED_BOTH);
            
        }
        else
        {
            this.setExtendedState(Main_Page.NORMAL);
        }
    }//GEN-LAST:event_jButtonMaxActionPerformed

    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
        frame = new JFrame("Exit");
        if(JOptionPane.showConfirmDialog(frame,"Comform if you want to Exit", "Billing System", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
            System.exit(0);

        }
    }//GEN-LAST:event_jButtonExitActionPerformed

    private void jButtonExit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExit1ActionPerformed
        this.setExtendedState(Main_Page.ICONIFIED);
    }//GEN-LAST:event_jButtonExit1ActionPerformed

        
    
    private void jPanelPricesButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelPricesButtonMouseClicked
        if("0.0".equals(jTextFieldTotal.getText()))
        {
            jPanemain.setVisible(true);
        jPanelHome.setVisible(false);
        jPanelPrices.setVisible(true);
        jPanelSummary.setVisible(false);
        jPanelSettings.setVisible(false);
        
        jPanelHomeButton.setBackground(new Color(0,0,51));
        jPanelPricesButton.setBackground(new Color(204,0,255));
        jPanelSummaryButton.setBackground(new Color(0,0,51));
        jPanelSettongBtton.setBackground(new Color(0,0,51));
        jPanelTitle.setBackground(new Color(204,0,255));
        
        showTabledataPrices();
        showTabledataExpireANDOutofStock();
                    jTextFieldNo.setEditable(false);
                    jTextField2.setEditable(false);
                    jTextFieldItem_name.setEditable(false);
                    jTextFieldQuantity.setEditable(false);
                    jTextFieldUnitPrice.setEditable(false);
                    jTextFieldMFD.setEditable(false);
                    jTextFieldEXP.setEditable(false);
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Plase reset the current Order...");
        }
        
        

    }//GEN-LAST:event_jPanelPricesButtonMouseClicked

    
    
    private void jPanelSummaryButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelSummaryButtonMouseClicked

        if("0.0".equals(jTextFieldTotal.getText()))
        {
            jPanemain.setVisible(true);
        jPanelHome.setVisible(false);
        jPanelPrices.setVisible(false);
        jPanelSummary.setVisible(true);
        jPanelSettings.setVisible(false);
        
        jPanelHomeButton.setBackground(new Color(0,0,51));
        jPanelPricesButton.setBackground(new Color(0,0,51));
        jPanelSummaryButton.setBackground(new Color(0,204,204));
        jPanelSettongBtton.setBackground(new Color(0,0,51));
        jPanelTitle.setBackground(new Color(0,204,204));
        
        
        showTabledataOrder();
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Plase reset the current Order...");
        }

    }//GEN-LAST:event_jPanelSummaryButtonMouseClicked

    private void jPanelSettongBttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelSettongBttonMouseClicked
        String t = null;
        try
        {
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos_system","root","");
            String sql = "SELECT user_type FROM loging_details WHERE `user_name`=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,jLabelUserName.getText());
            String id = jLabelUserName.getText();
            ResultSet rs = pst.executeQuery();
            if(rs.next())
            {
                t=(rs.getString(1));
            }
        }
        catch(SQLException | NumberFormatException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        
        if("admin".equals(t))
        {
            if("0.0".equals(jTextFieldTotal.getText()))
        {
            jPanemain.setVisible(true);
        jPanelHome.setVisible(false);
        jPanelPrices.setVisible(false);
        jPanelSummary.setVisible(false);
        jPanelSettings.setVisible(true);
        
        jPanelHomeButton.setBackground(new Color(0,0,51));
        jPanelPricesButton.setBackground(new Color(0,0,51));
        jPanelSummaryButton.setBackground(new Color(0,0,51));
        jPanelSettongBtton.setBackground(new Color(51,153,0));
        jPanelTitle.setBackground(new Color(51,153,0));
        
        jTextFieldENo.setEditable(false);
        jTextField6EItemCode.setEditable(false);
        
        itemId();
        
        jTextFieldNoU.setEditable(false);
        jRadioButtonUser.setSelected(true);
        jRadioButtonAdmin.setSelected(false);
        
        
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Plase reset the current Order...");
        }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Please loging Addmin account...");
        }
        

    }//GEN-LAST:event_jPanelSettongBttonMouseClicked

    private void jPanelHomeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelHomeButtonMouseClicked
        jPanemain.setVisible(true);
        jPanelHome.setVisible(true);
        jPanelPrices.setVisible(false);
        jPanelSummary.setVisible(false);
        jPanelSettings.setVisible(false);

        jPanelHomeButton.setBackground(new Color(0,0,153));
        jPanelPricesButton.setBackground(new Color(0,0,51));
        jPanelSummaryButton.setBackground(new Color(0,0,51));
        jPanelSettongBtton.setBackground(new Color(0,0,51));
        jPanelTitle.setBackground(new Color(0,0,153));
    }//GEN-LAST:event_jPanelHomeButtonMouseClicked

    
    
    private void jButtonLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogOutActionPerformed
        
        if(JOptionPane.showConfirmDialog(frame,"Comform if you want to Log out", "Error....", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
                    setVisible(false);
                    new POS_Loging().setVisible(true);
                    
                    

        }
    }//GEN-LAST:event_jButtonLogOutActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try
        {
            jTextAreaBill.print();
        }
        catch(java.awt.print.PrinterException e)
        {
            System.err.format("No Printer foung",e.getMessage());
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextFieldQuentityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldQuentityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldQuentityActionPerformed

    private void jTextFieldTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTotalActionPerformed

    private void jButtonCancleOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancleOrderActionPerformed
        DefaultTableModel model5 = (DefaultTableModel) jTablePrices.getModel();
        
        int rowsToRemoves = model5.getRowCount();
        
        for(int i=rowsToRemoves-1;i>=0;i--)
        {
            model5.removeRow(0);
        }
        
        for(int i=0;i<SumofPrice.length;i++)
        {
            SumofPrice[i]=0;
            SumofItems[i]="";
            UnitsCount[i]=0;
        }
        calctlate_total();
        
    }//GEN-LAST:event_jButtonCancleOrderActionPerformed

    private void jButtonTableResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTableResetActionPerformed
        DefaultTableModel modelwm = (DefaultTableModel) jTabledatabase.getModel();
        
        int rowsToRemove = modelwm.getRowCount();
        
        for(int i=rowsToRemove-1;i>=0;i--)
        {
            modelwm.removeRow(0);
        }
    }//GEN-LAST:event_jButtonTableResetActionPerformed
            
            private DefaultListModel modelEditUser;
            private DefaultListModel modelEditSummary;
            private DefaultListModel modelEditItem;
            private DefaultListModel model;     //list crete home page
            private DefaultListModel modelIListI;   //list crete items page
            private DefaultListModel modelIListO;   //list crete order page
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try{
            
            model = new DefaultListModel();
            jListSerch.setModel( model);
            
            modelIListI = new DefaultListModel();
            jListIPrices.setModel( modelIListI);
            
            modelIListO = new DefaultListModel();
            jListOr.setModel( modelIListO);
     
            modelEditItem = new DefaultListModel();
            jListEditItem.setModel(modelEditItem);
            
            modelEditSummary=new DefaultListModel();
            jListESummayList.setModel(modelEditSummary);
            
            modelEditUser = new DefaultListModel();
            jListUser.setModel( modelEditUser);
            
            
            
            
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, e,"Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_formWindowOpened

    private void jTextFieldSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchKeyReleased
        
        
        try
        {
            String val = jTextFieldSearch.getText();
            if(!val.equals(""))
            {
                model.removeAllElements();
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos_system","root","");
                String sql = "SELECT * FROM items where item_name like ? ";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1,val+"%");
                ResultSet rs = pst.executeQuery();
                
                 while(rs.next())
                {
                     model.addElement(rs.getString(3));
                     
                }

                String sql2 = "SELECT * FROM items where item_code like ? ";
                PreparedStatement pstt = con.prepareStatement(sql2);
                pstt.setString(1,val+"%");
                ResultSet r = pstt.executeQuery();
                
                 while(r.next())
                {
                     model.addElement(r.getString(2));
                     
                }

            }
            else
            {
                
                model.removeAllElements();
                
                
            }
        }
        catch(SQLException | HeadlessException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jTextFieldSearchKeyReleased

    private void jListSerchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListSerchMouseClicked
        if(!jListSerch.isSelectionEmpty())
        {
            String a=((String) model.getElementAt(jListSerch.getSelectedIndex()));
            
            try
            {
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos_system","root","");  
                String sql = "SELECT * FROM items where item_name like ? ";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1,a);
                ResultSet r = pst.executeQuery();
                if(r.next())
                {
                    jTextFieldItemName.setText(r.getString(3));
                    jTextFieldItemPrice.setText(r.getString(5));
                }
                String sql2 = "SELECT * FROM items where item_code like ? ";
                PreparedStatement pst2 = conn.prepareStatement(sql2);
                pst2.setString(1,a);
                ResultSet rs = pst2.executeQuery();
                if(rs.next())
                {
                    jTextFieldItemName.setText(rs.getString(3));
                    jTextFieldItemPrice.setText(rs.getString(5));
                }

            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
            

            
            model.removeAllElements();
            jTextFieldSearch.setForeground(Color.white);
            jTextFieldSearch.setText("Search");
            jTextFieldQuentity.setText("1");
            jTextFieldQuentity.requestFocus();
        }
    }//GEN-LAST:event_jListSerchMouseClicked

    private void jButtonClearItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearItemsActionPerformed
        jTextFieldItemName.setText(null);
        jTextFieldItemPrice.setText(null);
        jTextFieldQuentity.setText(null);
        jTextFieldSearch.setForeground(Color.white);
        jTextFieldSearch.setText("Search");
    }//GEN-LAST:event_jButtonClearItemsActionPerformed

    private void jTextFieldSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchKeyPressed
        jTextFieldSearch.setForeground(Color.black);
        
        
    }//GEN-LAST:event_jTextFieldSearchKeyPressed

    private void jTextFieldSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldSearchMouseClicked
        jTextFieldSearch.setText("");
    }//GEN-LAST:event_jTextFieldSearchMouseClicked
    public void calctlate_total()
    {
        
        Total_price=0;
        
        for(int k=0;k<SumofPrice.length;k++)
        {
            
            Total_price=Total_price+SumofPrice[k];
        }
        
        
        
        jTextFieldTotal.setText(String.valueOf(Total_price));
        
    }
    
    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        if("".equals(jTextFieldItemName.getText()) || "".equals(jTextFieldItemPrice.getText()) || "".equals(jTextFieldQuentity.getText())){
    
        JOptionPane.showMessageDialog(null,"Plase input values Correcly...");
    }
    else
        {
        DefaultTableModel model2 = (DefaultTableModel) jTablePrices.getModel();
        
             sum = Double.parseDouble(jTextFieldItemPrice.getText()) * Double.parseDouble(jTextFieldQuentity.getText());
            
        model2.addRow(new Object[]
        {
            jTextFieldItemName.getText(),
            jTextFieldQuentity.getText(),
            sum,
        }
        );
      
        
        int key=0;
        for(int i=0;SumofPrice[i]!=0;i++)
        {
            
                key++;
            
        }
        SumofItems[key]=jTextFieldItemName.getText();
        SumofPrice[key]=sum;
        UnitsCount[key]=Double.parseDouble(jTextFieldQuentity.getText());
        
        calctlate_total();
        
        jTextFieldItemName.setText(null);
        jTextFieldItemPrice.setText(null);
        jTextFieldQuentity.setText(null);
        }
        
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jTextFieldQuentityMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldQuentityMouseClicked
        jTextFieldQuentity.setText("");
    }//GEN-LAST:event_jTextFieldQuentityMouseClicked

    private void jButtonSelectedDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelectedDeleteActionPerformed
          DefaultTableModel model3 = (DefaultTableModel) jTablePrices.getModel();
          
        if(jTablePrices.getSelectedRowCount() == 1)
        {

            //---------------------------------------------------------delete array data-------------
            int point = jTablePrices.getSelectedRow();
            
            String slectItem =( model3.getValueAt(point, 0).toString());
            for(int i=0;i<SumofItems.length;i++)
            {
                if(SumofItems[i].equals(slectItem))
                {   
                    SumofPrice[i]=0;
                    SumofItems[i]="";
                    UnitsCount[i]=0;
                    break;
                }
            }

            calctlate_total();
            
            ////--------------------------------------------------------------------------------------------------------------

            //============================================table data remove code------------------------------------------
            model3.removeRow(jTablePrices.getSelectedRow());
            
            //--------------------------------------------------------------------------------------------------------
        }else{
            if(jTablePrices.getRowCount()==0){
                JOptionPane.showMessageDialog(this,"Table is empty");
            }else{
                JOptionPane.showMessageDialog(this,"Plase select single row for Delete");
            }
        }
        
    }//GEN-LAST:event_jButtonSelectedDeleteActionPerformed

    private void jButtonBalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBalanceActionPerformed
        if("".equals(jTextFieldPaymet.getText())){

            JOptionPane.showMessageDialog(null,"Plase input Paymet...");
        }
        else
        {
            balance =  Double.parseDouble(jTextFieldPaymet.getText())-Total_price;
            jTextFieldBalance.setText(String.valueOf(balance));
            
            Calendar timer = Calendar.getInstance();
        timer.getTime();
        SimpleDateFormat tTime = new SimpleDateFormat("HH:mm:ss");
        tTime.format(timer.getTime());
        SimpleDateFormat Tdate = new SimpleDateFormat("YYYY-MM-dd");
        Tdate.format(timer.getTime());
        
        DefaultTableModel model6 = (DefaultTableModel) jTablePrices.getModel();
        
        int rowscount = model6.getRowCount();
        
        String []c1=new String[rowscount];
        String []c2=new String[rowscount];
        double []c3=new double[rowscount];
        
        
        for(int i=0;i<rowscount;i++)
        {
            c1[i]=(String) model6.getValueAt(i, 0);
            c2[i]=(String) model6.getValueAt(i, 1);
            c3[i]=(double) model6.getValueAt(i, 2);
        }
       
        //---------------------------------------------------------///////////////////////////////////invoice id create//////////////
             int refs = (int) (Math.random()*781564);
             InvoiceId = "DCVMC";
             InvoiceId = InvoiceId+refs ;
        
        //----------------------------------------------/////////////////////////////////////////////////////////////////////////////////////
        
        
        jTextAreaBill.append(
                "_________________________________________________\n"+

                " Invoice  \t\t"+ Tdate.format(timer.getTime())+"\t"+tTime.format(timer.getTime())+
                "\n \t             ROCKET SHOP\n"+"\t+94750750621/+94703144951\n"+
                "--------------------------------------------------------------------------------------\n"+
                "Invoice No : "+InvoiceId+"\t\t"+Tdate.format(timer.getTime())+
                "\nInvoice by : "+jLabelUserName.getText()+"\t\t"+tTime.format(timer.getTime())+
                "\n--------------------------------------------------------------------------------------\n"+
                "Iname       \tUprice\tQuintity\t  Amount\n"+
                "--------------------------------------------------------------------------------------\n"
                
                


        
                        );
        
        for(int q=0;q<rowscount;q++)
                {
                    
                    String temp =String.valueOf(c3[q]/Double.parseDouble(c2[q]));//unuc price calculate
                    
                    jTextAreaBill.append(c1[q]+"\n"+"\t"+temp+"\t      "+c2[q]+"\t        "+c3[q]+" \n");
                }
        jTextAreaBill.append(
        "--------------------------------------------------------------------------------------\n"+
                "Total Rs\t\t-:\t"+jTextFieldTotal.getText()+
                "\nCash Payment Rs\t-:\t"+jTextFieldPaymet.getText()+
                "\nBalance\t\t-:\t"+jTextFieldBalance.getText()+
                "\n--------------------------------------------------------------------------------------\n"+
                " \t           Thank You, Come Again.\n"+
                "_________________________________________________\n\n\n"
        );
            jTextFieldSearch.setEditable(false);
            jTextFieldItemName.setEditable(false);
            jTextFieldItemPrice.setEditable(false);
            jTextFieldQuentity.setEditable(false);
            jTablePrices.setEnabled(false);
            jButtonClearItems.setEnabled(false);
            jButtonAdd.setEnabled(false);
            jButtonSelectedDelete.setEnabled(false);
            jButtonCancleOrder.setEnabled(false);
            
            jButtonClearItems.setForeground(new Color(0,102,255));
            jButtonAdd.setForeground(new Color(0,102,255));
            jButtonSelectedDelete.setForeground(new Color(0,102,255));
            jButtonCancleOrder.setForeground(new Color(0,102,255));
            
            
            
            
            
            DefaultTableModel modeld = (DefaultTableModel) jTabledatabase.getModel();
            modeld.addRow(new Object[]{
            InvoiceId,
             Tdate.format(timer.getTime()),
            tTime.format(timer.getTime()),
            jTextFieldTotal.getText(),
            
        });
            
            
            try
            {

                String sql="INSERT INTO order_summary(invoice_id, invoice_by, date, time, order_amount,invoice) VALUES (?,?,?,?,?,?)";
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos_system","root","");
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1,InvoiceId);
                pst.setString(2,jLabelUserName.getText());
                pst.setString(3,Tdate.format(timer.getTime()));
                pst.setString(4, tTime.format(timer.getTime()));
                pst.setString(5,jTextFieldTotal.getText());
                pst.setString(6,jTextAreaBill.getText());
                pst.executeUpdate();
                
            }
            catch(SQLException | HeadlessException ex){
                JOptionPane.showMessageDialog(null,ex);
            }
            

            
        }
        
        
        
        
    }//GEN-LAST:event_jButtonBalanceActionPerformed

    private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResetActionPerformed
        jTextFieldItemName.setText(null);
        jTextFieldItemPrice.setText(null);
        jTextFieldQuentity.setText(null);
        jTextFieldSearch.setForeground(Color.white);
        jTextFieldSearch.setText("Search");
        
        DefaultTableModel model5 = (DefaultTableModel) jTablePrices.getModel();
        
        int rowsToRemoves = model5.getRowCount();
        
        for(int i=rowsToRemoves-1;i>=0;i--)
        {
            model5.removeRow(0);
        }
        
        
        for(int i=0;i<SumofPrice.length;i++)
        {
            
            if(!"".equals(SumofItems[i]))
            {
                try
            {

                String sql="UPDATE items SET quantity = ((SELECT quantity FROM items WHERE item_name= ?) - ?) WHERE item_name= ?";
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos_system","root","");
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1,SumofItems[i]);
                pst.setString(2,String.valueOf(UnitsCount[i]));
                pst.setString(3,SumofItems[i]);

                pst.executeUpdate();
                
            }
            catch(SQLException | HeadlessException ex){
                JOptionPane.showMessageDialog(null,ex);
            }
            }
            
            
            
            
            SumofPrice[i]=0;
            SumofItems[i]="";
            UnitsCount[i]=0;
        }
        calctlate_total();
        
            jTextFieldSearch.setEditable(true);
            jTextFieldItemName.setEditable(true);
            jTextFieldItemPrice.setEditable(true);
            jTextFieldQuentity.setEditable(true);
            jTablePrices.setEnabled(true);
            jButtonClearItems.setEnabled(true);
            jButtonAdd.setEnabled(true);
            jButtonSelectedDelete.setEnabled(true);
            jButtonCancleOrder.setEnabled(true);
            
            jButtonClearItems.setForeground(new Color(51,255,255));
            jButtonAdd.setForeground(new Color(51,255,255));
            jButtonSelectedDelete.setForeground(new Color(51,255,255));
            jButtonCancleOrder.setForeground(new Color(51,255,255));
            
            jTextFieldPaymet.setText(null);
            jTextFieldBalance.setText(null);
            jTextAreaBill.setText(null);
    }//GEN-LAST:event_jButtonResetActionPerformed

    private void jButtondeleterowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtondeleterowActionPerformed
        DefaultTableModel modelm = (DefaultTableModel) jTabledatabase.getModel();
         
         
        if(jTabledatabase.getSelectedRowCount() == 1)
        {
            try
            {
                //--------------------------------------database remove code -----------------------------------------------
                String sql="DELETE FROM order_summary WHERE invoice_id=?";
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos_system","root","");
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1,(String) modelm.getValueAt(jTabledatabase.getSelectedRow(), 0));
                pst.executeUpdate();
                
            }
            catch(SQLException | HeadlessException ex){
                JOptionPane.showMessageDialog(null,ex);
            }
            //-----------------------------------------------------------------------------------------------------------------------
            
            //============================================table data remove code------------------------------------------
            modelm.removeRow(jTabledatabase.getSelectedRow());
            //--------------------------------------------------------------------------------------------------------
        }else{
            if(jTabledatabase.getRowCount()==0){
                JOptionPane.showMessageDialog(this,"Table is empty");
            }else{
                JOptionPane.showMessageDialog(this,"Plase select single row for Delete");
            }
        }
    }//GEN-LAST:event_jButtondeleterowActionPerformed

    private void jTextFieldSerchIKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSerchIKeyReleased
        try
        {
            String val = jTextFieldSerchI.getText();
            if(!val.equals(""))
            {
                modelIListI.removeAllElements();
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos_system","root","");
                String sql = "SELECT * FROM items where item_name like ? ";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1,val+"%");
                ResultSet rs = pst.executeQuery();
                
                 while(rs.next())
                {
                     modelIListI.addElement(rs.getString(3));
                     
                }

                String sql2 = "SELECT * FROM items where item_code like ? ";
                PreparedStatement pstt = con.prepareStatement(sql2);
                pstt.setString(1,val+"%");
                ResultSet r = pstt.executeQuery();
                
                 while(r.next())
                {
                     modelIListI.addElement(r.getString(2));
                     
                }

            }
            else
            {
                
                modelIListI.removeAllElements();
                
                
            }
        }
        catch(SQLException | HeadlessException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jTextFieldSerchIKeyReleased

    private void jTextFieldSerchIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSerchIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSerchIActionPerformed

    private void jTextFieldSerchIMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldSerchIMouseClicked
        jTextFieldSerchI.setText(null);
    }//GEN-LAST:event_jTextFieldSerchIMouseClicked

    private void jListIPricesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListIPricesMouseClicked
        if(!jListIPrices.isSelectionEmpty())
        {
            String a=((String) modelIListI.getElementAt(jListIPrices.getSelectedIndex()));
            
            try
            {
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos_system","root","");  
                String sql = "SELECT * FROM items where item_name like ? ";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1,a);
                ResultSet r = pst.executeQuery();
                if(r.next())
                {
                    jTextFieldNo.setText(r.getString(1));
                    jTextField2.setText(r.getString(2));
                    jTextFieldItem_name.setText(r.getString(3));
                    jTextFieldQuantity.setText(r.getString(4));
                    jTextFieldUnitPrice.setText(r.getString(5));
                    jTextFieldMFD.setText(r.getString(6));
                    jTextFieldEXP.setText(r.getString(7));
                }
                String sql2 = "SELECT * FROM items where item_code like ? ";
                PreparedStatement pst2 = conn.prepareStatement(sql2);
                pst2.setString(1,a);
                ResultSet rs = pst2.executeQuery();
                if(rs.next())
                {
                   
                    jTextFieldNo.setText(rs.getString(1));
                    jTextField2.setText(rs.getString(2));
                    jTextFieldItem_name.setText(rs.getString(3));
                    jTextFieldQuantity.setText(rs.getString(4));
                    jTextFieldUnitPrice.setText(rs.getString(5));
                    jTextFieldMFD.setText(rs.getString(6));
                    jTextFieldEXP.setText(rs.getString(7));
                    
                 
                }

            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
            

            
            modelIListI.removeAllElements();
            
            jTextFieldSerchI.setText("Search");
            
           
        }
    }//GEN-LAST:event_jListIPricesMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                    jTextFieldNo.setText(null);
                    jTextField2.setText(null);
                    jTextFieldItem_name.setText(null);
                    jTextFieldQuantity.setText(null);
                    jTextFieldUnitPrice.setText(null);
                    jTextFieldMFD.setText(null);
                    jTextFieldEXP.setText(null);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextFieldSearchInvoiceeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchInvoiceeKeyReleased
        try
        {
            String val = jTextFieldSearchInvoicee.getText();
            if(!val.equals(""))
            {
                modelIListO.removeAllElements();
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos_system","root","");
                String sql = "SELECT * FROM order_summary where invoice_id like ? ";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1,val+"%");
                ResultSet rs = pst.executeQuery();

                while(rs.next())
                {
                    modelIListO.addElement(rs.getString(1));

                }

            }
            else
            {

                modelIListO.removeAllElements();

            }
        }
        catch(SQLException | HeadlessException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jTextFieldSearchInvoiceeKeyReleased

    private void jTextFieldSearchInvoiceeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldSearchInvoiceeMouseClicked
        jTextFieldSearchInvoicee.setText("");
        jTextFieldSearchInvoicee.setEditable(true);
    }//GEN-LAST:event_jTextFieldSearchInvoiceeMouseClicked

    private void jListOrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListOrMouseClicked
        if(!jListOr.isSelectionEmpty())
        {
            String a=((String) modelIListO.getElementAt(jListOr.getSelectedIndex()));
            
            try
            {
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos_system","root","");  
                String sql = "SELECT * FROM order_summary where invoice_id = ? ";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1,a);
                ResultSet r = pst.executeQuery();
                if(r.next())
                {
                    jTextAreaOrder.setText(r.getString(6));

                }
                
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
            

            
            modelIListO.removeAllElements();
            
            jTextFieldSearchInvoicee.setText("Search");
            
           
        }
    }//GEN-LAST:event_jListOrMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jTextAreaOrder.setText(null);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextFieldSearchIemsSettingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldSearchIemsSettingsMouseClicked
        jTextFieldSearchIemsSettings.setText("");
    }//GEN-LAST:event_jTextFieldSearchIemsSettingsMouseClicked

    private void jTextFieldSearchIemsSettingsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchIemsSettingsKeyReleased
        try
        {
            String val = jTextFieldSearchIemsSettings.getText();
            if(!val.equals(""))
            {
                modelEditItem.removeAllElements();
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos_system","root","");
                String sql = "SELECT * FROM items where item_name like ? ";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1,val+"%");
                ResultSet rs = pst.executeQuery();
                
                 while(rs.next())
                {
                     modelEditItem.addElement(rs.getString(3));
                     
                }

                String sql2 = "SELECT * FROM items where item_code like ? ";
                PreparedStatement pstt = con.prepareStatement(sql2);
                pstt.setString(1,val+"%");
                ResultSet r = pstt.executeQuery();
                
                 while(r.next())
                {
                     modelEditItem.addElement(r.getString(2));
                     
                }

            }
            else
            {
                
                modelEditItem.removeAllElements();
                
                
            }
        }
        catch(SQLException | HeadlessException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jTextFieldSearchIemsSettingsKeyReleased

    private void jListEditItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListEditItemMouseClicked
        if(!jListEditItem.isSelectionEmpty())
        {
            String a=((String) modelEditItem.getElementAt(jListEditItem.getSelectedIndex()));
            
            try
            {
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos_system","root","");  
                String sql = "SELECT * FROM items where item_name like ? ";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1,a);
                ResultSet r = pst.executeQuery();
                if(r.next())
                {
                    jTextFieldENo.setText(r.getString(1));
                    jTextField6EItemCode.setText(r.getString(2));
                    jTextFieldEItemName.setText(r.getString(3));
                    jTextFieldEQuantity.setText(r.getString(4));
                    jTextFieldEUnitPrice.setText(r.getString(5));
                    //jDateChooser1.setDateFormatString(r.getString(6));
                    //jDateChooser2.setDateFormatString(r.getString(7));
                    
                    
                    String d1=r.getString(6);
                    Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(d1);
                    jDateChooser1.setDate(date1);
                    
                    String d2=r.getString(7);
                    Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(d2);
                    jDateChooser2.setDate(date2);
                }
                String sql2 = "SELECT * FROM items where item_code like ? ";
                PreparedStatement pst2 = conn.prepareStatement(sql2);
                pst2.setString(1,a);
                ResultSet rs = pst2.executeQuery();
                if(rs.next())
                {
                   
                    jTextFieldENo.setText(rs.getString(1));
                    jTextField6EItemCode.setText(rs.getString(2));
                    jTextFieldEItemName.setText(rs.getString(3));
                    jTextFieldEQuantity.setText(rs.getString(4));
                    jTextFieldEUnitPrice.setText(rs.getString(5));
                    
                    //jDateChooser1.setDateFormatString(rs.getString(6));
                    //jDateChooser2.setDateFormatString(rs.getString(7));
                    
                    String d1=r.getString(6);
                    Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(d1);
                    jDateChooser1.setDate(date1);
                    
                    String d2=r.getString(7);
                    Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(d2);
                    jDateChooser2.setDate(date2);
                }

            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
            

            
            modelEditItem.removeAllElements();
            
            jTextFieldSearchIemsSettings.setText("Search");
            
            
            
           
        }
    }//GEN-LAST:event_jListEditItemMouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        jTextFieldSearchIemsSettings.setText("Search");
        
        modelEditItem.removeAllElements();
        
        jTextFieldENo.setText("");
        jTextField6EItemCode.setText("");
        jTextFieldEItemName.setText("");
        jTextFieldEQuantity.setText("");
        jTextFieldEUnitPrice.setText("");
        jDateChooser1.setDate(null);
        jDateChooser2.setDate(null);
       
        jTextFieldENo.setEditable(false);
        jTextField6EItemCode.setEditable(false);
        itemId();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        boolean in_the_array = false;
        try
        {
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos_system","root","");
            String sql = "SELECT * FROM `items ";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            String id = jTextField6EItemCode.getText();
            
            while(rs.next())
            {
                 if(rs.getString(2).equals(id))
                 {
                     in_the_array = true;
                 }
            }
        }
        catch(SQLException | NumberFormatException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        
        if(in_the_array)
        {
            JOptionPane.showMessageDialog(this, "This item is alrady added....");
        }
        else
        {
            if("".equals(jTextFieldEItemName.getText()) || "".equals(jTextFieldEQuantity.getText()) || "".equals(jTextFieldEUnitPrice.getText()))
            {
                JOptionPane.showMessageDialog(null,"Plase input right values...");
            }
            else
            {
                try{
                        Class.forName("com.mysql.jdbc.Driver");
                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos_system","root","");
                        String sql = "INSERT INTO items( item_code, item_name, quantity, Unit_price, manufacture_date, expire_date) VALUES (?,?,?,?,?,?)";
                        PreparedStatement pst = con.prepareStatement(sql);
                        pst.setString(1,jTextField6EItemCode.getText());
                        pst.setString(2,jTextFieldEItemName.getText());
                        pst.setString(3,jTextFieldEQuantity.getText());
                        pst.setString(4,jTextFieldEUnitPrice.getText());
                        //pst.setString(5,jTextFieldEMFD.getText());
                        //pst.setString(6,jTextFieldEEXP.getText());
                        
                        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
                        String dateMF = sdf.format(jDateChooser1.getDate());
                        pst.setString(5,dateMF);
                        
                        String dateEX = sdf.format(jDateChooser2.getDate());
                        pst.setString(6,dateEX);
                        
                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Inserted Sussess...");
                        
                        jTextFieldENo.setText("");
                        jTextField6EItemCode.setText("");
                        jTextFieldEItemName.setText("");
                        jTextFieldEQuantity.setText("");
                        jTextFieldEUnitPrice.setText("");
                        jDateChooser1.setDate(null);
                        jDateChooser2.setDate(null);
       
                        jTextFieldENo.setEditable(false);
                        jTextField6EItemCode.setEditable(false);
                        itemId();

            
        }
        catch(ClassNotFoundException | SQLException | HeadlessException ex)
        {
           JOptionPane.showMessageDialog(null,ex);
        }
            }
        }
        
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButtonDeleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleActionPerformed
         boolean in_the_array = false;
        try
        {
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos_system","root","");
            String sql = "SELECT * FROM `items ";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            String id = jTextField6EItemCode.getText();
            
            while(rs.next())
            {
                 if(rs.getString(2).equals(id))
                 {
                     in_the_array = true;
                 }
            }
        }
        catch(SQLException | NumberFormatException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        
        if(in_the_array)
        {
            try
            {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos_system","root","");
                String sql = "DELETE FROM `items` WHERE item_code=?";
                PreparedStatement pst= con.prepareStatement(sql);
                pst.setString(1,jTextField6EItemCode.getText());
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null,"Delete Sussess...");
                
                        jTextFieldENo.setText("");
                        jTextField6EItemCode.setText("");
                        jTextFieldEItemName.setText("");
                        jTextFieldEQuantity.setText("");
                        jTextFieldEUnitPrice.setText("");
                        jDateChooser1.setDate(null);
                        jDateChooser2.setDate(null);
       
                        jTextFieldENo.setEditable(false);
                        jTextField6EItemCode.setEditable(false);
                        itemId();
                
            }
            catch(SQLException | HeadlessException e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Plase select item first");
        }
    }//GEN-LAST:event_jButtonDeleActionPerformed

    private void jButtonUpdateIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateIActionPerformed
        boolean in_the_array = false;
        try
        {
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos_system","root","");
            String sql = "SELECT * FROM `items ";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            String id = jTextField6EItemCode.getText();
            
            while(rs.next())
            {
                 if(rs.getString(2).equals(id))
                 {
                     in_the_array = true;
                 }
            }
        }
        catch(SQLException | NumberFormatException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        
        if(in_the_array)
        {
            try
            {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos_system","root","");
                String sql = "UPDATE `items` SET item_name=?,quantity=?,Unit_price=?,manufacture_date=?,expire_date=? WHERE item_code=?";
                PreparedStatement pst= con.prepareStatement(sql);
                pst.setString(6,jTextField6EItemCode.getText());
                pst.setString(1,jTextFieldEItemName.getText());
                pst.setString(2,jTextFieldEQuantity.getText());
                pst.setString(3,jTextFieldEUnitPrice.getText());
                //pst.setString(4,jTextFieldEMFD.getText());
                //pst.setString(5,jTextFieldEEXP.getText());
                
                SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
                String dateMF = sdf.format(jDateChooser1.getDate());
                pst.setString(4,dateMF);
                        
                String dateEX = sdf.format(jDateChooser2.getDate());
                pst.setString(5,dateEX);
                
                
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null,"Update Sussess...");
                
                        jTextFieldENo.setText("");
                        jTextField6EItemCode.setText("");
                        jTextFieldEItemName.setText("");
                        jTextFieldEQuantity.setText("");
                        jTextFieldEUnitPrice.setText("");
                        jDateChooser1.setDate(null);
                        jDateChooser2.setDate(null);
       
                        jTextFieldENo.setEditable(false);
                        jTextField6EItemCode.setEditable(false);
                        itemId();
                
            }
            catch(SQLException | HeadlessException e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Plase select item first");
        }
    }//GEN-LAST:event_jButtonUpdateIActionPerformed

    private void jTextFieldESummaryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldESummaryMouseClicked
        jTextFieldESummary.setText("");
    }//GEN-LAST:event_jTextFieldESummaryMouseClicked

    private void jTextFieldESummaryKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldESummaryKeyReleased
         try
        {
            String val = jTextFieldESummary.getText();
            if(!val.equals(""))
            {
                modelEditSummary.removeAllElements();

                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos_system","root","");
                String sql = "SELECT * FROM order_summary where invoice_id like ? ";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1,val+"%");
                ResultSet rs = pst.executeQuery();
                
                 while(rs.next())
                {
                     modelEditSummary.addElement(rs.getString(1));
                     
                }
            }
            else
            {
                
                modelEditSummary.removeAllElements();
                
                
            }
        }
        catch(SQLException | HeadlessException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jTextFieldESummaryKeyReleased

    private void jListESummayListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListESummayListMouseClicked
        if(!jListESummayList.isSelectionEmpty())
        {
            select=((String)modelEditSummary.getElementAt(jListESummayList.getSelectedIndex()));
            
            try
            {
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos_system","root","");  
                String sql = "SELECT * FROM order_summary where invoice_id = ? ";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1,select);
                ResultSet r = pst.executeQuery();
                if(r.next())
                {
                    jTextArea1.setText(r.getString(6));

                }
                
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
            

            
            modelEditSummary.removeAllElements();
            
            jTextFieldESummary.setText(" Search");
            
           
        }
    }//GEN-LAST:event_jListESummayListMouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        jTextFieldESummary.setText(" Search");
        modelEditSummary.removeAllElements();
        jTextArea1.setText("");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        
        
        try
            {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos_system","root","");
                String sql = "DELETE FROM order_summary WHERE invoice_id=?";
                PreparedStatement pst= con.prepareStatement(sql);
                pst.setString(1,select);
                pst.executeUpdate();
                
                jTextFieldESummary.setText(" Search");
                modelEditSummary.removeAllElements();
                jTextArea1.setText("");
                JOptionPane.showMessageDialog(null,"Delete Sussess...");
            }
            catch(SQLException | HeadlessException e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if(JOptionPane.showConfirmDialog(frame,"Comform if you want to Reset all Invoice data", "Invoice data", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
        {
            try
            {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos_system","root","");
                String sql = "DELETE FROM `order_summary`";
                PreparedStatement pst= con.prepareStatement(sql);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Reset Sussess...");
            }
            catch(SQLException | HeadlessException e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
            
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jTextFieldEUserAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldEUserAccountMouseClicked
        jTextFieldEUserAccount.setText("");
    }//GEN-LAST:event_jTextFieldEUserAccountMouseClicked

    private void jTextFieldEUserAccountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEUserAccountKeyReleased
        try
        {
            String val = jTextFieldEUserAccount.getText();
            if(!val.equals(""))
            {

                modelEditUser.removeAllElements();
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos_system","root","");
                String sql = "SELECT * FROM loging_details where user_name like ? ";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1,val+"%");
                ResultSet rs = pst.executeQuery();
                
                 while(rs.next())
                {
                     modelEditUser.addElement(rs.getString(2));
                     
                }
            }
            else
            {
                
                modelEditUser.removeAllElements();
                
                
            }
        }
        catch(SQLException | HeadlessException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jTextFieldEUserAccountKeyReleased

    private void jListUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListUserMouseClicked
        if(!jListUser.isSelectionEmpty())
        {
            String a=((String)modelEditUser.getElementAt(jListUser.getSelectedIndex()));
            
            try
            {
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos_system","root","");  
                String sql = "SELECT * FROM loging_details WHERE user_name = ? ";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1,a);
                ResultSet r = pst.executeQuery();
                if(r.next())
                {
                    jTextFieldNoU.setText(r.getString(1));
                    jTextFieldUser.setText(r.getString(2));
                    jTextFieldPassword.setText(r.getString(3));
                    String typ =  (r.getString(4));
                    jTextFieldNic.setText(r.getString(5));
                    jTextFieldaddress.setText(r.getString(6));
                    jTextFieldMobile.setText(r.getString(7));
                    
                    if("admin".equals(typ))
                    {
                        jRadioButtonAdmin.setSelected(true);
                        jRadioButtonUser.setSelected(false);
                    }
                    else
                    {
                        jRadioButtonAdmin.setSelected(false);
                        jRadioButtonUser.setSelected(true);
                    }
                    
                    
                }
                
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
            

            
            modelEditUser.removeAllElements();
            
            jTextFieldEUserAccount.setText(" Search");
            
           
        }
    }//GEN-LAST:event_jListUserMouseClicked

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        
        boolean in_the_array = false;
        try
        {
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos_system","root","");
            String sql = "SELECT * FROM loging_details ";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            String id = jTextFieldUser.getText();
            
            while(rs.next())
            {
                 if(rs.getString(2).equals(id))
                 {
                     in_the_array = true;
                 }
            }
        }
        catch(SQLException | NumberFormatException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        
        if(in_the_array)
        {
            JOptionPane.showMessageDialog(this, "This Account is alrady added....");
        }
        else
        {
            if("".equals(jTextFieldUser.getText()) || "".equals(jTextFieldPassword.getText()) || "".equals(jTextFieldNic.getText())|| "".equals(jTextFieldaddress.getText())|| "".equals(jTextFieldMobile.getText()))
            {
                JOptionPane.showMessageDialog(null,"Plase input right values...");
            }
            else
            {
                String t;
                if(jRadioButtonAdmin.isSelected())
                {
                    t="admin";
                }
                else
                {
                    t="user";
                }
                
                
                
                try{
                        Class.forName("com.mysql.jdbc.Driver");
                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos_system","root","");
                        String sql = "INSERT INTO loging_details( user_name, password, user_type, id_no, address, mobile) VALUES (?,?,?,?,?,?)";
                        PreparedStatement pst = con.prepareStatement(sql);
                        pst.setString(1,jTextFieldUser.getText());
                        pst.setString(2,jTextFieldPassword.getText());
                        pst.setString(4,jTextFieldNic.getText());
                        pst.setString(5,jTextFieldaddress.getText());
                        pst.setString(6,jTextFieldMobile.getText());
                        pst.setString(3,t);
                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Account Added Sussess...");
                        
                        jTextFieldNoU.setText("");
                        jTextFieldUser.setText("");
                        jTextFieldPassword.setText("");
                        jTextFieldNic.setText("");
                        jTextFieldaddress.setText("");
                        jTextFieldMobile.setText("");
                        jRadioButtonAdmin.setSelected(false);
                        jRadioButtonUser.setSelected(true);
                        jTextFieldNoU.setEditable(false);


            
        }
        catch(ClassNotFoundException | SQLException | HeadlessException ex)
        {
           JOptionPane.showMessageDialog(null,ex);
        }
            }
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jRadioButtonAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonAdminActionPerformed
       
         jRadioButtonAdmin.setSelected(true);
         jRadioButtonUser.setSelected(false);
            
    }//GEN-LAST:event_jRadioButtonAdminActionPerformed

    private void jRadioButtonUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonUserActionPerformed

        jRadioButtonUser.setSelected(true);
         jRadioButtonAdmin.setSelected(false);

    }//GEN-LAST:event_jRadioButtonUserActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
                        jTextFieldNoU.setText("");
                        jTextFieldUser.setText("");
                        jTextFieldPassword.setText("");
                        jTextFieldNic.setText("");
                        jTextFieldaddress.setText("");
                        jTextFieldMobile.setText("");
                        jRadioButtonAdmin.setSelected(false);
                        jRadioButtonUser.setSelected(true);
                        jTextFieldNoU.setEditable(false);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        boolean in_the_array = false;
        try
        {
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos_system","root","");
            String sql = "SELECT * FROM loging_details";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            String id = jTextFieldUser.getText();
            
            while(rs.next())
            {
                 if(rs.getString(2).equals(id))
                 {
                     in_the_array = true;
                 }
            }
        }
        catch(SQLException | NumberFormatException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        String t;
                if(jRadioButtonAdmin.isSelected())
                {
                    t="admin";
                }
                else
                {
                    t="user";
                }
        
        
        if(in_the_array)
        {
            try
            {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos_system","root","");
                String sql = "UPDATE `loging_details` SET user_name=?,password=?,user_type=?,id_no=?,address=?,mobile=? WHERE user_name=?";
                PreparedStatement pst= con.prepareStatement(sql);
                pst.setString(1,jTextFieldUser.getText());
                pst.setString(2,jTextFieldPassword.getText());
                pst.setString(4,jTextFieldNic.getText());
                pst.setString(5,jTextFieldaddress.getText());
                pst.setString(6,jTextFieldMobile.getText());
                pst.setString(3,t);
                pst.setString(7,jTextFieldUser.getText());
                
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null,"Modify Sussess...");
                

       
                        jTextFieldNoU.setText("");
                        jTextFieldUser.setText("");
                        jTextFieldPassword.setText("");
                        jTextFieldNic.setText("");
                        jTextFieldaddress.setText("");
                        jTextFieldMobile.setText("");
                        jRadioButtonAdmin.setSelected(false);
                        jRadioButtonUser.setSelected(true);
                        jTextFieldNoU.setEditable(false);
                
            }
            catch(SQLException | HeadlessException e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Plase select Account first");
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        boolean in_the_array = false;
        try
        {
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos_system","root","");
            String sql = "SELECT * FROM loging_details";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            String id = jTextFieldUser.getText();
            
            while(rs.next())
            {
                 if(rs.getString(2).equals(id))
                 {
                     in_the_array = true;
                 }
            }
        }
        catch(SQLException | NumberFormatException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        
        if(in_the_array)
        {
            try
            {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos_system","root","");
                String sql = "DELETE FROM loging_details WHERE user_name=?";
                PreparedStatement pst= con.prepareStatement(sql);
                pst.setString(1,jTextFieldUser.getText());
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null,"Delete Sussess...");
                
                        jTextFieldNoU.setText("");
                        jTextFieldUser.setText("");
                        jTextFieldPassword.setText("");
                        jTextFieldNic.setText("");
                        jTextFieldaddress.setText("");
                        jTextFieldMobile.setText("");
                        jRadioButtonAdmin.setSelected(false);
                        jRadioButtonUser.setSelected(true);
                        jTextFieldNoU.setEditable(false);
       
                        
                
            }
            catch(SQLException | HeadlessException e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please select Account first");
        }
    }//GEN-LAST:event_jButton16ActionPerformed
/**/
    private JFrame frame;
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main_Page().setVisible(true);
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonBalance;
    private javax.swing.JButton jButtonCancleOrder;
    private javax.swing.JButton jButtonClearItems;
    private javax.swing.JButton jButtonDele;
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonExit1;
    private javax.swing.JButton jButtonLogOut;
    private javax.swing.JButton jButtonMax;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JButton jButtonSelectedDelete;
    private javax.swing.JButton jButtonTableReset;
    private javax.swing.JButton jButtonUpdateI;
    private javax.swing.JButton jButtondeleterow;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JLabel jLabelTime;
    private javax.swing.JLabel jLabelUserName;
    private javax.swing.JList jListESummayList;
    private javax.swing.JList jListEditItem;
    private javax.swing.JList jListIPrices;
    private javax.swing.JList jListOr;
    private javax.swing.JList jListSerch;
    private javax.swing.JList jListUser;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelHome;
    private javax.swing.JPanel jPanelHomeButton;
    private javax.swing.JPanel jPanelPrices;
    private javax.swing.JPanel jPanelPricesButton;
    private javax.swing.JPanel jPanelSettings;
    private javax.swing.JPanel jPanelSettongBtton;
    private javax.swing.JPanel jPanelSummary;
    private javax.swing.JPanel jPanelSummaryButton;
    private javax.swing.JPanel jPanelTitle;
    private javax.swing.JPanel jPanemain;
    private javax.swing.JRadioButton jRadioButtonAdmin;
    private javax.swing.JRadioButton jRadioButtonUser;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTableAllPrices;
    private javax.swing.JTable jTableExpireStock;
    private javax.swing.JTable jTableOrderSamary;
    private javax.swing.JTable jTablePrices;
    private javax.swing.JTable jTabledatabase;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextAreaBill;
    private javax.swing.JTextArea jTextAreaOrder;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField6EItemCode;
    private javax.swing.JTextField jTextFieldBalance;
    private javax.swing.JTextField jTextFieldEItemName;
    private javax.swing.JTextField jTextFieldENo;
    private javax.swing.JTextField jTextFieldEQuantity;
    private javax.swing.JTextField jTextFieldESummary;
    private javax.swing.JTextField jTextFieldEUnitPrice;
    private javax.swing.JTextField jTextFieldEUserAccount;
    private javax.swing.JTextField jTextFieldEXP;
    private javax.swing.JTextField jTextFieldItemName;
    private javax.swing.JTextField jTextFieldItemPrice;
    private javax.swing.JTextField jTextFieldItem_name;
    private javax.swing.JTextField jTextFieldMFD;
    private javax.swing.JTextField jTextFieldMobile;
    private javax.swing.JTextField jTextFieldNic;
    private javax.swing.JTextField jTextFieldNo;
    private javax.swing.JTextField jTextFieldNoU;
    private javax.swing.JPasswordField jTextFieldPassword;
    private javax.swing.JTextField jTextFieldPaymet;
    private javax.swing.JTextField jTextFieldQuantity;
    private javax.swing.JTextField jTextFieldQuentity;
    private javax.swing.JTextField jTextFieldSearch;
    private javax.swing.JTextField jTextFieldSearchIemsSettings;
    private javax.swing.JTextField jTextFieldSearchInvoicee;
    private javax.swing.JTextField jTextFieldSerchI;
    private javax.swing.JTextField jTextFieldTotal;
    private javax.swing.JTextField jTextFieldUnitPrice;
    private javax.swing.JTextField jTextFieldUser;
    private javax.swing.JTextField jTextFieldaddress;
    // End of variables declaration//GEN-END:variables

   
}
