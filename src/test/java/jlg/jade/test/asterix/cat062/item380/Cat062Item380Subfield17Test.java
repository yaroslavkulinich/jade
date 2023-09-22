/* 
* Created by dan-geabunea on 5/3/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat062.item380;

import jlg.jade.asterix.cat062.item380.Cat062Item380Subfield17;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat062Item380Subfield17Test extends MandatoryFixedLengthAsterixTests<Cat062Item380Subfield17> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 2;
    }

    @Override
    protected Cat062Item380Subfield17 setFixedLengthAsterixDataInstance() {
        return new Cat062Item380Subfield17();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data(){
        //arrange
        byte[] input = {65, (byte) 224};
        int offset = 0;
        Cat062Item380Subfield17 subfield = new Cat062Item380Subfield17();

        //act
        subfield.decode(input, offset, input.length);

        //assert
        assertEquals("Track angle not decoded correctly", 16864, subfield.getTrackAngle());
    }
}
