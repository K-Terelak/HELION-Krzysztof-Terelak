package kt.mobile.helion_krzysztof_terelak2.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kt.mobile.helion_krzysztof_terelak2.data.HelionGateway
import kt.mobile.helion_krzysztof_terelak2.data.HelionRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideHelionGateway(
        helionRepository: HelionRepository
    ): HelionGateway = helionRepository
}