package cn.edu.buaa.crypto.encryption.ibbe.del07.params;

import cn.edu.buaa.crypto.utils.PairingUtils;
import cn.edu.buaa.crypto.algebra.params.PairingCiphertextParameters;
import it.unisa.dia.gas.jpbc.Element;
import it.unisa.dia.gas.jpbc.PairingParameters;

/**
 * Created by Weiran Liu on 2016/8/24.
 *
 * Ciphertext Parameters for Delerablée IBBE scheme.
 */
public class IBBEDel07CiphertextParameters extends PairingCiphertextParameters {

    private final Element C1;
    private final Element C2;

    public IBBEDel07CiphertextParameters(PairingParameters pairingParameters, Element C1, Element C2) {
        super(pairingParameters);
        this.C1 = C1.getImmutable();
        this.C2 = C2.getImmutable();
    }

    public Element getC1() { return this.C1.duplicate(); }

    public Element getC2() { return this.C2.duplicate(); }

    @Override
    public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof IBBEDel07CiphertextParameters) {
            IBBEDel07CiphertextParameters that = (IBBEDel07CiphertextParameters)anObject;
            //Compare C1
            if (!PairingUtils.isEqualElement(this.C1, that.getC1())){
                return false;
            }
            //Compare C2
            if (!PairingUtils.isEqualElement(this.C2, that.getC2())){
                return false;
            }
            //Compare Pairing Parameters
            return this.getParameters().toString().equals(that.getParameters().toString());
        }
        return false;
    }
}
