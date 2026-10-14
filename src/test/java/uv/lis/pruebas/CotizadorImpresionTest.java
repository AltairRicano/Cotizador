package uv.lis.pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

// Un método por caso de la tabla (CP01..CP26). El esperado se calcula a mano desde la
// especificación (R1 a R7) y se escribe en la aserción; no se copia del programa.
// BigDecimal se compara con equals: exige también los dos decimales de R7.
//
// Cuatro esperados difieren de la tabla original porque ésta omitía el factor de usuario
// (R5) o tenía un mensaje con tilde que la especificación no lleva:
//   CP02  500 págs. estudiante: 400.00 x 0.88 x 0.80 = 281.60  (tabla: 352.00)
//   CP11  150 págs. estudiante: 120.00 x 0.95 x 0.80 =  91.20  (tabla: 114.00)
//   CP12  400 págs. estudiante: 320.00 x 0.88 x 0.80 = 225.28  (tabla: 281.60)
//   CP26   20 págs. color estudiante: 90.00 x 0.80   =  72.00  (tabla: 18)
//   CP03  el mensaje de R1.2 es "PAGINAS FUERA DE RANGO: n", sin tilde.
class CotizadorImpresionTest {

    private final CotizadorImpresion cotizador = new CotizadorImpresion();

    // --- R1: validación de entradas ---

    @Test void CP01_usuarioNulo_lanzaTipoRequerido() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> cotizador.cotizar(null, 100, true, false));
        assertEquals("TIPO DE USUARIO REQUERIDO", e.getMessage());
    }

    @Test void CP02_valorMaximo500_devuelve281_60() {
        assertEquals(new BigDecimal("281.60"), cotizador.cotizar(TipoUsuario.ESTUDIANTE, 500, false, false));
    }

    @Test void CP03_fueraDeRangoMaximo600_lanzaPaginasFueraDeRango() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> cotizador.cotizar(TipoUsuario.DOCENTE, 600, false, false));
        assertEquals("PAGINAS FUERA DE RANGO: 600", e.getMessage());
    }

    @Test void CP04_fueraDeRangoMinimo0_lanzaPaginasFueraDeRango() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> cotizador.cotizar(TipoUsuario.EXTERNO, 0, true, true));
        assertEquals("PAGINAS FUERA DE RANGO: 0", e.getMessage());
    }

    @Test void CP05_valorMinimo1_devuelve5_18() {
        assertEquals(new BigDecimal("5.18"), cotizador.cotizar(TipoUsuario.EXTERNO, 1, true, false));
    }

    @Test void CP06_nuloYPaginasInvalidas_ganaTipoRequerido() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> cotizador.cotizar(null, 800, true, false));
        assertEquals("TIPO DE USUARIO REQUERIDO", e.getMessage());
    }

    // --- R2 y R3.1: precio por página, sin descuento por volumen ---

    @Test void CP07_precioBlancoYNegro20_devuelve12_80() {
        assertEquals(new BigDecimal("12.80"), cotizador.cotizar(TipoUsuario.ESTUDIANTE, 20, false, false));
    }

    @Test void CP08_sinDescuentoVolumen80Estudiante_devuelve51_20() {
        assertEquals(new BigDecimal("51.20"), cotizador.cotizar(TipoUsuario.ESTUDIANTE, 80, false, false));
    }

    @Test void CP09_sinDescuentoVolumen90Docente_devuelve36_00() {
        assertEquals(new BigDecimal("36.00"), cotizador.cotizar(TipoUsuario.DOCENTE, 90, false, false));
    }

    @Test void CP10_sinDescuentoVolumen72ExternoColor_devuelve372_60() {
        assertEquals(new BigDecimal("372.60"), cotizador.cotizar(TipoUsuario.EXTERNO, 72, true, false));
    }

    // --- R3.2 y R3.3: descuento por volumen ---

    @Test void CP11_descuento5PorCientoVolumen150_devuelve91_20() {
        assertEquals(new BigDecimal("91.20"), cotizador.cotizar(TipoUsuario.ESTUDIANTE, 150, false, false));
    }

    @Test void CP12_descuento12PorCientoVolumen400_devuelve225_28() {
        assertEquals(new BigDecimal("225.28"), cotizador.cotizar(TipoUsuario.ESTUDIANTE, 400, false, false));
    }

    // --- R4: doble cara ---

    @Test void CP13_dobleCara80_devuelve46_08() {
        assertEquals(new BigDecimal("46.08"), cotizador.cotizar(TipoUsuario.ESTUDIANTE, 80, false, true));
    }

    @Test void CP14_dobleCaraYVolumen5PorCiento_devuelve82_08() {
        assertEquals(new BigDecimal("82.08"), cotizador.cotizar(TipoUsuario.ESTUDIANTE, 150, false, true));
    }

    @Test void CP15_dobleCaraYVolumen12PorCiento_devuelve202_75() {
        assertEquals(new BigDecimal("202.75"), cotizador.cotizar(TipoUsuario.ESTUDIANTE, 400, false, true));
    }

    @Test void CP16_estudianteColorDobleCara50_devuelve162_00() {
        assertEquals(new BigDecimal("162.00"), cotizador.cotizar(TipoUsuario.ESTUDIANTE, 50, true, true));
    }

    @Test void CP17_unaPaginaNoAplicaDobleCara_devuelve3_60() {
        assertEquals(new BigDecimal("3.60"), cotizador.cotizar(TipoUsuario.ESTUDIANTE, 1, true, true));
    }

    // --- R5: tipo de usuario ---

    @Test void CP18_descuentoEstudiante25Color_devuelve90_00() {
        assertEquals(new BigDecimal("90.00"), cotizador.cotizar(TipoUsuario.ESTUDIANTE, 25, true, false));
    }

    @Test void CP19_descuentoDocente37Color_devuelve83_25() {
        assertEquals(new BigDecimal("83.25"), cotizador.cotizar(TipoUsuario.DOCENTE, 37, true, false));
    }

    @Test void CP20_recargoExterno71_devuelve65_32() {
        assertEquals(new BigDecimal("65.32"), cotizador.cotizar(TipoUsuario.EXTERNO, 71, false, false));
    }

    // --- R6: cargo mínimo ---

    @Test void CP21_cargoMinimoConDobleCara_devuelve2_00() {
        assertEquals(new BigDecimal("2.00"), cotizador.cotizar(TipoUsuario.DOCENTE, 4, false, true));
    }

    @Test void CP22_cargoMinimoUnaPagina_devuelve2_00() {
        assertEquals(new BigDecimal("2.00"), cotizador.cotizar(TipoUsuario.DOCENTE, 1, false, false));
    }

    // --- R7: redondeo, mitad hacia arriba ---

    @Test void CP23_redondeoMedioCentavoDocente45_devuelve91_13() {
        assertEquals(new BigDecimal("91.13"), cotizador.cotizar(TipoUsuario.DOCENTE, 45, true, true));
    }

    @Test void CP24_redondeoMedioCentavoExterno71_devuelve367_43() {
        assertEquals(new BigDecimal("367.43"), cotizador.cotizar(TipoUsuario.EXTERNO, 71, true, false));
    }

    @Test void CP25_redondeoTercerDecimal6Estudiante127_devuelve390_91() {
        assertEquals(new BigDecimal("390.91"), cotizador.cotizar(TipoUsuario.ESTUDIANTE, 127, true, true));
    }

    @Test void CP26_precioColor20Estudiante_devuelve72_00() {
        assertEquals(new BigDecimal("72.00"), cotizador.cotizar(TipoUsuario.ESTUDIANTE, 20, true, false));
    }

    // 100 págs. es el primer valor del tramo del 5 % (R3.2): 80.00 x 0.95 x 0.80 = 60.80
    @Test void CP27_fronteraDescuento5PorCiento100_devuelve60_80() {
        assertEquals(new BigDecimal("60.80"), cotizador.cotizar(TipoUsuario.ESTUDIANTE, 100, false, false));
    }
}
