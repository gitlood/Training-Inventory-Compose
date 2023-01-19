package com.example.inventory.core.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.inventory.core.data.util.Item
import com.example.inventory.core.data.util.ItemDao

@Database(
    entities = [Item::class],
    version = 1,
    exportSchema = false
)
abstract class InventoryDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao
}
