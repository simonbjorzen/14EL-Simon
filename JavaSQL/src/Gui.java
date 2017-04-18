import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.table.*;


/**
 * Created by simon on 4/5/17.
 */

public class Gui extends JFrame implements ActionListener{

    JButton refresh = new JButton("Refresh");
    JButton push = new JButton("Push edits");
    JButton addrow = new JButton("Add Row");
    JButton delrow = new JButton("Delete Row");
    JButton quit = new JButton("Quit");
    Object[][] coldata = {
            {"Jane", "Doe", 1},
            {"John", "Doe", 2},
            {"Jane", "Doe", 3},
            {"John", "Doe", 4},
            {"Jane", "Doe", 5},
            {"John", "Doe", 6},
            {"Jane", "Doe", 7},
            {"John", "Doe", 8},
            {"Jane", "Doe", 9},
            {"John", "Doe", 10},
            {"Jane", "Doe", 11},
            {"John", "Doe", 12},
            {"Jane", "Doe", 13},
            {"John", "Doe", 14},
            {"Jane", "Doe", 15},
            {"John", "Doe", 16},
            {"Jane", "Doe", 17},
            {"John", "Doe", 18},
            {"Jane", "Doe", 19},
            {"John", "Doe", 20},
            {"Jane", "Doe", 21},
            {"John", "Doe", 22},
            {"Jane", "Doe", 23},
            {"John", "Doe", 24},
            {"Jane", "Doe", 25},
            {"John", "Doe", 26},
            {"Jane", "Doe", 27},
            {"John", "Doe", 28}
    };
    String[] colnames = {"First Name",
            "Last Name", "ID"};


    class tableModel extends AbstractTableModel {
        private String[] columnNames = colnames;
        private Object[][] data = coldata;

        public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return data.length;
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) {
            return data[row][col];
        }

        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        public boolean isCellEditable(int row, int col) {
            //Note that the data/cell address is constant,
            //no matter where the cell appears onscreen.
            if (col == 2) {
                return false;
            } else {
                return true;
            }
        }

        /*
         * Don't need to implement this method unless your table's
         * data can change.
         */
        public void setValueAt(Object value, int row, int col) {
            data[row][col] = value;
            fireTableCellUpdated(row, col);
        }
    }

    JTable table = new JTable(new tableModel());

    public Object getValue(int a, int b){

        return table.getValueAt(a, b);
    }
    public Gui() {
        JFrame window = new JFrame();
        window.setSize(1000, 500);
        window.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        window.setDefaultCloseOperation(3);
        window.setTitle("JavaSQL");
        window.setResizable(false);





        table.setFillsViewportHeight(true);
        table.setAutoCreateRowSorter(true);
        table.setPreferredScrollableViewportSize(new Dimension(700, 380));
        TableColumn column = null;
        for (int i = 0; i < 3; i++) {
            column = table.getColumnModel().getColumn(i);
            if (i == 2) {
                column.setPreferredWidth(50);
            } else {
                column.setPreferredWidth(500);

            }
        }
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridy = 0;
        c.gridx = 0;
        c.weightx = 1;
        c.weighty = 3;
        c.gridwidth = 6;
        c.insets = new Insets(10, 30, 10, 30);
        JScrollPane scroll = new JScrollPane(table);
        window.add(scroll, c);
        c.insets = new Insets(0,0,0,0);
        refresh.addActionListener(this);
        push.addActionListener(this);
        quit.addActionListener(this);
        addrow.addActionListener(this);
        delrow.addActionListener(this);
        refresh.setPreferredSize(new Dimension(50,40));
        push.setPreferredSize(new Dimension(50,40));
        quit.setPreferredSize(new Dimension(50,40));
        addrow.setPreferredSize(new Dimension(50,40));
        delrow.setPreferredSize(new Dimension(50,40));

        c.anchor = GridBagConstraints.PAGE_END;
        c.gridwidth = 1;
        c.weighty = 1;
        c.weightx = 1;
        c.gridy = 1;
        c.gridx = 0;
        window.add(refresh, c);
        c.gridx = 1;
        window.add(push, c);
        c.gridx = 2;
        window.add(addrow, c);
        c.gridx = 3;
        window.add(delrow, c);
        c.gridx = 5;
        window.add(quit, c);


        window.setVisible(true);


    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == refresh){
            System.out.println("Refresh");
        }
        if(e.getSource() == push){
            System.out.println("Push");
        }
        if(e.getSource() == quit){
            System.out.println("Quit");
        }
        if(e.getSource() == addrow){
            System.out.println("Add Row");
        }
        if(e.getSource() == delrow){
            System.out.println("Del Row");
        }
    }


}
