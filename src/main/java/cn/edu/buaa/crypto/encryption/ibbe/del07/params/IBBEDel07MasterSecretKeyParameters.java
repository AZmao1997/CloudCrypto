package cn.edu.buaa.crypto.encryption.ibbe.del07.params;

import cn.edu.buaa.crypto.algebra.PairingUtils;
import cn.edu.buaa.crypto.pairingkem.params.PairingKeyParameters;
import it.unisa.dia.gas.jpbc.Element;
import it.unisa.dia.gas.jpbc.PairingParameters;

/**
 * Created by Weiran Liu on 16/8/23.
 *
 * Master Secret Key Parameters for Delerablée IBBE
 */
public class IBBEDel07MasterSecretKeyParameters extends PairingKeyParameters {

    private final Element g;
    private final Element gamma;

    public IBBEDel07MasterSecretKeyParameters(PairingParameters pairingParameters, Element g, Element gamma) {
        super(true, pairingParameters);
        this.g = g.getImmutable();
        this.gamma = gamma.getImmutable();
    }

    public Element getG(){
        return this.g.duplicate();
    }

    public Element getGamma() { return this.gamma.duplicate(); }

    @Override
    public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof IBBEDel07MasterSecretKeyParameters) {
            IBBEDel07MasterSecretKeyParameters that = (IBBEDel07MasterSecretKeyParameters)anObject;
            //compare g
            if (!(PairingUtils.isEqualElement(this.g, that.getG()))) {
                return false;
            }
            //compare gamma
            if (!(PairingUtils.isEqualElement(this.gamma, that.getGamma()))) {
                return false;
            }
            //Compare Pairing Parameters
            return this.getParameters().toString().equals(that.getParameters().toString());
        }
        return false;
    }
}
