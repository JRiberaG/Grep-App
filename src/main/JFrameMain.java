/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template FILE, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import language.StringEnglish;
import language.StringSpanish;
import support.StatManager;
import static support.StatManager.numDirs;
import static support.StatManager.numFiles;
import static support.StatManager.numThreads;
import static support.StatManager.reset;
import support.StatusThread;
import support.StringHelper;
import support.ResultCounterThread;
import support.Utils;
import static support.Utils.getExtensions;
import static support.Utils.hasSameExtension;

public class JFrameMain extends javax.swing.JFrame {
    
    public static final int CONTAINS = 0;
    public static final int STARTS_WITH = 1;
    public static final int ENDS_WITH = 2;
    
    private static String lang = "EN";
    private static int patternSelection = 0;
    
    private static StatusThread stThread;
    private static ResultCounterThread rcThread;
    
    public static DefaultTableModel model;
    
    private static JFileChooser openFileChooser;
    
    static ArrayList<String> listExtensions;
    static String rootPath;

    public JFrameMain() {
        initComponents();
        
        loadJFrame();
        configFileChooser();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupSearch = new javax.swing.ButtonGroup();
        btnGroupLanguage = new javax.swing.ButtonGroup();
        btnGroupExtensions = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        dialogAbout = new javax.swing.JDialog();
        lblAuthor = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblVersion = new javax.swing.JLabel();
        lblGithub = new javax.swing.JLabel();
        dialogHowTo = new javax.swing.JDialog();
        lblHowTo = new javax.swing.JLabel();
        etPattern = new javax.swing.JTextField();
        panelResults = new javax.swing.JPanel();
        btnClear = new javax.swing.JButton();
        lblNumResultsHeader = new javax.swing.JLabel();
        lblNumResults = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableResults = new javax.swing.JTable();
        etPath = new javax.swing.JTextField();
        panelSearchConfig = new javax.swing.JPanel();
        lblStatus = new javax.swing.JLabel();
        lblStatusHeader = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        panelExtensionOption = new javax.swing.JPanel();
        rbAllExtensions = new javax.swing.JRadioButton();
        rbSpecificExtensions = new javax.swing.JRadioButton();
        etExtensions = new javax.swing.JTextField();
        panelSearchOption = new javax.swing.JPanel();
        rbEnds = new javax.swing.JRadioButton();
        rbStarts = new javax.swing.JRadioButton();
        rbContains = new javax.swing.JRadioButton();
        lblErrPath = new javax.swing.JLabel();
        lblErrPattern = new javax.swing.JLabel();
        lblPattern = new javax.swing.JLabel();
        lblPath = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lblWarning = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        menuHowTo = new javax.swing.JMenu();
        menuLang = new javax.swing.JMenu();
        rbmEn = new javax.swing.JRadioButtonMenuItem();
        rbmEs = new javax.swing.JRadioButtonMenuItem();
        menuAbout = new javax.swing.JMenu();

        dialogAbout.setTitle("About - GrepApp");
        dialogAbout.setLocationByPlatform(true);
        dialogAbout.setMinimumSize(new java.awt.Dimension(225, 190));
        dialogAbout.setModal(true);
        dialogAbout.setResizable(false);
        dialogAbout.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAuthor.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblAuthor.setText("Jorge Ribera");
        dialogAbout.getContentPane().add(lblAuthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        lblDate.setText("may 2020");
        dialogAbout.getContentPane().add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        lblVersion.setText("Version 1.0");
        dialogAbout.getContentPane().add(lblVersion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        lblGithub.setText("https://www.github.com/jriberag");
        dialogAbout.getContentPane().add(lblGithub, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        dialogHowTo.setTitle("How to use the app - GrepApp");
        dialogHowTo.setMinimumSize(new java.awt.Dimension(700, 400));
        dialogHowTo.setResizable(false);
        dialogHowTo.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblHowTo.setText("<html>\n<h3>How to use the app</h3>\n<p> The objective of this app is to locate within the path or the file the pattern given by the user, quite useful when you know you wrote something like <code>Hello World!</code> but you can't remember where...<br/>\n<h4>Steps to follow:</h4>\n1) Type (copy/paste if you like) the path or the file in the corresponding field.<br/>\n2) Type the pattern to search, for example, <code>Hello World!</code><br/>\n3) Select where do you want or do you except to find the pattern, either within the whole file, just at the beginning or at the very end. <br/>\n4) Select the kind of files you want to search on, either all the binary files or just those who have a concrete extension, for example: <code>.json, .cpp, .java, .html,</code> ... <br/>\n5) Press <b>Search</b> and wait until the status stays as <i>Finished</i>. <br/><br/>\nIn case you want to reset the fields to their default value, press <b>Reset</b>.<br/>\nIn case you want to clear the data from the results, press <b>Clear</b>.<br/><br/>\n\n<p style=\"color:orange\">Warning! If your search is large your computer probably will crash. Try to <b>narrow it down</b> as much as possible.</p><br/>\nAny suggestion, doubt  or constructive criticism is very welcomed!<br/>\n(Link to my GitHub in the <b>About</b> menu)<br/>\n</html>\n");
        lblHowTo.setMinimumSize(new java.awt.Dimension(300, 300));
        lblHowTo.setPreferredSize(new java.awt.Dimension(300, 300));
        dialogHowTo.getContentPane().add(lblHowTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 670, 370));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Grep App");
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(1100, 600));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        etPattern.setToolTipText("<html>The pattern you are looking for. Example: <code>Hello World!</code><br/>\nMeanig that, within the path/file, the program will search for <code>Hello World</code> and, if there is any results, they will be shown in the table.</html>");
        etPattern.setNextFocusableComponent(rbContains);
        getContentPane().add(etPattern, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 260, -1));

        panelResults.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), "Results", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12))); // NOI18N
        panelResults.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        panelResults.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, 130, -1));

        lblNumResultsHeader.setText("Number of results: ");
        panelResults.add(lblNumResultsHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        lblNumResults.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblNumResults.setText("###");
        panelResults.add(lblNumResults, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 25, -1, -1));

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
        tableResults.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(tableResults);

        panelResults.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 620, 440));

        getContentPane().add(panelResults, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, 640, 510));

        etPath.setToolTipText("<html>The path/file where the pattern will be searched. Example: <code>C:\\Users\\Downloads</code></html>");
        etPath.setNextFocusableComponent(etPattern);
        getContentPane().add(etPath, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 230, -1));

        panelSearchConfig.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), "Search configuration", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12))); // NOI18N
        panelSearchConfig.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblStatus.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblStatus.setText("Waiting");
        panelSearchConfig.add(lblStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 465, -1, -1));

        lblStatusHeader.setText("Status:");
        panelSearchConfig.add(lblStatusHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 470, -1, -1));

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        panelSearchConfig.add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 410, 125, -1));

        btnSearch.setBackground(java.awt.SystemColor.activeCaption);
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        panelSearchConfig.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 410, 125, -1));

        panelExtensionOption.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Extension option", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 0, 12))); // NOI18N
        panelExtensionOption.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGroupExtensions.add(rbAllExtensions);
        rbAllExtensions.setSelected(true);
        rbAllExtensions.setText("All files");
        rbAllExtensions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAllExtensionsActionPerformed(evt);
            }
        });
        panelExtensionOption.add(rbAllExtensions, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        btnGroupExtensions.add(rbSpecificExtensions);
        rbSpecificExtensions.setText("Specific extensions:");
        rbSpecificExtensions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSpecificExtensionsActionPerformed(evt);
            }
        });
        panelExtensionOption.add(rbSpecificExtensions, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        etExtensions.setToolTipText("<html>Separate the extensions just like this: .extension<b>,</b> .extension<b>,</b> .extension<br/>\nExample: <code>.java, .json, .xml, .txt</code></html/>");
        etExtensions.setEnabled(false);
        panelExtensionOption.add(etExtensions, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 55, 190, -1));

        panelSearchConfig.add(panelExtensionOption, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 370, 100));

        panelSearchOption.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Search option", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 0, 12))); // NOI18N
        panelSearchOption.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGroupSearch.add(rbEnds);
        rbEnds.setText("Ends with ...");
        panelSearchOption.add(rbEnds, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, -1, -1));

        btnGroupSearch.add(rbStarts);
        rbStarts.setText("Starts with ...");
        panelSearchOption.add(rbStarts, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 30, -1, -1));

        btnGroupSearch.add(rbContains);
        rbContains.setSelected(true);
        rbContains.setText("Contains ...");
        panelSearchOption.add(rbContains, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        panelSearchConfig.add(panelSearchOption, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 370, 70));

        lblErrPath.setForeground(java.awt.Color.red);
        lblErrPath.setText("This field can't be empty");
        panelSearchConfig.add(lblErrPath, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, -1, -1));

        lblErrPattern.setForeground(java.awt.Color.red);
        lblErrPattern.setText("This field can't be empty");
        panelSearchConfig.add(lblErrPattern, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, -1, -1));

        lblPattern.setText("Pattern to search:");
        panelSearchConfig.add(lblPattern, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 95, -1, -1));

        lblPath.setText("Path or file:");
        panelSearchConfig.add(lblPath, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 35, 100, -1));

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelSearchConfig.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 28, 30, 30));

        getContentPane().add(panelSearchConfig, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 400, 510));

        lblWarning.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblWarning.setForeground(new java.awt.Color(255, 153, 51));
        lblWarning.setText("<html>\n\t<head>\n\t\t<style>\n\t\t</style>\n\t</head>\n\t<body>\n\t\t<p>Warning !</p>\n\t</body>\n</html>");
        lblWarning.setToolTipText("<html>Be careful! If your search is large your computer probably will crash. Try to <b>narrow it down</b> as much as possible.</html>");
        getContentPane().add(lblWarning, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 10, -1, 20));

        menuHowTo.setText("How to use");
        menuHowTo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuHowToMouseClicked(evt);
            }
        });
        menuBar.add(menuHowTo);

        menuLang.setText("Language");

        btnGroupLanguage.add(rbmEn);
        rbmEn.setSelected(true);
        rbmEn.setText("English");
        rbmEn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbmEnActionPerformed(evt);
            }
        });
        menuLang.add(rbmEn);

        btnGroupLanguage.add(rbmEs);
        rbmEs.setText("Spanish");
        rbmEs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbmEsActionPerformed(evt);
            }
        });
        menuLang.add(rbmEs);

        menuBar.add(menuLang);

        menuAbout.setText("About");
        menuAbout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuAboutMouseClicked(evt);
            }
        });
        menuBar.add(menuAbout);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        cleanTable();
        reset();   
        String strPath = etPath.getText().trim(),
                strPattern = etPattern.getText(),
                strExtensions = etExtensions.getText().trim();
        
        // Both Path and Pattern and Ok
        if (!strPath.isEmpty() && !strPattern.isEmpty()) {
            // <editor-fold>
            rootPath = "";
            // Hide the label errors
            lblErrPath.setText("");
            lblErrPattern.setText("");
            
            // Get the current option of PATTERN (CONTAINS, starts, ends)
            checkPatternSelection();
            
            // Check whether the path/file exists or not
            File file = new File(strPath);
            if (!file.exists()) {
                lblErrPath.setText(StringHelper.errorPath404);
            } else {
                rootPath = etPath.getText();
                if (!rootPath.endsWith(File.separator)){
                    rootPath += File.separator;
                }
                enablePanelResults();
                checkForSupportThreads();
                // Search within all non binary files
                if (rbAllExtensions.isSelected()) {
                    listExtensions.clear();
                    // Check whether is directory or not
                    if (file.isDirectory()) {
                        numDirs++;
                        ArrayList<File> files = new ArrayList<>(Arrays.asList(file.listFiles()));

                        for (File f : files) {
                            Seeker s = new Seeker(f, strPattern, patternSelection, false);
                            numThreads++;
                            s.start();
                        }
                    } else {
                        try {
                            synchronized(StatManager.class) {
                                numFiles++;
                            }
                            Seeker.readFile(file, strPattern, patternSelection);
                        } catch (IOException ex) {
                            Logger.getLogger(JFrameMain.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                // Search within the extensions that the user wants
                else {
                    if (!strExtensions.isEmpty()) {
                        if (strExtensions.contains(".")) {
                            
                            listExtensions = getExtensions(strExtensions);
                            

                            // Check whether is directory or not
                            if (file.isDirectory()) {
                                numDirs++;
                                ArrayList<File> files = new ArrayList<>(Arrays.asList(file.listFiles()));

                                // New thread is created for each FILE
                                for (File f : files) {
                                    Seeker s = new Seeker(f, strPattern, patternSelection, true);
                                    numThreads++;
                                    s.start();
                                }
                            } 
                            // Is FILE
                            else {
                                // Check whether the FILE extension matches any of the extensions user inputed
                                for (String ext : listExtensions) {
                                    if (hasSameExtension(file.getName(), ext)) {
                                        try {
                                            synchronized(StatManager.class) {
                                                numFiles++;
                                            }
                                            Seeker.readFile(file, strPattern, patternSelection);
                                        } catch (IOException ex) {
                                            Logger.getLogger(JFrameMain.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    } else {
                                        // Didn't match, goes for the next one
                                    }
                                }
                            }
                        } else {
                            // Wrong extensions
                        }
                    }
                }
            }
        // </editor-fold>
        } 
        // Either Path or Pattern are empty
        else {
            // <editor-fold>
            if (strPath.isEmpty()) {
                lblErrPath.setText(StringHelper.errorFieldEmpty);
            }
            if (strPattern.isEmpty()) {
                lblErrPattern.setText(StringHelper.errorFieldEmpty);
            }
            // </editor-fold>
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // Reset the stats (# of results, # of read files, ...)
        reset();
        
        cleanTable();
        
        btnClear.setEnabled(false);
        stThread.setGo(false);
        lblNumResults.setVisible(false);
    }//GEN-LAST:event_btnClearActionPerformed

    private void rbSpecificExtensionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSpecificExtensionsActionPerformed
        if (rbSpecificExtensions.isSelected()) {
            etExtensions.setEnabled(true);
        }
    }//GEN-LAST:event_rbSpecificExtensionsActionPerformed

    private void rbAllExtensionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAllExtensionsActionPerformed
        if (rbAllExtensions.isSelected()) {
            etExtensions.setEnabled(false);
            etExtensions.setText("");
        }
    }//GEN-LAST:event_rbAllExtensionsActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        loadJFrame();
    }//GEN-LAST:event_btnResetActionPerformed

    private void rbmEsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbmEsActionPerformed
        lang = "es";
        changeLang();
    }//GEN-LAST:event_rbmEsActionPerformed

    private void rbmEnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbmEnActionPerformed
        lang = "en";
        changeLang();
    }//GEN-LAST:event_rbmEnActionPerformed

    private void menuHowToMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuHowToMouseClicked
        dialogHowTo.setVisible(true);
    }//GEN-LAST:event_menuHowToMouseClicked

    private void menuAboutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuAboutMouseClicked
        dialogAbout.setVisible(true);
    }//GEN-LAST:event_menuAboutMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int returnValue = openFileChooser.showOpenDialog(this);
        
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            etPath.setText(openFileChooser.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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

    // <editor-fold defaultstate="collapsed" desc="Variables">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.ButtonGroup btnGroupExtensions;
    private javax.swing.ButtonGroup btnGroupLanguage;
    private javax.swing.ButtonGroup btnGroupSearch;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSearch;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JDialog dialogAbout;
    private javax.swing.JDialog dialogHowTo;
    private javax.swing.JTextField etExtensions;
    private javax.swing.JTextField etPath;
    private javax.swing.JTextField etPattern;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAuthor;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblErrPath;
    private javax.swing.JLabel lblErrPattern;
    private javax.swing.JLabel lblGithub;
    private javax.swing.JLabel lblHowTo;
    private javax.swing.JLabel lblNumResults;
    private javax.swing.JLabel lblNumResultsHeader;
    private javax.swing.JLabel lblPath;
    private javax.swing.JLabel lblPattern;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblStatusHeader;
    private javax.swing.JLabel lblVersion;
    private javax.swing.JLabel lblWarning;
    private javax.swing.JMenu menuAbout;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuHowTo;
    private javax.swing.JMenu menuLang;
    private javax.swing.JPanel panelExtensionOption;
    private javax.swing.JPanel panelResults;
    private javax.swing.JPanel panelSearchConfig;
    private javax.swing.JPanel panelSearchOption;
    private javax.swing.JRadioButton rbAllExtensions;
    private javax.swing.JRadioButton rbContains;
    private javax.swing.JRadioButton rbEnds;
    private javax.swing.JRadioButton rbSpecificExtensions;
    private javax.swing.JRadioButton rbStarts;
    private javax.swing.JRadioButtonMenuItem rbmEn;
    private javax.swing.JRadioButtonMenuItem rbmEs;
    private javax.swing.JTable tableResults;
    // End of variables declaration//GEN-END:variables
    // </editor-fold>
    
    
    private void loadJFrame() {
        setTable();
        deactivatePanelResult();
        
        lblErrPath.setText("");
        lblErrPattern.setText("");
        etPath.setText("");
        etPattern.setText("");
        
        if (stThread != null) {
            stThread.setGo(false);
        }
        
        etPattern.requestFocus();
        etPath.requestFocus();
        
        rbContains.setSelected(true);
        rbAllExtensions.setSelected(true);
        etExtensions.setEnabled(false);
        etExtensions.setText("");
        
        listExtensions = new ArrayList<>();
        rootPath = "";
    }
    
    private void setTable() {
        String titles[] = {StringHelper.file, StringHelper.numOfLine, StringHelper.line};
        model = new DefaultTableModel(null, titles) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return true;
            }
        };
        
        tableResults.setModel(model);
        
        // Sets each columns width
        tableResults.getColumnModel().getColumn(0).setPreferredWidth(400);
        tableResults.getColumnModel().getColumn(1).setPreferredWidth(50);
        tableResults.getColumnModel().getColumn(2).setPreferredWidth(400);
    }

    private void deactivatePanelResult() {
        panelResults.setEnabled(false);
        tableResults.setEnabled(false);
        btnClear.setEnabled(false);
        lblNumResults.setVisible(false);
        lblNumResultsHeader.setEnabled(false);
    }

    private void changeLang() {
        setStringHelperStrings();
        setStrings();
    }

    private void checkPatternSelection() {
        if (rbContains.isSelected()) {
            patternSelection = CONTAINS;
        } else if (rbStarts.isSelected()) {
            patternSelection = STARTS_WITH;
        } else  {
            patternSelection = ENDS_WITH;
        }
    }
    
    /**
     * Removes all the rows
     */
    private void cleanTable() {
        DefaultTableModel dm = (DefaultTableModel)tableResults.getModel();
        for (int i = tableResults.getModel().getRowCount() - 1; i >= 0; i--) {
            dm.removeRow(i);
        }
    }

    private void checkForSupportThreads() {
        if (stThread == null) {
            stThread = new StatusThread(lblStatus);
            stThread.start();
        }
        stThread.setGo(true);

        if (rcThread == null) {
            rcThread = new ResultCounterThread(lblNumResults);
            rcThread.start();
        }
        rcThread.setGo(true);
    }

    private void setStringHelperStrings() {
        if (lang.equals("es")) {
            StringHelper.errorPath404 = StringSpanish.ERROR_PATH_404_ES;
            StringHelper.errorFieldEmpty = StringSpanish.ERROR_FIELD_EMTY_ES;
            StringHelper.status = StringSpanish.STATUS_ES;
            StringHelper.finished = StringSpanish.FINISHED_ES;
            StringHelper.searching1 = StringSpanish.SEARCHING1_ES;
            StringHelper.searching2 = StringSpanish.SEARCHING2_ES;
            StringHelper.searching3 = StringSpanish.SEARCHING3_ES;
            StringHelper.waiting = StringSpanish.WAITING_ES;
            StringHelper.file = StringSpanish.FILE_ES;
            StringHelper.numOfLine = StringSpanish.NUM_OF_LINE_ES;
            StringHelper.line = StringSpanish.LINE_ES;
            StringHelper.numOfResults = StringSpanish.NUM_OF_RESULTS_ES;
            StringHelper.pathOrFile = StringSpanish.PATH_OR_FILE_ES;
            StringHelper.pattern = StringSpanish.PATTERN_ES;
            StringHelper.searchConfiguration = StringSpanish.SEARCH_CONFIG_ES;
            StringHelper.searchOption = StringSpanish.SEARCH_OPTION_ES;
            StringHelper.extensionOption = StringSpanish.EXTENSION_OPTION_ES;
            StringHelper.results = StringSpanish.RESULTS_ES;
            StringHelper.search = StringSpanish.SEARCH_ES;
            StringHelper.reset = StringSpanish.RESET_ES;
            StringHelper.clear = StringSpanish.CLEAR_ES;
            StringHelper.contains = StringSpanish.CONTAINS_ES;
            StringHelper.endsWith = StringSpanish.ENDS_WITH_ES;
            StringHelper.startsWith = StringSpanish.STARTS_WITH_ES;
            StringHelper.allNonBinary = StringSpanish.ALL_NON_BINARY_FILES_ES;
            StringHelper.specificExtensions = StringSpanish.SPECIFIC_EXTENSIONS_ES;
            StringHelper.howToUse = StringSpanish.HOW_TO_USE_ES;
            StringHelper.language = StringSpanish.LANGUAGE_ES;
            StringHelper.spanish = StringSpanish.SPANISH_ES;
            StringHelper.english = StringSpanish.ENGLISH_ES;
            StringHelper.about = StringSpanish.ABOUT_ES;
            StringHelper.howToSteps = StringSpanish.HOW_TO_STEPS_ES;
            StringHelper.titleAbout = StringSpanish.TITLE_ABOUT_ES;
            StringHelper.titleHowTo = StringSpanish.TITLE_HOW_TO_ES;
        } else {
            StringHelper.errorPath404 = StringEnglish.ERROR_PATH_404;
            StringHelper.errorFieldEmpty = StringEnglish.ERROR_FIELD_EMPTY;
            StringHelper.status = StringEnglish.STATUS;
            StringHelper.finished = StringEnglish.FINISHED;
            StringHelper.searching1 = StringEnglish.SEARCHING1;
            StringHelper.searching2 = StringEnglish.SEARCHING2;
            StringHelper.searching3 = StringEnglish.SEARCHING3;
            StringHelper.waiting = StringEnglish.WAITING;
            StringHelper.numOfResults = StringEnglish.NUM_OF_RESULTS;
            StringHelper.file = StringEnglish.FILE;
            StringHelper.numOfLine = StringEnglish.NUM_OF_LINE;
            StringHelper.line = StringEnglish.LINE;
            StringHelper.pathOrFile = StringEnglish.PATH_OR_FILE;
            StringHelper.pattern = StringEnglish.PATTERN;
            StringHelper.searchConfiguration = StringEnglish.SEARCH_CONFIG;
            StringHelper.searchOption = StringEnglish.SEARCH_OPTION;
            StringHelper.extensionOption = StringEnglish.EXTENSION_OPTION;
            StringHelper.results = StringEnglish.RESULTS;
            StringHelper.search = StringEnglish.SEARCH;
            StringHelper.reset = StringEnglish.RESET;
            StringHelper.clear = StringEnglish.CLEAR;
            StringHelper.contains = StringEnglish.CONTAINS;
            StringHelper.endsWith = StringEnglish.ENDS_WIDTH;
            StringHelper.startsWith = StringEnglish.START_WITH;
            StringHelper.allNonBinary = StringEnglish.ALL_BINARY_NON_FILES;
            StringHelper.specificExtensions = StringEnglish.SPECIFIC_EXTENSIONS;
            StringHelper.howToUse = StringEnglish.HOW_TO_USE;
            StringHelper.language = StringEnglish.LANGUAGE;
            StringHelper.spanish = StringEnglish.SPANISH;
            StringHelper.english = StringEnglish.ENGLISH;
            StringHelper.about = StringEnglish.ABOUT;
            StringHelper.howToSteps = StringEnglish.TITLE_HOW_TO_STEPS;
            StringHelper.titleAbout = StringEnglish.TITLE_ABOUT;
            StringHelper.titleHowTo = StringEnglish.TITLE_HOW_TO;
        }
    }

    private void setStrings() {
        lblStatusHeader.setText(StringHelper.status);
        if (lblErrPath.getText().contains("empty") ||
                lblErrPath.getText().contains("vacío")) {
            lblErrPath.setText(StringHelper.errorFieldEmpty);
        } else if (lblErrPath.getText().contains("exists") ||
                lblErrPath.getText().contains("existe")){
            lblErrPath.setText(StringHelper.errorPath404);
        }
        
        if (lblErrPattern.getText().contains("empty") ||
                lblErrPattern.getText().contains("vacío")) {
            lblErrPattern.setText(StringHelper.errorFieldEmpty);
        }
        lblStatus.setText(StringHelper.waiting);
        setTable();
        lblPath.setText(StringHelper.pathOrFile);
        lblPattern.setText(StringHelper.pattern);
        panelSearchConfig.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), StringHelper.searchConfiguration, javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12))); // NOI18N
        panelResults.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), StringHelper.results, javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12)));
        panelSearchOption.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), StringHelper.searchOption, javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 0, 12))); // NOI18N
        panelExtensionOption.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), StringHelper.extensionOption, javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 0, 12))); // NOI18N
        btnSearch.setText(StringHelper.search);
        btnReset.setText(StringHelper.reset);
        btnClear.setText(StringHelper.clear);
        lblNumResultsHeader.setText(StringHelper.numOfResults);
        rbContains.setText(StringHelper.contains);
        rbStarts.setText(StringHelper.startsWith);
        rbEnds.setText(StringHelper.endsWith);
        rbAllExtensions.setText(StringHelper.allNonBinary);
        rbSpecificExtensions.setText(StringHelper.specificExtensions);
        menuHowTo.setText(StringHelper.howToUse);
        menuLang.setText(StringHelper.language);
        menuAbout.setText(StringHelper.about);
        rbmEs.setText(StringHelper.spanish);
        rbmEn.setText(StringHelper.english);
        lblHowTo.setText(StringHelper.howToSteps);
        dialogAbout.setTitle(StringHelper.titleAbout);
        dialogHowTo.setTitle(StringHelper.titleHowTo);
    }

    private void enablePanelResults() {
        panelResults.setEnabled(true);
        tableResults.setEnabled(true);
        btnClear.setEnabled(true);
        lblNumResultsHeader.setEnabled(true);
        lblNumResults.setVisible(true);
        lblNumResults.setText("0");
    }

    private void configFileChooser() {
        openFileChooser = new JFileChooser();
        openFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    }
}
