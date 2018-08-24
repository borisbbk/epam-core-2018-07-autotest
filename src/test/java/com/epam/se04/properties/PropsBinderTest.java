package com.epam.se04.properties;

import lombok.Value;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class PropsBinderTest {

    @Test
    @DisplayName("From method works correctly")
    void testFrom() {
        val props = PropsBinder.from(Props.class);
        assertThat(props.getProp1(), is(50));
        assertThat(props.getProp2(), is("qwerty!"));
        Props2 p3 = props.getP3();
        assertThat(p3.getP1(), is(2));
        assertThat(p3.getP2(), is("qwerty!!!"));
    }
}

@Value
class Props {
    int prop1;
    String prop2;
    Props2 p3;
}

@Value
class Props2 {
    int p1;
    String p2;
}