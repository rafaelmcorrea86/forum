package br.com.alura.forum.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.alura.forum.modelo.Curso;
import junit.framework.Assert;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CursoRepositoryTest {

	@Autowired
	public CursoRepository repository;

	@Test
	public void findByNomeNotNullTest() {
		String nomeCurso = "HTML 5";
		Curso curso = repository.findByNome(nomeCurso);
		
		Assert.assertEquals(curso.getNome(), nomeCurso);
	}
	
	@Test
	public void findByNomeShouldBeNullTest() {
		String nomeCurso = "HTML 5";
		Curso curso = repository.findByNome(nomeCurso);
		
		Assert.assertNotNull(curso);
	}

}
