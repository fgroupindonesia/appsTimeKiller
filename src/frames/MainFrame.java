/*
 *  This is a Supplemental File from the Main Project used
 *  in APPSTIMERKILLER
 *  with FGroupIndonesia online & offline sessions.
 *  (c) FGroupIndonesia.com
 */
package frames;

import java.awt.AWTException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import logic.CMDExecutor;
import logic.Data;
import logic.UIHelper;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import logic.ImageExtractor;
import logic.CustomColorRenderer;

/**
 *
 * @author ASUS
 */
public class MainFrame extends javax.swing.JFrame {

    SystemTray tray = SystemTray.getSystemTray();
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    TrayIcon trayIcon = null;

    private void makeTray() {

        if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
            return;
        }

        //Image image = toolkit.getImage("timer.jpg");
        Image image = toolkit.getImage(ImageExtractor.getImageLocation());

        PopupMenu menu = new PopupMenu();

        MenuItem messageItem = new MenuItem("Show Frame");
        messageItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainFrame.this.setExtendedState(JFrame.NORMAL);
            }
        });
        menu.add(messageItem);

        MenuItem closeItem = new MenuItem("Close");
        closeItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menu.add(closeItem);
        trayIcon = new TrayIcon(image, "Apps Time Killer", menu);
        trayIcon.setImageAutoSize(true);

        try {
            tray.add(trayIcon);

        } catch (AWTException ex) {
            System.out.println("Tray is unsupported!");
        }

    }

    private void removeTray() {
        tray.remove(trayIcon);
    }

    /**
     * Creates new form MainFrame
     */
    ArrayList<Data> seluruhApp = null;

    public MainFrame() {
        initComponents();

        UIHelper.setTable(jTable1);

        UIHelper.centerColumn(0);
        UIHelper.centerColumn(2);
        UIHelper.centerColumn(3);
        UIHelper.centerColumn(4);

        UIHelper.centerHeader();

        refreshData();

        ImageExtractor.extractFile("timer.png");
        applyFrameIcon();
        applyCustomTable();
    }

    private void applyCustomTable() {
        CustomColorRenderer colorRenderer = new CustomColorRenderer();
        int manyCols = jTable1.getColumnModel().getColumnCount();

        for (int i = 0; i < manyCols; i++) {
            TableColumn tColumn = jTable1.getColumnModel().getColumn(i);
            tColumn.setCellRenderer(colorRenderer);
        }
    }

    private void applyFrameIcon() {
        ImageIcon img = new ImageIcon(ImageExtractor.getImageLocation());
        this.setIconImage(img.getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        buttonInfo = new javax.swing.JButton();
        buttonRefresh = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        buttonSetShutdown = new javax.swing.JButton();
        buttonKillNow = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Apps Time Killer");
        setResizable(false);
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "App Name", "PID", "Memory Used", "Shutdown Time", "Type"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(40);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(40);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(40);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setMinWidth(0);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(5).setMaxWidth(0);
        }

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setPreferredSize(new java.awt.Dimension(456, 50));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        buttonInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/info.png"))); // NOI18N
        buttonInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInfoActionPerformed(evt);
            }
        });
        jPanel1.add(buttonInfo);

        buttonRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.png"))); // NOI18N
        buttonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRefreshActionPerformed(evt);
            }
        });
        jPanel1.add(buttonRefresh);

        jLabel1.setText("Select any program below and...");
        jPanel1.add(jLabel1);

        buttonSetShutdown.setText("Set Time");
        buttonSetShutdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSetShutdownActionPerformed(evt);
            }
        });
        jPanel1.add(buttonSetShutdown);

        buttonKillNow.setText("Kill Now");
        buttonKillNow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonKillNowActionPerformed(evt);
            }
        });
        jPanel1.add(buttonKillNow);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRefreshActionPerformed

        refreshData();

    }//GEN-LAST:event_buttonRefreshActionPerformed

    private void renderTable() {
        UIHelper.clearData();

        for (Data satu : seluruhApp) {
            UIHelper.addData(satu);
        }
    }

    private void refreshData() {
        seluruhApp = CMDExecutor.getAppsList();

        renderTable();

        UIHelper.centerColumn(0);
        UIHelper.centerColumn(2);
        UIHelper.centerColumn(3);
        UIHelper.centerColumn(4);

        applyCustomTable();
    }

    private void buttonKillNowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKillNowActionPerformed
        int row = jTable1.getSelectedRow();

        if (row != -1) {

            int col = 1;
            String nameSelected = jTable1.getValueAt(row, col).toString();
            String typeSelected = jTable1.getValueAt(row, 5).toString();

            if (typeSelected.equalsIgnoreCase("services")) {
                JOptionPane.showMessageDialog(this, "Service type app unable to be killed!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {

                CMDExecutor.kill(nameSelected);
                refreshData();

            }
        }
    }//GEN-LAST:event_buttonKillNowActionPerformed

    private void buttonSetShutdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSetShutdownActionPerformed
        int row = jTable1.getSelectedRow();

        if (row != -1) {

            ShutdownTime dialog = new ShutdownTime(this, true);
            String nameSelected = jTable1.getValueAt(row, 1).toString();
            String typeSelected = jTable1.getValueAt(row, 5).toString();

            if (typeSelected.equalsIgnoreCase("services")) {
                JOptionPane.showMessageDialog(this, "Service type app unable to be killed!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {

                dialog.setAppName(nameSelected);
                dialog.setMainFrame(this);
                dialog.setVisible(true);

            }

        }
    }//GEN-LAST:event_buttonSetShutdownActionPerformed

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged

        if ((evt.getNewState() & JFrame.ICONIFIED) == JFrame.ICONIFIED) {
            makeTray();
        } else if ((evt.getNewState() & JFrame.NORMAL) == JFrame.NORMAL) {
            //remoteTray();
            removeTray();
        }

    }//GEN-LAST:event_formWindowStateChanged

    private void buttonInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInfoActionPerformed
        JOptionPane.showMessageDialog(this, "AppsTimeKiller for killing any desktop program by time, designed by FGroupIndonesia.com", "About", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_buttonInfoActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {

        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonInfo;
    private javax.swing.JButton buttonKillNow;
    private javax.swing.JButton buttonRefresh;
    private javax.swing.JButton buttonSetShutdown;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    public void setAppTime(String appSelected, String hourMinute) throws Exception {

        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dateCompleteFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date = new Date();

        String saatIni = dateFormatter.format(date) + " " + hourMinute;
        Date dateExecution = dateCompleteFormatter.parse(saatIni);

        //Now create the time and schedule it
        Timer timer = new Timer();

        timer.schedule(new MyTimeTask(appSelected), dateExecution);
        System.out.println("Apps " + appSelected + " akan close pada " + saatIni);

        for (Data satu : seluruhApp) {
            if (satu.getName().equalsIgnoreCase(appSelected)) {
                satu.setShutdowntime(hourMinute);
            }
        }

        renderTable();
    }

    private class MyTimeTask extends TimerTask {

        public MyTimeTask(String appName) {
            targetName = appName;
        }

        String targetName;
        int targetPID;

        public void run() {
            CMDExecutor.kill(targetName);
            refreshData();
        }
    }

}
