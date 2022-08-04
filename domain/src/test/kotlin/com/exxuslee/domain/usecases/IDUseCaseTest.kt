package com.exxuslee.domain.usecases

import com.exxuslee.domain.repositories.IDRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class PriceUseCaseTest {

    @Mock
    private lateinit var idRepository: IDRepository
    private lateinit var getIDs: GetIDUseCase.Base
    private val getFromRemote: Boolean = false


    @Before
    fun setUp() {
        getIDs = GetIDUseCase.Base(idRepository)
    }

    @Test
    fun getIDUseCase_calls_IDRepository() {
        runTest {
            getIDs.listIDs(getFromRemote)
            Mockito.verify(idRepository).listIDs(getFromRemote)
        }
    }
}