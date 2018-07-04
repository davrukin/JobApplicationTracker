package net.davrukin.jobapplicationtracker

import androidx.room.Room
import androidx.test.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import net.davrukin.jobapplicationtracker.database.AppDatabase
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class JobApplicationDaoTest {

    private lateinit var db: AppDatabase
    //@get:Rule var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun initiDb() {
        db = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(),
                AppDatabase::class.java)
                .build()
    }

    @After
    fun closeDb() {
        db.close()
    }

}