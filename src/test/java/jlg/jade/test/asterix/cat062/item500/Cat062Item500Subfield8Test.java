/* 
* Created by dan-geabunea on 5/13/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat062.item500;

import jlg.jade.asterix.cat062.item500.Cat062Item500Subfield8;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat062Item500Subfield8Test extends MandatoryFixedLengthAsterixTests<Cat062Item500Subfield8> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 1;
    }

    @Override
    protected Cat062Item500Subfield8 setFixedLengthAsterixDataInstance() {
        return new Cat062Item500Subfield8();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data(){
        //arrange
        byte[] input = {15};
        int offset = 0;
        Cat062Item500Subfield8 subfield8 = new Cat062Item500Subfield8();

        //act
        subfield8.decode(input, offset, input.length);

        //assert
        assertEquals("Subfield not decoded correctly", 15, subfield8.getAccuracyForRocd());
    }
}
