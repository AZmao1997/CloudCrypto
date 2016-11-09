package cn.edu.buaa.crypto.encryption.ibbe.del07.generators;

import cn.edu.buaa.crypto.utils.PairingUtils;
import cn.edu.buaa.crypto.encryption.ibbe.del07.params.IBBEDel07MasterSecretKeySerParameter;
import cn.edu.buaa.crypto.encryption.ibbe.del07.params.IBBEDel07PublicKeySerParameter;
import cn.edu.buaa.crypto.encryption.ibbe.del07.params.IBBEDel07SecretKeyGenerationParameters;
import cn.edu.buaa.crypto.encryption.ibbe.del07.params.IBBEDel07SecretKeySerParameter;
import it.unisa.dia.gas.crypto.cipher.CipherParametersGenerator;
import it.unisa.dia.gas.jpbc.Element;
import it.unisa.dia.gas.jpbc.Pairing;
import it.unisa.dia.gas.plaf.jpbc.pairing.PairingFactory;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.KeyGenerationParameters;

/**
 * Created by Weiran Liu on 2016/8/24.
 *
 * Secret key generator for Delerablée IBBE scheme.
 */
public class IBBEDel07SecretKeyGenerator implements CipherParametersGenerator {
    private IBBEDel07SecretKeyGenerationParameters parameters;

    public void init(KeyGenerationParameters keyGenerationParameters) {
        this.parameters = (IBBEDel07SecretKeyGenerationParameters)keyGenerationParameters;
    }

    public CipherParameters generateKey() {
        IBBEDel07MasterSecretKeySerParameter masterSecretKeyParameters = parameters.getMasterSecretKeyParameters();
        IBBEDel07PublicKeySerParameter publicKeyParameters = parameters.getPublicKeyParameters();

        Pairing pairing = PairingFactory.getPairing(publicKeyParameters.getParameters());
        Element elementId = PairingUtils.MapToZr(pairing, parameters.getId());

        Element secretKey = masterSecretKeyParameters.getG().powZn(masterSecretKeyParameters.getGamma().add(elementId).invert()).getImmutable();

        return new IBBEDel07SecretKeySerParameter(publicKeyParameters.getParameters(), parameters.getId(), elementId, secretKey);
    }
}
