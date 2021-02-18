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

import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ASUS
 */
public class CustomColorRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        String jenis = table.getValueAt(row, 5).toString();
        String shutdownTime = table.getValueAt(row, 4).toString();

        if (isSelected) {
            c.setBackground(Color.ORANGE);
            c.setForeground(Color.BLACK);
        } else {

            if (!shutdownTime.equalsIgnoreCase("-")) {
                c.setBackground(Color.YELLOW);
                c.setForeground(Color.BLACK);
                
            } else if (jenis.equalsIgnoreCase("services")) {
                c.setBackground(Color.DARK_GRAY);
                c.setForeground(Color.RED);
            } else if (jenis.equalsIgnoreCase("console")) {
                c.setBackground(null);
                c.setForeground(null);
            }

        }

        return c;
    }

}
