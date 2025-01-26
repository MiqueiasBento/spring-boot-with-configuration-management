package com.demo.spring.spring_boot_with_docker.atividade;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@AutoConfigureMockMvc
public class AtividadeServiceTest {

    @InjectMocks
    private AtividadeService atividadeService;

    @Mock
    private AtividadeRepository atividadeRepository;

    private Atividade atividade;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        atividade = new Atividade();
        atividade.setId(1L);
        atividade.setDescricao("Atividade Teste");
    }

    @Test
    public void testSave() {
        when(atividadeRepository.save(any(Atividade.class))).thenReturn(atividade);

        Atividade savedAtividade = atividadeService.save(atividade);

        assertNotNull(savedAtividade);
        assertEquals(atividade.getId(), savedAtividade.getId());
        assertEquals(atividade.getDescricao(), savedAtividade.getDescricao());
        verify(atividadeRepository, times(1)).save(atividade);
    }

    @Test
    public void testFindAll() {
        when(atividadeRepository.findAll()).thenReturn(List.of(atividade));

        Iterable<Atividade> atividades = atividadeService.findAll();

        assertNotNull(atividades);
        assertTrue(atividades.iterator().hasNext());
        verify(atividadeRepository, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        when(atividadeRepository.findById(1L)).thenReturn(Optional.of(atividade));

        Atividade foundAtividade = atividadeService.findById(1L);

        assertNotNull(foundAtividade);
        assertEquals(atividade.getId(), foundAtividade.getId());
        verify(atividadeRepository, times(1)).findById(1L);
    }

    @Test
    public void testDelete() {
        doNothing().when(atividadeRepository).deleteById(1L);

        atividadeService.delete(1L);

        verify(atividadeRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testUpdate() {
        when(atividadeRepository.existsById(1L)).thenReturn(true);
        when(atividadeRepository.save(any(Atividade.class))).thenReturn(atividade);

        Atividade updatedAtividade = atividadeService.update(1L, atividade);

        assertNotNull(updatedAtividade);
        assertEquals(atividade.getId(), updatedAtividade.getId());
        verify(atividadeRepository, times(1)).save(atividade);
    }

    @Test
    public void testUpdateNotFound() {
        when(atividadeRepository.existsById(1L)).thenReturn(false);

        Atividade updatedAtividade = atividadeService.update(1L, atividade);

        assertNull(updatedAtividade);
        verify(atividadeRepository, times(0)).save(any(Atividade.class));
    }
}