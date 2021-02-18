/*
 *  This is a Supplemental File from the Main Project used
 *  in APPSTIMERKILLER
 *  with FGroupIndonesia online & offline sessions.
 *  (c) FGroupIndonesia.com
 */
package logic;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author ASUS
 */
public class UIHelper {

    private static JTable jtable;

    public static void setTable(JTable ent) {
        jtable = ent;
    }

    public static void centerColumn(int post) {
        DefaultTableCellRenderer centerRender = new DefaultTableCellRenderer();
        centerRender.setHorizontalAlignment(SwingConstants.CENTER);
        jtable.getColumnModel().getColumn(post).setCellRenderer(centerRender);

    }

    public static String numericDigit(int val) {

        String endVal = null;

        if (val < 10) {
            endVal = "0" + val;
        } else {
            endVal = "" + val;
        }

        return endVal;

    }

    public static void centerHeader() {
        // applied to all header
        DefaultTableCellRenderer centerRender = (DefaultTableCellRenderer) jtable.getTableHeader().getDefaultRenderer();
        centerRender.setHorizontalAlignment(SwingConstants.CENTER);
    }

    public static void clearData() {
        DefaultTableModel dtm = (DefaultTableModel) jtable.getModel();
        dtm.setRowCount(0);
    }

    public static void addData(Data entry) {

        DefaultTableModel dtm = (DefaultTableModel) jtable.getModel();

        Object rowData[] = {entry.getNo(), entry.getName(), entry.getPid(), entry.getMemoryUsed(), entry.getShutdowntime(), entry.getType()};

        dtm.addRow(rowData);
    }

    

}
