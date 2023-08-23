import org.example.service.AnagramService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
public class AnagramServiceTest {

    @InjectMocks
    private AnagramService anagramService;

    @Test
    void testAreAnagrams() {
        assertThat(anagramService.areAnagrams("listen", "silent")).isTrue();
        assertThat(anagramService.areAnagrams("apple", "paple")).isTrue();
        assertThat(anagramService.areAnagrams("a gentleman", "elegant man")).isTrue();

        assertThat(anagramService.areAnagrams("hello", "123")).isFalse();
        assertThat(anagramService.areAnagrams("cat", "dog")).isFalse();
    }

    @Test
    void testAreOnlyNumbers() {
        assertThat(anagramService.areOnlyNumbers("12345", "67890")).isTrue();
        assertThat(anagramService.areOnlyNumbers("abc123", "456def")).isFalse();
    }
}
