package org.junit.jupiter.engine.descriptor;

import org.junit.jupiter.api.Test;
import org.junit.platform.engine.UniqueId;
import org.junit.platform.engine.support.descriptor.EngineDescriptor;

import static org.assertj.core.api.Assertions.assertThat;


class JupiterEngineDescriptorTests {

    private static final UniqueId UNIQUE_ID = UniqueId.forEngine("test-id");

    @Test
    void createDescriptorWithDefaultDisplayName() {
        // Arrange
        EngineDescriptor expectedDescriptor = new EngineDescriptor(UNIQUE_ID, "JUnit Jupiter");
        // Act
        EngineDescriptor descriptor = new JupiterEngineDescriptor(UNIQUE_ID);
        // Assert
        assertThat(descriptor).isNotNull()
                              .isEqualToComparingFieldByField(expectedDescriptor)
                              .extracting(EngineDescriptor::getDisplayName)
                              .isEqualTo("JUnit Jupiter");
    }

    @Test
    void createDescriptorWithCustomDisplayName() {
        // Arrange
        EngineDescriptor expectedDescriptor = new EngineDescriptor(UNIQUE_ID, "Custom name");
        // Act
        EngineDescriptor descriptor = new JupiterEngineDescriptor(UNIQUE_ID, "Custom name");
        // Assert
        assertThat(descriptor).isNotNull()
                              .isEqualToComparingFieldByField(expectedDescriptor)
                              .extracting(EngineDescriptor::getDisplayName)
                              .isEqualTo("Custom name");
    }
}