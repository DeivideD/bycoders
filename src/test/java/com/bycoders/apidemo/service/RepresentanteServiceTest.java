package com.bycoders.apidemo.service;

import com.bycoders.apidemo.model.Representante;
import com.bycoders.apidemo.repository.RepresentanteRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class RepresentanteServiceTest {

  @InjectMocks
  private RepresentanteService service;

  @Mock
  private RepresentanteRepository repository;

  private Representante representante;

  @BeforeEach
  void setup() {
    MockitoAnnotations.openMocks(this);
    representante = new Representante();

    representante.setCPF("033983698832");
    representante.setNome("Joaozinho");
    representante.setId( Long.valueOf(1));
  }

  @Test
  void findByCPF() {
    Mockito.when(repository.findByCPF(Mockito.anyString())).thenReturn(representante);
    Representante response = service.findByCPF("033983698832");

    Assert.assertNotNull(response);
    Assert.assertEquals(Representante.class, response.getClass());

    Assert.assertEquals( representante.getNome(), response.getNome());
    Assert.assertEquals( representante.getCPF(), response.getCPF());
    Assert.assertEquals( representante.getId(), response.getId());
  }

  @Test
  void findByNome() {

      Mockito.when(repository.findByNome(Mockito.anyString())).thenReturn(representante);
      Representante response = service.findByNome("Joaozinho");

      Assert.assertNotNull(response);
      Assert.assertEquals(Representante.class, response.getClass());

      Assert.assertEquals( representante.getNome(), response.getNome());
      Assert.assertEquals( representante.getCPF(), response.getCPF());
      Assert.assertEquals( representante.getId(), response.getId());

  }

  @Test
  void findAllAndReturnListRepresentantes(){
    Mockito.when(repository.findAll()).thenReturn(List.of(representante));

    List<Representante> response = service.findAll();

    Assert.assertNotNull(response);
    Assert.assertEquals(1, response.size());
    Assert.assertEquals(Representante.class, response.get(0).getClass());
  }


  @Test
  void save() {
  Mockito.when(repository.save(Mockito.any())).thenReturn(representante) ;
  Representante response = service.save(representante);

  Assert.assertNotNull(response);
  Assert.assertEquals(Representante.class, response.getClass());

  }
}