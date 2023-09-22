/* 
* Created by dan-geabunea on 4/25/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix;

import jlg.jade.common.AsterixDecodingException;
import jlg.jade.common.Decodable;
import jlg.jade.common.Encodable;

/**
 * Generic definition of an Asterix data item with a fixed length. All fixed length items will derive from this
 * base class;
 */
public abstract class FixedLengthAsterixData extends AsterixItem implements Decodable, Encodable {

    protected FixedLengthAsterixData() {
        this.sizeInBytes = setSizeInBytes();
    }

    @Override
    public int decode(byte[] input, int offset, int inputLength) {
        checkLength(input, offset, inputLength);
        decodeFromByteArray(input, offset);
        this.valid = validate();

        return offset + sizeInBytes;
    }

    protected abstract int setSizeInBytes();

    protected abstract void decodeFromByteArray(byte[] input, int offset);

    private void checkLength(byte[] input, int offset, int inputLength) {
        appendDebugMsg(this.getDisplayName() + ":");
        appendNewLine();

        /**
         * @implNote No more available length
         */
        if (offset + sizeInBytes > inputLength) {
            appendDebugMsg("Available length was exceeded while creating " + this.getDisplayName() +
                    " input: " + input.length + ", offset: " + offset + ", size of items: " + sizeInBytes);
            appendNewLine();
            throw new AsterixDecodingException.AvailableLengthExceeded("Available length was exceeded while creating " +
                    "" + this.getDisplayName() +
                    " input: " + input.length + ", offset: " + offset + ", size of items: " + sizeInBytes);
        }

        /**
         * @implNote Input does not have enough data
         */
        if (input.length < offset + sizeInBytes) {
            appendDebugMsg("Unexpected end of data found while creating " + this.getDisplayName() +
                    " input: " + input.length + ", offset: " + offset + ", length: " + sizeInBytes);
            appendNewLine();
            throw new AsterixDecodingException.UnexpectedEndOfData("Unexpected end of data found while creating " +
                    this.getDisplayName() +
                    " input: " + input.length + ", offset: " + offset + ", length: " + sizeInBytes);
        }

        //add byte information to debug message
        appendDebugMsg("  -- Received raw bytes / octets: ");
        if (sizeInBytes != AsterixItemLength.VARIABLE.getValue()) {
            for (int i = offset; i < offset + sizeInBytes; i++) {
                appendDebugMsg(" " + Byte.toUnsignedInt(input[i]));
            }
        }
        appendNewLine();
    }
}
