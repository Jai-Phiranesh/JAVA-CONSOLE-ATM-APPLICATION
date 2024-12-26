public class Notes implements Cloneable{
    private String note;
    private long count;

    public String getNotes() {
        return note;
    }

    public long getCount() {
        return count;
    }

    public void setNotes(String note) {
        this.note = note;
    }

    public void setCount(long c) {
        this.count = c;
    }
   
    @Override
    public Notes clone() throws CloneNotSupportedException {
        
        return (Notes)super.clone();
    }

}
