package edu.iis.mto.bsearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    private int [] firstSeq = {4};

    private BinarySearch binSearch = BinarySearch.create();

    @Test
    void OneElementSequenceTest() {
        int position = 0;
        int firstTry = 4;
        SearchResult searchRes = binSearch.search(firstTry, firstSeq);

        assertTrue(searchRes.isFound());
        assertEquals(position, searchRes.getPosition());
        assertEquals(firstTry, firstSeq[searchRes.getPosition()]);
    }

    @Test
    void OneElementSequenceWithoutOurNumberTest() {
        int secondTry = 3;
        int position = -1;
        SearchResult searchRes = binSearch.search(secondTry, firstSeq);

        assertFalse(searchRes.isFound());
        assertEquals(position, searchRes.getPosition());
    }

}