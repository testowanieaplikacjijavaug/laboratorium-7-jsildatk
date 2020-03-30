import java.util.List;

public interface NoteStorage {
    
    void add(Note note);
    
    List<Note> getAllNotesOf(String name);
    
    void clear();
    
}
