import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ValidadorTest {
    // Passo 1
    @Test
    void deveValidarCPFValido() {
        assertTrue(Validador.validarCPF("529.982.247-25")); // Valido com mascara
        assertTrue(Validador.validarCPF("52998224725")); // Valido sem mascara
        assertTrue(Validador.validarCPF(" 52998224725 ")); // Espacos externos
    }

    // Passo 3
    @Test
    void deveRejeitarEntradasInvalidas() {
        assertFalse(Validador.validarCPF(null)); // Nulo
        assertFalse(Validador.validarCPF("")); // Vazio
        assertFalse(Validador.validarCPF("529.982.247-2X")); // Caractere Invalido
        assertFalse(Validador.validarCPF("00000000000")); // Sequencia repetida
    }

    // Passo 4
    @Test
    void deveRejeitarTamanhosIncorretos() {
        assertFalse(Validador.validarCPF("935.411.347-8"));   // 10 dígitos
        assertFalse(Validador.validarCPF("935.411.347-800")); // 12 dígitos
    }

    // Passo 6
    @Test
    void deveRejeitarDVIncorreto() {
        assertFalse(Validador.validarCPF("529.982.247-24")); // DV incorreto
        assertFalse(Validador.validarCPF("123.456.789-00")); // Generico
    }

    // Passo extra
    @Test
    void deveValidarMeuCPF() {
        assertTrue(Validador.validarCPF("064.224.459-62")); // Meu CPF
        assertTrue(Validador.validarCPF("06422445962")); // Sem mascara
    }

}
