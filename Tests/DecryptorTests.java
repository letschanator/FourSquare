
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import fourSquare.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecryptorTests {

    @Test
    void test1(){
        Four_Square square = new Four_Square("EXAMPLE","KEYWORD");
        Decryptor decryptor = new Decryptor(square,"FYGMKYHOBXMFKKKIMD");
        assertEquals("HELPMEOBIWANKENOBI",decryptor.getDecrypted());
    }

    @Test
    void test2(){
        Four_Square square = new Four_Square("LOREM","IPSYUM");
        Decryptor decryptor = new Decryptor(square,"MHKFSLDOREERMGIORUUYUONPECTMSSDHFPJASOEUMHEDSRKGEORJUETAIYDYDYTJUOPHOIHRMUTYHJHRRJOMGYOEFO");
        assertEquals("DOLORSITAMETCONSECTETURADIPISCINGELITSEDDOEIUSMODTEMPORINCIDIDUNTUTLABOREETDOLOREMAGNAALIU",decryptor.getDecrypted());
    }

    @Test
    void test3(){
        Four_Square square = new Four_Square("STAR","TREK");
        Decryptor decryptor = new Decryptor(square,"ULBIKRKWGIXCTURMLMLKCENDKMTASGIU");
        assertEquals("TOBOLDLYGOWHERENOONEHASGONEBEFOR",decryptor.getDecrypted());
    }

    @Test
    void test4(){
        Four_Square square = new Four_Square("LORD","RINGS");
        Decryptor decryptor = new Decryptor(square,"KLOUFKFOIUPLDUGNHNIHKLOUFKFOHEFKDTGNMJMGTBIDUKOOFKFOGNHNIHDFDDKTGNLGNHMGSPDBKGSDRL");
        assertEquals("ONERINGTORULETHEMALLONERINGTOFINDTHEMONERINGTOBRINGTHEMALLANDINTHEDARKNESSBINDTHEM",decryptor.getDecrypted());
    }

    @Test
    void test5(){
        Four_Square square = new Four_Square("HARRY","POTTER");
        Decryptor decryptor = new Decryptor(square,"ZEOMAVGYALRDALSW");
        assertEquals("YERRAWIZARDHARRY",decryptor.getDecrypted());
    }
}
