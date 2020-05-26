/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.table.DefaultTableModel;
import support.StringHelper;

public class JFrameMain extends javax.swing.JFrame {
    
    private static String lang = "EN";
    private static int patternSelection = 0;

    public JFrameMain() {
        initComponents();
        
        loadJFrame();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupSearch = new javax.swing.ButtonGroup();
        btnLanguage = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        etPattern = new javax.swing.JTextField();
        panelResults = new javax.swing.JPanel();
        btnClean = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableResults = new javax.swing.JTable();
        lblNumResultsHeader = new javax.swing.JLabel();
        lblNumResults = new javax.swing.JLabel();
        lblPattern = new javax.swing.JLabel();
        etPath = new javax.swing.JTextField();
        panelOptions = new javax.swing.JPanel();
        rbEnds = new javax.swing.JRadioButton();
        rbStarts = new javax.swing.JRadioButton();
        rbContains = new javax.swing.JRadioButton();
        btnSearch = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblAuthor = new javax.swing.JLabel();
        lblYear = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        rbEN = new javax.swing.JRadioButton();
        rbES = new javax.swing.JRadioButton();
        lblStatusHeader = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        lblErrPattern = new javax.swing.JLabel();
        lblErrPath = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Grep App");
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(1100, 500));
        setPreferredSize(new java.awt.Dimension(600, 500));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Path or file:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 100, -1));

        etPattern.setText("Hello World");
        getContentPane().add(etPattern, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 95, 260, -1));

        panelResults.setBorder(javax.swing.BorderFactory.createTitledBorder("Results"));
        panelResults.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnClean.setText("Clean");
        panelResults.add(btnClean, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, 130, -1));

        tableResults.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableResults);

        panelResults.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 620, 360));

        lblNumResultsHeader.setText("Number of results: ");
        panelResults.add(lblNumResultsHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        lblNumResults.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblNumResults.setText("###");
        panelResults.add(lblNumResults, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 25, -1, -1));

        getContentPane().add(panelResults, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, 640, 430));

        lblPattern.setText("Pattern to search:");
        getContentPane().add(lblPattern, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        etPath.setText("X:/path/to/search");
        getContentPane().add(etPath, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 35, 260, -1));

        panelOptions.setBorder(javax.swing.BorderFactory.createTitledBorder("Search option"));
        panelOptions.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGroupSearch.add(rbEnds);
        rbEnds.setText("Ends with ...");
        panelOptions.add(rbEnds, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, -1, -1));

        btnGroupSearch.add(rbStarts);
        rbStarts.setText("Starts with ...");
        panelOptions.add(rbStarts, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 30, -1, -1));

        btnGroupSearch.add(rbContains);
        rbContains.setSelected(true);
        rbContains.setText("Contains ...");
        panelOptions.add(rbContains, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        getContentPane().add(panelOptions, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 370, 70));

        btnSearch.setBackground(java.awt.SystemColor.activeCaption);
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 125, -1));

        btnStop.setText("Stop");
        getContentPane().add(btnStop, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, 125, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAuthor.setText("Jorge Ribera");
        jPanel1.add(lblAuthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        lblYear.setText("2020");
        jPanel1.add(lblYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 100, 60));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Language")));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnLanguage.add(rbEN);
        rbEN.setSelected(true);
        rbEN.setText("EN");
        rbEN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbENActionPerformed(evt);
            }
        });
        jPanel2.add(rbEN, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 50, -1));

        btnLanguage.add(rbES);
        rbES.setText("ES");
        rbES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbESActionPerformed(evt);
            }
        });
        jPanel2.add(rbES, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 50, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 370, 130, 90));

        lblStatusHeader.setText("Status:");
        getContentPane().add(lblStatusHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, -1, -1));

        lblStatus.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblStatus.setText("Waiting");
        getContentPane().add(lblStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 325, -1, -1));

        lblErrPattern.setForeground(java.awt.Color.red);
        lblErrPattern.setText("This field can't be empty");
        getContentPane().add(lblErrPattern, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 125, -1, -1));

        lblErrPath.setForeground(java.awt.Color.red);
        lblErrPath.setText("This field can't be empty");
        getContentPane().add(lblErrPath, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 65, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbESActionPerformed
        lang = "es";
        changeLang();
    }//GEN-LAST:event_rbESActionPerformed

    private void rbENActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbENActionPerformed
        lang = "en";
        changeLang();
    }//GEN-LAST:event_rbENActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String strPath = etPath.getText().trim(),
                strPattern = etPattern.getText();
        
        if (!strPath.isEmpty() && !strPattern.isEmpty()) {
            
            checkPatternSelection();
            
            lblErrPath.setText("");
            lblErrPattern.setText("");
            
            File file = new File(strPath);
            if (!file.exists()) {
                lblErrPath.setText(StringHelper.errorPath404);
            } else {
                if (file.isDirectory()) {
                    ArrayList<File> files = new ArrayList<>(Arrays.asList(file.listFiles()));
                    
                    for (File f : files) {
                        Seeker s = new Seeker(f, strPattern, patternSelection);
                        s.start();
                    }
                } else {
//                    setTable();
                }
            }
        } else {
            if (strPath.isEmpty()) {
                lblErrPath.setText(StringHelper.errorPathEmpty);
            }
            if (strPattern.isEmpty()) {
                lblErrPattern.setText(StringHelper.errorPatternEmpty);
            }
        }
    }//GEN-LAST:event_btnSearchActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClean;
    private javax.swing.ButtonGroup btnGroupSearch;
    private javax.swing.ButtonGroup btnLanguage;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnStop;
    private javax.swing.JTextField etPath;
    private javax.swing.JTextField etPattern;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAuthor;
    private javax.swing.JLabel lblErrPath;
    private javax.swing.JLabel lblErrPattern;
    private javax.swing.JLabel lblNumResults;
    private javax.swing.JLabel lblNumResultsHeader;
    private javax.swing.JLabel lblPattern;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblStatusHeader;
    private javax.swing.JLabel lblYear;
    private javax.swing.JPanel panelOptions;
    private javax.swing.JPanel panelResults;
    private javax.swing.JRadioButton rbContains;
    private javax.swing.JRadioButton rbEN;
    private javax.swing.JRadioButton rbES;
    private javax.swing.JRadioButton rbEnds;
    private javax.swing.JRadioButton rbStarts;
    private javax.swing.JTable tableResults;
    // End of variables declaration//GEN-END:variables

    private void initiateTable() {
        String titles[] = {"File", "# of line", "Line"};
        DefaultTableModel m = new DefaultTableModel(null, titles) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // set table column uneditable
                return false;
            }
        };
        
        tableResults.setModel(m);
    }

    private void deactivatePanelResult() {
        panelResults.setEnabled(false);
        tableResults.setEnabled(false);
        btnClean.setEnabled(false);
        lblNumResults.setVisible(false);
    }

    private void changeLang() {
        if (lang.equals("en")) {
        } else {
        }
    }

    private void checkPatternSelection() {
        if (rbContains.isSelected()) {
            patternSelection = 0;
        } else if (rbStarts.isSelected()) {
            patternSelection = 1;
        } else  {
            patternSelection = 2;
        }
    }

    private void loadJFrame() {
        initiateTable();
        deactivatePanelResult();
        
        lblErrPath.setText("");
        lblErrPattern.setText("");
        etPath.setText("");
        etPattern.setText("");
    }
}
