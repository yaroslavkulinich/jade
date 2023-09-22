/* 
* Created by dan-geabunea on 4/19/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix;

import jlg.NotImplementedException;
import jlg.jade.common.DebugMessageSource;
import jlg.jade.common.Decodable;

import java.util.ArrayList;
import java.util.List;

/**
 * The application data is transmitted over the communication medium via one or a concatenation of
 * consecutive data blocks. A data block shall consist of:
 * - a one octet field indicating the Asterix category
 * - a two octet field indicating the length of the data block, including the CAT and LEN fields
 */
public class AsterixDataBlock extends DebugMessageSource implements Decodable {
    private final int category;
    private final List<AsterixRecord> records;
    private ReservedFieldFactory customReservedFieldFactory;

    /**
     * Create an Asterix data block for the specified category
     * @param category
     */
    public AsterixDataBlock(int category) {
        this.category = category;
        this.records = new ArrayList<>();
        this.customReservedFieldFactory = null;
    }

    /**
     * Create an Asterix data block for the specified category with a custom factory
     * implementation for SP,RE fields.
     * @param category
     * @param reservedFieldFactory The custom reserved field factory
     */
    public AsterixDataBlock(int category, ReservedFieldFactory reservedFieldFactory) {
//        Assert.notNull(reservedFieldFactory);

        this.category = category;
        this.records = new ArrayList<>();
        this.customReservedFieldFactory = reservedFieldFactory;
    }

    /**
     * Decodes the raw data to Asterix data block, containing zero or more Asterix
     * records
     *
     * @param input  The raw data
     * @param offset The start offset in the raw data, at which reading should begin
     * @param length The number of bytes to read
     * @return The new offset in the raw data
     */
    public int decode(byte[] input, int offset, int length) {
        while (offset < length) {
            AsterixRecord record = buildAsterixRecord(category, customReservedFieldFactory);

            offset = record.decode(input, offset, length);

            //append logs
            switch (category) {
                case 4: {
                    appendNewLine();
                    appendDebugMsg(record.getCat004Record().getDebugString());
                    break;
                }
                case 34: {
                    appendNewLine();
                    appendDebugMsg(record.getCat034Record().getDebugString());
                    break;
                }
                case 48: {
                    appendNewLine();
                    appendDebugMsg(record.getCat048Record().getDebugString());
                    break;
                }
                case 62: {
                    appendNewLine();
                    appendDebugMsg(record.getCat062Record().getDebugString());
                    break;
                }
                case 65: {
                    appendNewLine();
                    appendDebugMsg(record.getCat065Record().getDebugString());
                    break;
                }
                case 150: {
                    appendNewLine();
                    appendDebugMsg(record.getCat150Record().getDebugString());
                    break;
                }
                default: {
                    break;
                }
            }

            records.add(record);
        }
        return offset;
    }


    /**
     * Encodes the current Asterix data block into a byte array, that can be then sent over the
     * network
     * or written to a file.
     *
     * @param dest   The destination array
     * @param offset The start offset in array dest at which writing should begin
     * @param length The number of bytes to write
     * @return The new offset in the dest array, after the data has been encoded, or -1 if data
     * can not be written because end of array has
     * been reached
     */
    public int encode(byte[] dest, int offset, int length) {
        throw new NotImplementedException();
    }

    public int getCategory() {
        return category;
    }

    public List<AsterixRecord> getRecords() {
        return records;
    }

    /**
     * Build an Asterix record, by calling the appropriate constructor.
     *
     * @param category
     * @param customReservedFieldFactory
     * @return
     */
    private AsterixRecord buildAsterixRecord(int category, ReservedFieldFactory customReservedFieldFactory) {
        AsterixRecord record;
        if (customReservedFieldFactory == null) {
            record = new StandardAsterixRecord(category);
        } else {
            record = new StandardAsterixRecord(category, customReservedFieldFactory);
        }
        return record;
    }
}
