import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NoteTest {
    
    @Test
    public void shouldNotAddNoteWithNullStudentName() {
        assertThrows(IllegalArgumentException.class, () -> Note.of(null, 0.0f));
    }
    
    @Test
    public void shouldNotAddNoteWithEmptyStudentName() {
        assertThrows(IllegalArgumentException.class, () -> Note.of("", 0.0f));
    }
    
    @Test
    public void shouldNotAddNoteWithStudentNameWithWhitespaces() {
        assertThrows(IllegalArgumentException.class, () -> Note.of("       ", 0.0f));
    }
    
    @Test
    public void shouldNotAddNoteWithTooBigValue() {
        assertThrows(IllegalArgumentException.class, () -> Note.of("test", 6.0001f));
    }
    
    @Test
    public void shouldNotAddNoteWithTooLessValue() {
        assertThrows(IllegalArgumentException.class, () -> Note.of("test", 1.999999f));
    }
    
    @Test
    public void shouldAddNote() {
        final String name = "test";
        final float value = 3.5f;
        
        final Note note = Note.of(name, value);
        
        assertAll(() -> assertEquals(name, note.getName()),
                () -> assertEquals(value, note.getNote()));
    }
    
}