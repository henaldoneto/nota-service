package br.com.arquivei.application.nota;

import br.com.arquivei.application.nota.dto.NotaDTO;
import br.com.arquivei.domain.model.Nota;
import br.com.arquivei.domain.service.nota.NotaService;
import br.com.arquivei.shared.NotaQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import static br.com.arquivei.shared.NotaFixture.getNota;
import static br.com.arquivei.shared.TestConstants.ACCESS_KEY;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class NotaApplicationServiceTest {

    @InjectMocks
    private NotaApplicationService notaApplicationService;

    @Mock
    private NotaService notaService;

    @Test
    public void givenValidAccessKeyWhenFindByAccessKeyThenInvokeServiceFindByAccessKey(){
        var nota = getNota();
        when(notaService.findByAccessKey(ACCESS_KEY)).thenReturn(nota);
        notaApplicationService.findByAccessKey(ACCESS_KEY);
        then(notaService).should().findByAccessKey(ACCESS_KEY);
    }

    //TODO implementar
//    @Test
//    public void givenValidNotaQueryWhenFindThenInvokeServiceFind(){
//        var notaQuery = new NotaQuery();
//
////        when(notaService.find(notaQuery)).thenReturn();
//        notaApplicationService.find(notaQuery);
//        then(notaService).should().find(notaQuery);
//    }

    @Test
    public void givenValidNotaThenDelegateToNotaServiceSave(){
        var nota = getNota();
        notaApplicationService.save(nota);
        then(notaService).should().save(nota);
    }

    @Test
    public void givenCallReceiveNfeThenDelegateToNotaServiceReceiveNfe(){
        notaApplicationService.receiveNfe();
        then(notaService).should().receiveNfe();
    }

}