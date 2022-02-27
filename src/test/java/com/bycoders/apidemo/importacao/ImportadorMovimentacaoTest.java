package com.bycoders.apidemo.importacao;

import com.bycoders.apidemo.model.Representante;
import com.bycoders.apidemo.service.RepresentanteService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class ImportadorMovimentacaoTest {

  @Mock
  private ImportadorMovimentacao importador;

  String horaFomatada;
  Date date;

  @BeforeEach
  void setup() {
    MockitoAnnotations.openMocks(this);
    horaFomatada = "10:20:30";
    date = new Date();
  }

  @Test
  void parserData() {
    Mockito.when(importador.parserData(Mockito.anyString(), Mockito.anyString())).thenReturn(date);
    Date returnData = importador.parserData("20200101", "yyyy-MM-dd");

    Assert.assertNotNull(returnData);
    Assert.assertEquals(date, returnData);
  }

  @Test
  void parserDataNulla() {
    Mockito.when(importador.parserData(Mockito.isNull(), Mockito.anyString())).thenReturn(date);
    Date returnData = importador.parserData("20200101", "yyyy-MM-dd");

    Assert.assertNull(returnData);
  }

  @Test
  void parseHora() {
    Mockito.when(importador.parseHora(Mockito.anyString())).thenReturn(horaFomatada);
    String returnHora = importador.parseHora("102030");

    Assert.assertNotNull(returnHora);
    Assert.assertEquals(horaFomatada, returnHora);

  }
}