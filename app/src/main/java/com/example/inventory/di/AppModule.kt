package com.example.inventory.di

import android.content.Context
import androidx.room.Room
import com.example.inventory.InventoryApplication
import com.example.inventory.core.data.InventoryDatabase
import com.example.inventory.core.data.repository.OfflineItemsRepository
import com.example.inventory.core.data.repository.interfaces.ItemsRepository
import com.example.inventory.core.data.util.ItemDao
import com.example.inventory.core.util.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): InventoryApplication {
        return app as InventoryApplication
    }

    @Singleton
    @Provides
    fun provideNotesDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(context, InventoryDatabase::class.java, DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideItemsRepository(itemDao: ItemDao): ItemsRepository = OfflineItemsRepository(itemDao)

    @Singleton
    @Provides
    fun provideItemDao(db:InventoryDatabase) = db.itemDao()

}