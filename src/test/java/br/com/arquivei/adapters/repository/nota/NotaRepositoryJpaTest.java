package br.com.arquivei.adapters.repository.nota;

import br.com.arquivei.domain.service.nota.NotaRepository;
import br.com.arquivei.shared.NotaQuery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.PageRequest;

import static br.com.arquivei.shared.NotaFixture.getNota;
import static br.com.arquivei.shared.TestConstants.ACCESS_KEY;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.then;

@RunWith(MockitoJUnitRunner.class)
public class NotaRepositoryJpaTest {

    @Mock
    private NotaRepositorySpringData notaRepositorySpringData;

    private NotaRepository notaRepository;

    @Before
    public void setUp(){
        notaRepository = new NotaRepositoryJpa(notaRepositorySpringData);
    }

    @Test
    public void givenAValidNotaWhenSaveThenDelegateToJpaRepository(){
        var nota = getNota();
        notaRepository.save(nota);
        then(notaRepositorySpringData).should().save(nota);
    }

    @Test
    public void givenAccessKeyWhenFindNotaThenDelegateToJpaRepository(){
        notaRepository.findByAccessKey(ACCESS_KEY);
        then(notaRepositorySpringData).should().findByAccessKey(ACCESS_KEY);
    }

    @Test
    public void givenNotaQueryWhenFindByFilterThenDelegateToJpaRepository(){
        NotaQuery notaQuery = new NotaQuery();
        notaRepository.find(notaQuery);
        then(notaRepositorySpringData).should().findAll(any(PageRequest.class));
    }

}