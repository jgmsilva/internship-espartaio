
package TODO;


public class Task {
    private String description;
    private boolean finished;
    private boolean selected;
    
    public Task(String description){
        this.description = description;
        this.finished = false;
        this.selected = false;
    }
    
    public void setSelected(boolean check){
        this.selected = check;
    }
    
    public void setFinished(boolean check){
        this.finished = check;
    }
    
    public String getDescription(){
        return description;
    }
    
    public String getFinished(){
        if(finished){
            return "Finalizada";
        }else{
            return "Pendente";
        }
    }
    
    public boolean isSelected(){
        return selected;
    }
}
