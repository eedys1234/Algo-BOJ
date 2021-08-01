package greedy;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class PS_3135Test {

    private PS_3135 ps;

    @Before
    public void setUP() throws Exception {
        ps = new PS_3135();
    }

    @Test
    public void 케이스_1() throws Exception {

        //given
        String first_line = "100 15";
        String second_line = "1";
        String[] thirty_line = {"15"};

        //when
        int expected = ps.moveShortestCount(first_line, second_line, thirty_line);

        //then
        assertThat(1, is(expected));
    }

    @Test
    public void 케이스_2() throws Exception {

        //given
        String first_line = "88 17";
        String second_line = "3";
        String[] thirty_line = {"18", "1", "42"};

        //when
        int expected = ps.moveShortestCount(first_line, second_line, thirty_line);

        //then
        assertThat(2, is(expected));
    }

    @Test
    public void 케이스_3() throws Exception {

        //given
        String first_line = "64 120";
        String second_line = "1";
        String[] thirty_line = {"567"};

        //when
        int expected = ps.moveShortestCount(first_line, second_line, thirty_line);

        //then
        assertThat(56, is(expected));
    }
}
