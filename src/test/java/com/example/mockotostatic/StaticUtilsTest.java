package com.example.mockotostatic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class StaticUtilsTest {

    @DisplayName("Get to name")
    @Test
    void getNameTest() {
        assertThat(StaticUtils.name()).isEqualTo("Mixamus");

        try (MockedStatic<StaticUtils> utilsMockedStatic = Mockito.mockStatic(StaticUtils.class)) {
            utilsMockedStatic.when(StaticUtils::name).thenReturn("Melisa");
            assertThat(StaticUtils.name()).isEqualTo("Melisa");
        }

        assertThat(StaticUtils.name()).isEqualTo("Mixamus");
    }

    @DisplayName("Get to range numbers")
    @Test
    void getRangeTest() {
        assertThat(StaticUtils.range(2, 6)).containsExactly(2, 3, 4, 5);

        try (MockedStatic<StaticUtils> utilsMockedStatic = Mockito.mockStatic(StaticUtils.class)) {
            utilsMockedStatic.when(() -> StaticUtils.range(2, 6))
                    .thenReturn(Arrays.asList(10, 11, 12));
            assertThat(StaticUtils.range(2, 6)).containsExactly(10, 11, 12);
        }

        assertThat(StaticUtils.range(2, 6)).containsExactly(2, 3, 4, 5);
    }
}