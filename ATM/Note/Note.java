package ATM.Note;// Class representing a currency note like 500,200,2000,100 and its common fields

public abstract  class Note implements Cloneable {
    private String note;  // Denomination of the note (e.g., "100", "500")
    private long count;   // Number of notes available


   protected Note(String note,long count){//protected so that we no cannot create object outside package
        this.note=note;
     this.count=count;
    }

    public Note(){

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
    public Note clone() throws CloneNotSupportedException {
        return (Note) super.clone();  // Creates a clone of the current Notes object
    }
}
