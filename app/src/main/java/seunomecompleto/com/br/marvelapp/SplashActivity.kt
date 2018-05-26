package seunomecompleto.com.br.marvelapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v4.content.ContextCompat
import android.support.v4.content.ContextCompat.startActivity
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    private val tempo = 2000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        carregar()
    }

    private fun carregar(){
        iniciarAnimacao()
        carregarProximaTela()
    }

    private fun iniciarAnimacao(){
        val anim = AnimationUtils.loadAnimation(this, R.anim.animacao_splash)
        ivLogo.startAnimation(anim)
    }

    private fun carregarProximaTela(){
        Handler().postDelayed({val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, tempo)
    }
}

