/**
 * Created by Dan Geabunea on 7/6/2016.
 */

package jlg.jade.test.asterix.cat150;

import jlg.jade.asterix.cat150.Cat150Item210;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat150Item210Test extends MandatoryFixedLengthAsterixTests<Cat150Item210> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 2;
    }

    @Override
    protected Cat150Item210 setFixedLengthAsterixDataInstance() {
        return new Cat150Item210();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        byte[] input = {(byte) 130, 2};
        int offset = 0;
        Cat150Item210 cat150Item210 = new Cat150Item210();

        //act
        cat150Item210.decode(input, offset, input.length);

        //assert
        assertEquals("Item not decoded correctly", 33282, cat150Item210.getCorrelatedTrackNb());
    }
}
