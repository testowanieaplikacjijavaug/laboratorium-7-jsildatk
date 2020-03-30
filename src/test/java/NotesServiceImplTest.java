import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NotesServiceImplTest {
    
    private NotesService notesService;
    
    private NotesStorage notesStorage;
    
    @BeforeEach
    public void setUp() {
        notesStorage = new NotesStorageMock();
        notesService = NotesServiceImpl.createWith(notesStorage);
    }
    
    @Test
    public void shouldAdd() {
        final Note note = Note.of("test", 4.0f);
        
        notesService.add(note);
        
        assertFalse(notesStorage.isEmptyList());
    }
    
    @Test
    public void shouldNotCalculateAverageForNullPerson() {
        assertThrows(IllegalArgumentException.class, () -> notesService.averageOf(null));
    }
    
    @Test
    public void shouldNotCalculateAverageForEmptyPerson() {
        assertThrows(IllegalArgumentException.class, () -> notesService.averageOf(""));
    }
    
    @Test
    public void shouldNotCalculateAverageForPersonWithWhitespaces() {
        assertThrows(IllegalArgumentException.class, () -> notesService.averageOf("          "));
    }
    
    @Test
    public void shouldNotCalculateAverageForNotExistingPerson() {
        assertThrows(IllegalArgumentException.class, () -> notesService.averageOf("teest"));
    }
    
    @Test
    public void shouldCalculateAverageForStudent() {
        final String name = "test";
        notesService.add(Note.of(name, 3.0f));
        notesService.add(Note.of(name, 4.0f));
        
        final float result = notesService.averageOf(name);
        
        assertEquals(3.5f, result, 0.01);
    }
    
    @Test
    public void shouldClear() {
        notesService.clear();
        assertTrue(notesStorage.isEmptyList());
    }
    
    @AfterEach
    public void tearDown() {
        notesService = null;
        notesStorage = null;
    }
    
}