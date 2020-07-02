/**
 * 
 */
package net.xaviersala.Vaca.Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

/**
 *
 * @author tolsa
 */
public class CiutatTests {
    @BeforeEach
    void setUp() throws Exception {
    }

    static Stream<Arguments> CalculaPreuLletVaques() {
        List<Vaca> vaques;
        vaques = new ArrayList<Vaca>();
        for (int i = 0; i < 10; i++) {
            int pes = 200+i*10;
            Raca racaFalsa = Mockito.mock(Raca.class);
            Vaca sut = new Vaca("nom"+i, pes, racaFalsa);
            vaques.add(sut);
        }
            
        int litresCiutat1=0;
        int litresCiutat2=500;
        int litresCiutat3=1500;
        int litresCamio1=1000;
        int litresCamio2=1001;
        int litresCamio3=1500;
        return Stream.of(Arguments.of(vaques, litresCiutat1,litresCamio1),Arguments.of(vaques, litresCiutat2,litresCamio2),Arguments.of(vaques, litresCiutat3, litresCamio3));
    }

    @ParameterizedTest
    @MethodSource("CalculaPreuLletVaques")
    void testQueRetornaCorrectamentElPreuDeLaLlet(ArrayList<Vaca> vaques, int litresCiutat, int litresCamio) {

            double preuLlet = 1.1;
            // ARRANGE
            Camio camioFals = Mockito.mock(Camio.class);
            Mockito.when(camioFals.getVaques()).thenReturn(vaques);

            Ciutat sut = new Ciutat("nom", litresCiutat);
            if (litresCiutat>1000){
                boolean resultat = Ciutat.getComproLlet();                
                assertEquals(false, resultat);
            }
            else{
                boolean resultat = Ciutat.getComproLlet();                
                assertEquals(true, resultat);
                
                if (litresCamio%2==0)
                    preuLlet +=0.1;
                else
                    preuLlet -=0.1;
                for (Iterator<Vaca> iterator = vaques.iterator(); iterator.hasNext();) {
                    Vaca next = iterator.next();
                    
                }

                double resultat2 = Ciutat.getPreuLlet(); 
                assertEquals(preuLlet, resultat2);
            }

    }


}
