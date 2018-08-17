package net.davrukin.jobapplicationtracker.database

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteQuery
import io.reactivex.Flowable
import net.davrukin.jobapplicationtracker.models.User

@Dao
interface UserDao {

	// TODO: make sure these don't occur on the main thread

	@Insert
    fun insert(user: User)

    @Update
    fun update(user: User)

    @Delete
    fun delete(user: User)

    @Query("SELECT * FROM User")
    fun getUser(): LiveData<User>

    @RawQuery(observedEntities = [(User::class)])
    fun getUserViaQuery(query: SupportSQLiteQuery): LiveData<User>


}