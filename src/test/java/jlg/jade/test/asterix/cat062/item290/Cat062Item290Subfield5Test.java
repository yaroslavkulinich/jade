/* 
* Created by dan-geabunea on 5/6/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat062.item290;

import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.asterix.cat062.item290.Cat062Item290Subfield5;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat062Item290Subfield5Test extends MandatoryFixedLengthAsterixTests {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 2;
    }

    @Override
    protected FixedLengthAsterixData setFixedLengthAsterixDataInstance() {
        return new Cat062Item290Subfield5();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data(){
        //arrange
        byte[] input = {(byte) 255, (byte) 255};
        int offset = 0;
        Cat062Item290Subfield5 subfield5 = new Cat062Item290Subfield5();

        //act
        subfield5.decode(input, offset, input.length);

        //assert
        assertEquals("ADSC age not decocded correctly", 65535, subfield5.getAge());
    }
}
