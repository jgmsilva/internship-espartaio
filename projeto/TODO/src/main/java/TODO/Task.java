
package TODO;


public class Task {
    private String description;
    private boolean selected;
    
    public Task(String description){
        this.description = description;
        this.selected = false;
    }
    
    public void setSelected(boolean check){
        this.selected = check;
    }
    
    public String getDescription(){
        return description;
    }
    
    public boolean isSelected(){
        return selected;
    }
}
