package net.davrukin.jobapplicationtracker.database

import androidx.lifecycle.LiveData
import androidx.room.*
import io.reactivex.Flowable
import net.davrukin.jobapplicationtracker.models.User

@Dao
interface UserDao {

    @Insert
    fun insert(user: User)

    @Update
    fun update(user: User)

    @Delete
    fun delete(user: User)

    @Query("SELECT * FROM User")
    fun getUser(): LiveData<User>


}