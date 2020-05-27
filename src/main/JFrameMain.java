/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public JFrameMain() {
        initComponents();
        
        loadJFrame();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupSearch = new javax.swing.ButtonGroup();
        btnGroupLanguage = new javax.swing.ButtonGroup();
        btnGroupExtensions = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
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
        menuBar = new javax.swing.JMenuBar();
        menuHowTo = new javax.swing.JMenu();
        menuLang = new javax.swing.JMenu();
        rbmEn = new javax.swing.JRadioButtonMenuItem();
        rbmEs = new javax.swing.JRadioButtonMenuItem();
        menuAbout = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Grep App");
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(1100, 600));
        setPreferredSize(new java.awt.Dimension(600, 600));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        etPattern.setToolTipText("<html>The pattern you are looking for. Example: <code>Hello World!</code><br/>\nMeanig that, within the path/file, the program will search for <code>Hello World</code> and, if there is any results, they will be shown in the table.</html>");
        getContentPane().add(etPattern, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 260, -1));

        panelResults.setBorder(javax.swing.BorderFactory.createTitledBorder("Results"));
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
        getContentPane().add(etPath, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 260, -1));

        panelSearchConfig.setBorder(javax.swing.BorderFactory.createTitledBorder("Search configuration"));
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

        panelExtensionOption.setBorder(javax.swing.BorderFactory.createTitledBorder("Extension option"));
        panelExtensionOption.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGroupExtensions.add(rbAllExtensions);
        rbAllExtensions.setSelected(true);
        rbAllExtensions.setText("All non binare files");
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

        panelSearchOption.setBorder(javax.swing.BorderFactory.createTitledBorder("Search option"));
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

        getContentPane().add(panelSearchConfig, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 400, 510));

        menuHowTo.setText("How to use");
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
        menuBar.add(menuAbout);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        cleanTable();
        reset();
//        btnClean.setEnabled(true);
//        lblNumResults.setVisible(true);
//        lblNumResults.setText("0");
//        ResultCounterThread test = new ResultCounterThread(lblNumResults);
//        test.start();
        
        
//        StatusThread st = new StatusThread(lblStatus);
//        st.start();
//        st.setGo(true);
        
        String strPath = etPath.getText().trim(),
                strPattern = etPattern.getText(),
                strExtensions = etExtensions.getText().trim();
        
        // Both Path and Pattern and Ok
        if (!strPath.isEmpty() && !strPattern.isEmpty()) {
            // <editor-fold>
            
            // Hide the label errors
            lblErrPath.setText("");
            lblErrPattern.setText("");
            
            // Get the current option of pattern (contains, starts, ends)
            checkPatternSelection();
            
            // Check whether the path/file exists or not
            File file = new File(strPath);
            if (!file.exists()) {
                lblErrPath.setText(StringHelper.errorPath404);
            } else {
//                
                // Search within all non binary files
                if (rbAllExtensions.isSelected()) {
                    
                    btnClear.setEnabled(true);
                    lblNumResults.setVisible(true);
                    lblNumResults.setText("0");
                    checkForSupportThreads();

                    // Check whether is directory or not
                    if (file.isDirectory()) {
                        
                        numDirs++;
                        
                        ArrayList<File> files = new ArrayList<>(Arrays.asList(file.listFiles()));

                        for (File f : files) {
                            Seeker s = new Seeker(f, strPattern, patternSelection, null);
                            numThreads++;
                            s.start();
                        }
                    } else {
                        try {

                            synchronized(StatManager.class) {
                                numFiles++;
                            }
                            
                           
//                            ArrayList<Seeker> results = Seeker.readFile(file, strPattern, patternSelection);
                            Seeker.readFile(file, strPattern, patternSelection);
//                            for (Seeker s : results) {
//    //                            System.out.println(s.toString());
//                            }
                        } catch (IOException ex) {
                            Logger.getLogger(JFrameMain.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                // Search within the extensions that the user wants
                else {
                    if (!strExtensions.isEmpty()) {
                        if (strExtensions.contains(".")) {
                            btnClear.setEnabled(true);
                            lblNumResults.setVisible(true);
                            lblNumResults.setText("0");
                            checkForSupportThreads();
                            
                            ArrayList<String> listExtensions = getExtensions(strExtensions);

                            // Check whether is directory or not
                            if (file.isDirectory()) {

                                numDirs++;

                                ArrayList<File> files = new ArrayList<>(Arrays.asList(file.listFiles()));

                                // New thread is created for each file
                                for (File f : files) {
                                    Seeker s = new Seeker(f, strPattern, patternSelection, listExtensions);
                                    numThreads++;
                                    s.start();
                                }
                            } 
                            // Is file
                            else {
                                // Check whether the file extension matches any of the extensions user inputed
                                for (String ext : listExtensions) {
                                    if (hasSameExtension(file.getName(), ext)) {
                                        try {

                                synchronized(StatManager.class) {
                                    numFiles++;
                                }


    //                                        ArrayList<Seeker> results = Seeker.readFile(file, strPattern, patternSelection);
                                            Seeker.readFile(file, strPattern, patternSelection);
    //                                        for (Seeker s : results) {
    //                //                            System.out.println(s.toString());
    //                                        }
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
        // Either Path or Pattern are emty
        else {
            // <editor-fold>
            if (strPath.isEmpty()) {
                lblErrPath.setText(StringHelper.errorPathEmpty);
            }
            if (strPattern.isEmpty()) {
                lblErrPattern.setText(StringHelper.errorPatternEmpty);
            }
            // </editor-fold>
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
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
    private javax.swing.JTextField etExtensions;
    private javax.swing.JTextField etPath;
    private javax.swing.JTextField etPattern;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblErrPath;
    private javax.swing.JLabel lblErrPattern;
    private javax.swing.JLabel lblNumResults;
    private javax.swing.JLabel lblNumResultsHeader;
    private javax.swing.JLabel lblPath;
    private javax.swing.JLabel lblPattern;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblStatusHeader;
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
    
    
    private void setTable() {
        String titles[] = {StringHelper.file, StringHelper.numOfLine, StringHelper.line};
//        String titles[] = {"File", "# of line", "Line"};
        model = new DefaultTableModel(null, titles) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // set table column uneditable
                return false;
            }
        };
        
        tableResults.setModel(model);
        
//        tableResults.getTableHeader().setResizingAllowed(false);
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
//        if (lang.equals("en")) {
//        } else {
//        }
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
//        lblStatus.setText("Waiting");
        
        etPath.requestFocus();
    }
    
    private ArrayList<String> getExtensions(String str) {
        str = str.replace(" ", "");
        String arrExtensions[] = str.split(",");
        
         return new ArrayList<String>(Arrays.asList(arrExtensions));
    }

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
            StringHelper.errorPath404 = StringSpanish.errorPath404_ES;
            StringHelper.errorPathEmpty = StringSpanish.errorPathEmpty_ES;
            StringHelper.errorPatternEmpty = StringSpanish.errorPatternEmpty_ES;
            StringHelper.status = StringSpanish.status_ES;
            StringHelper.finished = StringSpanish.finished_ES;
            StringHelper.searching1 = StringSpanish.searching1_ES;
            StringHelper.searching2 = StringSpanish.searching2_ES;
            StringHelper.searching3 = StringSpanish.searching3_ES;
            StringHelper.waiting = StringSpanish.waiting_ES;
            StringHelper.file = StringSpanish.file_ES;
            StringHelper.numOfLine = StringSpanish.numOfLine_ES;
            StringHelper.line = StringSpanish.line_ES;
            StringHelper.numOfResults = StringSpanish.numOfResults_ES;
            StringHelper.pathOrFile = StringSpanish.pathOrFile_ES;
            StringHelper.pattern = StringSpanish.pattern_ES;
            StringHelper.searchConfiguration = StringSpanish.searchConfiguration_ES;
            StringHelper.searchOption = StringSpanish.searchOption_ES;
            StringHelper.extensionOption = StringSpanish.extensionOption_ES;
            StringHelper.results = StringSpanish.results_ES;
            StringHelper.search = StringSpanish.search_ES;
            StringHelper.reset = StringSpanish.reset_ES;
            StringHelper.clear = StringSpanish.clear_ES;
            StringHelper.contains = StringSpanish.contains_ES;
            StringHelper.endsWith = StringSpanish.endsWith_ES;
            StringHelper.startsWith = StringSpanish.startsWith_ES;
            StringHelper.allNonBinary = StringSpanish.allNonBinary_ES;
            StringHelper.specificExtensions = StringSpanish.specificExtensions_ES;
            StringHelper.howToUse = StringSpanish.howToUse_ES;
            StringHelper.language = StringSpanish.language_ES;
            StringHelper.spanish = StringSpanish.spanish_ES;
            StringHelper.english = StringSpanish.english_ES;
            StringHelper.about = StringSpanish.about_ES;
        } else {
            StringHelper.errorPath404 = StringEnglish.errorPath404;
            StringHelper.errorPathEmpty = StringEnglish.errorPathEmpty;
            StringHelper.errorPatternEmpty = StringEnglish.errorPatternEmpty;
            StringHelper.status = StringEnglish.status;
            StringHelper.finished = StringEnglish.finished;
            StringHelper.searching1 = StringEnglish.searching1;
            StringHelper.searching2 = StringEnglish.searching2;
            StringHelper.searching3 = StringEnglish.searching3;
            StringHelper.waiting = StringEnglish.about;
            StringHelper.numOfResults = StringEnglish.numOfResults;
            StringHelper.file = StringEnglish.file;
            StringHelper.numOfLine = StringEnglish.numOfLine;
            StringHelper.line = StringEnglish.line;
            StringHelper.pathOrFile = StringEnglish.pathOrFile;
            StringHelper.pattern = StringEnglish.pattern;
            StringHelper.searchConfiguration = StringEnglish.searchConfiguration;
            StringHelper.searchOption = StringEnglish.searchOption;
            StringHelper.extensionOption = StringEnglish.extensionOption;
            StringHelper.results = StringEnglish.results;
            StringHelper.search = StringEnglish.search;
            StringHelper.reset = StringEnglish.reset;
            StringHelper.clear = StringEnglish.clear;
            StringHelper.contains = StringEnglish.contains;
            StringHelper.endsWith = StringEnglish.endsWith;
            StringHelper.startsWith = StringEnglish.startsWith;
            StringHelper.allNonBinary = StringEnglish.allNonBinary;
            StringHelper.specificExtensions = StringEnglish.specificExtensions;
            StringHelper.howToUse = StringEnglish.howToUse;
            StringHelper.language = StringEnglish.language;
            StringHelper.spanish = StringEnglish.spanish;
            StringHelper.english = StringEnglish.english;
            StringHelper.about = StringEnglish.about;
        }
    }

    private void setStrings() {
//        lblErrPattern.setText(StringHelper.errorPatternEmpty);
        lblStatusHeader.setText(StringHelper.status);
        if (lblErrPath.getText().contains("empty") ||
                lblErrPath.getText().contains("vacío")) {
            lblErrPath.setText(StringHelper.errorPathEmpty);
        } else if (lblErrPath.getText().contains("exists") ||
                lblErrPath.getText().contains("existe")){
            lblErrPath.setText(StringHelper.errorPath404);
        }
        
        if (lblErrPattern.getText().contains("empty") ||
                lblErrPattern.getText().contains("vacío")) {
            lblErrPattern.setText(StringHelper.errorPatternEmpty);
        }
        lblStatus.setText(StringHelper.waiting);
        setTable();
        lblPath.setText(StringHelper.pathOrFile);
        lblPattern.setText(StringHelper.pattern);
        panelSearchConfig.setBorder(javax.swing.BorderFactory.createTitledBorder(StringHelper.searchConfiguration));
        panelSearchOption.setBorder(javax.swing.BorderFactory.createTitledBorder(StringHelper.searchOption));
        panelExtensionOption.setBorder(javax.swing.BorderFactory.createTitledBorder(StringHelper.extensionOption));
        panelResults.setBorder(javax.swing.BorderFactory.createTitledBorder(StringHelper.results));
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
    }
}
