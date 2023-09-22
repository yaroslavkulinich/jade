/**
 * Created by Dan Geabunea on 6/28/2016.
 */

package jlg.jade.asterix.cat004.item100;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.IA5Decoder;

/**
 * Cat004 Item100 Subfield1 - Area Name
 * Name of the area involved in a Safety Net alarm
 *
 * @implSpec The area name is always left adjusted. If needed, the remaining
 * characters are filled with space character
 */
public class Cat004Item100Subfield1 extends FixedLengthAsterixData {
    private String areaName;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.SIX_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.areaName = IA5Decoder.decodeFromSixBytes(input, offset);
        appendItemDebugMsg("Area Name", this.areaName);
    }

    @Override
    protected String setDisplayName() {
        return "Cat004Item100Subfield1 - Area Name";
    }

    public String getAreaName() {
        return areaName;
    }
}
