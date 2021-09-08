
package TODO;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.ArrayList;


public class TaskTableModel extends AbstractTableModel {
    
    private String[] columns;
    private List<Task> tasks;
    
    public TaskTableModel(){
        columns = new String[]{ "Tarefa", "Status", "Selecionada"};
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
        if(columnIndex == 2){
            return Boolean.class;
        }else{
            return String.class;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        Task task = tasks.get(row);
        switch(column){
            case 0: return task.getDescription();
            case 1: return task.getFinished();
            case 2: return task.isSelected();
            default: return null;
        }
    }
    
    @Override
    public void setValueAt(Object aValue, int row, int column){
        Task task = tasks.get(row);
        switch(column){
            case 1: task.setFinished((boolean)aValue);
            case 2: task.setSelected(!task.isSelected());
        }
        
    }
    
    @Override
    public boolean isCellEditable(int row, int column){
        return column==2;
    }
    
    public void addRow(String description){
        tasks.add(new Task(description));
        fireTableRowsInserted(tasks.size()-1, tasks.size()-1);
    }
    
    public void removeSelectedRows(){
        for(int i=0; i < tasks.size(); i++){
            if(tasks.get(i).isSelected()){
                tasks.remove(i);
                i--;
            }
        }
        fireTableDataChanged();
    }
}
