package ATM;
import ATM.Note.Note;

public class Notes<T> {
    T[]  note = (T[]) new Note[4];
    //T[]  note = (T[]) new Object[4];

    int length=0;
    public void add(T e){
        if(length>note.length){
            System.out.println("Index out of bound");
        }
        note[length]=(T) e;
        length++;
    }



    public T get(int index){
        return note[index];
    }


    public T[] getAll(){
        return note;
    }
}
