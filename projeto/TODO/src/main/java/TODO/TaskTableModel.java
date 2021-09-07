
package TODO;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.ArrayList;


public class TaskTableModel extends AbstractTableModel {
    
    private String[] columns;
    private List<Task> tasks;
    
    public TaskTableModel(){
        columns = new String[]{ "Tarefa", "Selecionada"};
        tasks = new ArrayList<>();
    }

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
