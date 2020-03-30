import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class NotesStorageMock implements NotesStorage {
    
    private Multimap<String, Float> notes = ArrayListMultimap.create();
    
    private boolean isEmpty = true;
    
    @Override
    public void add(Note note) {
        notes.put(note.getName(), note.getNote());
        isEmpty = false;
    }
    
    @Override
    public boolean isEmptyList() {
        return isEmpty;
    }
    
    @Override
    public List<Note> getAllNotesOf(String name) {
        Collection<Float> values = notes.get(name);
        List<Note> result = new ArrayList<>();
        values.forEach(aFloat -> result.add(Note.of(name, aFloat)));
        return result;
    }
    
    @Override
    public void clear() {
        notes.clear();
        isEmpty = true;
    }
    
}
