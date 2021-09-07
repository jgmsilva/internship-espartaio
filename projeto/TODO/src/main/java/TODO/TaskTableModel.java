/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TODO;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 *
 * @author joao
 */
public class TaskTableModel extends AbstractTableModel {
    
    private String[] columns;
    private List<Task> tasks;

    @Override
    public int getRowCount() {
        return tasks.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        
    }
    
    @Override
    public boolean isCellEditable(int row, int column){
        
    }
    
}
