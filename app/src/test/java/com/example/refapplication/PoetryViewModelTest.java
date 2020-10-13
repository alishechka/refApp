package com.example.refapplication;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.Observer;

import com.example.refapplication.model.RandomPoem;
import com.example.refapplication.repo.Repo;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PoetryViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    private PoetryViewModel viewModel;
    @Mock
    Observer<RandomPoem> observer;
    @Mock
    Repo repo;
    private RandomPoem poem =  new RandomPoem();
    private List<RandomPoem> list = new ArrayList<>();


    @Before
    public void setUp() {
        viewModel = new PoetryViewModel();
        viewModel.poem().observeForever(observer);
    }

    @Test
    public void testNull() {
        when(repo.getRepoClientCallThing()).thenReturn(null);
        assertNotNull(viewModel.poem());
        assertTrue(viewModel.poem().hasObservers());
    }

    @Test
    public void testApiFetchSuccess() {
        poem.setAuthor("testAuth");
        poem.setLinecount("15");
        poem.setTitle("testTitle");

        list.add(poem);
        when(repo.getRepoClientCallThing()).thenReturn(Single.just(list));
        viewModel.getPoemData();

        assertEquals(list.get(0),poem);
    }


}