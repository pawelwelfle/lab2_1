package edu.iis.mto.bsearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    private int [] firstSeq = {4};

    private BinarySearch binSearch = BinarySearch.create();

    @Test
    void OneElementSequenceTest() {
        int position = 0;
        int matchingNumber = 4;
        SearchResult searchRes = binSearch.search(matchingNumber, firstSeq);

        assertTrue(searchRes.isFound());
        assertEquals(position, searchRes.getPosition());
        assertEquals(matchingNumber, firstSeq[searchRes.getPosition()]);
    }

    @Test
    void OneElementSequenceWithoutOurNumberTest() {
        int wrongNumber = 3;
        int position = -1;
        SearchResult searchRes = binSearch.search(wrongNumber, firstSeq);

        assertFalse(searchRes.isFound());
        assertEquals(position, searchRes.getPosition());
    }

    @Test
    void IsItOurFirstNumberInSequenceTest() {
        int[] seq = {3, 5};
        int firstNumber = 3;
        int position = 0;
        SearchResult searchRes = binSearch.search(firstNumber, seq);

        assertTrue(searchRes.isFound());
        assertEquals(position, searchRes.getPosition());
        assertEquals(firstNumber, seq[searchRes.getPosition()]);
    }

    @Test
    void IsItOurLastNumberInSequenceTest() {
        int[] seq = {3, 5, 8};
        int lastNumber = 8;
        int position = seq.length - 1;
        SearchResult searchRes = binSearch.search(lastNumber, seq);

        assertTrue(searchRes.isFound());
        assertEquals(position, searchRes.getPosition());
        assertEquals(lastNumber, seq[searchRes.getPosition()]);
    }
}