package com.demo.spring.spring_boot_with_docker.atividade;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

@SpringBootTest
@AutoConfigureMockMvc
public class AtividadeControllerTest {

    @InjectMocks
    private AtividadeController atividadeController;

    @Mock
    private AtividadeService atividadeService;

    @Autowired
    private MockMvc mockMvc;

    private Atividade atividade;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(atividadeController).build();

        atividade = new Atividade();
        atividade.setId(1L);
        atividade.setDescricao("Atividade Teste");
    }

    @Test
    public void testFindAll() throws Exception {
        when(atividadeService.findAll()).thenReturn(Collections.singletonList(atividade));

        mockMvc.perform(get("/atividades")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(atividade.getId()))
                .andExpect(jsonPath("$[0].descricao").value(atividade.getDescricao()));

        verify(atividadeService, times(1)).findAll();
    }

    @Test
    public void testFindById() throws Exception {
        when(atividadeService.findById(1L)).thenReturn(atividade);

        mockMvc.perform(get("/atividades/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(atividade.getId()))
                .andExpect(jsonPath("$.descricao").value(atividade.getDescricao()));

        verify(atividadeService, times(1)).findById(1L);
    }

    @Test
    public void testSave() throws Exception {
        when(atividadeService.save(any(Atividade.class))).thenReturn(atividade);

        mockMvc.perform(post("/atividades")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(atividade)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(atividade.getId()))
                .andExpect(jsonPath("$.descricao").value(atividade.getDescricao()));

        verify(atividadeService, times(1)).save(any(Atividade.class));
    }

    @Test
    public void testDelete() throws Exception {
        doNothing().when(atividadeService).delete(1L);

        mockMvc.perform(delete("/atividades/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(atividadeService, times(1)).delete(1L);
    }

    @Test
    public void testUpdate() throws Exception {
        when(atividadeService.update(eq(1L), any(Atividade.class))).thenReturn(atividade);

        mockMvc.perform(put("/atividades/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(atividade)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(atividade.getId()))
                .andExpect(jsonPath("$.descricao").value(atividade.getDescricao()));

        verify(atividadeService, times(1)).update(eq(1L), any(Atividade.class));
    }
}