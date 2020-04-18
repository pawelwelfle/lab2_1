package edu.iis.mto.bsearch;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    private int [] firstSeq = {4};

    private BinarySearch binSearch = BinarySearch.create();

    @Test
    void CheckOneElementSequence() {
        int position = 0;
        int matchingNumber = 4;
        SearchResult searchRes = binSearch.search(matchingNumber, firstSeq);

        assertThat(searchRes.isFound(), is(true));
        assertThat(position, is(searchRes.getPosition()));
        assertThat(matchingNumber, is(firstSeq[searchRes.getPosition()]));
    }

    @Test
    void CheckOneElementSequenceWithoutOurNumber() {
        int wrongNumber = 3;
        int position = -1;
        SearchResult searchRes = binSearch.search(wrongNumber, firstSeq);

        assertThat(searchRes.isFound(),is(false));
        assertThat(position, is(searchRes.getPosition()));
    }

    @Test
    void CheckIfIsItOurFirstNumberInSequence() {
        int[] seq = {3, 5};
        int firstNumber = 3;
        int position = 0;
        SearchResult searchRes = binSearch.search(firstNumber, seq);

        assertThat(searchRes.isFound(), is(true));
        assertThat(position, is(searchRes.getPosition()));
        assertThat(firstNumber, is(seq[searchRes.getPosition()]));
    }

    @Test
    void CheckIfIsItOurLastNumberInSequence() {
        int[] seq = {3, 5, 8};
        int lastNumber = 8;
        int position = seq.length - 1;
        SearchResult searchRes = binSearch.search(lastNumber, seq);

        assertThat(searchRes.isFound(), is(true));
        assertThat(position, is(searchRes.getPosition()));
        assertThat(lastNumber, is(seq[searchRes.getPosition()]));
    }

    @Test
    void CheckIfIsItOurCenterNumberInSequence() {
        int[] seq = {3, 5, 8};
        int centerNumber = 5;
        int position = seq.length / 2;
        SearchResult searchRes = binSearch.search(centerNumber, seq);

        assertThat(searchRes.isFound(), is(true));
        assertThat(position, is(searchRes.getPosition()));
        assertThat(centerNumber, is(seq[searchRes.getPosition()]));
    }

    @Test
    void CheckIfIsItThisNumberInSequence() {
        int[] seq = {3, 5, 8};
        int thisNumber = 7;
        int position = -1;
        SearchResult searchRes = binSearch.search(thisNumber, seq);

        assertThat(searchRes.isFound(), is(false));
        assertThat(position, is(searchRes.getPosition()));
    }
}