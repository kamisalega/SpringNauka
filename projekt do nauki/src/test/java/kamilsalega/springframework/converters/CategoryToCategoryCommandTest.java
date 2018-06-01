package kamilsalega.springframework.converters;

import kamilsalega.springframework.commands.CategoryCommand;
import kamilsalega.springframework.domain.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryToCategoryCommandTest {

    public static final String OPIS = "opis";
    public static final Long WARTOSC = new Long(1L);

    CategoryToCategoryCommand convter;

    @Before
    public void setUp() throws Exception {
        convter = new CategoryToCategoryCommand();
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(convter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(convter.convert(new Category()));
    }

    @Test
    public void convert() throws Exception {
        //given
        Category category = new Category();
        category.setId(WARTOSC);
        category.setDescription(OPIS);

        //when
        CategoryCommand categoryCommand = convter.convert(category);

        //then
        assertEquals(WARTOSC, categoryCommand.getId());
        assertEquals(OPIS, categoryCommand.getDescription());

    }

}
