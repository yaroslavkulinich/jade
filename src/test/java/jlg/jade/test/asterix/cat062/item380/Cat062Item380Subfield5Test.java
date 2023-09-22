/* 
* Created by dan-geabunea on 4/27/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat062.item380;


import jlg.jade.asterix.cat062.item380.Cat062Item380Subfield5;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class Cat062Item380Subfield5Test {
    @Test
    public void should_have_length_of_2_bytes() {
        //arrange
        Cat062Item380Subfield5 subfield = new Cat062Item380Subfield5();

        //assert
        assertEquals("Subfield length is invalid", 2, subfield.getSizeInBytes());
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        byte[] input = {0, 64};
        int offset = 0;
        Cat062Item380Subfield5 subfield = new Cat062Item380Subfield5();

        //act
        subfield.decode(input, offset, input.length);

        //assert
        assertEquals("True air speed not decoded correctly", 64, subfield.getTrueAirSpeedKn());
    }

    @Test
    public void the_decode_method_should_increase_offset() {
        //arrange
        byte[] input = {0, 64};
        int offset = 0;
        Cat062Item380Subfield5 subfield = new Cat062Item380Subfield5();

        //act
        int newOffset = subfield.decode(input, offset, input.length);

        //assert
        assertEquals("Offset not updated after decoding data", 2, newOffset);
    }

    @Test
    @Parameters({"0,0,true", "7,254,true", "7,255,false"})
    public void the_validate_method_should_be_implemented_correctly(int firstOctet, int secondOctet, boolean expected) {
        /**
         * 0 ≤ True Air Speed ≤ 2046 knots
         */

        //arrange
        byte[] input = {(byte) firstOctet, (byte) secondOctet};
        int offset = 0;
        Cat062Item380Subfield5 subfield = new Cat062Item380Subfield5();

        //act
        subfield.decode(input, offset, input.length);

        //assert
        assertEquals("True air speed validation failed", expected, subfield.isValid());
    }

    /*
    Encoding Test
     */

    @Test
    public void the_encode_method_should_produce_correct_byte_array() {
        //arrange
        int speed = 64;
        Cat062Item380Subfield5 cat062Item380Subfield5 = new Cat062Item380Subfield5();
        cat062Item380Subfield5.setTrueAirSpeedKn(speed);

        //act
        byte[] result = cat062Item380Subfield5.encode();

        //assert
        byte[] expected = {0, 64};
        assertTrue("Item 380 - true air speed not encoded correctly", Arrays.equals(expected, result));
        assertEquals(cat062Item380Subfield5.getSizeInBytes(), result.length);
    }

}
