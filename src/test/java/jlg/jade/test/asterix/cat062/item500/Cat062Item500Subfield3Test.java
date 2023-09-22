/* 
* Created by dan-geabunea on 5/12/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat062.item500;

import jlg.jade.asterix.cat062.item500.Cat062Item500Subfield3;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat062Item500Subfield3Test extends MandatoryFixedLengthAsterixTests<Cat062Item500Subfield3> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 4;
    }

    @Override
    protected Cat062Item500Subfield3 setFixedLengthAsterixDataInstance() {
        return new Cat062Item500Subfield3();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        byte[] input = {0, 28, 0, 41};
        int offset = 0;
        Cat062Item500Subfield3 subfield3 = new Cat062Item500Subfield3();

        //act
        subfield3.decode(input,offset,input.length);

        //arrange
        assertEquals("APW Latitude not decoded correctly", 28, subfield3.getAccurracyForPositionLat());
        assertEquals("APW Longitude not decoded correctly", 41, subfield3.getAccurracyForPositionLon());
    }
}
