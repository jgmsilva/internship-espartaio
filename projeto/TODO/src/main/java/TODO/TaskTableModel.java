
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
    public String getColumnName(int column){
        return columns[column];
    }
    
    @Override
    public Class<?> getColumnClass​(int columnIndex){
        if(columnIndex == 0){
            return String.class;
        }else{
            return Boolean.class;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        Task task = tasks.get(row);
        return column == 1 ? task.isSelected() : task.getDescription();
    }
    
    @Override
    public void setValueAt(Object aValue, int row, int column){
        if(isCellEditable(row, column)){
            Task task = tasks.get(row);
            task.setSelected(!task.isSelected());
        }
    }
    
    @Override
    public boolean isCellEditable(int row, int column){
        return column==1;
    }
    
    public void addRow(String description){
        tasks.add(new Task(description));
        fireTableRowsInserted(tasks.size()-1, tasks.size()-1);
    }
    
}
