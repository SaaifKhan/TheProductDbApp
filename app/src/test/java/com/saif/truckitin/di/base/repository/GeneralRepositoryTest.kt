package com.saif.truckitin.di.base.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.saif.truckitin.MainCoroutinesRule
import com.saif.truckitin.MockTestUtil
import com.saif.truckitin.data.models.ProductModel
import com.saif.truckitin.data.remote.ApiService
import com.saif.truckitin.data.remote.reporitory.MainRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * @author AliAzazAlam on 5/26/2021.
 */
@RunWith(JUnit4::class)
class GeneralRepositoryTest {

    // Subject under test
    private lateinit var repository: MainRepository

    @MockK
    private lateinit var authApi: ApiService

    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesRule = MainCoroutinesRule()

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `test getAllMovies returns list of movies`() = runBlocking {
        // Given
        repository = MainRepository(authApi, localDataSource)


        // Invoke
        val moviesFlow = repository.getProducts()

        // Then
        MatcherAssert.assertThat(moviesFlow, CoreMatchers.notNullValue())

        val movies = moviesFlow
        MatcherAssert.assertThat(movies, CoreMatchers.notNullValue())
        MatcherAssert.assertThat(movies, CoreMatchers.notNullValue())
        MatcherAssert.assertThat(movies, CoreMatchers.`is`(1))
        MatcherAssert.assertThat(movies.body()!![1].id, CoreMatchers.`is`(1))
    }

    @Test
    fun `test getAllProducts returns zero list of products`() = runBlocking {
        // Given
        repository = MainRepository(authApi, localDataSource)
        val moviesList = MockTestUtil.createZeroProductList()

        // When
        coEvery { authApi.getProducts() }.returns(moviesList)

        // Invoke
        val moviesFlow = repository.getProducts()

        // Then
        MatcherAssert.assertThat(moviesFlow, CoreMatchers.notNullValue())

        val movies = moviesFlow
        MatcherAssert.assertThat(movies, CoreMatchers.notNullValue())
        MatcherAssert.assertThat(movies, CoreMatchers.notNullValue())
        MatcherAssert.assertThat(
            movies.body()!!.size,
            CoreMatchers.`is`(moviesList.size)
        )
    }


    @After
    fun tearDown() {

    }
}

private fun Any.returns(returnValue: ArrayList<ProductModel>) {
    returnValue.add(ProductModel(0, "", "", "", "", "", isAddToCard = false))

}
