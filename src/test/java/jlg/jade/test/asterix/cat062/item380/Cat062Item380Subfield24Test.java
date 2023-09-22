/* 
* Created by dan-geabunea on 5/4/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat062.item380;

import jlg.jade.asterix.cat062.item380.Cat062Item380Subfield24;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;

public class Cat062Item380Subfield24Test extends MandatoryFixedLengthAsterixTests<Cat062Item380Subfield24> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 1;
    }

    @Override
    protected Cat062Item380Subfield24 setFixedLengthAsterixDataInstance() {
        return new Cat062Item380Subfield24();
    }
}
