import java.util.Arrays;
import java.util.List;

public class NotesStorageMock implements NotesStorage {
    
    private boolean isEmpty = true;
    
    @Override
    public void add(Note note) {
        isEmpty = false;
    }
    
    @Override
    public boolean isEmptyList() {
        return isEmpty;
    }
    
    @Override
    public List<Note> getAllNotesOf(String name) {
        return Arrays.asList(Note.of(name, 3.0f), Note.of(name, 4.0f));
    }
    
    @Override
    public void clear() {
        isEmpty = true;
    }
    
}
