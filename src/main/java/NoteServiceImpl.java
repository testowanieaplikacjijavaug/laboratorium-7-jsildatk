import java.util.Collection;

public class NoteServiceImpl implements NoteService {
    
    private final NoteStorage storageService;
    
    private NoteServiceImpl(final NoteStorage storageService) {
        this.storageService = storageService;
    }
    
    public static NoteServiceImpl createWith(final NoteStorage storageService) {
        return new NoteServiceImpl(storageService);
    }
    
    @Override
    public void add(Note note) {
        storageService.add(note);
    }
    
    @Override
    public float averageOf(String name) {
        float sum = 0.0f;
        final Collection<Note> notes = storageService.getAllNotesOf(name);
        for ( final Note note : notes ) {
            sum += note.getNote();
        }
        return sum / notes.size();
    }
    
    @Override
    public void clear() {
        storageService.clear();
    }
    
}
