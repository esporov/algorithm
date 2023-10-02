package leetcode.arrays_and_hashing;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class _217_Contains_DuplicateTest {

    @BeforeAll

    @Test
    void containsDuplicate1() {
        assertTrue(_217_Contains_Duplicate.containsDuplicate(new int[]{1, 2, 3, 1}));
        assertFalse(_217_Contains_Duplicate.containsDuplicate(new int[]{1,2,3,4}));
        assertTrue(_217_Contains_Duplicate.containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));
        assertFalse(_217_Contains_Duplicate.containsDuplicate(new int[]{1}));
        assertFalse(_217_Contains_Duplicate.containsDuplicate(new int[]{}));
    }

    @Test
    void containsDuplicate2() {
        assertTrue(_217_Contains_Duplicate.containsDuplicate(new int[]{1, 2, 3, 1}));
    }

    @Test
    void containsDuplicate3() {
        assertTrue(_217_Contains_Duplicate.containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));
    }

    @Test
    void containsDuplicate4() {
        assertFalse(_217_Contains_Duplicate.containsDuplicate(new int[]{1}));
    }


    @Test
    void containsDuplicate5() {
        assertFalse(_217_Contains_Duplicate.containsDuplicate(new int[]{}));
    }



}