package seunomecompleto.com.br.marvelapp.adapter

/**
 * Created by logonrm on 25/05/2018.
 */
import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.card_lista.view.*
import seunomecompleto.com.br.marvelapp.Heroi
import seunomecompleto.com.br.marvelapp.R

class HeroAdapter(private val herois: List<Heroi>,
                  private val context: Context,
                  val listener: (Heroi) -> Unit) : RecyclerView.Adapter<HeroAdapter.ViewHolder>(){
    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.let{it.bindView (herois[position], listener)}
    }

    override fun getItemCount(): Int {
        return herois.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.card_lista, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindView(heroi : Heroi,
                     listener: (Heroi) -> Unit) = with(itemView){
            tvName.text = heroi.nome
            ivHero.setImageDrawable(ContextCompat.getDrawable(itemView.context, heroi.imagemId))
            tvDescription.text = heroi.descricao

            setOnClickListener{listener(heroi)}
        }
    }
}