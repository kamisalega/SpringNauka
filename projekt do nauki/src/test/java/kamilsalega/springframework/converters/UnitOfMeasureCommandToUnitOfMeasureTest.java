package kamilsalega.springframework.converters;

import kamilsalega.springframework.commands.UnitOfMeasureCommand;
import kamilsalega.springframework.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class UnitOfMeasureCommandToUnitOfMeasureTest {

    public static final String OPIS = "opis";
    public static final Long WARTOSC = new Long(1L);

    UnitOfMeasureCommandToUnitOfMeasure converter;


    @Before
    public void setUp() throws Exception {
        converter = new UnitOfMeasureCommandToUnitOfMeasure();

    }

    @Test
    public void testNullParamter() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new UnitOfMeasureCommand()));
    }

    @Test
    public void convert() throws Exception {

        //given
        UnitOfMeasureCommand command = new UnitOfMeasureCommand();
        command.setId(WARTOSC);
        command.setDescription(OPIS);

        //when
        UnitOfMeasure uom = converter.convert(command);

        //then
        assertNotNull(uom);
        assertEquals(WARTOSC, uom.getId());
        assertEquals(OPIS, uom.getDescription());


    }
}