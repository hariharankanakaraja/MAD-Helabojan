package com.nibm.hari.helabojan.ui.authentication.signin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room
import com.google.firebase.auth.FirebaseAuth
import com.nibm.hari.helabojan.R
import com.nibm.hari.helabojan.databinding.ActivitySignInBinding
import com.nibm.hari.helabojan.databinding.ActivityWelcomeBinding
import com.google.firebase.auth.auth
import com.google.firebase.Firebase
import com.nibm.hari.helabojan.data.db.room.HELABOJANDatabase
import com.nibm.hari.helabojan.data.db.room.entity.UserEntity
import com.nibm.hari.helabojan.ui.home.GPSActivity
import com.nibm.hari.helabojan.ui.home.HomeActivity
import java.lang.Exception
import java.util.concurrent.Executors


class SignInActivity : Activity() {

    private lateinit var binding: ActivitySignInBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var db: HELABOJANDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth

        binding.btnSignIn.setOnClickListener{

            val email = binding.usernameInp.text.toString().trim()
            val password = binding.passwordInp.text.toString().trim()


            if(email.isNotEmpty() && password.isNotEmpty()){
                //signin in with firebase email auth
//                signInWithEmail(email, password)
                addNewUserIntoDb()
            }

        }

        db = Room.databaseBuilder(this, HELABOJANDatabase::class.java, "hela_bojan").build()

    }

    fun addNewUserIntoDb(){
        val executor = Executors.newSingleThreadExecutor();
        executor.execute{
            try{
                var user = UserEntity(
                    id = null,
                    userName = "user 1",
                    email = "user1@helabojan.com",
                    age = 1,
                )
                db.getUserDao().insertNewUser(user)
                var users: List<UserEntity> = db.getUserDao().getAllUsers()
                Handler(Looper.getMainLooper()).post{
                    Toast.makeText(this, "user insert success", Toast.LENGTH_LONG).show()
                }
            }
            catch (e: Exception){
                Handler(Looper.getMainLooper()).post{
                    Toast.makeText(this, "user insert issue", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    fun signInWithEmail(email: String, password: String){

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    navigateHomeActivity()
                } else {
                }
            }
    }

    fun navigateHomeActivity(){
        val intent = Intent(this, GPSActivity::class.java)
        startActivity(intent)
    }

}