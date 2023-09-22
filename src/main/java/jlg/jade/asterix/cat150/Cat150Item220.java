/**
 * Created by Dan Geabunea on 7/6/2016.
 */

package jlg.jade.asterix.cat150;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.UnsignedNumericDecoder;

/**
 * Cat150 Item220 - Maximum Plan Count
 * The maximum number of possible active plans
 */
public class Cat150Item220 extends FixedLengthAsterixData {
    private int maxPlanCount;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.maxPlanCount = UnsignedNumericDecoder.decodeFromTwoBytes(input, offset);
        this.appendItemDebugMsg("Max Plan Count", this.maxPlanCount);
    }

    @Override
    protected String setDisplayName() {
        return "Cat150Item220 - Max Plan Count";
    }

    public int getMaxPlanCount() {
        return maxPlanCount;
    }
}
