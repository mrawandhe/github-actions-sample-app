package com.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = {
        "app.name=Order-Service",
        "app.version=1.0.0",
        "app.notification.enabled=true"
})
class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Test
    void shouldReturnApplicationDetails() {
        // when
        Map<String, String> appDetails = orderService.getAppDetails();

        // then
        assertThat(appDetails)
                .containsEntry("App name", "Order-Service")
                .containsEntry("App version", "1.0.0")
                .containsEntry("Notification Enabled", "true");
    }

    @Test
    void shouldReturnOrderConfigurationMetadata() {
        // when
        Map<String, String> metadata = orderService.getOrderConfigMetadata();

        // then
        assertThat(metadata)
                .containsEntry("threshold", "10000.00")
                .containsEntry("minOrderValue", "500.00")
                .containsEntry("currency", "INR");
    }

    @Test
    void shouldContainExactlyThreeAppDetailEntries() {
        // when
        Map<String, String> appDetails = orderService.getAppDetails();

        // then
        assertThat(appDetails)
                .hasSize(3)
                .containsOnlyKeys(
                        "App name",
                        "App version",
                        "Notification Enabled"
                );
    }


    @Test
    void orderMetadataValuesShouldNotBeNullOrBlank() {
        // when
        Map<String, String> metadata = orderService.getOrderConfigMetadata();

        // then
        assertThat(metadata.values())
                .allMatch(value -> value != null && !value.isBlank());
    }

    @Test
    void numericOrderMetadataShouldBeParsable() {
        Map<String, String> metadata = orderService.getOrderConfigMetadata();

        assertThatCode(() -> Double.parseDouble(metadata.get("threshold")))
                .doesNotThrowAnyException();

        assertThatCode(() -> Double.parseDouble(metadata.get("minOrderValue")))
                .doesNotThrowAnyException();
    }

    @Test
    void notificationEnabledFlagShouldBeBooleanValue() {
        String flag = orderService.getAppDetails()
                .get("Notification Enabled");

        assertThat(flag)
                .isIn("true", "false");
    }


}

