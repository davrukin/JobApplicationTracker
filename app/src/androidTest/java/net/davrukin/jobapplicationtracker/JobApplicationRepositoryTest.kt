package net.davrukin.jobapplicationtracker

import androidx.test.InstrumentationRegistry
import net.davrukin.jobapplicationtracker.database.AppDatabase
import net.davrukin.jobapplicationtracker.database.JobApplicationDao
import net.davrukin.jobapplicationtracker.database.JobApplicationRepository
import org.junit.Rule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class JobApplicationRepositoryTest {

    //val jad = mock(JobApplicationDao::class)

    //val repo = JobApplicationRepository(jad)

    // TODO: also test the migrations at some point, check if data inserted before migration is present after migration
    //@Rule val testHelper = MigrationTestHelper(InstrumentationRegistry.getInstrumentation(), AppDatabase::class.java.canonicalName)
}