package ATM.Notes;// Class representing a currency note like 500,200,2000,100 and its common fields

public class Notes implements Cloneable {
    private String note;  // Denomination of the note (e.g., "100", "500")
    private long count;   // Number of notes available


   protected Notes(String note,long count){
        this.note=note;
     this.count=count;
    }
    
    // Getter method for the note denomination
    public String getNotes() {
        return note;
    }

    // Getter method for the count of notes
    public long getCount() {
        return count;
    }

    // Setter method to set the note denomination
    public void setNotes(String note) {
        this.note = note;
    }

    // Setter method to set the count of notes
    public void setCount(long c) {
        this.count = c;
    }

    // Clone method to create a copy of the Notes object
    @Override
    public Notes clone() throws CloneNotSupportedException {
        return (Notes) super.clone();  // Creates a clone of the current Notes object
    }
}
