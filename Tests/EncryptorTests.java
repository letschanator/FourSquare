
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import fourSquare.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EncryptorTests {

    @Test
    void test1(){
        Four_Square square = new Four_Square("EXAMPLE","KEYWORD");
        Encryptor encryptor =new Encryptor(square,"HELP ME OBIWAN KENOBI");
        assertEquals("FYGMKYHOBXMFKKKIMD",encryptor.getEncrypted());
    }

    @Test
    void test2(){
        Four_Square square = new Four_Square("LOREM","IPSYUM");
        Encryptor encryptor = new Encryptor(square,"dolor sit amet consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore et dolore magna aliqua");
        assertEquals("MHKFSLDOREERMGIORUUYUONPECTMSSDHFPJASOEUMHEDSRKGEORJUETAIYDYDYTJUOPHOIHRMUTYHJHRRJOMGYOEFO",encryptor.getEncrypted());
    }

    @Test
    void test3(){
        Four_Square square = new Four_Square("STAR","TREK");
        Encryptor encryptor = new Encryptor(square,"TO BOLDLY GO WHERE NO ONE HAS GONE BEFORE");
        assertEquals("ULBIKRKWGIXCTURMLMLKCENDKMTASGIU",encryptor.getEncrypted());
    }

    @Test
    void test4(){
        Four_Square square = new Four_Square("LORD","RINGS");
        Encryptor encryptor = new Encryptor(square,"ONE RING TO RULE THEM ALL ONE RING TO FIND THEM ONE RING TO BRING THEM ALL AND IN THE DARKNESS BIND THEM");
        assertEquals("KLOUFKFOIUPLDUGNHNIHKLOUFKFOHEFKDTGNMJMGTBIDUKOOFKFOGNHNIHDFDDKTGNLGNHMGSPDBKGSDRL",encryptor.getEncrypted());
    }

    @Test
    void test5(){
        Four_Square square = new Four_Square("HARRY","POTTER");
        Encryptor encryptor = new Encryptor(square,"Yerr a wizard Harry");
        assertEquals("ZEOMAVGYALRDALSW",encryptor.getEncrypted());
    }
}
