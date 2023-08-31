package leetcode.arrays_and_hashing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _242_Valid_AnagramTest {

    @Test
    void isAnagram1() {
        assertTrue(_242_Valid_Anagram.isAnagram("anagram", "nagaram"));
    }

    @Test
    void isAnagram2() {
        assertFalse(_242_Valid_Anagram.isAnagram("rat", "car"));
    }

    @Test
    void isAnagram3() {
        assertFalse(_242_Valid_Anagram.isAnagram("rat", "car55"));
    }
}