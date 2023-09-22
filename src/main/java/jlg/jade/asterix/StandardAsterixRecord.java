/* 
* Created by dan-geabunea on 4/19/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix;

import jlg.NotImplementedException;
import jlg.jade.asterix.cat004.Cat004Record;
import jlg.jade.asterix.cat034.Cat034Record;
import jlg.jade.asterix.cat048.Cat048Record;
import jlg.jade.asterix.cat062.Cat062Record;
import jlg.jade.asterix.cat065.Cat065Record;
import jlg.jade.asterix.cat150.Cat150Record;
import jlg.jade.common.DebugMessageSource;

import java.util.AbstractMap;
import java.util.HashMap;

/**
 * Represents a single Asterix message of a given category.
 */
public class StandardAsterixRecord extends DebugMessageSource implements AsterixRecord {
    private String sacSicCode;
    private final int category;
    private Cat062Record cat062Record;
    private Cat065Record cat065Record;
    private Cat004Record cat004Record;
    private Cat034Record cat034Record;
    private Cat048Record cat048Record;
    private Cat150Record cat150Record;
    /**
     * This field is used by 3rd party applications using this library. It helps to
     * add more information on the ASTERIX record, that can simplify the logic in
     * their own apps.
     *
     * @implNote No ASTERIX decoded field shall be inserted here. This will be empty. Only users can
     * add info on this list after the decoding has been done.
     */
    private AbstractMap<String, Object> additionalInfo;

    /**
     * Create an Asterix Record without any SP,RE fields
     * @param category
     */
    public StandardAsterixRecord(int category) {
        this.category = category;
        this.additionalInfo = new HashMap<>();
        switch (category) {
            case 4: {
                this.cat004Record = new Cat004Record();
                break;
            }
            case 34: {
                this.cat034Record = new Cat034Record();
                break;
            }
            case 48: {
                this.cat048Record = new Cat048Record();
                break;
            }
            case 62: {
                this.cat062Record = new Cat062Record();
                break;
            }
            case 65: {
                this.cat065Record = new Cat065Record();
                break;
            }
            case 150: {
                this.cat150Record = new Cat150Record();
                break;
            }
            default:
                throw new NotImplementedException();
        }
    }

    /**
     * Create an Asterix Record where the SP or RE fields need to have a custom decoding/encoding
     * implementation
     * @param category
     */
    public StandardAsterixRecord(int category, ReservedFieldFactory customReservedFieldFactory) {
//        Assert.notNull(customReservedFieldFactory); //Use other constructor if no custom factory is needed

        this.category = category;
        this.additionalInfo = new HashMap<>();
        switch (category) {
            case 4: {
                this.cat004Record = new Cat004Record(customReservedFieldFactory);
                break;
            }
            case 34: {
                this.cat034Record = new Cat034Record(customReservedFieldFactory);
                break;
            }
            case 48: {
                this.cat048Record = new Cat048Record(customReservedFieldFactory);
                break;
            }
            case 62: {
                this.cat062Record = new Cat062Record(customReservedFieldFactory);
                break;
            }
            case 65: {
                this.cat065Record = new Cat065Record(customReservedFieldFactory);
                break;
            }
            case 150: {
                //Cat150 does not have SP and RE fields, so we do not need to pass in additional arguments
                this.cat150Record = new Cat150Record();
                break;
            }
            default:
                throw new NotImplementedException();
        }
    }

    /**
     * Decodes the raw data to Asterix data block, containing zero or more Asterix
     * records
     *
     * @param input       The raw data
     * @param offset      The start offset in the raw data, at which reading should begin
     * @param inputLength The amount of data that needs to be read from the input
     * @return The new offset in the raw data
     */
    @Override
    public int decode(byte[] input, int offset, int inputLength) {
        switch (category) {
            case 4: {
                int newOffset = this.cat004Record.decode(input, offset, inputLength);
                this.sacSicCode = cat004Record.getItem010().getSac() + "/" + cat004Record
                        .getItem010().getSic();
                return newOffset;
            }
            case 34: {
                int newOffset = this.cat034Record.decode(input, offset, inputLength);
                this.sacSicCode = cat034Record.getItem010().getSac() + "/" + cat034Record
                        .getItem010().getSic();
                return newOffset;
            }
            case 48: {
                int newOffset = this.cat048Record.decode(input, offset, inputLength);
                this.sacSicCode = cat048Record.getItem010().getSac() + "/" + cat048Record
                        .getItem010().getSic();
                return newOffset;
            }
            case 62: {
                int newOffset = this.cat062Record.decode(input, offset, inputLength);
                this.sacSicCode = cat062Record.getItem010().getSac() + "/" + cat062Record
                        .getItem010().getSic();
                return newOffset;
            }
            case 65: {
                int newOffset = this.cat065Record.decode(input, offset, inputLength);
                this.sacSicCode = cat065Record.getItem010().getSac() + "/" + cat065Record
                        .getItem010().getSic();
                return newOffset;
            }
            case 150: {
                int newOffset = this.cat150Record.decode(input, offset, inputLength);
                this.sacSicCode = "NA";
                return newOffset;
            }
            default:
                throw new NotImplementedException();
        }
    }

    /**
     * Encodes the current Asterix record into a byte array, that can be then sent over the network
     * or written to a file.
     *
     * @return The new offset in the dest array, after the data has been encoded, or -1 if data
     * can not be written because end of array has
     * been reached
     */
    @Override
    public byte[] encode() {
        throw new NotImplementedException();
    }

    @Override
    public int getCategory() {
        return category;
    }

    @Override
    public Cat062Record getCat062Record() {
        return cat062Record;
    }

    @Override
    public void setCat062Record(Cat062Record cat062Record) {
        this.cat062Record = cat062Record;
    }

    @Override
    public Cat065Record getCat065Record() {
        return cat065Record;
    }

    @Override
    public void setCat065Record(Cat065Record cat065Record) {
        this.cat065Record = cat065Record;
    }

    @Override
    public Cat004Record getCat004Record() {
        return cat004Record;
    }

    @Override
    public void setCat004Record(Cat004Record cat004Record) {
        this.cat004Record = cat004Record;
    }

    @Override
    public Cat034Record getCat034Record() {
        return cat034Record;
    }

    @Override
    public void setCat034Record(Cat034Record cat034Record) {
        this.cat034Record = cat034Record;
    }

    @Override
    public Cat048Record getCat048Record() { return cat048Record; }

    @Override
    public void setCat048Record(Cat048Record cat048Record) {
        this.cat048Record = cat048Record;
    }

    @Override
    public Cat150Record getCat150Record() {
        return cat150Record;
    }

    @Override
    public void setCat150Record(Cat150Record cat150Record) {
        this.cat150Record = cat150Record;
    }

    /**
     * Dictionary of key-value pairs for extending the information of the ASTERIX record
     */
    @Override
    public AbstractMap<String, Object> getAdditionalInfo() {
        return this.additionalInfo;
    }

    /**
     * The SAC/SIC code of the Asterix Record. Cat150 message will always have NA as a value, since
     * this information is not present.
     *
     * @return
     */
    @Override
    public String getSacSicCode() {
        return sacSicCode;
    }
}
