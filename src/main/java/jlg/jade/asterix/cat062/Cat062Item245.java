/* 
* Created by dan-geabunea on 4/26/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat062;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.DecodingNotImplemented;
import jlg.jade.asterix.FixedLengthAsterixData;

/**
 * Cat 062 Item 245 - Target (aircraft or vehicle) identification in 8 characters.
 * @implSpec  Item is not used any more according to Asterix ICD
 */
public class Cat062Item245 extends FixedLengthAsterixData {

    @Override
    @DecodingNotImplemented(reason = "Not needed yet")
    protected void decodeFromByteArray(byte[] input, int offset) {
        appendNotImplementedMsg();
    }

    @Override
    protected boolean validate() {
        return true;
    }

    @Override
    protected String setDisplayName() {
        return "Cat062Item245 - Traget Identification (Aircraft & Vehicle)";
    }

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.SEVEN_BYTES.getValue();
    }
}
