package org.adaschool.weather.controller;

import org.adaschool.weather.data.WeatherReport;
import org.adaschool.weather.service.WeatherReportService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.when;

@SpringBootTest
public class WeatherReportControllerTest {
    @MockBean
    private WeatherReportService weatherReportService;
    @Autowired
    private WeatherReportController weatherReportController;

    @Test
    public void testGetWeatherReport() {
        WeatherReport mockReport = new WeatherReport();
        mockReport.setTemperature(20.0);
        mockReport.setHumidity(80.0);

        when(weatherReportService.getWeatherReport(anyDouble(), anyDouble())).thenReturn(mockReport);

        WeatherReport report = weatherReportController.getWeatherReport(10.0, 10.0);

        assertEquals(20.0, report.getTemperature());
        assertEquals(80.0, report.getHumidity());
    }
}
